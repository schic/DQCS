package org.datacleaner.beans;

import org.datacleaner.api.Categorized;
import org.datacleaner.api.Configured;
import org.datacleaner.api.InputRow;
import org.datacleaner.api.OutputColumns;
import javax.inject.Named;
import org.datacleaner.api.*;
import org.datacleaner.components.categories.LeoTransCategory;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Description
 * @Author Leo
 * @Date 2021年3月1日
 **/
@Named("闰年检查")
@Description("检查某时间字段所在年是否为闰年")
@Categorized(LeoTransCategory.class)
public class JLeoTransformer implements Transformer {

    public static final String PROPERTY_INPUTS_COLUMN = "输入列";
    public static final String OUTPUT_COLUMN_NO_LEAP_YEAR = "距离下一个闰年";
    public static final String OUTPUT_COLUMN_LEAP_YEAR = "是否闰年";
    /**
     * 为了从传入字段中读取数据，我们需要注入一个InputColumn<E>实例（或者一个数组）,其中<E>是传入字段的数据类型。
     * 为了注入，我们使用@Configured注解。
     */
    @Configured(PROPERTY_INPUTS_COLUMN)
    @Description("输入列")
    InputColumn<Date> _inputsColumn;



    public JLeoTransformer() {
    }

    /**
     * 框架调用此方法以确定转换器将生成哪些虚拟列。
     * @return
     */
    @Override
    public OutputColumns getOutputColumns() {
        return new OutputColumns(String.class, OUTPUT_COLUMN_NO_LEAP_YEAR, OUTPUT_COLUMN_LEAP_YEAR);
    }

    /**
     * 对于每一行要转换的值，都将调用此方法。
     * 方法的返回类型是表示行的新值的对象数组。返回数组的索引应与输出列匹配
     * @param
     * @return
     */
    @Override
    public String[] transform(InputRow inputRow) {
        final String[] result = new String[2];
        final Date date = inputRow.getValue(_inputsColumn);

        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy");
            String year = sdf.format(date);
            Long yearLong = Long.valueOf(year);
            if(yearLong%4== 0 && yearLong%100!=0||yearLong%400==0) {
                result[0] = "0";
                result[1] = "yes";
            }else{
                for (int i = 1; i < 400; i++) {
                    yearLong++;
                    if(yearLong%4== 0 && yearLong%100!=0||yearLong%400==0) {
                        result[0] = String.valueOf(i);
                        break;
                    }
                }
                result[1] = "no";
            }
        }
        return result;
    }

    public void setDateColumn(final InputColumn<Date> col) {
        _inputsColumn = col;
    }
}
