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
package org.datacleaner.monitor.server.wizard;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.metamodel.util.FileResource;
import org.apache.metamodel.util.Resource;
import org.datacleaner.monitor.shared.model.DCUserInputException;
import org.datacleaner.monitor.wizard.WizardContext;
import org.datacleaner.monitor.wizard.WizardPageController;
import org.datacleaner.monitor.wizard.common.AbstractFreemarkerWizardPage;
import org.datacleaner.repository.RepositoryFolder;
import org.datacleaner.repository.file.FileRepositoryFolder;
import org.datacleaner.server.EnvironmentBasedHadoopClusterInformation;
import org.datacleaner.spark.utils.HadoopUtils;
import org.datacleaner.util.HadoopResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Page where user selects which folder the file should be located in
 * 用户选择文件应位于哪个文件夹的页面
 */
public abstract class CsvDatastoreLocationWizardPage extends AbstractFreemarkerWizardPage {

    private static Logger logger = LoggerFactory.getLogger(CsvDatastoreLocationWizardPage.class);

    private final WizardContext _wizardContext;
    private final String _filename;
    private final boolean _newFile;

    public CsvDatastoreLocationWizardPage(WizardContext wizardContext, String filename, boolean newFile) {
        _wizardContext = wizardContext;
        _filename = filename;
        _newFile = newFile;
    }

    @Override
    public Integer getPageIndex() {
        return 1;
    }

    @Override
    protected String getTemplateFilename() {
        return "CsvDatastoreLocationWizardPage.html";
    }

    @Override
    protected Map<String, Object> getFormModel() {
        final String absolutePrefix = File.listRoots()[0].getAbsolutePath() + "data" + File.separatorChar;

        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("filename", _filename);
        map.put("absolutePrefix", absolutePrefix);

        if (_newFile) {
            map.put("introductionText", "CSV文件的服务器位置应该在哪：");
            map.put("repositoryText", "将其复制到存储库中的某个位置：");
            map.put("absoluteText", "将其复制到服务器上的绝对位置：");
        } else {
            map.put("introductionText", "CSV文件的服务器位置是什么：");
            map.put("repositoryText", "它位于存储库中：");
            map.put("absoluteText", "它在服务器上的绝对位置：");
            map.put("relativePrefix", "/datacleaner/");
            map.put("relativeHadoopText", "这是Hadoop集群上的路径：");
        }

        return map;
    }

    @Override
    public WizardPageController nextPageController(Map<String, List<String>> formParameters)
            throws DCUserInputException {
        final List<String> locations = formParameters.get("location");
        if (locations == null || locations.isEmpty()) {
            throw new DCUserInputException("请选择CSV文件的位置");
        }

        final String location = locations.get(0);
        final Resource resource;
        if ("repository".equals(location)) {
            final String filepath = formParameters.get("filepath_repository").get(0);
            final RepositoryFolder tenantFolder = _wizardContext.getTenantContext().getTenantRootFolder();
            if (!(tenantFolder instanceof FileRepositoryFolder)) {
                throw new DCUserInputException("您的存储库类型不支持托管原始数据文件");
            }

            final FileRepositoryFolder fileRepositoryFolder = (FileRepositoryFolder) tenantFolder;

            final File file = new File(fileRepositoryFolder.getFile(), filepath);
            resource = new FileResource(file);
        } else if ("absolute".equals(location)) {
            final String filepath = formParameters.get("filepath_absolute").get(0);
            final File file = new File(filepath);
            resource = new FileResource(file);
        } else if ("relativeHadoop".equals(location)) {
            final String path = formParameters.get("filepath_relative_hadoop").get(0);
            String uri;
            try {
                uri = HadoopUtils.getFileSystem().getUri().resolve(path).toString();
            } catch (IOException e) {
                throw new DCUserInputException("Hadoop路径不存在");
            }
            final EnvironmentBasedHadoopClusterInformation environmentBasedHadoopClusterInformation = new EnvironmentBasedHadoopClusterInformation(
                    "default", HadoopResource.DEFAULT_CLUSTERREFERENCE);
            if (!EnvironmentBasedHadoopClusterInformation.isConfigurationDirectoriesSpecified()) {
                throw new DCUserInputException("未定义HADOOP_CONF_DIR或/和SPARK_CONF_DIR");
            }

            logger.debug("Environment variable is", environmentBasedHadoopClusterInformation.getDescription());
            resource = new HadoopResource(uri, environmentBasedHadoopClusterInformation.getConfiguration(),
                    HadoopResource.DEFAULT_CLUSTERREFERENCE);
        } else {
            throw new IllegalArgumentException("无效的位置： " + location);
        }

        logger.info("资源路径是 " + resource.getQualifiedPath());
        return nextPageController(resource);
    }

    /**
     * Invoked when the user has selected a file location on the server of the
     * CSV file.
     *
     * @param filepath
     * @param resource
     * @return
     */
    protected abstract WizardPageController nextPageController(Resource resource);

}
