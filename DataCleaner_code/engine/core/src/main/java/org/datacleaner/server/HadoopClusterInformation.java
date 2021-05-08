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
package org.datacleaner.server;


import org.apache.hadoop.conf.Configuration;
import org.datacleaner.configuration.ServerInformation;

/**
 * Represents a connection to a hadoop cluster. Either by namenode or other means (i.e. in the case of MapR).
 * 表示与Hadoop集群的连接。通过名称节点或其他方式（例如，对于MapR）。
 */
public interface HadoopClusterInformation extends ServerInformation {
    Configuration getConfiguration();
}
