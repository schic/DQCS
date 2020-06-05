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

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.datacleaner.api.AnalyzerResult;
import org.datacleaner.job.ComponentJob;
import org.datacleaner.result.AnalysisResult;

/**
 * Represents the result of an analysis. The analysis may still be running,
 * which is why this interface contains the isDone(), await() and
 * await(long,TimeUnit) methods.
 * 表示分析结果。分析可能仍在运行，这就是为什么此接口包含isDone（），await（）和await（long，TimeUnit）方法的原因。
 *
 * When the result is done it may either be successful or erroneous. Clients can
 * find out using the isSuccessful() or isErrornous() methods.
 * 结果完成后，它可能成功或错误。客户端可以使用isSuccessful（）或isErrornous（）方法来查找。
 *
 * If successful, the results can be retrieved like specified in the
 * {@link AnalysisResult} interface - using the getResults() method. If
 * erroneous the error messages can be retrieved using the getErrors() method.
 * If the analysis was only partly erroneous, there may be both result and
 * errors, but isSuccessful() will return false.
 *如果成功，则可以使用getResults（）方法像在{@link AnalysisResult}接口中指定的那样检索结果。
 * 如果错误，则可以使用getErrors（）方法检索错误消息。
 * 如果分析只是部分错误，则可能同时有结果和错误，但是isSuccessful（）将返回false。
 *
 */
public interface AnalysisResultFuture extends ErrorAware, AnalysisResult {

    /**
     * @return true if the job has finished
     */
    boolean isDone();

    /**
     * Blocks the current thread until interrupted, most probably because the
     * job has ended.
     */
    void await();

    /**
     * Cancels the job, if it is still running.
     */
    void cancel();

    /**
     * Blocks the current thread until interrupted, either because the job has
     * ended or because it has timed out.
     *
     * @param timeout
     * @param timeUnit
     */
    void await(long timeout, TimeUnit timeUnit);

    /**
     * @return true if the job has executed without errors
     */
    boolean isSuccessful();

    /**
     * @return SUCCESSFUL if the job is finished and successful, ERRORNOUS if
     *         errors have been reported and NOT_FINISHED if no errors have been
     *         reported but the job is not done yet
     */
    JobStatus getStatus();

    /**
     * Finds (and waits if necessary) the results of this analysis.
     *
     * @return the results from the Analyzers in the executed job
     * @throws AnalysisJobFailedException
     *             if the analysis did not go well (use isSuccessful() or
     *             isErrornous() to check)
     */
    @Override
    List<AnalyzerResult> getResults() throws AnalysisJobFailedException;

    /**
     * Finds (and waits if necessary) the results of a single Analyzer.
     *
     * @param componentJob
     *            the component job (typically AnalyzerJob) to find the result
     *            for
     * @return the result for a given component job
     * @throws AnalysisJobFailedException
     *             if the analysis did not go well (use isSuccessful() or
     *             isErrornous() to check)
     */
    @Override
    AnalyzerResult getResult(ComponentJob componentJob) throws AnalysisJobFailedException;

    /**
     * Finds (and waits if necessary) the results mapped to the Analyzer jobs
     *
     * @return a map with ComponentJobs as keys to the corresponding
     *         AnalyzerResults.
     * @throws AnalysisJobFailedException
     *             if the analysis did not go well (use isSuccessful() or
     *             isErrornous() to check)
     */
    @Override
    Map<ComponentJob, AnalyzerResult> getResultMap() throws AnalysisJobFailedException;

    /**
     * @return any errors reported during execution, if the job was not
     *         successful
     */
    @Override
    List<Throwable> getErrors();
}
