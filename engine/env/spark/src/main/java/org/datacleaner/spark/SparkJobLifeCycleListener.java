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
package org.datacleaner.spark;

import java.io.Serializable;

/**
 * Implement this interface for following the lifecycle of a Spark job.
 * 实施此接口以遵循Spark作业的生命周期。
 *
 * It is important that the implementation is serializable and with as few
 * and small fields as possible, as the listener will be serialized and sent to
 * nodes.
 * 重要的是，实现是可序列化的，并具有尽可能少的和小字段，因为侦听器将被序列化并发送到节点。
 *
 * Also note that the serialization is one-way. You cannot retrieve anything that
 * happened on the nodes through this listener.
 * 另请注意，序列化是单向的。您无法通过此侦听器检索节点上发生的任何事情。
 */
public interface SparkJobLifeCycleListener extends Serializable {
    /**
     * Triggered when a node starts processing a task. This will be executed
     * on the nodes themselves.
     */
    void onPartitionProcessingStart(SparkJobContext sparkJobContext);

    /**
     * Triggered when a node completes processing a task. This will be executed
     * on the nodes themselves.
     */
    void onPartitionProcessingEnd(SparkJobContext sparkJobContext);

    /**
     * Triggered as the job starts running.
     */
    void onJobStart(SparkJobContext sparkJobContext);

    /**
     * Triggered on job completion.
     */
    void onJobEnd(SparkJobContext sparkJobContext);
}
