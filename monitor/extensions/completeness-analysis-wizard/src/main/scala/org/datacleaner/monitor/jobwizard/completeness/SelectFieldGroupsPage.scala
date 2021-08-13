package org.datacleaner.monitor.jobwizard.completeness

import org.datacleaner.monitor.wizard.WizardPageController
import org.datacleaner.monitor.shared.model.DCUserInputException

abstract class SelectFieldGroupsPage(pageIndex: Int) extends WizardPageController {

  override def getPageIndex = pageIndex

  override def getFormInnerHtml: String = {
    return <div>
             <p>
               可以使用不同级别的粒度来检查完整性。您可以选择只包含一组要检查完整性的大字段，也可以选择为一组连接的字段选择单个字段组。例如，
             </p>
             <ul>
               <li>将“给定名称”和“家族名称”的字段视为具有标题“名称”的单个字段组。</li>
               <li>指定所有必需信息的字段组和可选信息的字段组。</li>
             </ul>
             <p>请指定您希望添加到分析中的字段组数：</p>
             <input type="text" value="2" name="num_field_groups"/>
           </div>.toString()
  }

  override def nextPageController(formParameters: java.util.Map[String, java.util.List[String]]): WizardPageController = {
    val fieldGroupsStr = formParameters.get("num_field_groups").get(0);
    val fieldGroups = parseInt(fieldGroupsStr);
    if (fieldGroups <= 0) {
      throw new DCUserInputException("Number of field groups must be a positive integer");
    }
    return nextPageController(fieldGroups);
  }

  def parseInt(fieldGroupsStr: String): Int = {
    try {
      return Integer.parseInt(fieldGroupsStr);
    } catch {
      case _ : Throwable =>
        throw new DCUserInputException("Please provide a valid number of field groups");
    }
  }

  def nextPageController(fieldGroups: Int): WizardPageController;
}
