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
 *       &lt;sequence&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="manual-trigger" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *           &lt;element name="cron-expression" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="one-time" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="dependent-job" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *           &lt;element name="hot-folder" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="distributed-execution" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="run-on-hadoop" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="variable-provider" type="{http://eobjects.org/datacleaner/schedule/1.0}variableProvider" minOccurs="0"/&gt;
 *         &lt;element name="alerts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="alert" type="{http://eobjects.org/datacleaner/schedule/1.0}alert" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "manualTrigger",
    "cronExpression",
    "oneTime",
    "dependentJob",
    "hotFolder",
    "distributedExecution",
    "runOnHadoop",
    "variableProvider",
    "alerts"
})
@XmlRootElement(name = "schedule")
public class Schedule {

    @XmlElement(name = "manual-trigger", defaultValue = "true")
    protected Boolean manualTrigger;
    @XmlElement(name = "cron-expression")
    protected String cronExpression;
    @XmlElement(name = "one-time")
    protected String oneTime;
    @XmlElement(name = "dependent-job")
    protected String dependentJob;
    @XmlElement(name = "hot-folder")
    protected String hotFolder;
    @XmlElement(name = "distributed-execution")
    protected Boolean distributedExecution;
    @XmlElement(name = "run-on-hadoop")
    protected Boolean runOnHadoop;
    @XmlElement(name = "variable-provider")
    protected VariableProvider variableProvider;
    protected Schedule.Alerts alerts;

    /**
     * 获取manualTrigger属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isManualTrigger() {
        return manualTrigger;
    }

    /**
     * 设置manualTrigger属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setManualTrigger(Boolean value) {
        this.manualTrigger = value;
    }

    /**
     * 获取cronExpression属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 设置cronExpression属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCronExpression(String value) {
        this.cronExpression = value;
    }

    /**
     * 获取oneTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOneTime() {
        return oneTime;
    }

    /**
     * 设置oneTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOneTime(String value) {
        this.oneTime = value;
    }

    /**
     * 获取dependentJob属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentJob() {
        return dependentJob;
    }

    /**
     * 设置dependentJob属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentJob(String value) {
        this.dependentJob = value;
    }

    /**
     * 获取hotFolder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotFolder() {
        return hotFolder;
    }

    /**
     * 设置hotFolder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotFolder(String value) {
        this.hotFolder = value;
    }

    /**
     * 获取distributedExecution属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDistributedExecution() {
        return distributedExecution;
    }

    /**
     * 设置distributedExecution属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDistributedExecution(Boolean value) {
        this.distributedExecution = value;
    }

    /**
     * 获取runOnHadoop属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRunOnHadoop() {
        return runOnHadoop;
    }

    /**
     * 设置runOnHadoop属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRunOnHadoop(Boolean value) {
        this.runOnHadoop = value;
    }

    /**
     * 获取variableProvider属性的值。
     * 
     * @return
     *     possible object is
     *     {@link VariableProvider }
     *     
     */
    public VariableProvider getVariableProvider() {
        return variableProvider;
    }

    /**
     * 设置variableProvider属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link VariableProvider }
     *     
     */
    public void setVariableProvider(VariableProvider value) {
        this.variableProvider = value;
    }

    /**
     * 获取alerts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Schedule.Alerts }
     *     
     */
    public Schedule.Alerts getAlerts() {
        return alerts;
    }

    /**
     * 设置alerts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Schedule.Alerts }
     *     
     */
    public void setAlerts(Schedule.Alerts value) {
        this.alerts = value;
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
     *         &lt;element name="alert" type="{http://eobjects.org/datacleaner/schedule/1.0}alert" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "alert"
    })
    public static class Alerts {

        protected List<Alert> alert;

        /**
         * Gets the value of the alert property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the alert property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAlert().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Alert }
         * 
         * 
         */
        public List<Alert> getAlert() {
            if (alert == null) {
                alert = new ArrayList<Alert>();
            }
            return this.alert;
        }

    }

}
