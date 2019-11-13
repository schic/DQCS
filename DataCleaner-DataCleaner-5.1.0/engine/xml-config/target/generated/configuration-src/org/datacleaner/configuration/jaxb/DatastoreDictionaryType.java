//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:46 PM CST 
//


package org.datacleaner.configuration.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>datastoreDictionaryType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="datastoreDictionaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datastore-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="column-path" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="load-into-memory" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datastoreDictionaryType", propOrder = {
    "datastoreName",
    "columnPath",
    "loadIntoMemory"
})
public class DatastoreDictionaryType {

    @XmlElement(name = "datastore-name", required = true)
    protected String datastoreName;
    @XmlElement(name = "column-path", required = true)
    protected String columnPath;
    @XmlElement(name = "load-into-memory")
    protected Boolean loadIntoMemory;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "description")
    protected String description;

    /**
     * 获取datastoreName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatastoreName() {
        return datastoreName;
    }

    /**
     * 设置datastoreName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatastoreName(String value) {
        this.datastoreName = value;
    }

    /**
     * 获取columnPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnPath() {
        return columnPath;
    }

    /**
     * 设置columnPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnPath(String value) {
        this.columnPath = value;
    }

    /**
     * 获取loadIntoMemory属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLoadIntoMemory() {
        return loadIntoMemory;
    }

    /**
     * 设置loadIntoMemory属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLoadIntoMemory(Boolean value) {
        this.loadIntoMemory = value;
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

}
