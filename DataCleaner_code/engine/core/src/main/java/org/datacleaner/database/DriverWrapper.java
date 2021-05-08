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
package org.datacleaner.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * This class simply wraps a JDBC driver. It is necessary to wrap them since
 * DriverManager will only accept Driver instances that have the same
 * ClassLoader as the DriverManager it self and sometimes we use dynamic class
 * loading for the drivers.
 * 此类仅包装JDBC驱动程序。必须包装它们，
 * 因为DriverManager将只接受与其自身具有相同ClassLoader的Driver实例，
 * 有时我们会为驱动程序使用动态类加载。
 */
public final class DriverWrapper implements Driver {

    private final Driver _driver;

    public DriverWrapper(final Driver driver) {
        _driver = driver;
    }

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public boolean acceptsURL(final String url) throws SQLException {
        return _driver.acceptsURL(url);
    }

    public Connection connect(final String url, final Properties info) throws SQLException {
        return _driver.connect(url, info);
    }

    public int getMajorVersion() {
        return _driver.getMajorVersion();
    }

    public int getMinorVersion() {
        return _driver.getMinorVersion();
    }

    public DriverPropertyInfo[] getPropertyInfo(final String url, final Properties info) throws SQLException {
        return _driver.getPropertyInfo(url, info);
    }

    public boolean jdbcCompliant() {
        return _driver.jdbcCompliant();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DriverWrapper) {
            obj = ((DriverWrapper) obj)._driver;
        }
        if (obj instanceof Driver) {
            return _driver.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        return _driver.hashCode();
    }

    @Override
    public String toString() {
        return _driver.toString();
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }
}
