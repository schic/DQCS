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
package org.datacleaner.storage;

import java.util.Collections;
import java.util.List;

import org.datacleaner.api.InputRow;

/**
 * A {@link RowAnnotationFactory} that does not store any row samples. As such
 * it is usually not very useful to the user but can function as a stub for
 * situations where the row data is irrelevant.
 * 一个{@link RowAnnotationFactory}，它不存储任何行样本。
 * 因此，它通常对用户不是很有用，但是可以用作与行数据无关的情况下的存根。
 */
public class DummyRowAnnotationFactory extends AbstractRowAnnotationFactory2 {

    @Override
    public List<InputRow> getSampleRows(final RowAnnotation annotation) {
        return Collections.emptyList();
    }
}
