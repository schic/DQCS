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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.metamodel.schema.Column;
import org.datacleaner.api.InputColumn;
import org.datacleaner.connection.Datastore;

/**
 * Defines a job to be executed by DataCleaner.
 * 定义要由DataCleaner执行的作业。
 *
 * A {@link AnalysisJob} contains a set of components.
 * {@link AnalysisJob}包含一组组件。
 *
 * A {@link AnalysisJob} references a source {@link Datastore} and some
 * {@link Column}s (represented via {@link InputColumn}s) of this datastore.
 * {@link AnalysisJob}引用源{@link Datastore}和该数据存储的一些{@link Column}
 * （通过{@link InputColumn}表示）。
 *
 * Building jobs is usually done using the <b>AnalysisJobBuilder</b> class.
 * 通常使用 AnalysisJobBuilder 类完成构建作业。
 *
 * Executing jobs is usually done using the <b>AnalysisRunner</b> interface.
 * 执行作业通常是使用 AnalysisRunner 界面完成的。
 */
public interface AnalysisJob {

    /**
     * Gets the {@link AnalysisJobMetadata} which add additional descriptions
     * and properties of the job.
     *
     * @return
     */
    AnalysisJobMetadata getMetadata();

    /**
     * Gets the {@link Datastore} that this job uses as it's source.
     *
     * @return
     */
    Datastore getDatastore();

    /**
     * Gets the source columns of the {@link Datastore} (see
     * {@link #getDatastore()}) referenced by this job.
     *
     * @return
     */
    List<InputColumn<?>> getSourceColumns();

    /**
     * Gets all {@link TransformerJob}s contained in this job.
     *
     * @return
     */
    List<TransformerJob> getTransformerJobs();

    /**
     * Gets all {@link FilterJob}s contained in this job.
     *
     * @return
     */
    List<FilterJob> getFilterJobs();

    /**
     * Gets all {@link AnalyzerJob}s contained in this job.
     *
     * @return
     */
    List<AnalyzerJob> getAnalyzerJobs();

    /**
     * Get all {@link ComponentJob}s contained in this job.
     *
     * @return
     */
    default List<ComponentJob> getComponentJobs() {
        final ArrayList<ComponentJob> componentJobs = new ArrayList<>();
        componentJobs.addAll(getTransformerJobs());
        componentJobs.addAll(getAnalyzerJobs());
        componentJobs.addAll(getFilterJobs());
        return componentJobs;
    }

    default Stream<AnalysisJob> flattened() {
        return Stream.concat(Stream.of(this), getComponentJobs().stream().flatMap(
                componentJob -> Stream.of(componentJob.getOutputDataStreamJobs()).map(OutputDataStreamJob::getJob))
                .flatMap(AnalysisJob::flattened));
    }
}
