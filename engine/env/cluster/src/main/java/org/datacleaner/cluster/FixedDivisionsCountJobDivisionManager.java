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
package org.datacleaner.cluster;

import org.datacleaner.job.AnalysisJob;

/**
 * A simple {@link JobDivisionManager} which builds divisions based on a
 * preferred fixed number of divisions. Typically this fixed number will be the
 * number of slave nodes in the cluster.
 * 一个简单的{@link JobDivisionManager}，它基于首选块大小来构建分区。
 * 例如，如果块大小为1000条记录，且传入作业的预期行数为30,000条记录-那么将进行30个划分。
 */
public class FixedDivisionsCountJobDivisionManager implements JobDivisionManager {

    private final int _divisionCount;

    public FixedDivisionsCountJobDivisionManager(final int divisionCount) {
        if (divisionCount <= 0) {
            throw new IllegalArgumentException("Division count must be a positive integer");
        }
        _divisionCount = divisionCount;
    }

    @Override
    public int calculateDivisionCount(final AnalysisJob masterJob, final int expectedRows) {
        return _divisionCount;
    }

}
