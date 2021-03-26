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
package org.datacleaner.beans.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Named;

import org.datacleaner.api.Categorized;
import org.datacleaner.api.Configured;
import org.datacleaner.api.Description;
import org.datacleaner.api.InputColumn;
import org.datacleaner.api.InputRow;
import org.datacleaner.api.OutputColumns;
import org.datacleaner.api.Transformer;
import org.datacleaner.components.categories.DateAndTimeCategory;

/**
 * 这是日期格式化  转换器。将日期字段 按照 yyyy-MM-dd HH:mm:ss 格式。最简单的转换器
 */
@Named("FormatDateTransformer.name")
@Description("FormatDateTransformer.Description")
@Categorized(DateAndTimeCategory.class)
public class FormatDateTransformer implements Transformer {

    @Configured("Date")
    InputColumn<Date> dateColumn;

    @Configured
    String dateFormat = "yyyy-MM-dd HH:mm:ss";

    @Override
    public OutputColumns getOutputColumns() {
        return new OutputColumns(String.class, dateColumn.getName() + " (formatted)");
    }

    @Override
    public String[] transform(final InputRow inputRow) {
        final Date date = inputRow.getValue(dateColumn);
        if (date == null) {
            return new String[] { null };
        }

        final SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return new String[] { format.format(date) };
    }

}
