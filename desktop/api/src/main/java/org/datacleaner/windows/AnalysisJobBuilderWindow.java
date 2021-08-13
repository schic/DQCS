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
package org.datacleaner.windows;

import org.apache.commons.vfs2.FileObject;
import org.apache.metamodel.util.HasName;
import org.datacleaner.configuration.DataCleanerConfiguration;
import org.datacleaner.connection.Datastore;
import org.datacleaner.guice.DCModule;
import org.datacleaner.job.builder.AnalysisJobBuilder;
import org.datacleaner.user.UserPreferences;
import org.datacleaner.util.PropertyUtil;

/**
 * This interface represents the main window in the DataCleaner GUI. An
 * {@link AnalysisJobBuilderWindow} has it's name because it's primary purpose
 * is to present a job that is being built. Behind the covers this job state is
 * respresented in the {@link AnalysisJobBuilder} class.
 * 此界面表示DataCleaner GUI中的主窗口。
 * {@link AnalysisJobBuilderWindow}的名称是因为它的主要目的是表示正在构建的作业。
 * 封面的后面是该工作状态*在{@link AnalysisJobBuilder}类中表示。
 *
 * Besides job building, an {@link AnalysisJobBuilderWindow} also handles
 * datastore selection and menus in general.
 * 除工作建立外，{@link AnalysisJobBuilderWindow}通常还处理数据存储区选择和菜单。
 */
public interface AnalysisJobBuilderWindow extends DCWindow {

    enum AnalysisWindowPanelType implements HasName {

        WELCOME(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.welcome")),

        SELECT_DS(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.select.datastore")),

        MANAGE_DS(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.manage.datastores")),

        EDITING_CONTEXT(PropertyUtil.getProperty("datacleaner.ui.desktop.canvas.analyisi.job"));

        private final String _name;

        AnalysisWindowPanelType(final String name) {
            _name = name;
        }

        @Override
        public String getName() {
            return _name;
        }
    }

    /**
     * Gets whether or not the datastore has been set in this window (ie. if the
     * tree is showing a datastore).
     *
     * @return true if a datastore is set.
     */
    boolean isDatastoreSet();

    /**
     * Initializes the window to use a particular datastore in the schema tree.
     *
     * @param datastore
     */
    void setDatastore(Datastore datastore);

    /**
     * Initializes the window to use a particular datastore in the schema tree.
     *
     * @param datastore
     * @param expandTree
     *            true if the datastore tree should be initially expanded.
     */
    void setDatastore(Datastore datastore, boolean expandTree);

    /**
     * Gets the current job file
     *
     * @return
     */
    FileObject getJobFile();

    /**
     * Sets the job file of the window (will be visible in the title and more).
     *
     * @param jobFile
     */
    void setJobFile(FileObject jobFile);

    /**
     * Gets whether datastore selection is enabled.
     *
     * @see #setDatastoreSelectionEnabled(boolean)
     * @return a boolean indicating whether or not datastore selection is
     *         enabled.
     */
    boolean isDatastoreSelectionEnabled();

    /**
     * Sets whether or not datastore selection should be enabled (default is
     * true). If disabled, only a single datastore will be usable within this
     * window.
     *
     * @param datastoreSelectionEnabled
     */
    void setDatastoreSelectionEnabled(boolean datastoreSelectionEnabled);

    /**
     * Applies property values for all job components visible in the window.
     */
    void applyPropertyValues();

    /**
     * Gets the status text of the status label. Useful if something goes wrong
     * - this status label will typically have a humanly readable explanation.
     *
     * @return
     */
    String getStatusLabelText();

    /**
     * Sets the status label text. Note that the status label text changes based
     * on multiple events, so the duration of a given text may not be for long.
     *
     * @param statusLabelText
     */
    void setStatusLabelText(String statusLabelText);

    /**
     * Sets the icon of the status label to indicate an error situation
     */
    void setStatusLabelError();

    /**
     * Sets the icon of the status label to indicate a warning situation
     */
    void setStatusLabelWarning();

    /**
     * Sets the icon of the status label to indicate an valid situation
     */
    void setStatusLabelValid();

    /**
     * Sets the icon of the status label to indicate an notice/informational
     * situation
     */
    void setStatusLabelNotice();

    /**
     * Gets the {@link AnalysisJobBuilder} that the window currently represents.
     *
     * @return
     */
    AnalysisJobBuilder getAnalysisJobBuilder();

    /**
     * Changes the current panel showing in the builder
     *
     * @param panel
     */
    void changePanel(AnalysisWindowPanelType panel);

    /**
     * Gets the {@link DataCleanerConfiguration} that the window is based on.
     *
     * @return
     */
    DataCleanerConfiguration getConfiguration();

    /**
     * Gets the {@link UserPreferences} of the current session
     *
     * @return
     */
    UserPreferences getUserPreferences();

    /**
     * Gets the {@link DCModule} that this window is scoped within
     *
     * @return
     */
    DCModule getDCModule();
}
