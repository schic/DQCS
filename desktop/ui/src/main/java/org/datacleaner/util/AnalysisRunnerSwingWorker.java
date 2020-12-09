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
package org.datacleaner.util;

import java.util.concurrent.TimeUnit;

import javax.swing.SwingWorker;

import org.datacleaner.configuration.DataCleanerConfiguration;
import org.datacleaner.job.AnalysisJob;
import org.datacleaner.job.runner.AnalysisListener;
import org.datacleaner.job.runner.AnalysisResultFuture;
import org.datacleaner.job.runner.AnalysisRunner;
import org.datacleaner.job.runner.AnalysisRunnerImpl;
import org.datacleaner.windows.ResultWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link SwingWorker} that fires the execution of an {@link AnalysisJob} and
 * publishes updated to a {@link ResultWindow}.
 * {@link SwingWorker}会触发{@link AnalysisJob}的执行，并且将更新发布到{@link ResultWindow}。
 */
public final class AnalysisRunnerSwingWorker extends SwingWorker<AnalysisResultFuture, Void> {

    private static final Logger logger = LoggerFactory.getLogger(AnalysisRunnerSwingWorker.class);
    private final AnalysisRunner _analysisRunner;
    private final AnalysisJob _job;
    private final ResultWindow _resultWindow;

    public AnalysisRunnerSwingWorker(final DataCleanerConfiguration configuration, final AnalysisJob job,
            final ResultWindow resultWindow) {
        final AnalysisListener analysisListener = resultWindow.createAnalysisListener();
        _analysisRunner = new AnalysisRunnerImpl(configuration, analysisListener);
        _job = job;
        _resultWindow = resultWindow;
    }

    @Override
    protected AnalysisResultFuture doInBackground() throws Exception {
        try {
            return _analysisRunner.run(_job);
        } catch (final Exception e) {
            logger.error("Unexpected error occurred when invoking run(...) on AnalysisRunner", e);
            _resultWindow.onUnexpectedError(_job, e);
            throw e;
        }
    }

    public void cancelIfRunning() {
        final javax.swing.SwingWorker.StateValue state = getState();
        switch (state) {
        case STARTED:
        case DONE:
            try {
                final AnalysisResultFuture resultFuture = get(2, TimeUnit.SECONDS);
                if (!resultFuture.isDone()) {
                    resultFuture.cancel();
                }
            } catch (final Exception e) {
                logger.warn("未能取消作业", e);
            }
            break;
        case PENDING:
            logger.info("SwingWorker hasn't started yet - cancelIfRunning() invocation disregarded");
            break;
        default:
            throw new IllegalArgumentException();
        }
    }
}
