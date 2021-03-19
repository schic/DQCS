package org.datacleaner.beans;/**
 * @author Leo
 * @description 干嘛干嘛的
 * @date 2019/9/5 17:53
 **/

import org.datacleaner.data.MockInputColumn;
import org.datacleaner.data.MockInputRow;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * @Description
 * @Author 10648
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
        final MockInputColumn<String> col = new MockInputColumn<>("Name", String.class);

        final JLeoHelloTransformer transformer = new JLeoHelloTransformer();
        transformer.nameColumn = col;
        transformer.greetings = new String[] { "Hello" };

        assertEquals("Name (greeting)", transformer.getOutputColumns().getColumnName(0));

        assertEquals("Hello Tom", transformer.transform(new MockInputRow().put(col, "Tom"))[0]);
        assertEquals("Hello Martin", transformer.transform(new MockInputRow().put(col, "Martin"))[0]);
        assertEquals("Hello Jesse", transformer.transform(new MockInputRow().put(col, "Jesse"))[0]);
    }
}
