//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.12 时间 04:02:39 PM CST 
//


package org.datacleaner.monitor.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacleaner.monitor.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CustomJob_QNAME = new QName("http://eobjects.org/datacleaner/custom-job/1.0", "custom-job");
    private final static QName _Metric_QNAME = new QName("http://eobjects.org/datacleaner/shared/1.0", "metric");
    private final static QName _Metrics_QNAME = new QName("http://eobjects.org/datacleaner/shared/1.0", "metrics");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacleaner.monitor.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Schedule }
     * 
     */
    public Schedule createSchedule() {
        return new Schedule();
    }

    /**
     * Create an instance of {@link ChartOptionsType }
     * 
     */
    public ChartOptionsType createChartOptionsType() {
        return new ChartOptionsType();
    }

    /**
     * Create an instance of {@link ChartOptionsType.HorizontalAxis }
     * 
     */
    public ChartOptionsType.HorizontalAxis createChartOptionsTypeHorizontalAxis() {
        return new ChartOptionsType.HorizontalAxis();
    }

    /**
     * Create an instance of {@link MetricType }
     * 
     */
    public MetricType createMetricType() {
        return new MetricType();
    }

    /**
     * Create an instance of {@link PropertiesType }
     * 
     */
    public PropertiesType createPropertiesType() {
        return new PropertiesType();
    }

    /**
     * Create an instance of {@link CustomJavaComponentJob }
     * 
     */
    public CustomJavaComponentJob createCustomJavaComponentJob() {
        return new CustomJavaComponentJob();
    }

    /**
     * Create an instance of {@link ExecutionLog }
     * 
     */
    public ExecutionLog createExecutionLog() {
        return new ExecutionLog();
    }

    /**
     * Create an instance of {@link VariableProvider }
     * 
     */
    public VariableProvider createVariableProvider() {
        return new VariableProvider();
    }

    /**
     * Create an instance of {@link Schedule.Alerts }
     * 
     */
    public Schedule.Alerts createScheduleAlerts() {
        return new Schedule.Alerts();
    }

    /**
     * Create an instance of {@link Alert }
     * 
     */
    public Alert createAlert() {
        return new Alert();
    }

    /**
     * Create an instance of {@link MetricsType }
     * 
     */
    public MetricsType createMetricsType() {
        return new MetricsType();
    }

    /**
     * Create an instance of {@link Timeline }
     * 
     */
    public Timeline createTimeline() {
        return new Timeline();
    }

    /**
     * Create an instance of {@link TimelineMetadataType }
     * 
     */
    public TimelineMetadataType createTimelineMetadataType() {
        return new TimelineMetadataType();
    }

    /**
     * Create an instance of {@link ChartOptionsType.VerticalAxis }
     * 
     */
    public ChartOptionsType.VerticalAxis createChartOptionsTypeVerticalAxis() {
        return new ChartOptionsType.VerticalAxis();
    }

    /**
     * Create an instance of {@link ChartOptionsType.HorizontalAxis.RollingAxis }
     * 
     */
    public ChartOptionsType.HorizontalAxis.RollingAxis createChartOptionsTypeHorizontalAxisRollingAxis() {
        return new ChartOptionsType.HorizontalAxis.RollingAxis();
    }

    /**
     * Create an instance of {@link ChartOptionsType.HorizontalAxis.FixedAxis }
     * 
     */
    public ChartOptionsType.HorizontalAxis.FixedAxis createChartOptionsTypeHorizontalAxisFixedAxis() {
        return new ChartOptionsType.HorizontalAxis.FixedAxis();
    }

    /**
     * Create an instance of {@link MetricType.Children }
     * 
     */
    public MetricType.Children createMetricTypeChildren() {
        return new MetricType.Children();
    }

    /**
     * Create an instance of {@link PropertiesType.Property }
     * 
     */
    public PropertiesType.Property createPropertiesTypeProperty() {
        return new PropertiesType.Property();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomJavaComponentJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eobjects.org/datacleaner/custom-job/1.0", name = "custom-job")
    public JAXBElement<CustomJavaComponentJob> createCustomJob(CustomJavaComponentJob value) {
        return new JAXBElement<CustomJavaComponentJob>(_CustomJob_QNAME, CustomJavaComponentJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetricType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eobjects.org/datacleaner/shared/1.0", name = "metric")
    public JAXBElement<MetricType> createMetric(MetricType value) {
        return new JAXBElement<MetricType>(_Metric_QNAME, MetricType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetricsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eobjects.org/datacleaner/shared/1.0", name = "metrics")
    public JAXBElement<MetricsType> createMetrics(MetricsType value) {
        return new JAXBElement<MetricsType>(_Metrics_QNAME, MetricsType.class, null, value);
    }

}
