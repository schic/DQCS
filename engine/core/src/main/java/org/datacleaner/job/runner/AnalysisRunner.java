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
package org.datacleaner.job.runner;

import org.datacleaner.job.AnalysisJob;

/**
 * Central component for executing/running AnalysisJobs. Typically an
 * AnalysisRunner will do all the complicated work of traversing the
 * AnalysisJob, setting up filters, transformers and analyzers and kick off row
 * processing.
 * 执行/运行AnalysisJobs的中央组件。通常，AnalysisRunner将完成遍历AnalysisJob，
 * 设置过滤器，转换器和分析器以及启动行处理的所有复杂工作。
 *
 * Typeically an AnalysisRunner will be able to utilize multithreading and will
 * therefore be able to return much earlier than when the job is finished.
 * Therefore the result of the run(...) method is a <i>Future</i>, which means
 * that it is a reference to a future result. You can use the future to ask if
 * the result is ready or it is possible to wait/block untill it is done.
 *通常，AnalysisRunner将能够利用多线程，因此可以比作业完成时更早返回。
 * 因此，run（...）方法的结果是<i> Future </ i>，这意味着它是对将来结果的引用。
 * 您可以使用将来的程序询问结果是否已准备好，或者可以等待/阻止直到完成。
 *
 */
public interface AnalysisRunner {

    AnalysisResultFuture run(AnalysisJob job);
}
