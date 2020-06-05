/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.sample;

import java.util.Random;

import javax.inject.Named;

import org.datacleaner.api.Categorized;
import org.datacleaner.api.Concurrent;
import org.datacleaner.api.Configured;
import org.datacleaner.api.Description;
import org.datacleaner.api.InputColumn;
import org.datacleaner.api.InputRow;
import org.datacleaner.api.OutputColumns;
import org.datacleaner.api.Transformer;
import org.datacleaner.components.categories.TextCategory;

/**
 * A sample transformer that appends a greeting to a name column's values.
 * 一个示例转换器，将问候语附加到名称列的值。
 *
 * After reading the sample code, notice these characteristics of the
 * transformer implementation.
 * 阅读示例代码后，请注意转换器实现的这些特征。
 *
 * REQUIRED: The class must be annotated with @TransformerBean with a name
 * 必需：该类必须使用@TransformerBean进行注释，并带有名称
 *
 * REQUIRED: The class must implement the {@link Transformer} interface. The
 * generic parameter to this interface specifies the transformed output
 * column(s) type.
 * 必需：该类必须实现{@link Transformer}接口。该接口的通用参数指定转换后的输出列的类型。
 *
 * OPTIONAL: @Categorized for categorization in menus etc.
 * 可选：@Categorized，用于菜单等中的分类。
 *
 * OPTIONAL: @Description for tooltips etc.
 * 可选：@Description为工具提示等。
 *
 * OPTIONAL: @Concurrent for specification of multithreaded behaviour (default
 * true = multithreading allowed)
 * 可选：@Concurrent用于指定多线程行为（默认值* true =允许多线程）
 *
 * REQUIRED: One or more @Configured InputColumn (or InputColumn[]) fields.
 * 必需：一个或多个@Configured InputColumn（或InputColumn []）字段。
 *
 * OPTIONAL: Additional @Configured fields.
 * 可选：其他@Configured字段。
 *
 * OPTIONAL: Any amount of methods with the @Initialize or @Close methods.
 * 可选：使用@Initialize或@Close方法的任意数量的方法。
 *
 * OPTIONAL: A .png file with the fully classified class name as it's path (see
 * src/main/resources).
 * 可选：.png文件，具有完全分类的类名作为路径（请参阅src / main / resources）。
 */
@Named("HelloWorldTransformer.name")
@Categorized(TextCategory.class)
@Description("HelloWorldTransformer.Description")
@Concurrent(true)
public class HelloWorldTransformer implements Transformer {

    // REQUIRED: One or more InputColumn based
    @Configured
    InputColumn<String> nameColumn;

    @Configured
    @Description("A set of randomized greetings")
    String[] greetings = { "Hello", "Howdy", "Hi", "Yo" };

    private Random random = new Random();

    @Override
    public OutputColumns getOutputColumns() {
        final String[] columnNames = { nameColumn.getName() + " (greeting)" };
        return new OutputColumns(String.class, columnNames);
    }

    @Override
    public String[] transform(final InputRow inputRow) {
        final String name = inputRow.getValue(nameColumn);

        final int randomIndex = random.nextInt(greetings.length);
        final String greeting = greetings[randomIndex];

        final String greetingLine = greeting + " " + name;

        return new String[] { greetingLine };
    }

}
