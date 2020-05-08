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
package org.datacleaner.util.convert;

import org.apache.metamodel.util.InMemoryResource;
import org.apache.metamodel.util.Resource;
import org.datacleaner.util.ReflectionUtils;
import org.datacleaner.util.convert.ResourceConverter.ResourceTypeHandler;

/**
 * A {@link ResourceTypeHandler} that handles resource with the "repo" scheme,
 * produced by the DataCleaner monitor. Since the desktop client is not
 * connected to the monitor repository, we will only serve empty
 * {@link InMemoryResource}s for these requests. While this may cause data to be
 * missing from these resources, it does cover the basic scenarios of being able
 * to load jobs etc.
 * 一个{@link ResourceTypeHandler}，它使用由DataCleaner监视器生成的“回购”方案来处理资源。
 * 由于桌面客户端未连接到监视器存储库，因此我们将仅为这些请求提供空的{@link InMemoryResource}。
 * 虽然这可能会导致这些资源中的数据丢失，但它确实涵盖了能够加载作业等的基本情况。
 */
public class DummyRepositoryResourceFileTypeHandler implements ResourceTypeHandler<InMemoryResource> {

    @Override
    public String createPath(final Resource res) {
        final InMemoryResource resource = (InMemoryResource) res;
        return resource.getPath();
    }

    @Override
    public String getScheme() {
        return "repo";
    }

    @Override
    public boolean isParserFor(final Class<? extends Resource> resourceClass) {
        return ReflectionUtils.is(resourceClass, InMemoryResource.class);
    }

    @Override
    public InMemoryResource parsePath(final String path) {
        return new InMemoryResource(path);
    }

}
