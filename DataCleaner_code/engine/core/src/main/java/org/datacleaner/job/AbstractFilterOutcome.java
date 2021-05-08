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
package org.datacleaner.job;

import java.util.List;

import org.apache.metamodel.util.BaseObject;
import org.datacleaner.job.builder.LazyFilterOutcome;

/**
 * Provides hashCode, equals and toString implementations for FilterOutcome,
 * making them comparable across different implementations.
 * 为FilterOutcome提供hashCode，equals和toString实现，使它们在不同的实现之间具有可比性。
 *
 * Specifically this has been designed to make it possible to use the
 * equals(...) method with both ImmutableFilterOutcome and LazyFilterOutcome
 * instances.
 * 特别是，这被设计为使ImmutableFilterOutcome和LazyFilterOutcome实例都可以使用equals（...）方法。
 *
 * @see ImmutableFilterOutcome
 * @see LazyFilterOutcome
 */
public abstract class AbstractFilterOutcome extends BaseObject implements FilterOutcome {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean isEquals(final FilterOutcome filterOutcome) {
        return equals(filterOutcome);
    }

    @Override
    protected final void decorateIdentity(final List<Object> identifiers) {
        identifiers.add(getCategory());
        identifiers.add(getSource());
    }

    @Override
    protected final boolean classEquals(final BaseObject obj) {
        // works with all subtypes
        return obj instanceof FilterOutcome;
    }

    @Override
    public String toString() {
        return "FilterOutcome[category=" + getCategory() + "]";
    }

    @Override
    public final String getSimpleName() {
        return getCategory().toString();
    }
}
