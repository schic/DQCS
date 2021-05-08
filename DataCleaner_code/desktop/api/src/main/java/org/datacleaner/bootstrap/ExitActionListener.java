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
package org.datacleaner.bootstrap;

/**
 * Represents the action listener invoked when the user quits DataCleaner.
 * 表示用户退出DataCleaner时调用的操作侦听器。
 *
 * Typically the exit call will stop the process completely, but for embedded
 * use it might instead simply change the state of the surrounding application
 * or similar.
 * 通常，退出调用将完全停止该过程，但对于嵌入式使用，它可能只是更改周围应用程序或类似状态的状态。
 */
public interface ExitActionListener {

    void exit(int statusCode);
}
