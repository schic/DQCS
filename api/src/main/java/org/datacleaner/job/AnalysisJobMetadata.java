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

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.metamodel.schema.ColumnType;

/**
 * Defines the metadata of a job. This metadata type can be used to present
 * basic information about a job to the user before he/she decides to open the
 * job. Because opening a job may fail the metadata can also be used to do
 * various verifications. In particular it is needed that the datastore name is
 * matched in the current configuration and that the source column paths are
 * present in that particular datastore.
 * 定义作业的元数据。此元数据类型可用于在用户决定打开作业之前向其呈现有关该作业的基本信息。
 * 因为打开工作可能失败，所以元数据也可以用于进行各种验证。
 * 尤其需要在当前配置中匹配数据存储名称，并且在该特定数据存储中存在源列路径。
 */
public interface AnalysisJobMetadata {

    AnalysisJobMetadata EMPTY_METADATA = new EmptyAnalysisJobMetadata();

    String getJobName();

    String getJobVersion();

    String getJobDescription();

    String getAuthor();

    Date getCreatedDate();

    Date getUpdatedDate();

    String getDatastoreName();

    List<String> getSourceColumnPaths();

    List<ColumnType> getSourceColumnTypes();

    Map<String, String> getVariables();

    Map<String, String> getProperties();
}
