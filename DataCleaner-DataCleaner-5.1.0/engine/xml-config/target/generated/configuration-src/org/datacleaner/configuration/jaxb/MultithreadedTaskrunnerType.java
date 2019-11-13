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
 * <p>multithreadedTaskrunnerType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="multithreadedTaskrunnerType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="max-threads" type="{http://www.w3.org/2001/XMLSchema}short" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multithreadedTaskrunnerType")
public class MultithreadedTaskrunnerType {

    @XmlAttribute(name = "max-threads")
    protected Short maxThreads;

    /**
     * 获取maxThreads属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMaxThreads() {
        return maxThreads;
    }

    /**
     * 设置maxThreads属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMaxThreads(Short value) {
        this.maxThreads = value;
    }

}
