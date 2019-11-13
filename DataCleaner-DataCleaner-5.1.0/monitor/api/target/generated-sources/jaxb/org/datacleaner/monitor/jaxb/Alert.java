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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>alert complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="alert"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://eobjects.org/datacleaner/shared/1.0}metric"/&gt;
 *         &lt;element name="minimum-value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="maximum-value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="severity" type="{http://eobjects.org/datacleaner/schedule/1.0}alertSeverityType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alert", propOrder = {
    "description",
    "metric",
    "minimumValue",
    "maximumValue",
    "severity"
})
public class Alert {

    protected String description;
    @XmlElement(namespace = "http://eobjects.org/datacleaner/shared/1.0", required = true)
    protected MetricType metric;
    @XmlElement(name = "minimum-value")
    protected Integer minimumValue;
    @XmlElement(name = "maximum-value")
    protected Integer maximumValue;
    @XmlSchemaType(name = "string")
    protected AlertSeverityType severity;

    /**
     * 获取description属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置description属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * 获取metric属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetricType }
     *     
     */
    public MetricType getMetric() {
        return metric;
    }

    /**
     * 设置metric属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetricType }
     *     
     */
    public void setMetric(MetricType value) {
        this.metric = value;
    }

    /**
     * 获取minimumValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinimumValue() {
        return minimumValue;
    }

    /**
     * 设置minimumValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinimumValue(Integer value) {
        this.minimumValue = value;
    }

    /**
     * 获取maximumValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaximumValue() {
        return maximumValue;
    }

    /**
     * 设置maximumValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaximumValue(Integer value) {
        this.maximumValue = value;
    }

    /**
     * 获取severity属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AlertSeverityType }
     *     
     */
    public AlertSeverityType getSeverity() {
        return severity;
    }

    /**
     * 设置severity属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AlertSeverityType }
     *     
     */
    public void setSeverity(AlertSeverityType value) {
        this.severity = value;
    }

}
