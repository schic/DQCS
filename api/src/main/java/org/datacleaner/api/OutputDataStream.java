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
package org.datacleaner.api;

import java.io.Serializable;

import org.apache.metamodel.query.Query;
import org.apache.metamodel.schema.Table;
import org.apache.metamodel.util.HasName;
import org.datacleaner.connection.PerformanceCharacteristics;

/**
 * Interface that describes the metadata of an output data stream.
 * 描述输出数据流的元数据的接口。
 *
 * See {@link HasOutputDataStreams} for details on how the metadata relates to
 * actual data.
 * 有关元数据如何与实际数据相关的详细信息，请参见{@link HasOutputDataStreams}。
 */
public interface OutputDataStream extends HasName, Serializable {

    /**
     * Gets the name of the output data stream, as presented to the user and
     * referenced to in analysis job files etc.
     */
    @Override
    String getName();

    /**
     * Gets the logical (or physical) {@link Table} objects that represent the
     * format of the data that will be made available by the data stream.
     *
     * @return
     */
    Table getTable();

    /**
     * Gets performance characteristics of the output data stream. This may
     * influence the {@link Query} posted to consume the data. See
     * {@link HasOutputDataStreams#initializeOutputDataStream(OutputDataStream, Query, OutputRowCollector)}
     * for details on usage.
     *
     * @return
     */
    PerformanceCharacteristics getPerformanceCharacteristics();
}
