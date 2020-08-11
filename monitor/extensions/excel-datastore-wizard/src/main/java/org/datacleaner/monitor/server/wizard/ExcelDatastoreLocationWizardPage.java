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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.datacleaner.monitor.shared.model.DCUserInputException;
import org.datacleaner.monitor.wizard.WizardContext;
import org.datacleaner.monitor.wizard.WizardPageController;
import org.datacleaner.monitor.wizard.common.AbstractFreemarkerWizardPage;
import org.datacleaner.repository.RepositoryFolder;
import org.datacleaner.repository.file.FileRepositoryFolder;

/**
 * Page where user selects which folder the file should be located in
 */
public abstract class ExcelDatastoreLocationWizardPage extends AbstractFreemarkerWizardPage {

    private final WizardContext _wizardContext;
    private final String _filename;
    private final boolean _newFile;

    public ExcelDatastoreLocationWizardPage(WizardContext wizardContext, String filename, boolean newFile) {
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
        return "ExcelDatastoreLocationWizardPage.html";
    }

    @Override
    protected Map<String, Object> getFormModel() {
        final String absolutePrefix = File.listRoots()[0].getAbsolutePath() + "data" + File.separatorChar;

        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("filename", _filename);
        map.put("absolutePrefix", absolutePrefix);

        if (_newFile) {
            map.put("introductionText", "Excel电子表格的服务器位置应该是什么：");
            map.put("repositoryText", "将其复制到存储库中的某个位置：");
            map.put("absoluteText", "将其复制到服务器上的绝对位置：");
        } else {
            map.put("introductionText", "Excel电子表格的服务器位置是什么：");
            map.put("repositoryText", "它位于存储库中：");
            map.put("absoluteText", "它在服务器上的绝对位置：");
        }

        return map;
    }

    @Override
    public WizardPageController nextPageController(Map<String, List<String>> formParameters)
            throws DCUserInputException {
        final List<String> locations = formParameters.get("location");
        if (locations == null || locations.isEmpty()) {
            throw new DCUserInputException("请选择Excel电子表格的位置");
        }

        final String location = locations.get(0);
        final String filepath;
        final File file;
        if ("repository".equals(location)) {
            filepath = formParameters.get("filepath_repository").get(0);
            final RepositoryFolder tenantFolder = _wizardContext.getTenantContext().getTenantRootFolder();
            if (!(tenantFolder instanceof FileRepositoryFolder)) {
                throw new DCUserInputException("您的存储库类型不支持托管原始数据文件");
            }

            final FileRepositoryFolder fileRepositoryFolder = (FileRepositoryFolder) tenantFolder;

            file = new File(fileRepositoryFolder.getFile(), filepath);
        } else if ("absolute".equals(location)) {
            filepath = formParameters.get("filepath_absolute").get(0);
            file = new File(filepath);
        } else {
            throw new IllegalArgumentException("无效的位置: " + location);
        }

        return nextPageController(filepath, file);
    }

    /**
     * Invoked when the user has selected a file location on the server of the
     * Excel spreadsheet.
     *
     * @param filepath
     * @param file
     * @return
     */
    protected abstract WizardPageController nextPageController(String filepath, File file);

}
