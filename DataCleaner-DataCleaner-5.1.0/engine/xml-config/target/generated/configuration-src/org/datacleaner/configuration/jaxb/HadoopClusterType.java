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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>hadoopClusterType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="hadoopClusterType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="environment-configured"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="directories"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded"&gt;
 *                   &lt;element name="directory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="namenode-url" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *       &lt;/choice&gt;
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
@XmlType(name = "hadoopClusterType", propOrder = {
    "environmentConfigured",
    "directories",
    "namenodeUrl"
})
public class HadoopClusterType {

    @XmlElement(name = "environment-configured")
    protected HadoopClusterType.EnvironmentConfigured environmentConfigured;
    protected HadoopClusterType.Directories directories;
    @XmlElement(name = "namenode-url")
    @XmlSchemaType(name = "anyURI")
    protected String namenodeUrl;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "description")
    protected String description;

    /**
     * 获取environmentConfigured属性的值。
     * 
     * @return
     *     possible object is
     *     {@link HadoopClusterType.EnvironmentConfigured }
     *     
     */
    public HadoopClusterType.EnvironmentConfigured getEnvironmentConfigured() {
        return environmentConfigured;
    }

    /**
     * 设置environmentConfigured属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link HadoopClusterType.EnvironmentConfigured }
     *     
     */
    public void setEnvironmentConfigured(HadoopClusterType.EnvironmentConfigured value) {
        this.environmentConfigured = value;
    }

    /**
     * 获取directories属性的值。
     * 
     * @return
     *     possible object is
     *     {@link HadoopClusterType.Directories }
     *     
     */
    public HadoopClusterType.Directories getDirectories() {
        return directories;
    }

    /**
     * 设置directories属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link HadoopClusterType.Directories }
     *     
     */
    public void setDirectories(HadoopClusterType.Directories value) {
        this.directories = value;
    }

    /**
     * 获取namenodeUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamenodeUrl() {
        return namenodeUrl;
    }

    /**
     * 设置namenodeUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamenodeUrl(String value) {
        this.namenodeUrl = value;
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


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence maxOccurs="unbounded"&gt;
     *         &lt;element name="directory" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "directory"
    })
    public static class Directories {

        @XmlElement(required = true)
        protected List<String> directory;

        /**
         * Gets the value of the directory property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the directory property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDirectory().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDirectory() {
            if (directory == null) {
                directory = new ArrayList<String>();
            }
            return this.directory;
        }

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
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class EnvironmentConfigured {


    }

}
