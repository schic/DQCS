/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
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
package org.datacleaner.monitor.scheduling.model;

/**
 * Represents the severity of an {@link AlertDefinition}. Such severity is used
 * to categorize and determine appropriate actions in case an alert is raised.
 * 表示{@link AlertDefinition}的严重性。此类严重性用于进行分类并确定适当的操作，以防发生警报。
 *
 * The available severities are (in order of increasing severity):
 * <ul>
 * <li>INTELLIGENCE - for mostly informational and reporting oriented alerts.
 * This is the least severe type of alert.</li>
 * <li>SURVEILLANCE - this severity is used for alerts that monitor metrics that
 * are under surveillance because a data stewards suspects that the metric might
 * fluctuate or be going in the wrong direction.</li>
 * <li>WARNING - Alerts that are considered dangerous to the data quality.
 * Warnings will typically prompt the data steward to take action.</li>
 * <li>FATAL - Alerts that are raised in cases of fatal data issues in the
 * monitored system</li>
 * </ul>
 * 可用的严重等级为（按严重程度递增的顺序）：
 * INTELLIGENCE - 适用于大多数以信息和报告为导向的警报。这是最不严重的警报类型。
 * SURVEILLANCE - 此严重性用于监视处于监视状态的指标的警报,因为数据管理员怀疑该指标可能波动或方向错误。
 * WARNING - 被认为对数据质量有害的警报.警告通常会提示数据管理员采取措施。
 * FATAL - 在受监视的系统中出现致命数据问题时引发的警报
 */
public enum AlertSeverity {

    INTELLIGENCE, SURVEILLANCE, WARNING, FATAL
}
