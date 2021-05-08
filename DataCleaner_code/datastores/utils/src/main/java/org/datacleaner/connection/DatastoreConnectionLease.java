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
package org.datacleaner.connection;

import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.metamodel.DataContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A datastore connection lease that ensures that the connection can only be
 * closed once by a particular user. The underlying (delegated) connection can
 * thus be shared safely without risking premature closing by other parties.
 * 数据存储连接租约，可确保特定用户只能关闭一次连接。
 * 因此，可以安全地共享基础（委托）连接，而不必担心其他方过早关闭。
 */
public class DatastoreConnectionLease implements DatastoreConnection {

    private static final Logger logger = LoggerFactory.getLogger(DatastoreConnectionLease.class);

    private final DatastoreConnection _delegate;
    private final AtomicBoolean _closed;

    public DatastoreConnectionLease(final DatastoreConnection delegate) {
        _delegate = delegate;
        _closed = new AtomicBoolean(false);
    }

    public DatastoreConnection getDelegate() {
        return _delegate;
    }

    public boolean isClosed() {
        return _closed.get();
    }

    @Override
    public DataContext getDataContext() {
        return _delegate.getDataContext();
    }

    @Override
    public SchemaNavigator getSchemaNavigator() {
        return _delegate.getSchemaNavigator();
    }

    @Override
    public Datastore getDatastore() {
        return _delegate.getDatastore();
    }

    @Override
    public void close() {
        final boolean changed = _closed.compareAndSet(false, true);
        if (changed) {
            _delegate.close();
        } else {
            logger.warn("连接已关闭，但已调用关闭！", new Throwable());
        }
    }

    @Override
    public String toString() {
        return "DatastoreConnectionLease[" + _delegate + "]";
    }
}
