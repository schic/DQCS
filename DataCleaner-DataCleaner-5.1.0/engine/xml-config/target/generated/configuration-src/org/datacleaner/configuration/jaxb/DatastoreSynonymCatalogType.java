//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:46 PM CST 
//


package org.datacleaner.configuration.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>datastoreSynonymCatalogType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="datastoreSynonymCatalogType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datastore-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="master-term-column-path" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="synonym-column-path" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "datastoreSynonymCatalogType", propOrder = {
    "datastoreName",
    "masterTermColumnPath",
    "synonymColumnPath",
    "loadIntoMemory"
})
public class DatastoreSynonymCatalogType {

    @XmlElement(name = "datastore-name", required = true)
    protected String datastoreName;
    @XmlElement(name = "master-term-column-path", required = true)
    protected String masterTermColumnPath;
    @XmlElement(name = "synonym-column-path", required = true)
    protected List<String> synonymColumnPath;
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
     * 获取masterTermColumnPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterTermColumnPath() {
        return masterTermColumnPath;
    }

    /**
     * 设置masterTermColumnPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterTermColumnPath(String value) {
        this.masterTermColumnPath = value;
    }

    /**
     * Gets the value of the synonymColumnPath property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the synonymColumnPath property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSynonymColumnPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSynonymColumnPath() {
        if (synonymColumnPath == null) {
            synonymColumnPath = new ArrayList<String>();
        }
        return this.synonymColumnPath;
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
