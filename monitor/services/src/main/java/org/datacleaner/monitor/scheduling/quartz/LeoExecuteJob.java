package org.datacleaner.monitor.scheduling.quartz;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.datacleaner.monitor.scheduling.model.LeoExecutionData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LeoExecuteJob extends AbstractQuartzJob{
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        logger.info("====定时扫描任务结果日志启动====");
        String demoPath = getDemoPath();
        logger.info("==1.获取到当前demo目录路径: "+demoPath);
        createJsonFileyN(demoPath);
        List<LeoExecutionData> destJsonData = getJsonFileData(demoPath);
        System.out.println(("==destJsonData=== " + destJsonData));
        List<LeoExecutionData> srcJsonData = compareData(demoPath,destJsonData);
        System.out.println(("==srcJsonData=== " + srcJsonData));
        if (srcJsonData !=null && !srcJsonData.isEmpty()){
            writeJsonFile(demoPath,srcJsonData);
        }
        logger.info("====定时扫描任务结果日志结束====");
    }

    public String getDemoPath() {
        String path = this.getClass().getResource("/").getPath();
        String path2 = path.substring(0, path.substring(0, path.substring(0, path.lastIndexOf("/")).lastIndexOf("/")).lastIndexOf("/"));
        return path2+ "/repository/demo";
    }

    private Boolean createJsonFileyN(String jsonPath) {
        boolean create = true;
        File folder = new File(jsonPath);
        for (File file : folder.listFiles()) {
            if (file.toPath().toString().endsWith("dataTable.json")){
                create = false;
            }
        }
        if (create){
            try {
                new File(jsonPath+"/dataTable.json").createNewFile();
                logger.info("创建dataTable.json文件成功!!!");
            } catch (IOException e) {
                logger.error("创建dataTable.json文件失败!!!", e);
            }
        }
        return create;
    }

    public List<LeoExecutionData> getJsonFileData(String path) {
        logger.info("==2.读取dataTable.json文件内容!");
        List<LeoExecutionData> jsonList = new ArrayList<LeoExecutionData>();
        try {
            File jsonFile = new File(path + "/dataTable.json");
            String jsonStr = FileUtils.readFileToString(jsonFile, "UTF-8");
            if (!"".equals(jsonStr) && !jsonStr.isEmpty())
            jsonList = JSON.parseArray(jsonStr, LeoExecutionData.class);
            logger.info("读取dataTable.json文件内容成功!!!");
        } catch (NullPointerException e) {
            logger.error("dataTable.json文件还没有被创建!!!");
        }catch (FileNotFoundException e) {
            logger.error("dataTable.json文件还没有被创建!!!");
        }catch (IOException e) {
            logger.error("读取dataTable.json文件内容失败!!!", e);
        }
        return jsonList;
    }

    private List<LeoExecutionData> compareData(String path, List<LeoExecutionData> destJsonData) {
        logger.info("==3.比对json文件和日志文件");
        String resultsPath = path + "/results";
        if (!new File(resultsPath).exists() || !new File(resultsPath).isDirectory()){
            logger.error("目前还没有任务被执行，results文件夹还未被创建!!!");
            return null;
        }
        if (noXmlFile(resultsPath)){
            logger.error("目前results文件夹下没有xml任务记录文件!!!");
            return null;
        }
        File resultsFolder = new File(resultsPath);
        for (File file : resultsFolder.listFiles()) {
            if (file.getName().endsWith(".xml")){
                destJsonData = parseXml(file,destJsonData);
            }
        }
        return destJsonData;
    }

    private boolean noXmlFile(String resultsPath) {
        boolean flag = true;
        File results = new File(resultsPath);
        for (File file : results.listFiles()) {
            if (file.toPath().toString().endsWith(".xml")){
                flag = false;
            }
        }
        return flag;
    }

    private List<LeoExecutionData> parseXml(File file, List<LeoExecutionData> destJsonDataList) {
        LeoExecutionData data = new LeoExecutionData();
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
            Element rootElement = document.getRootElement();

            String dateStr1 = rootElement.element("job-begin-date").getText();
            Date date = formatDate(dateStr1);
            if (!withInMonth(date)) return destJsonDataList;

            //name
            String resultId = rootElement.element("result-id").getText();
            if (destJsonDataList != null && destJsonDataList.size()>0 ){
                for (LeoExecutionData leoExecutionData : destJsonDataList) {
                    if (leoExecutionData.getResultId().equals(resultId)) return destJsonDataList;
                }
            }
            logger.info("发现新的xml日志并解析内容");
            String[] split = resultId.split("-");
            String name = split[0];
            //beginTime endTime cost
            String beginTime = getMyDate(dateStr1);
            String dateStr2 = rootElement.element("job-end-date").getText();
            String endTime = getMyDate(dateStr2);
            long  cost = formatDate(dateStr2).getTime() - formatDate(dateStr1).getTime();
            //status
            String status = rootElement.element("execution-status").getText();
            //url
            String url = "/repository/demo/results/"+ resultId + ".analysis.result.dat";
            //triggerType triggerBy
            String triggerType = "";
            String triggerBy = "";
            if (rootElement.element("trigger-type")!=null && !rootElement.element("trigger-type").getText().isEmpty()){
                triggerType = rootElement.element("trigger-type").getText();
            }
            if (rootElement.element("triggered-by")!=null && !rootElement.element("triggered-by").getText().isEmpty()){
                triggerBy = rootElement.element("triggered-by").getText();
            }
            //logOutput
            String logOutput = rootElement.element("log-output").getText();
            data.setName(name);
            data.setResultId(resultId);
            data.setBeginTime(beginTime);
            data.setEndTime(endTime);
            data.setCost(String.valueOf(cost));
            data.setStatus(status);
            data.setUrl(url);
            data.setTriggerType(triggerType);
            data.setTriggerBy(triggerBy);
            data.setLogOutput(logOutput);
            destJsonDataList.add(data);
            logger.info("新的xml日志内容添加成功");
        } catch (DocumentException e) {
            logger.error("解析results目录下xml文件时错误!!!",e);
        }
        return destJsonDataList;
    }
    private String getMyDate(String formatDate) {
        String[] dates = formatDate.split("T");
        String[] dates2 = dates[1].split("\\+");
        formatDate = dates[0]+" "+dates2[0];
        String[] split = formatDate.split("\\.");
        return split[0];
    }
    private Date formatDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        String[] dates = dateStr.split("T");
        String[] dates2 = dates[1].split("\\+");
        dateStr = dates[0]+" "+dates2[0];
        Date date = null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    private boolean withInMonth(Date date) {
        Boolean flag = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -3);
        Date startTime = calendar.getTime();
        if (date.getTime() < startTime.getTime()){
            flag = false;
        }
        return flag;
    }

    private Boolean writeJsonFile(String destinPath, List<LeoExecutionData> srcJsonData) {
        logger.info("==4.开始写入json内容");
        boolean flag = true;
        String fullPath = destinPath+"/dataTable.json";
        File jsonFile = new File(fullPath);
        if (jsonFile.exists()){
            try {
                Writer write = new OutputStreamWriter(new FileOutputStream(jsonFile), "UTF-8");
                write.write(srcJsonData.toString());
                write.flush();
                write.close();
            } catch (UnsupportedEncodingException e) {
                flag = false;
                logger.error("写入dataTable.json文件内容时出错!!!",e);
            } catch (IOException e) {
                flag = false;
                logger.error("写入dataTable.json文件内容时出错!!!",e);
            }
        }
        return flag;
    }
}
