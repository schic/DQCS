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
package org.datacleaner.result;

import org.datacleaner.api.Alias;
import org.datacleaner.api.AnalyzerResult;
import org.datacleaner.api.Metric;

/**
 * Very simple result type for analyzers that simply return a number (maybe a
 * KPI or something like that).
 * 对于仅返回数字的分析器，结果类型非常简单（可能是KPI或类似的东西）。
 *
 * Mostly used for testing purposes.主要用于测试目的。
 */
public class NumberResult implements AnalyzerResult {

    private static final long serialVersionUID = 1L;
    private Number number;

    public NumberResult(final Number number) {
        this.number = number;
    }

    @Metric("Number")
    @Alias("Some number")
    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        if (number == null) {
            return "<null>";
        }
        return number.toString();
    }
}
