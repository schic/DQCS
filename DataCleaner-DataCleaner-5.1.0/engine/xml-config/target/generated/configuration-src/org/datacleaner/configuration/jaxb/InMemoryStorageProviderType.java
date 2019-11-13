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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>inMemoryStorageProviderType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="inMemoryStorageProviderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="max-rows-threshold" type="{http://www.w3.org/2001/XMLSchema}int" default="1000" /&gt;
 *       &lt;attribute name="max-sets-threshold" type="{http://www.w3.org/2001/XMLSchema}int" default="150" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inMemoryStorageProviderType")
public class InMemoryStorageProviderType {

    @XmlAttribute(name = "max-rows-threshold")
    protected Integer maxRowsThreshold;
    @XmlAttribute(name = "max-sets-threshold")
    protected Integer maxSetsThreshold;

    /**
     * 获取maxRowsThreshold属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getMaxRowsThreshold() {
        if (maxRowsThreshold == null) {
            return  1000;
        } else {
            return maxRowsThreshold;
        }
    }

    /**
     * 设置maxRowsThreshold属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRowsThreshold(Integer value) {
        this.maxRowsThreshold = value;
    }

    /**
     * 获取maxSetsThreshold属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getMaxSetsThreshold() {
        if (maxSetsThreshold == null) {
            return  150;
        } else {
            return maxSetsThreshold;
        }
    }

    /**
     * 设置maxSetsThreshold属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSetsThreshold(Integer value) {
        this.maxSetsThreshold = value;
    }

}
