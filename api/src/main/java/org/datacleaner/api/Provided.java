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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Methods and fields with the @Provided annotation are used to let component
 * retrieve service-objects such as persistent collections, the current
 * SchemaNavigator or DataContext.
 * 带有@Provided批注的方法和字段用于使组件检索服务对象，
 * 例如持久性集合，当前的SchemaNavigator或DataContext。
 *
 * This features ensures separation of concerns: The framework will make sure
 * that persistence is handled and the component developer will not have to worry
 * about memory problems related to his/her collection(s).
 * 此功能可确保关注点分离：框架将确保处理持久性，并且组件开发人员将不必担心与他/她的收藏相关的内存问题。
 *
 * Additionally components can use the @Provided annotation to inject a
 * SchemaNavigator in order to perform metadata-based analysis. A Datastore
 * can also be injected.
 * 另外，组件可以使用@Provided批注注入SchemaNavigator，以执行基于元数据的分析。还可以注入数据存储。
 *
 * Valid types for @Provided annotated fields and method arguments are:
 * <ul>
 * <li>org.datacleaner.configuration.DataCleanerConfiguration</li>
 * <li>org.datacleaner.connection.Datastore</li>
 * <li>org.datacleaner.connection.SchemaNavigator</li>
 * <li>org.datacleaner.storage.CollectionFactory</li>
 * <li>org.datacleaner.storage.RowAnnotationFactory</li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
@Inherited
public @interface Provided {
}
