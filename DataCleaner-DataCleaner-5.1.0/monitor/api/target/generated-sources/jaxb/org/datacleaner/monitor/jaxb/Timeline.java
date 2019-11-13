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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="timeline-metadata" type="{http://eobjects.org/datacleaner/timeline/1.0}timelineMetadataType" minOccurs="0"/&gt;
 *         &lt;element name="job-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="metrics" type="{http://eobjects.org/datacleaner/shared/1.0}metricsType"/&gt;
 *         &lt;element name="chart-options" type="{http://eobjects.org/datacleaner/timeline/1.0}chartOptionsType" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "timeline", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
public class Timeline {

    @XmlElement(name = "timeline-metadata", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
    protected TimelineMetadataType timelineMetadata;
    @XmlElement(name = "job-name", namespace = "http://eobjects.org/datacleaner/timeline/1.0", required = true)
    protected String jobName;
    @XmlElement(namespace = "http://eobjects.org/datacleaner/timeline/1.0", required = true)
    protected MetricsType metrics;
    @XmlElement(name = "chart-options", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
    protected ChartOptionsType chartOptions;

    /**
     * 获取timelineMetadata属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TimelineMetadataType }
     *     
     */
    public TimelineMetadataType getTimelineMetadata() {
        return timelineMetadata;
    }

    /**
     * 设置timelineMetadata属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TimelineMetadataType }
     *     
     */
    public void setTimelineMetadata(TimelineMetadataType value) {
        this.timelineMetadata = value;
    }

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
     * 获取metrics属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MetricsType }
     *     
     */
    public MetricsType getMetrics() {
        return metrics;
    }

    /**
     * 设置metrics属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MetricsType }
     *     
     */
    public void setMetrics(MetricsType value) {
        this.metrics = value;
    }

    /**
     * 获取chartOptions属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChartOptionsType }
     *     
     */
    public ChartOptionsType getChartOptions() {
        return chartOptions;
    }

    /**
     * 设置chartOptions属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChartOptionsType }
     *     
     */
    public void setChartOptions(ChartOptionsType value) {
        this.chartOptions = value;
    }

}
