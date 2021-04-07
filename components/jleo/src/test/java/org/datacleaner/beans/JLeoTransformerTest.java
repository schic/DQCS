package org.datacleaner.beans;
import org.apache.commons.lang.time.DateUtils;
import org.datacleaner.components.categories.LeoTransCategory;
import org.datacleaner.data.MockInputColumn;
import org.datacleaner.data.MockInputRow;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * @Description
 * @Author Leo
 * @Date 2021年1月11日14:32:51
 **/
public class JLeoTransformerTest {
    @Test
    public void test1() {
        final MockInputColumn<Date> col = new MockInputColumn<>("haha666", Date.class);

        JLeoTransformer transformer = new JLeoTransformer();
        transformer.setDateColumn(col);

        Date date = new Date();
        String[] result = transformer.transform(new MockInputRow().put(col, date));
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    @Test
    public void test2() {
        System.out.println("===="+new LeoTransCategory().getName());
        final MockInputColumn<String> col = new MockInputColumn<>("Name", String.class);

        final JLeoHelloTransformer transformer = new JLeoHelloTransformer();
        transformer.nameColumn = col;
        transformer.greetings = new String[] { "Hello" };

        assertEquals("Name (greeting)", transformer.getOutputColumns().getColumnName(0));

        assertEquals("Hello Tom", transformer.transform(new MockInputRow().put(col, "Tom"))[0]);
        assertEquals("Hello Martin", transformer.transform(new MockInputRow().put(col, "Martin"))[0]);
        assertEquals("Hello Jesse", transformer.transform(new MockInputRow().put(col, "Jesse"))[0]);
    }
    @Test
    public void test3(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        try {
            Date parse = format.parse("2021-04-15");
            System.out.println(currentDate);
            System.out.println(parse);
            if (currentDate.getTime() >= parse.getTime()){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
