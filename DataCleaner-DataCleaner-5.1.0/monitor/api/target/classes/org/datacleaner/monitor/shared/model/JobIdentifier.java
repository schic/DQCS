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
package org.datacleaner.monitor.shared.model;

import java.io.Serializable;

import org.datacleaner.monitor.scheduling.model.ExecutionIdentifier;
import org.datacleaner.monitor.scheduling.model.ExecutionLog;

/**
 * Identifies a job in the repository. The identifier is based on the name of
 * the job, but typically also holds the type (in the form of a JobType class
 * name) of the job.
 */
public class JobIdentifier implements Serializable, Comparable<JobIdentifier>, HasName {

    private static final long serialVersionUID = 1L;

    public static final String JOB_TYPE_ANALYSIS_JOB = "DataCleanerAnalysisJob";
    public static final String JOB_TYPE_CUSTOM_JOB = "CustomJob";

    private String _name;
    private String _type;

    public JobIdentifier(String name, String type) {
        _name = name;
        _type = type;
    }

    public JobIdentifier(String name) {
        this(name, null);
    }

    public JobIdentifier() {
        this(null);
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    @Override
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_name == null) ? 0 : _name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JobIdentifier other = (JobIdentifier) obj;
        if (_name == null) {
            if (other._name != null)
                return false;
        } else if (!_name.equals(other._name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "JobIdentifier[name=" + _name + "]";
    }

    @Override
    public int compareTo(JobIdentifier o) {
        return getName().compareTo(o.getName());
    }

    public static JobIdentifier fromResultId(String resultId) {
        if (resultId == null || "".equals(resultId)) {
            throw new IllegalArgumentException("Result ID cannot be null or empty string");
        }

        final int lastIndexOfDash = resultId.lastIndexOf('-');
        if (lastIndexOfDash == -1 || lastIndexOfDash == 0) {
            throw new IllegalArgumentException("Result ID '" + resultId
                    + "' does not match expected pattern: [jobname]-[timestamp]");
        }

        final String timestamp = resultId.substring(lastIndexOfDash + 1);
        try {
            Long.parseLong(timestamp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Result ID '" + resultId
                    + "' does not match expected pattern: [jobname]-[timestamp]");
        }
        
        final String jobName = resultId.substring(0, lastIndexOfDash);

        return new JobIdentifier(jobName);
    }

    public static JobIdentifier fromExecutionIdentifier(ExecutionIdentifier executionIdentifier) {
        if (executionIdentifier instanceof ExecutionLog) {
            JobIdentifier job = ((ExecutionLog) executionIdentifier).getJob();
            if (job != null) {
                return job;
            }
        }
        String resultId = executionIdentifier.getResultId();
        return fromResultId(resultId);
    }

}
