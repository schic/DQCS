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
package org.datacleaner.output;

/**
 * Represents an object which can be used to write rows of data to some output
 * (typically a database or a file).
 * 表示一个对象，该对象可用于将数据行写入某些输出（通常是数据库或文件）。
 */
public interface OutputWriter {

    /**
     * Creates a new row in the output.
     *
     * @return
     */
    OutputRow createRow();

    /**
     * Closes the output writing sequence. Implementing classes should flush and
     * close any outputstreams etc. here.
     */
    void close();
}
