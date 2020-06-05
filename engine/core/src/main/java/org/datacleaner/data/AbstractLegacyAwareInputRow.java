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
package org.datacleaner.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectStreamField;
import java.lang.reflect.Field;
import java.util.Collection;

import org.datacleaner.api.InputRow;

/**
 * Abstract super-class for {@link InputRow} implementations that are aware of
 * (and impacted by) the change of {@link InputRow#getId()} which was changed
 * from type int to long.
 * {@link InputRow}实现的抽象超类，了解（并受其影响）{@link InputRow＃getId（）}的更改，
 * 该更改已从int类型更改为long类型。
 *
 * To enable deserialization of old objects where the value is stored as an int,
 * but should be deserialized into a long, this class provides a mechanism for
 * converting the values.
 * 为了对值存储为int的旧对象启用反序列化，但应将其反序列化为long，此类提供了转换值的机制。
 */
abstract class AbstractLegacyAwareInputRow extends AbstractInputRow {

    private static final long serialVersionUID = 1L;

    protected abstract String getFieldNameForOldId();

    protected abstract String getFieldNameForNewId();

    protected abstract Collection<String> getFieldNamesInAdditionToId();

    /**
     * Subclasses should call this method within their
     * readObject(ObjectInputStream) invocations
     *
     * @param stream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    protected void doReadObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        final GetField readFields = stream.readFields();

        for (final String fieldName : getFieldNamesInAdditionToId()) {
            final Object value = readFields.get(fieldName, null);
            setField(fieldName, value);
        }

        // fix issue of deserializing _rowNumber in it's previous int form
        final long rowNumber;
        final ObjectStreamField legacyRowNumberField =
                readFields.getObjectStreamClass().getField(getFieldNameForOldId());
        if (legacyRowNumberField != null) {
            rowNumber = readFields.get(getFieldNameForOldId(), -1);
        } else {
            rowNumber = readFields.get(getFieldNameForNewId(), -1L);
        }

        setField(getFieldNameForNewId(), rowNumber);
    }

    private void setField(final String fieldName, final Object value) {
        try {
            final Field field = getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, value);
        } catch (final Exception e) {
            throw new IllegalStateException("Failed to set field '" + fieldName + "' to value: " + value, e);
        }
    }
}
