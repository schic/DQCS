//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:46 PM CST 
//


package org.datacleaner.configuration.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>combinedStorageProviderType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="combinedStorageProviderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="collections-storage" type="{http://eobjects.org/analyzerbeans/configuration/1.0}storageProviderType"/&gt;
 *         &lt;element name="row-annotation-storage" type="{http://eobjects.org/analyzerbeans/configuration/1.0}storageProviderType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "combinedStorageProviderType", propOrder = {
    "collectionsStorage",
    "rowAnnotationStorage"
})
public class CombinedStorageProviderType {

    @XmlElement(name = "collections-storage", required = true)
    protected StorageProviderType collectionsStorage;
    @XmlElement(name = "row-annotation-storage", required = true)
    protected StorageProviderType rowAnnotationStorage;

    /**
     * 获取collectionsStorage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageProviderType }
     *     
     */
    public StorageProviderType getCollectionsStorage() {
        return collectionsStorage;
    }

    /**
     * 设置collectionsStorage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageProviderType }
     *     
     */
    public void setCollectionsStorage(StorageProviderType value) {
        this.collectionsStorage = value;
    }

    /**
     * 获取rowAnnotationStorage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageProviderType }
     *     
     */
    public StorageProviderType getRowAnnotationStorage() {
        return rowAnnotationStorage;
    }

    /**
     * 设置rowAnnotationStorage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageProviderType }
     *     
     */
    public void setRowAnnotationStorage(StorageProviderType value) {
        this.rowAnnotationStorage = value;
    }

}
