//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:47 PM CST 
//


package org.datacleaner.job.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>componentType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="componentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descriptor" type="{http://eobjects.org/analyzerbeans/job/1.0}descriptorType"/&gt;
 *         &lt;element name="metadata-properties" type="{http://eobjects.org/analyzerbeans/job/1.0}metadataProperties" minOccurs="0"/&gt;
 *         &lt;element name="properties" type="{http://eobjects.org/analyzerbeans/job/1.0}configuredPropertiesType" minOccurs="0"/&gt;
 *         &lt;element name="input" type="{http://eobjects.org/analyzerbeans/job/1.0}inputType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="output-data-stream" type="{http://eobjects.org/analyzerbeans/job/1.0}outputDataStreamType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="requires" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "componentType", propOrder = {
    "descriptor",
    "metadataProperties",
    "properties",
    "input",
    "outputDataStream"
})
@XmlSeeAlso({
    TransformerType.class,
    FilterType.class,
    AnalyzerType.class
})
public class ComponentType {

    @XmlElement(required = true)
    protected DescriptorType descriptor;
    @XmlElement(name = "metadata-properties")
    protected MetadataProperties metadataProperties;
    protected ConfiguredPropertiesType properties;
    protected List<InputType> input;
    @XmlElement(name = "output-data-stream")
    protected List<OutputDataStreamType> outputDataStream;
    @XmlAttribute(name = "requires")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String requires;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * 获取descriptor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DescriptorType }
     *     
     */
    public DescriptorType getDescriptor() {
        return descriptor;
    }

    /**
     * 设置descriptor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptorType }
     *     
     */
    public void setDescriptor(DescriptorType value) {
        this.descriptor = value;
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

    /**
     * 获取properties属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ConfiguredPropertiesType }
     *     
     */
    public ConfiguredPropertiesType getProperties() {
        return properties;
    }

    /**
     * 设置properties属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ConfiguredPropertiesType }
     *     
     */
    public void setProperties(ConfiguredPropertiesType value) {
        this.properties = value;
    }

    /**
     * Gets the value of the input property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the input property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputType }
     * 
     * 
     */
    public List<InputType> getInput() {
        if (input == null) {
            input = new ArrayList<InputType>();
        }
        return this.input;
    }

    /**
     * Gets the value of the outputDataStream property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputDataStream property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputDataStream().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputDataStreamType }
     * 
     * 
     */
    public List<OutputDataStreamType> getOutputDataStream() {
        if (outputDataStream == null) {
            outputDataStream = new ArrayList<OutputDataStreamType>();
        }
        return this.outputDataStream;
    }

    /**
     * 获取requires属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequires() {
        return requires;
    }

    /**
     * 设置requires属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequires(String value) {
        this.requires = value;
    }

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
