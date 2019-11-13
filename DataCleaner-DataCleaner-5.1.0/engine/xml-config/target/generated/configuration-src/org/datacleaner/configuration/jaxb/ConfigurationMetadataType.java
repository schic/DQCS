//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:46 PM CST 
//


package org.datacleaner.configuration.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>configurationMetadataType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="configurationMetadataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="configuration-name" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="configuration-description" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="configuration-version" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="created-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="updated-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configurationMetadataType", propOrder = {
    "configurationName",
    "configurationDescription",
    "configurationVersion",
    "author",
    "createdDate",
    "updatedDate"
})
public class ConfigurationMetadataType {

    @XmlElement(name = "configuration-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String configurationName;
    @XmlElement(name = "configuration-description")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String configurationDescription;
    @XmlElement(name = "configuration-version")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String configurationVersion;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String author;
    @XmlElement(name = "created-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createdDate;
    @XmlElement(name = "updated-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar updatedDate;

    /**
     * 获取configurationName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationName() {
        return configurationName;
    }

    /**
     * 设置configurationName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationName(String value) {
        this.configurationName = value;
    }

    /**
     * 获取configurationDescription属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationDescription() {
        return configurationDescription;
    }

    /**
     * 设置configurationDescription属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationDescription(String value) {
        this.configurationDescription = value;
    }

    /**
     * 获取configurationVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigurationVersion() {
        return configurationVersion;
    }

    /**
     * 设置configurationVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigurationVersion(String value) {
        this.configurationVersion = value;
    }

    /**
     * 获取author属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置author属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * 获取createdDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置createdDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * 获取updatedDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置updatedDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedDate(XMLGregorianCalendar value) {
        this.updatedDate = value;
    }

}
