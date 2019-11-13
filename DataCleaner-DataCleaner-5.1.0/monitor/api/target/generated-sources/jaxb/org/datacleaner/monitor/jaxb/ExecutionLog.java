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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="result-id" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="job-begin-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="job-end-date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="execution-status" type="{http://eobjects.org/datacleaner/execution-log/1.0}execution-type"/&gt;
 *         &lt;element name="trigger-type" type="{http://eobjects.org/datacleaner/execution-log/1.0}trigger-type"/&gt;
 *         &lt;element name="triggered-by" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element ref="{http://eobjects.org/datacleaner/schedule/1.0}schedule"/&gt;
 *         &lt;element name="log-output" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="result-persisted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
    "resultId",
    "jobBeginDate",
    "jobEndDate",
    "executionStatus",
    "triggerType",
    "triggeredBy",
    "schedule",
    "logOutput",
    "resultPersisted"
})
@XmlRootElement(name = "execution-log", namespace = "http://eobjects.org/datacleaner/execution-log/1.0")
public class ExecutionLog {

    @XmlElement(name = "result-id", namespace = "http://eobjects.org/datacleaner/execution-log/1.0", required = true)
    protected String resultId;
    @XmlElement(name = "job-begin-date", namespace = "http://eobjects.org/datacleaner/execution-log/1.0")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobBeginDate;
    @XmlElement(name = "job-end-date", namespace = "http://eobjects.org/datacleaner/execution-log/1.0")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar jobEndDate;
    @XmlElement(name = "execution-status", namespace = "http://eobjects.org/datacleaner/execution-log/1.0", required = true)
    @XmlSchemaType(name = "string")
    protected ExecutionType executionStatus;
    @XmlElement(name = "trigger-type", namespace = "http://eobjects.org/datacleaner/execution-log/1.0", required = true)
    @XmlSchemaType(name = "string")
    protected TriggerType triggerType;
    @XmlElement(name = "triggered-by", namespace = "http://eobjects.org/datacleaner/execution-log/1.0", required = true)
    protected String triggeredBy;
    @XmlElement(required = true)
    protected Schedule schedule;
    @XmlElement(name = "log-output", namespace = "http://eobjects.org/datacleaner/execution-log/1.0", required = true)
    protected String logOutput;
    @XmlElement(name = "result-persisted", namespace = "http://eobjects.org/datacleaner/execution-log/1.0")
    protected Boolean resultPersisted;

    /**
     * 获取resultId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultId() {
        return resultId;
    }

    /**
     * 设置resultId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultId(String value) {
        this.resultId = value;
    }

    /**
     * 获取jobBeginDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJobBeginDate() {
        return jobBeginDate;
    }

    /**
     * 设置jobBeginDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJobBeginDate(XMLGregorianCalendar value) {
        this.jobBeginDate = value;
    }

    /**
     * 获取jobEndDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJobEndDate() {
        return jobEndDate;
    }

    /**
     * 设置jobEndDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJobEndDate(XMLGregorianCalendar value) {
        this.jobEndDate = value;
    }

    /**
     * 获取executionStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ExecutionType }
     *     
     */
    public ExecutionType getExecutionStatus() {
        return executionStatus;
    }

    /**
     * 设置executionStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionType }
     *     
     */
    public void setExecutionStatus(ExecutionType value) {
        this.executionStatus = value;
    }

    /**
     * 获取triggerType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TriggerType }
     *     
     */
    public TriggerType getTriggerType() {
        return triggerType;
    }

    /**
     * 设置triggerType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TriggerType }
     *     
     */
    public void setTriggerType(TriggerType value) {
        this.triggerType = value;
    }

    /**
     * 获取triggeredBy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTriggeredBy() {
        return triggeredBy;
    }

    /**
     * 设置triggeredBy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTriggeredBy(String value) {
        this.triggeredBy = value;
    }

    /**
     * 获取schedule属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Schedule }
     *     
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * 设置schedule属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule }
     *     
     */
    public void setSchedule(Schedule value) {
        this.schedule = value;
    }

    /**
     * 获取logOutput属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogOutput() {
        return logOutput;
    }

    /**
     * 设置logOutput属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogOutput(String value) {
        this.logOutput = value;
    }

    /**
     * 获取resultPersisted属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResultPersisted() {
        return resultPersisted;
    }

    /**
     * 设置resultPersisted属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResultPersisted(Boolean value) {
        this.resultPersisted = value;
    }

}
