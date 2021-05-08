package org.datacleaner.beans.unleo;

import org.apache.metamodel.util.HasName;

/**
 * @author Leo
 * @description
 * @date
 **/
public enum MatchDateType implements HasName {

    LAST_WEEK("last week", String.class),
    LAST_MONTH("last month", String.class),
    LAST_THREE_MONTHS("last three months", String.class),
    LAST_HALF_YEAR("last half year", String.class);

    private final String _name;
    private final Class<?> _outputClass;

    MatchDateType(final String name, final Class<?> outputClass) {
        _name = name;
        _outputClass = outputClass;
    }

    @Override
    public String getName() {
        return _name;
    }

    public Class<?> getOutputClass() {
        return _outputClass;
    }
}
