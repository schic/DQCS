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
package org.datacleaner.job;

import org.datacleaner.api.Analyzer;
import org.datacleaner.descriptors.AnalyzerDescriptor;

/**
 * {@link ComponentJob} subinterface for {@link Analyzer}s.
 * {@link Analyzer}的{@link ComponentJob}子界面。
 *
 * @see Analyzer
 */
public interface AnalyzerJob extends ComponentJob {

    @Override
    AnalyzerDescriptor<?> getDescriptor();
}
