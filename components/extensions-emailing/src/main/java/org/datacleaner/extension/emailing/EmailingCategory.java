package org.datacleaner.extension.emailing;

import org.datacleaner.components.categories.AbstractComponentCategory;
import org.datacleaner.util.PropertyUtil;

public class EmailingCategory extends AbstractComponentCategory {

    private static final long serialVersionUID = 1L;

    @Override
    public String getName() {
        return  PropertyUtil.getProperty("Emailing");
    }
}
