/**
 * eobjects.org DataCleaner
 * Copyright (C) 2010 eobjects.org
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
package org.eobjects.datacleaner.output;

/**
 * Represents an object which can be used to write rows of data to some output
 * (typically a database or a file).
 * 
 * @author Kasper Sørensen
 */
public interface OutputWriter {

	/**
	 * Creates a new row in the output.
	 * 
	 * @return
	 */
	public OutputRow createRow();

	/**
	 * Closes the output writing sequence. Implementing classes should flush and
	 * close any outputstreams etc. here.
	 */
	public void close();
}