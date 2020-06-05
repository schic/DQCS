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
package org.datacleaner.cluster;

import org.datacleaner.configuration.DataCleanerConfiguration;
import org.datacleaner.job.builder.AnalysisJobBuilder;

/**
 * Represents an optional component that can intercept a slave job as it has
 * been parsed/read by the slave node. Using this component type, slaves can be
 * configured to e.g. replace certain job configuration options, perform local
 * logging operations or similar actions.
 * 表示一个可选组件，该组件可以拦截从属节点已经解析/读取的从属作业。
 * 使用此组件类型，可以将从站配置为。替换某些作业配置选项，执行本地日志记录操作或类似操作。
 */
public interface SlaveJobInterceptor {

    void intercept(AnalysisJobBuilder jobBuilder, DataCleanerConfiguration configuration);

}
