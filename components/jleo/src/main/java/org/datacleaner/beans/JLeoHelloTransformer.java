package org.datacleaner.beans;

import org.datacleaner.api.*;
import org.datacleaner.components.categories.LeoTransCategory;

import javax.inject.Named;
import java.util.Random;

/**
 * @Description
 * @Author Leo
 * @Date 2021年3月8日
 **/
@Named("Hello示例")
@Description("这是示例转换器，在某字段前随机拼接问候语")
@Categorized(LeoTransCategory.class)
public class JLeoHelloTransformer implements Transformer {

    // REQUIRED: One or more InputColumn based 要求：基于一个或多个输入列
    @Configured
    InputColumn<String> nameColumn;

    @Configured
    @Description("A set of randomized greetings 一组随机化问候语")
    String[] greetings = { "Hello", "Howdy", "Hi", "Yo" };

    private Random random = new Random();

    @Override
    public OutputColumns getOutputColumns() {
        final String[] columnNames = { nameColumn.getName() + " (greeting)" };
        return new OutputColumns(String.class, columnNames);
    }

    @Override
    public String[] transform(final InputRow inputRow) {
        final String name = inputRow.getValue(nameColumn);//获取该行该列的值
        final int randomIndex = random.nextInt(greetings.length);
        final String greeting = greetings[randomIndex];

        final String greetingLine = greeting + " " + name;

        return new String[] { greetingLine };
    }

}
