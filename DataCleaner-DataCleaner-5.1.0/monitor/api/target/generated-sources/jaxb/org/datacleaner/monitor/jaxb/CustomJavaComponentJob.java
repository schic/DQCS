//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.12 时间 04:02:39 PM CST 
//


package org.datacleaner.monitor.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>customJavaComponentJob complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="customJavaComponentJob"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="class-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="properties" type="{http://eobjects.org/datacleaner/custom-job/1.0}propertiesType" minOccurs="0"/&gt;
 *         &lt;element name="group-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="persist-result" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customJavaComponentJob", namespace = "http://eobjects.org/datacleaner/custom-job/1.0", propOrder = {

})
public class CustomJavaComponentJob {

    @XmlElement(name = "class-name")
    protected String className;
    protected PropertiesType properties;
    @XmlElement(name = "group-name")
    protected String groupName;
    @XmlElement(name = "persist-result")
    protected Boolean persistResult;

    /**
     * 获取className属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置className属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * 获取properties属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PropertiesType }
     *     
     */
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * 设置properties属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesType }
     *     
     */
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * 获取groupName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置groupName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * 获取persistResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPersistResult() {
        return persistResult;
    }

    /**
     * 设置persistResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPersistResult(Boolean value) {
        this.persistResult = value;
    }

}
