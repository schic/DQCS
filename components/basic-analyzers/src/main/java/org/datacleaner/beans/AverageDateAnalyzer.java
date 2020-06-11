package org.datacleaner.beans;

import org.datacleaner.api.*;
import org.datacleaner.result.Crosstab;
import org.datacleaner.result.CrosstabDimension;
import org.datacleaner.result.CrosstabNavigator;
import org.datacleaner.result.CrosstabResult;
import org.datacleaner.storage.RowAnnotationFactory;
import org.datacleaner.storage.RowAnnotations;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Named("AverageDateAnalyzer.name")
@Description("AverageDateAnalyzer.Description")
@Concurrent(true)
public class AverageDateAnalyzer implements Analyzer<CrosstabResult> {

    public static final String SUNDAY = "Sunday";
    public static final String MONDAY = "Monday";
    public static final String TUESDAY = "Tuesday";
    public static final String WEDNESDAY = "Wednesday";
    public static final String THURSDAY = "Thursday";
    public static final String FRIDAY = "Friday";
    public static final String SATURDAY = "Saturday";
    @Inject
    @Configured
    InputColumn<Date>[] _columns;
    @Inject
    @Configured
    @Description("Gather so-called descriptive statistics, including median, skewness, kurtosis and percentiles, "
            + "which have a larger memory-footprint.")
    boolean descriptiveStatistics = false;
    @Inject
    @Provided
    RowAnnotationFactory _annotationFactory;

    private Map<InputColumn<Date>, Map<Integer, Integer>> distributionMap;



    public AverageDateAnalyzer(){

    }
    public AverageDateAnalyzer(final InputColumn<Date>... columns) {
        _columns = columns;
        _annotationFactory = RowAnnotations.getDefaultFactory();
        init();
    }

    @Initialize
    public void init() {
        distributionMap = new HashMap<InputColumn<Date>, Map<Integer, Integer>>();
        for (InputColumn<Date> col : _columns) {
            Map<Integer, Integer> countMap = new HashMap<Integer, Integer>(7);
            for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
                // put a count of 0 for each day of the week
                countMap.put(i, 0);
            }
            distributionMap.put(col, countMap);
        }
    }

    @Override
    public void run(InputRow row, int distinctCount) {
        for (InputColumn<Date> col : _columns) {
            Date value = row.getValue(col);
            if (value != null) {
                Calendar c = Calendar.getInstance();
                c.setTime(value);
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                Map<Integer, Integer> countMap = distributionMap.get(col);
                int count = countMap.get(dayOfWeek);
                count += distinctCount;
                countMap.put(dayOfWeek, count);
            }
        }
    }

    @Override
    public CrosstabResult getResult() {
        CrosstabDimension columnDimension = new CrosstabDimension("Column");
        CrosstabDimension weekdayDimension = new CrosstabDimension("Weekday");
        weekdayDimension.addCategory(SUNDAY).addCategory(MONDAY)
                .addCategory(TUESDAY).addCategory(WEDNESDAY).addCategory(THURSDAY)
                .addCategory(FRIDAY).addCategory(SATURDAY);

        Crosstab crosstab = new Crosstab(Integer.class, columnDimension, weekdayDimension);
        for (InputColumn col : _columns) {
            columnDimension.addCategory(col.getName());
            CrosstabNavigator nav = crosstab.where(columnDimension, col.getName());
            Map countMap = distributionMap.get(col);

            nav.where(weekdayDimension, SUNDAY).put((Serializable) countMap.get(Calendar.SUNDAY));
            nav.where(weekdayDimension, MONDAY).put((Serializable) countMap.get(Calendar.MONDAY));
            nav.where(weekdayDimension, TUESDAY).put((Serializable) countMap.get(Calendar.TUESDAY));
            nav.where(weekdayDimension, WEDNESDAY).put((Serializable) countMap.get(Calendar.WEDNESDAY));
            nav.where(weekdayDimension, THURSDAY).put((Serializable) countMap.get(Calendar.THURSDAY));
            nav.where(weekdayDimension, FRIDAY).put((Serializable) countMap.get(Calendar.FRIDAY));
            nav.where(weekdayDimension, SATURDAY).put((Serializable) countMap.get(Calendar.SATURDAY));
        }
        return new CrosstabResult(crosstab);
    }

}
