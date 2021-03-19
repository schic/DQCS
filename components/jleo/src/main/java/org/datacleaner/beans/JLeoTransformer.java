package org.datacleaner.beans;/**
 * @author Leo
 * @description 干嘛干嘛的
 * @date 2019/9/5 17:53
 **/

import org.datacleaner.api.*;
import org.datacleaner.components.categories.LeoTransCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Description
 * @Author 10648
 * @Date 2021年3月1日
 **/
@Named("闰年检查")
@Description("检查时间字段所在年是否为闰年")
@Categorized(LeoTransCategory.class)
public class JLeoTransformer implements Transformer {

    public static final String PROPERTY_INPUTS_COLUMN = "Inputs column";
    public static final String OUTPUT_COLUMN_NO_Leap_Year = "Next Leap year";
    public static final String OUTPUT_COLUMN_Leap_Year = "Leap year";
    private static final Logger logger = LoggerFactory.getLogger(JLeoTransformer.class);

    /**
     * 为了从传入字段中读取数据，我们需要注入一个InputColumn<E>实例（或者一个数组）,其中<E>是传入字段的数据类型。
     * 为了注入，我们使用@Configured注解。
     */
    @Configured(PROPERTY_INPUTS_COLUMN)
    @Description("Inputs column")
    InputColumn<Date> _inputsColumn;



    public JLeoTransformer() {
    }

    /**
     * 框架调用此方法以确定转换器将生成哪些虚拟列。
     * @return
     */
    @Override
    public OutputColumns getOutputColumns() {
        return new OutputColumns(String.class, OUTPUT_COLUMN_NO_Leap_Year, OUTPUT_COLUMN_Leap_Year);
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
