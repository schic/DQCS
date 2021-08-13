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
package org.datacleaner.monitor.configuration;

import java.io.File;

import org.datacleaner.configuration.DataCleanerHomeFolder;
import org.datacleaner.repository.RepositoryFolder;
import org.datacleaner.repository.file.FileRepositoryFolder;

/**
 * Implementation of {@link DataCleanerHomeFolder} for the DataCleaner monitor
 * webapp.
 * 为DataCleaner监视器*webapp实现{@link DataCleanerHomeFolder}。
 * 
 * This implementation provides a central place to have a fallback strategy in
 * cases where the repository is not file based, so that {@link #toFile()} will
 * return a useable directory.
 * 在存储库不是基于文件的情况下，此实现提供了一个后备策略的中心位置，
 * 因此{@link #toFile（）}将返回可用的目录。
 */
public class TenantHomeFolder implements DataCleanerHomeFolder {

    private final RepositoryFolder _tenantRootFolder;

    public TenantHomeFolder(RepositoryFolder tenantRootFolder) {
        _tenantRootFolder = tenantRootFolder;
    }

    @Override
    public File toFile() {
        if (_tenantRootFolder instanceof FileRepositoryFolder) {
            return ((FileRepositoryFolder) _tenantRootFolder).getFile();
        }
        final String userHome = System.getProperty("user.home");
        final String tenantId = _tenantRootFolder.getName();
        final String directoryName = userHome + File.separator + ".datacleaner/repository/" + tenantId;

        return new File(directoryName);
    }

    @Override
    public RepositoryFolder toRepositoryFolder() {
        return _tenantRootFolder;
    }

}
