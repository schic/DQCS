/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
 * <p>
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.monitor.configuration;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.datacleaner.configuration.DataCleanerConfiguration;
import org.datacleaner.configuration.DataCleanerEnvironment;
import org.datacleaner.configuration.InjectionManagerFactory;
import org.datacleaner.monitor.job.JobContext;
import org.datacleaner.monitor.job.JobEngine;
import org.datacleaner.monitor.job.JobEngineManager;
import org.datacleaner.monitor.scheduling.SchedulingService;
import org.datacleaner.monitor.scheduling.model.ExecutionIdentifier;
import org.datacleaner.monitor.scheduling.model.ExecutionLog;
import org.datacleaner.monitor.scheduling.model.LeoExecutionData;
import org.datacleaner.monitor.scheduling.quartz.LeoExecuteJob;
import org.datacleaner.monitor.shared.model.*;
import org.datacleaner.repository.Repository;
import org.datacleaner.repository.RepositoryFile;
import org.datacleaner.repository.RepositoryFolder;
import org.datacleaner.util.StringUtils;
import org.eclipse.jetty.util.ajax.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Default implementation of {@link TenantContext}.
 */
public class TenantContextImpl extends AbstractTenantContext implements TenantContext {

    private static final Logger logger = LoggerFactory.getLogger(TenantContextImpl.class);

    private final String _tenantId;
    private final Repository _repository;
    private final ConfigurationCache _configurationCache;
    private final ComponentStore _componentStore;
    private final JobEngineManager _jobEngineManager;
    private final LoadingCache<JobIdentifier, JobContext> _jobCache;
    private String leoJson;
    @Autowired
    TenantContextFactory _tenantContextFactory;


    /**
     * Constructs the {@link TenantContext}.
     *
     * @param tenantId
     * @param repository
     * @param environment
     *            Contains the injection manager factory applicable to the whole
     *            application. This injection manager will be decorated/wrapped
     *            with a {@link TenantInjectionManagerFactory} in order to
     *            provide tenant-specific injection options.
     * @param jobEngineManager
     */
    public TenantContextImpl(String tenantId, Repository repository, DataCleanerEnvironment environment,
                             JobEngineManager jobEngineManager) {
        _tenantId = tenantId;
        _repository = repository;
        _jobEngineManager = jobEngineManager;
        if (jobEngineManager == null) {
            throw new IllegalArgumentException("JobEngineManager cannot be null");
        }

        final InjectionManagerFactory injectionManagerFactory = environment.getInjectionManagerFactory();
        final TenantInjectionManagerFactory tenantInjectionManagerFactory = new TenantInjectionManagerFactory(
                injectionManagerFactory, repository, this);

        _configurationCache = new ConfigurationCache(tenantInjectionManagerFactory, this, repository);
        _componentStore = new ComponentStoreImpl(_repository, _tenantId);
        _jobCache = buildJobCache();
    }

    private LoadingCache<JobIdentifier, JobContext> buildJobCache() {
        final LoadingCache<JobIdentifier, JobContext> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS).build(new CacheLoader<JobIdentifier, JobContext>() {
                    @Override
                    public JobContext load(JobIdentifier job) throws Exception {
                        final String jobName = job.getName();
                        if (StringUtils.isNullOrEmpty(jobName)) {
                            throw new NoSuchObjectException();
                        }

                        final TenantContext tenantContext = TenantContextImpl.this;
                        final JobEngine<?> jobEngine = _jobEngineManager.getJobEngine(tenantContext, jobName);
                        if (jobEngine == null) {
                            throw new NoSuchObjectException();
                        }
                        final JobContext result = jobEngine.getJobContext(tenantContext, job);
                        return result;
                    }
                });
        return cache;
    }

    @Override
    public List<JobIdentifier> getJobs() {
        final List<JobIdentifier> jobs = new ArrayList<JobIdentifier>();

        final Collection<JobEngine<?>> jobEngines = _jobEngineManager.getJobEngines();
        for (JobEngine<?> jobEngine : jobEngines) {
            final List<JobIdentifier> jobEngineJobs = jobEngine.getJobs(this);
            jobs.addAll(jobEngineJobs);
        }

        return jobs;
    }

    public List getJobsName(){
        List jobs = getJobs();
        List jobsname = new ArrayList();
        for (int i = 0; i < jobs.size(); i++) {
            int strStartIndex = jobs.get(i).toString().indexOf("=");
            int strEndIndex = jobs.get(i).toString().indexOf("]");
            /* 开始截取 */
            String result = jobs.get(i).toString().substring(strStartIndex+1, strEndIndex);
            jobsname.add(result);
        }
        return jobsname;
    }

    public static class JobIdentifiers {
        private String name;
        private String endTime;
        private String beginTime;
        private String status;
        private String cost;
        private String resultId;
        private String triggerType;
        private String triggerBy;
        private String url;

        public String getResultId() {
            return resultId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setResultId(String resultId) {
            this.resultId = resultId;
        }

        public String getTriggerType() {
            return triggerType;
        }

        public void setTriggerType(String triggerType) {
            this.triggerType = triggerType;
        }

        public String getTriggerBy() {
            return triggerBy;
        }

        public void setTriggerBy(String triggerBy) {
            this.triggerBy = triggerBy;
        }

        public String getLogOutput() {
            return logOutput;
        }

        public void setLogOutput(String logOutput) {
            this.logOutput = logOutput;
        }

        private String logOutput;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }
    }

    public String getLeoJson() {
        return leoJson;
    }

    public void setLeoJson(String leoJson) {
        this.leoJson = leoJson;
    }

