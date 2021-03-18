package org.datacleaner.beans.unleo;

import org.datacleaner.api.*;
import org.datacleaner.result.Crosstab;
import org.datacleaner.result.CrosstabDimension;
import org.datacleaner.result.CrosstabNavigator;
import org.datacleaner.result.CrosstabResult;

import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 返回类型CrosstabResult，相对来说简单一点。就是一个两列，多行的一个表。呈现结果；
 * @Author 10648
 * @Date 2021年1月15日
 **/
@Named("数据日期分布")
@Description("这是自编写的Analyzer。目的是检查数据的某个日期字段在某时间段的分布。")
@Concurrent(true)
public class UnLeoChecker implements Analyzer<CrosstabResult> {

    /**
     * 这是用一个map来保存最后的结果的分布值，一个嵌套的映射；
     */
    private final Map<InputColumn<Date>, Map<Integer, AtomicInteger>> distributionMap;

    /**
     *您需要使用@Configured注释注入一个或多个InputColumn<E>，以便使用传入的数据。
     * <E>type参数定义感兴趣的数据类型，它还用于确定分析器支持哪些类型的数据类型。
     * 这个相当于注入字段数据，直接就可以使用了。如下，是输入的某一个或多个日期字段；
     */
    @Alias("日期字段")
    @Configured
    InputColumn<Date>[] dateColumns;

    @Alias("时间段")
    @Configured
    MatchDateType _dateRange = MatchDateType.LAST_WEEK;


    private final ArrayList<String> list = new ArrayList<>();

    /**
     * 拖拽组件到工作区，建立该对象；执行job时，建立该对象；
     * 都会走该无参构造器；
     */
    public UnLeoChecker() {
        distributionMap = new HashMap<>();
    }


    /**
     * 初始化方法   执行后首先进入的就是无参构造器  然后是这个init方法
     * 这里可以看到，要初始化该方法，首先是注入dateColumns，因此也呼应了上面要配置注入输入列；
     *    dateColumns  ：  指的是多个字段集合，比如{注册日期、修改日期、创建日期}这么一个集合。如输入列只有一个字段，那就只有一个字段；
     *    AtomicInteger： 原子类相比于普通的锁，粒度更细、效率更高。应对高并发多线程情况下计算更正确。毕竟是统计数据量，大
     */
    @Initialize
    public void init() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date();
        calendar.setTime(currentDate);
        switch (_dateRange.getName()){
            case "last week" : calendar.add(Calendar.WEEK_OF_MONTH, -1);break;
            case "last month" : calendar.add(Calendar.MONTH, -1);break;
            case "last three months" : calendar.add(Calendar.MONTH, -3);break;
            case "last half year" : calendar.add(Calendar.MONTH, -6);break;
        }
        Date threeMonthsAgo = calendar.getTime();
        do {
            Date nextDay = getNextDay(threeMonthsAgo);
            String nextDayStr = dateFormat.format(nextDay);
            threeMonthsAgo = nextDay;
            list.add(nextDayStr);
        }while (threeMonthsAgo.before(currentDate));
        for (final InputColumn<Date> col : dateColumns) {
            final Map<Integer, AtomicInteger> countMap = new HashMap<>(100);//这个7 是哈希表的初始容量。
            for (int i = 0; i < list.size(); i++) {
                countMap.put(i, new AtomicInteger(0));
            }
            distributionMap.put(col, countMap);//这里distributionMap，key是当前日期字段，value是countMap。。。。即一个字段对应一个countMap
        }
    }//init方法后  会进入run方法；但是问题是，init方法后的distributionMap并没有将数据做有效统计。进入run方法时distributionMap却已经统计好了

    /**
     * 必须要自定义实现的方法一：
     *
     * @param row
     *            the row to analyze要分析的行
     * @param distinctCount
     */
    @Override
    public void run(final InputRow row, final int distinctCount) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (final InputColumn<Date> col : dateColumns) {//同样该循环是  遍历有多少个字段多少个列参与到了输入
            final Date value = row.getValue(col);//从该字段去获取值
            if (value != null) {
                final Map<Integer, AtomicInteger> countMap = distributionMap.get(col);
                String dayStr = dateFormat.format(value);
                for (int i = 0; i < list.size(); i++) {
                    if (dayStr.equals(list.get(i))){
                        final AtomicInteger count = countMap.get(i);
                        count.addAndGet(distinctCount);//这是一个累加效果？
                    }
                }
            }
        }
    }

    /**
     * 必须要自定义实现的方法二：
     *  构建结果    交叉结果表
     * @return
     */
    @Override
    public CrosstabResult getResult() {
        final CrosstabDimension columnDimension = new CrosstabDimension("Column");//构建维度1
        final CrosstabDimension weekdayDimension = new CrosstabDimension("day");//构建维度2
        int sum = list.size();
        list.add(0,"Total amount of data");
        list.add(1,"Days with data");
        list.add(2,"Days without data");
        weekdayDimension.addCategories(list);
        final Crosstab<Integer> crosstab = new Crosstab<>(Integer.class, columnDimension, weekdayDimension);
        for (final InputColumn<Date> col : dateColumns) {
            columnDimension.addCategory(col.getName());
            final CrosstabNavigator<Integer> nav = crosstab.where(columnDimension, col.getName());//这里的col.getName() 就是上面取得名字Column
            final Map<Integer, AtomicInteger> countMap = distributionMap.get(col);
            int total = 0;
            int daysWithoutData = 0;
            for (int i = 0; i < list.size()-3; i++) {
                total = countMap.get(i).get() + total;
                if (countMap.get(i).get() == 0){
                    daysWithoutData = daysWithoutData + 1 ;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                if (i==0){
                    nav.where(weekdayDimension,list.get(i)).put(total);
                }else if(i==1){
                    nav.where(weekdayDimension,list.get(i)).put(sum - daysWithoutData);
                }else if(i==2){
                    nav.where(weekdayDimension,list.get(i)).put(daysWithoutData);
                }else{
                    nav.where(weekdayDimension, list.get(i)).put(countMap.get(i-3).get());
                }
            }
        }
        return new CrosstabResult(crosstab);
    }

    // used only for unittesting 仅用于单元测试
    public void setDateColumns(final InputColumn<Date>[] dateColumns) {
        this.dateColumns = dateColumns;
    }

    private Date getNextDay(Date day){
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DAY_OF_MONTH,1);
        return c.getTime();
    }
}
