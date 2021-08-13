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
package org.datacleaner.api;

/**
 * Interface for input columns that contain an expression that is evaluated when
 * the a value is extracted from the row, as opposed to being written to the row
 * in advance.
 * 输入列的接口，其中包含一个表达式，该表达式在从该行中提取一个值时进行评估，而不是预先写入该行中。
 *
 * @param <E>
 */
public interface ExpressionBasedInputColumn<E> extends InputColumn<E> {

    E evaluate(InputRow row);

    String getExpression();
}
