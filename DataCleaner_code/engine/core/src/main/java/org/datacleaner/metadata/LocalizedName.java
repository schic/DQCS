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
package org.datacleaner.metadata;

import java.util.Locale;
import java.util.Map;

/**
 * Represents metadata about localized/I18N names of columns, tables etc.
 * 表示有关列，表等的本地化/ I18N名称的元数据。
 */
public final class LocalizedName {

    private final Map<String, String> _map;

    public LocalizedName(final Map<String, String> parameters) {
        _map = parameters;
    }

    public String getDisplayName(final String locale) {
        if (locale == null) {
            return null;
        }
        return _map.get(locale);
    }

    public String getDisplayName(final String... locales) {
        if (locales == null) {
            return null;
        }
        for (final String locale : locales) {
            final String result = getDisplayName(locale);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public String getDisplayName(final Locale locale) {
        if (locale == null) {
            return null;
        }
        final String localeString = locale.toString();
        final String language = locale.getLanguage();
        return getDisplayName(localeString, language);
    }

    public Map<String, String> getDisplayNamesAsMap() {
        return _map;
    }
}
