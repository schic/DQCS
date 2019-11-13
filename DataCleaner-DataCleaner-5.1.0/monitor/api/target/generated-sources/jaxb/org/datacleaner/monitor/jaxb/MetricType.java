//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.12 时间 04:02:39 PM CST 
//


package org.datacleaner.monitor.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>metricType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="metricType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="metric-display-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="metric-color" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="analyzer-descriptor-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="analyzer-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="analyzer-input" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="metric-descriptor-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="metric-param-query-string" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="metric-param-column-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="formula" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="children"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="metric" type="{http://eobjects.org/datacleaner/shared/1.0}metricType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                     &lt;/sequence&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/sequence&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "metricType", namespace = "http://eobjects.org/datacleaner/shared/1.0", propOrder = {
    "metricDisplayName",
    "metricColor",
    "analyzerDescriptorName",
    "analyzerName",
    "analyzerInput",
    "metricDescriptorName",
    "metricParamQueryString",
    "metricParamColumnName",
    "formula",
    "children"
})
public class MetricType {

    @XmlElement(name = "metric-display-name")
    protected String metricDisplayName;
    @XmlElement(name = "metric-color")
    protected String metricColor;
    @XmlElement(name = "analyzer-descriptor-name")
    protected String analyzerDescriptorName;
    @XmlElement(name = "analyzer-name")
    protected String analyzerName;
    @XmlElement(name = "analyzer-input")
    protected String analyzerInput;
    @XmlElement(name = "metric-descriptor-name")
    protected String metricDescriptorName;
    @XmlElement(name = "metric-param-query-string")
    protected String metricParamQueryString;
    @XmlElement(name = "metric-param-column-name")
    protected String metricParamColumnName;
    protected String formula;
    protected MetricType.Children children;

    /**
     * 获取metricDisplayName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricDisplayName() {
        return metricDisplayName;
    }

    /**
     * 设置metricDisplayName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricDisplayName(String value) {
        this.metricDisplayName = value;
    }

    /**
     * 获取metricColor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricColor() {
        return metricColor;
    }

    /**
     * 设置metricColor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricColor(String value) {
        this.metricColor = value;
    }

    /**
     * 获取analyzerDescriptorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalyzerDescriptorName() {
        return analyzerDescriptorName;
    }

    /**
     * 设置analyzerDescriptorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalyzerDescriptorName(String value) {
        this.analyzerDescriptorName = value;
    }

    /**
     * 获取analyzerName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalyzerName() {
        return analyzerName;
    }

    /**
     * 设置analyzerName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalyzerName(String value) {
        this.analyzerName = value;
    }

    /**
     * 获取analyzerInput属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalyzerInput() {
        return analyzerInput;
    }

    /**
     * 设置analyzerInput属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalyzerInput(String value) {
        this.analyzerInput = value;
    }

    /**
     * 获取metricDescriptorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricDescriptorName() {
        return metricDescriptorName;
    }

    /**
     * 设置metricDescriptorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricDescriptorName(String value) {
        this.metricDescriptorName = value;
    }

    /**
     * 获取metricParamQueryString属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricParamQueryString() {
        return metricParamQueryString;
    }

    /**
     * 设置metricParamQueryString属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricParamQueryString(String value) {
        this.metricParamQueryString = value;
    }

    /**
     * 获取metricParamColumnName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetricParamColumnName() {
        return metricParamColumnName;
    }

    /**
     * 设置metricParamColumnName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetricParamColumnName(String value) {
        this.metricParamColumnName = value;
    }

    /**
     * 获取formula属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormula() {
        return formula;
    }

    /**
     * 设置formula属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormula(String value) {
        this.formula = value;
    }

    /**
     * 获取children属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetricType.Children }
     *     
     */
    public MetricType.Children getChildren() {
        return children;
    }

    /**
     * 设置children属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetricType.Children }
     *     
     */
    public void setChildren(MetricType.Children value) {
        this.children = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="metric" type="{http://eobjects.org/datacleaner/shared/1.0}metricType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "metric"
    })
    public static class Children {

        @XmlElement(namespace = "http://eobjects.org/datacleaner/shared/1.0")
        protected List<MetricType> metric;

        /**
         * Gets the value of the metric property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the metric property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMetric().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MetricType }
         * 
         * 
         */
        public List<MetricType> getMetric() {
            if (metric == null) {
                metric = new ArrayList<MetricType>();
            }
            return this.metric;
        }

    }

}
