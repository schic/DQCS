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
package org.datacleaner.repository.file;

import java.io.File;
import java.io.FileFilter;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.metamodel.util.Action;
import org.apache.metamodel.util.CollectionUtils;
import org.apache.metamodel.util.ToStringComparator;
import org.datacleaner.repository.AbstractRepositoryNode;
import org.datacleaner.repository.RepositoryFile;
import org.datacleaner.repository.RepositoryFolder;
import org.datacleaner.repository.RepositoryNode;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * {@link RepositoryFolder} implementation based on a local directory.
 * 基于本地目录的{@link RepositoryFolder}实现。
 */
public class FileRepositoryFolder extends AbstractRepositoryNode implements RepositoryFolder {

    private static final long serialVersionUID = 1L;

    private final File _file;
    private final FileRepositoryFolder _parent;

    private transient LoadingCache<File, RepositoryNode> _childCache;

    public FileRepositoryFolder(final FileRepositoryFolder parent, final File file) {
        if (file == null) {
            throw new IllegalArgumentException("文件不能为空");
        }
        if (!file.exists()) {
            throw new IllegalArgumentException("文件不存在：" + file);
        }
        _parent = parent;
        _file = file;
    }

    private LoadingCache<File, RepositoryNode> getChildCache() {
        if (_childCache == null) {
            _childCache = CacheBuilder.newBuilder().expireAfterAccess(10, TimeUnit.SECONDS)
                    .build(new CacheLoader<File, RepositoryNode>() {
                        @Override
                        public RepositoryNode load(final File key) throws Exception {
                            if (key.isDirectory()) {
                                return new FileRepositoryFolder(FileRepositoryFolder.this, key);
                            }
                            return new FileRepositoryFile(FileRepositoryFolder.this, key);
                        }
                    });
        }
        return _childCache;
    }

    public File getFile() {
        return _file;
    }

    @Override
    public RepositoryFolder getParent() {
        return _parent;
    }

    @Override
    public String getName() {
        return _file.getName();
    }

    @Override
    public List<RepositoryFolder> getFolders() {
        final File[] directories = _file.listFiles(file -> {
            if (file.isDirectory() && !file.isHidden() && !file.getName().startsWith(".")) {
                return true;
            }
            return false;
        });
        //Sort the directories as listFiles does not gurantee an order.
        Arrays.sort(directories);

        return CollectionUtils
                .map(directories, directory -> (RepositoryFolder) getChildCache().getUnchecked(directory));
    }

    public int getGroupsNum(){
        int num = this._file.list().length;
        return num;
    }

    @Override
    public RepositoryFile getLatestFile(final String prefix, final String extension) {
        final FileFilter baseFilter = createFileFilter(prefix, extension);

        final LatestFileFilter latestFileFilter = new LatestFileFilter(baseFilter);
        _file.listFiles(latestFileFilter);

        final File latestFile = latestFileFilter.getLatestFile();
        if (latestFile == null) {
            return null;
        }

        return (RepositoryFile) getChildCache().getUnchecked(latestFile);
    }

    @Override
    public List<RepositoryFile> getFiles(final String prefix, final String extension) {
        final File[] files = _file.listFiles(createFileFilter(prefix, extension));
        Arrays.sort(files, ToStringComparator.getComparator());
        return CollectionUtils.map(files, file -> (RepositoryFile) getChildCache().getUnchecked(file));
    }

    private FileFilter createFileFilter(final String prefix, final String extension) {
        return file -> {
            if (file.isFile() && !file.isHidden()) {
                final String filename = file.getName();
                if (prefix == null || filename.startsWith(prefix)) {
                    if (extension == null) {
                        return true;
                    } else {
                        return filename.endsWith(extension);
                    }
                }
            }
            return false;
        };
    }

    @Override
    public List<RepositoryFile> getFiles() {
        return getFiles(null, null);
    }

