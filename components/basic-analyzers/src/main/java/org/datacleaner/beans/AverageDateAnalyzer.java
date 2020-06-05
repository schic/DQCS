package org.datacleaner.beans;

import org.datacleaner.api.*;
import org.datacleaner.result.Crosstab;
import org.datacleaner.result.CrosstabDimension;
import org.datacleaner.result.CrosstabNavigator;
import org.datacleaner.result.CrosstabResult;

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

    public  static final String SUNDAY="Sunday";
    public  static final String Monday="Monday";
    public  static final String Tuesday="Tuesday";
    public  static final String Wednesday="Wednesday";
    public  static final String Thursday="Thursday";
    public  static final String Friday="Friday";
    public  static final String Saturday="Saturday";
    @Configured
    InputColumn<Date>[] dateColumns;
    private Map<InputColumn<Date>, Map<Integer, Integer>> distributionMap;

    public AverageDateAnalyzer(final InputColumn<Date>... dateColumns) {
        this.dateColumns = dateColumns;
        init();
    }
    @Initialize
    public void init() {
        distributionMap = new HashMap<InputColumn<Date>, Map<Integer, Integer>>();
        for (InputColumn<Date> col : dateColumns) {
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
        for (InputColumn<Date> col : dateColumns) {
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
        weekdayDimension.addCategory("Sunday").addCategory("Monday")
                .addCategory("Tuesday").addCategory("Wednesday").addCategory("Thursday")
                .addCategory("Friday").addCategory("Saturday");

        Crosstab crosstab = new Crosstab(Integer.class, columnDimension, weekdayDimension);
        for (InputColumn col : dateColumns) {
            columnDimension.addCategory(col.getName());
            CrosstabNavigator nav = crosstab.where(columnDimension, col.getName());
            Map countMap = distributionMap.get(col);

            nav.where(weekdayDimension, "Sunday").put((Serializable) countMap.get(Calendar.SUNDAY));
            nav.where(weekdayDimension, "Monday").put((Serializable) countMap.get(Calendar.MONDAY));
            nav.where(weekdayDimension, "Tuesday").put((Serializable) countMap.get(Calendar.TUESDAY));
            nav.where(weekdayDimension, "Wednesday").put((Serializable) countMap.get(Calendar.WEDNESDAY));
            nav.where(weekdayDimension, "Thursday").put((Serializable) countMap.get(Calendar.THURSDAY));
            nav.where(weekdayDimension, "Friday").put((Serializable) countMap.get(Calendar.FRIDAY));
            nav.where(weekdayDimension, "Saturday").put((Serializable) countMap.get(Calendar.SATURDAY));
        }
        return new CrosstabResult(crosstab);
    }

}