//    @Override
//    public String getLeoJobsJson() throws Exception {
//        String jobsJson = getJobsJson();
//        if("".equals(jobsJson) || jobsJson ==null){
//            return "[]";
//        }else {
//            leoJson = jobsJson;
//        }
//        return leoJson;
//    }

//    @Override
//    public String getJobsJson() throws Exception{
//        final List<JobIdentifier> jobs = new ArrayList<JobIdentifier>();
//
//        final Collection<JobEngine<?>> jobEngines = _jobEngineManager.getJobEngines();
//        for (JobEngine<?> jobEngine : jobEngines) {
//            final List<JobIdentifier> jobEngineJobs = jobEngine.getJobs(this);
//            jobs.addAll(jobEngineJobs);
//        }
//
//        WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
//        SchedulingService delegate = applicationContext.getBean(SchedulingService.class);
///*
//         TenantContext tenantContext = _tenantContextFactory.getContext(getTenantId());
//*/
//        // ClientConfig clientConfig = new DictionaryClientConfig();
//
//
//        TenantIdentifier tenantContext = new TenantIdentifier(getTenantId());
//        ExecutionLog executionLog;
//        List jobIdentifiers = new ArrayList<>();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (JobIdentifier jobIdentifier : jobs) {
//            List<ExecutionIdentifier> Executions = delegate.getAllExecutions(tenantContext, jobIdentifier);
//            for (ExecutionIdentifier ExecutionIdentifier : Executions) {
//                executionLog = delegate.getExecution(tenantContext, ExecutionIdentifier);
//                if (executionLog != null) {
//                    Map map = new HashMap();
//                    JobIdentifiers jobIdentifiers1 = new JobIdentifiers();
//                    if(jobIdentifier.getName() != null){
//                        map.put("name", jobIdentifier.getName());
//                        jobIdentifiers1.setName(jobIdentifier.getName());
//                    } if(executionLog.getJobEndDate() != null){
//                        String endDate = formatter.format(executionLog.getJobEndDate());
//                        map.put("endTime", endDate);
//                        jobIdentifiers1.setEndTime(endDate);
//                    } if(executionLog.getJobBeginDate() != null){
//                        String beginDate = formatter.format(executionLog.getJobBeginDate());
//                        map.put("beginTime", beginDate);
//                        jobIdentifiers1.setBeginTime(beginDate);
//                    } if(executionLog.getExecutionStatus().name() != null){
//                        map.put("status", executionLog.getExecutionStatus().name());
//                        jobIdentifiers1.setStatus(executionLog.getExecutionStatus().name());
//                    } if((executionLog.getJobEndDate() != null) && (executionLog.getJobBeginDate() != null)){
//                        map.put("cost", executionLog.getJobEndDate().getTime() - executionLog.getJobBeginDate().getTime());
//                        jobIdentifiers1.setCost(String.valueOf(executionLog.getJobEndDate().getTime() - executionLog.getJobBeginDate().getTime()));
//                    }
//                    String resultId="";
//                    String url="";
//                    if(executionLog.getResultId() != null){
//                        resultId=executionLog.getResultId();
////                        url = Urls.createRelativeUrl("repository/" + tenantContext.getId() + "/results/" + resultId + ".analysis.result.dat");
////                        url = "/DataCleaner_monitor_ui_war/"+"repository/" + tenantContext.getId() + "/results/" + resultId + ".analysis.result.dat";
//                        url = "/repository/" + tenantContext.getId() + "/results/" + resultId + ".analysis.result.dat";
//                        map.put("resultId", resultId);
//                        jobIdentifiers1.setResultId(resultId);
//                        map.put("url", url);
//                        jobIdentifiers1.setUrl(url);
//                    } if(executionLog.getTriggerType().name() != null){
//                        map.put("triggerType", executionLog.getTriggerType().name()+" triggered");
//                        jobIdentifiers1.setTriggerType(executionLog.getTriggerType().name()+" triggered");
//                    } if(executionLog.getTriggeredBy() != null){
//                        map.put("triggerBy", executionLog.getTriggeredBy());
//                        jobIdentifiers1.setTriggerBy(executionLog.getTriggeredBy());
//                    } if(executionLog.getLogOutput() != null){
//                        map.put("logOutput", executionLog.getLogOutput());
//                        jobIdentifiers1.setLogOutput(executionLog.getLogOutput());
//                    }
//                    jobIdentifiers.add(map);
//                }
//            }
//        }
//        for(int i=0;i<jobIdentifiers.size();i++){
//            for(int j=0;j<jobIdentifiers.size()-i-1;j++){
//                Map map = (Map) jobIdentifiers.get(j);
//                Map map2 = (Map) jobIdentifiers.get(j+1);
//                if(formatter.parse(map.get("beginTime").toString()).getTime() < formatter.parse(map2.get("beginTime").toString()).getTime()){
//                    Object o = jobIdentifiers.get(j);
//                    jobIdentifiers.set(j, jobIdentifiers.get(j+1));
//                    jobIdentifiers.set(j+1, o);
//                }
//            }
//        }
//
//        System.out.println(JSON.toString(jobIdentifiers));
//        return JSON.toString(jobIdentifiers);
//    }

    @Override
    public String getJobsJson() throws Exception{
        LeoExecuteJob job = new LeoExecuteJob();
        List<LeoExecutionData> jsonFileData = job.getJsonFileData(job.getDemoPath());
        return jsonFileData.toString();
    }



    @Override
    public JobContext getJob(JobIdentifier jobIdentifier) throws IllegalArgumentException {
        if (jobIdentifier == null) {
            throw new IllegalArgumentException("JobIdentifier不能为空");
        }

        try {
            return _jobCache.get(jobIdentifier);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof NoSuchObjectException) {
                // expected exception at this point
                return null;
            }
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            throw new IllegalStateException(e);
        }
    }

    public int getJobNum() throws Exception {
        return getJobs().size();
    }

    @Override
    public DataCleanerConfiguration getConfiguration() {
        return _configurationCache.getAnalyzerBeansConfiguration();
    }

    @Override
    public DataCleanerConfiguration getConfiguration(final Map<String, String> overrideProperties) {
        if (overrideProperties == null) {
            return getConfiguration();
        }
        return _configurationCache.readConfiguration(overrideProperties);
    }

    @Override
    public RepositoryFolder getTenantRootFolder() {
        RepositoryFolder tenantFolder = _repository.getFolder(_tenantId);
        if (tenantFolder == null) {
            logger.info("Creating tenant folder '{}' for tenant '{}'", _tenantId, _tenantId);
            tenantFolder = _repository.createFolder(_tenantId);
            tenantFolder.createFolder(PATH_JOBS);
            tenantFolder.createFolder(PATH_RESULTS);
            tenantFolder.createFolder(PATH_TIMELINES);
        }
        return tenantFolder;
    }

    @Override
    public String getTenantId() {
        return _tenantId;
    }

    @Override
    protected ResultContext getResult(RepositoryFile resultFile) {
        if (resultFile == null) {
            return null;
        }
        return new DefaultResultContext(this, resultFile);
    }

    @Override
    public RepositoryFile getConfigurationFile() {
        return _configurationCache.getConfigurationFile();
    }


    @Override
    public void onConfigurationChanged() {
        logger.debug("onConfigurationChanged() invoked on tenant: {}", _tenantId);
        _configurationCache.clearCache();
        _jobCache.invalidateAll();
    }

    @Override
    public ComponentStore getComponentStore() {
        return _componentStore;
    }

}
