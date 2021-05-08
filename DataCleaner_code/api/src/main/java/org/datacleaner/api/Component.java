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

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Abstract interface for components in DataCleaner.
 * DataCleaner中组件的抽象接口。
 *
 * Usually components are annotated (at the class level) with the following
 * annotations.
 * 通常，使用以下注释对组件进行注释（在类级别）。
 *
 * All components must be annotated with {@link Named} at the class-level to be
 * discovered and exposed as functions that can be applied to a job.
 * 所有组件必须在类级别上用{@link Named}进行注释，以便被发现并公开为可以应用于作业的函数。
 *
 * Components usually has one (or more) methods that take an {@link InputRow} as
 * an argument. This is typically the main method of the component which will be
 * invoked repeatedly by the framework - once for each row in the data stream.
 * {@link Component}s are usually configured with various {@link InputColumn}s
 * which can be used as keys to retrieve values from the {@link InputRow}s.
 * 组件通常具有一个（或多个）采用{@link InputRow}作为参数的方法。
 * 这通常是组件的主要方法，将由框架重复调用-对于数据流中的每一行一次.
 * {@link Component}通常配置有各种{@link InputColumn}，这些键可用作从{@link InputRow}检索值的键。
 *
 * If needed one or more aliases can be provided using {@link Alias}. This is
 * especially useful if renaming the main name of the component - then the old
 * name can be provided as an alias to retain backwards compatibility and
 * discoverability.
 * 如果需要，可以使用{@link Alias}提供一个或多个别名。
 * 如果重命名组件的主要名称，则特别有用-可以将旧的名称用作别名，以保持向后兼容性和可发现性。
 *
 * Furthermore a description for end users can be provided using
 * {@link Description}.
 * 此外，可以使用{@link Description}提供最终用户的描述。
 *
 * If the {@link Component} also implements the {@link HasLabelAdvice} interface
 * then this will be used to present a configuration-specific label towards the
 * end user. This often helps to recognize the component instance among other
 * instances.
 * 如果{@link Component}也实现了{@link HasLabelAdvice}接口，
 * 那么它将用于向最终用户呈现特定于配置的标签。这通常有助于识别其他实例中的组件实例。
 *
 * The {@link Categorized} annotation helps to category the component into
 * logical groupings for the user to navigate.
 * {@link Categorized}注释有助于将组件分类为逻辑分组，以供用户浏览。
 *
 * The {@link Concurrent} annotation can be used to influence whether the
 * framework allows for concurrent (on same JVM) invocation of the component
 * during job execution.
 * {@link Concurrent}批注可用于影响框架是否允许作业执行期间并发（在同一JVM上）调用组件。
 *
 * The {@link Distributed} annotation determines whether a component allows to
 * be distributed across a cluster of JVM nodes.
 * {@link Distributed}批注确定组件是否允许跨JVM节点集群分布。
 *
 * Configuration of a component is provided via fields with {@link Inject} and
 * the {@link Configured} annotation.
 * 组件的配置是通过带有{@link Inject}和{@link Configured}注释的字段提供的。
 *
 * Access to environment and context classes is possible via fields with the
 * {@link Inject} and {@link Provided} annotation.
 * 通过带有{@link Inject}和{@link Provided}注释的字段可以访问环境和上下文类。
 *
 * Life-cycle methods can be added to the class if properly annotated with
 * {@link Validate}, {@link Initialize} and {@link Close}.
 * 如果使用{@link Validate}，{@ link Initialize}和{@link Close}正确注释，
 * 则可以将生命周期方法添加到类中。
 *
 * @since 4.0
 */
public interface Component {

}
