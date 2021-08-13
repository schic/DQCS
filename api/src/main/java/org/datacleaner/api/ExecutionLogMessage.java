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
package org.datacleaner.api;

import org.slf4j.Logger;

/**
 * Commonly used {@link ComponentMessage} which represents a message from the
 * component to the end user inspecting the log of a job's execution.
 * 常用的{@link ComponentMessage}表示从组件到检查作业执行日志的最终用户的消息。
 *
 * Components are advised to only publish this type of message with especially
 * relevant information. Use a regular {@link Logger} for background information
 * of relevance to the system administration.
 * 建议组件仅发布带有特别相关信息的此类消息。使用常规的{@link Logger}获取与系统管理相关的背景信息。
 */
public class ExecutionLogMessage implements ComponentMessage {

    private final String _message;

    public ExecutionLogMessage(final String message) {
        _message = message;
    }

    public String getMessage() {
        return _message;
    }

    @Override
    public String toString() {
        return "ExecutionLogMessage[" + _message + "]";
    }
}
