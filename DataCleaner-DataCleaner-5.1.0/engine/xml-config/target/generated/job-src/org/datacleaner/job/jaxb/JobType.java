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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>jobType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jobType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="job-metadata" type="{http://eobjects.org/analyzerbeans/job/1.0}jobMetadataType" minOccurs="0"/&gt;
 *         &lt;element name="source" type="{http://eobjects.org/analyzerbeans/job/1.0}sourceType" minOccurs="0"/&gt;
 *         &lt;element name="transformation" type="{http://eobjects.org/analyzerbeans/job/1.0}transformationType" minOccurs="0"/&gt;
 *         &lt;element name="analysis" type="{http://eobjects.org/analyzerbeans/job/1.0}analysisType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jobType", propOrder = {
    "jobMetadata",
    "source",
    "transformation",
    "analysis"
})
@XmlSeeAlso({
    Job.class
})
public class JobType {

    @XmlElement(name = "job-metadata")
    protected JobMetadataType jobMetadata;
    protected SourceType source;
    protected TransformationType transformation;
    protected AnalysisType analysis;

    /**
     * 获取jobMetadata属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JobMetadataType }
     *     
     */
    public JobMetadataType getJobMetadata() {
        return jobMetadata;
    }

    /**
     * 设置jobMetadata属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JobMetadataType }
     *     
     */
    public void setJobMetadata(JobMetadataType value) {
        this.jobMetadata = value;
    }

    /**
     * 获取source属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SourceType }
     *     
     */
    public SourceType getSource() {
        return source;
    }

    /**
     * 设置source属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SourceType }
     *     
     */
    public void setSource(SourceType value) {
        this.source = value;
    }

    /**
     * 获取transformation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransformationType }
     *     
     */
    public TransformationType getTransformation() {
        return transformation;
    }

    /**
     * 设置transformation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransformationType }
     *     
     */
    public void setTransformation(TransformationType value) {
        this.transformation = value;
    }

    /**
     * 获取analysis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AnalysisType }
     *     
     */
    public AnalysisType getAnalysis() {
        return analysis;
    }

    /**
     * 设置analysis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AnalysisType }
     *     
     */
    public void setAnalysis(AnalysisType value) {
        this.analysis = value;
    }

}
