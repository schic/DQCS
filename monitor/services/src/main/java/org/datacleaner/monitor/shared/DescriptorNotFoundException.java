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
package org.datacleaner.monitor.shared;

/**
 * An exception which is thrown when a component descriptor in
 * DataCleaner/AnalyzerBeans is not found. Typically this happens when jobs
 * reference components that are not available in the servers descriptor
 * provider.在DataCleaner/AnalyzerBeans中找不到组件描述符时引发的异常。通常，当作业引用服务器描述符提供程序中不可用的组件时，会发生这种情况。
 */
public class DescriptorNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public DescriptorNotFoundException(String message) {
        super(message);
    }

    public DescriptorNotFoundException() {
        super();
    }
}
