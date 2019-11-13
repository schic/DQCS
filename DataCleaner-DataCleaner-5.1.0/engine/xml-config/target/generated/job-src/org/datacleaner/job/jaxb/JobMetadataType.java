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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>jobMetadataType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jobMetadataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="job-name" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="job-description" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="job-version" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="author" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *         &lt;element name="created-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="updated-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="metadata-properties" type="{http://eobjects.org/analyzerbeans/job/1.0}metadataProperties" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jobMetadataType", propOrder = {

})
public class JobMetadataType {

    @XmlElement(name = "job-name")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String jobName;
    @XmlElement(name = "job-description")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String jobDescription;
    @XmlElement(name = "job-version")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String jobVersion;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String author;
    @XmlElement(name = "created-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar createdDate;
    @XmlElement(name = "updated-date")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar updatedDate;
    @XmlElement(name = "metadata-properties")
    protected MetadataProperties metadataProperties;

    /**
     * 获取jobName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置jobName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobName(String value) {
        this.jobName = value;
    }

    /**
     * 获取jobDescription属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * 设置jobDescription属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobDescription(String value) {
        this.jobDescription = value;
    }

    /**
     * 获取jobVersion属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobVersion() {
        return jobVersion;
    }

    /**
     * 设置jobVersion属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobVersion(String value) {
        this.jobVersion = value;
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

    /**
     * 获取metadataProperties属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetadataProperties }
     *     
     */
    public MetadataProperties getMetadataProperties() {
        return metadataProperties;
    }

    /**
     * 设置metadataProperties属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetadataProperties }
     *     
     */
    public void setMetadataProperties(MetadataProperties value) {
        this.metadataProperties = value;
    }

}
