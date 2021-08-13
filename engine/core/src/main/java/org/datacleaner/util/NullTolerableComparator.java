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
package org.datacleaner.util;

import java.io.Serializable;
import java.util.Comparator;

/**
 * A comparable that delegates to {@link Comparator} methods, but tolerates null
 * values by checking for this before delegating.
 * 委托给{@link Comparator}方法的可比对象，但在委托之前通过检查此值来允许null值。
 *
 *
 * @param <E>
 *            any comparable type
 */
public class NullTolerableComparator<E extends Comparable<? super E>> implements Comparator<E>, Serializable {

    private static final long serialVersionUID = 1L;

    public static <E extends Comparable<? super E>> Comparator<E> get(final Class<E> clazz) {
        return new NullTolerableComparator<>();
    }

    @Override
    public int compare(final E o1, final E o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}
