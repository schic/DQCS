package org.datacleaner.visualization

import org.datacleaner.components.categories.AbstractComponentCategory
import org.datacleaner.util.PropertyUtil

class VisualizationCategory extends AbstractComponentCategory {

  override def getName() = PropertyUtil.getProperty("Visualization");
}