    public int getFilesNum(){
        int num = 0;
        int cf = 0;
        List td = new ArrayList();
        List<RepositoryFile> list = getFiles(null, null);
        for (int i = 0;i<list.size();i++){
            if (list.get(i).toString().endsWith("result.dat")){
                String string = list.get(i).toString();
                String date1 = string.substring(string.indexOf("-")+1,string.indexOf("-")+14);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                long date_temp = Long.valueOf(date1);
                Date date = new Date();
                String time = sdf.format(date);
                date.setTime(date_temp);
                if (sdf.format(date).equals(time.substring(0,10))){
                    td.add(list.get(i).toString().substring(0,string.indexOf("-")));
                }
            }
        }

        for (int i = 0;i < td.size()-1;i ++){
            for (int j = i + 1;j < td.size();j++){
                if (td.get(i).equals(td.get(j))){
                    cf ++;
                }
            }
        }

        Set stringSet=new HashSet<>(td);

        return stringSet.size();
    }

    public int getFilesNumTd(){
        int num = 0;
        List<RepositoryFile> list = getFiles(null, null);
        for (int i = 0;i<list.size();i++){
            if (list.get(i).toString().endsWith("result.dat")){
                String string = list.get(i).toString();
                String date1 = string.substring(string.indexOf("-")+1,string.indexOf("-")+14);
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                long date_temp = Long.valueOf(date1);
                Date date = new Date();
                String time = sdf.format(date);
                date.setTime(date_temp);
                if (sdf.format(date).equals(time.substring(0,10))){
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public RepositoryFile getFile(final String name) {
        if (name.indexOf('/') != -1 || name.indexOf('\\') != -1) {
            throw new IllegalArgumentException("文件名不能包含斜杠");
        }

        final File file = new File(_file, name);

        if (!file.exists()) {
            return null;
        }
        if (file.isHidden()) {
            return null;
        }

        if (!file.isFile()) {
            return null;
        }

        return (RepositoryFile) getChildCache().getUnchecked(file);
    }

    @Override
    public RepositoryFolder getFolder(final String name) {
        if (name.indexOf('/') != -1 || name.indexOf('\\') != -1) {
            throw new IllegalArgumentException("文件夹名称不能包含斜杠");
        }

        final File file = new File(_file, name);
        if (!file.exists() || file.isHidden() || !file.isDirectory()) {
            return null;
        }

        return (RepositoryFolder) getChildCache().getUnchecked(file);
    }

    @Override
    public RepositoryFile createFile(final String name, final Action<OutputStream> writeCallback) {
        if (name.indexOf('/') != -1 || name.indexOf('\\') != -1) {
            throw new IllegalArgumentException("文件名不能包含斜杠");
        }

        final File file = new File(_file, name);
        if (file.exists()) {
            throw new IllegalArgumentException("一个名为'" + name + "' 的文件已经存在");
        }

        final RepositoryFile repositoryFile = (RepositoryFile) getChildCache().getUnchecked(file);
        repositoryFile.writeFile(writeCallback);

        return repositoryFile;
    }

    @Override
    public void delete() throws IllegalStateException {
        final boolean success = _file.delete();
        if (!success) {
            throw new IllegalStateException("无法删除目录：" + _file);
        }
        _parent.onDeleted(_file);
    }

    /**
     * Notification method invoked when a child file has been deleted.
     *
     * @param file
     */
    protected void onDeleted(final File file) {
        getChildCache().invalidate(file);
    }

    @Override
    public RepositoryFolder createFolder(final String name) {
        final File file = new File(_file, name);
        if (file.exists()) {
            throw new IllegalArgumentException("名为'" + name + "' 的文件夹已经存在");
        }
        final boolean result = file.mkdir();
        if (!result) {
            throw new IllegalStateException("创建目录失败'" + name + "' 在 " + _file);
        }
        return (RepositoryFolder) getChildCache().getUnchecked(file);
    }

    @Override
    public RepositoryFolder getOrCreateFolder(final String name) {
        final File file = new File(_file, name);
        if (!file.exists()) {
            file.mkdir();
        }
        return (RepositoryFolder) getChildCache().getUnchecked(file);
    }
}
