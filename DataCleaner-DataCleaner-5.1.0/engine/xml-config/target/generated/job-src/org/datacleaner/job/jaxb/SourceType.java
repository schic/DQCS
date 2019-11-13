//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:47 PM CST 
//


package org.datacleaner.job.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sourceType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="sourceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="data-context" type="{http://eobjects.org/analyzerbeans/job/1.0}dataContextType" minOccurs="0"/&gt;
 *         &lt;element name="columns" type="{http://eobjects.org/analyzerbeans/job/1.0}columnsType" minOccurs="0"/&gt;
 *         &lt;element name="variables" type="{http://eobjects.org/analyzerbeans/job/1.0}variablesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sourceType", propOrder = {
    "dataContext",
    "columns",
    "variables"
})
public class SourceType {

    @XmlElement(name = "data-context")
    protected DataContextType dataContext;
    protected ColumnsType columns;
    protected VariablesType variables;

    /**
     * 获取dataContext属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DataContextType }
     *     
     */
    public DataContextType getDataContext() {
        return dataContext;
    }

    /**
     * 设置dataContext属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DataContextType }
     *     
     */
    public void setDataContext(DataContextType value) {
        this.dataContext = value;
    }

    /**
     * 获取columns属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ColumnsType }
     *     
     */
    public ColumnsType getColumns() {
        return columns;
    }

    /**
     * 设置columns属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnsType }
     *     
     */
    public void setColumns(ColumnsType value) {
        this.columns = value;
    }

    /**
     * 获取variables属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VariablesType }
     *     
     */
    public VariablesType getVariables() {
        return variables;
    }

    /**
     * 设置variables属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VariablesType }
     *     
     */
    public void setVariables(VariablesType value) {
        this.variables = value;
    }

}
