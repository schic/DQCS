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
 * <p>storageProviderType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="storageProviderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="combined" type="{http://eobjects.org/analyzerbeans/configuration/1.0}combinedStorageProviderType"/&gt;
 *         &lt;element name="in-memory" type="{http://eobjects.org/analyzerbeans/configuration/1.0}inMemoryStorageProviderType"/&gt;
 *         &lt;element name="berkeley-db" type="{http://eobjects.org/analyzerbeans/configuration/1.0}berkeleyDbStorageProviderType"/&gt;
 *         &lt;element name="custom-storage-provider" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "storageProviderType", propOrder = {
    "combined",
    "inMemory",
    "berkeleyDb",
    "customStorageProvider"
})
public class StorageProviderType {

    protected CombinedStorageProviderType combined;
    @XmlElement(name = "in-memory")
    protected InMemoryStorageProviderType inMemory;
    @XmlElement(name = "berkeley-db")
    protected BerkeleyDbStorageProviderType berkeleyDb;
    @XmlElement(name = "custom-storage-provider")
    protected CustomElementType customStorageProvider;

    /**
     * 获取combined属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CombinedStorageProviderType }
     *     
     */
    public CombinedStorageProviderType getCombined() {
        return combined;
    }

    /**
     * 设置combined属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CombinedStorageProviderType }
     *     
     */
    public void setCombined(CombinedStorageProviderType value) {
        this.combined = value;
    }

    /**
     * 获取inMemory属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InMemoryStorageProviderType }
     *     
     */
    public InMemoryStorageProviderType getInMemory() {
        return inMemory;
    }

    /**
     * 设置inMemory属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InMemoryStorageProviderType }
     *     
     */
    public void setInMemory(InMemoryStorageProviderType value) {
        this.inMemory = value;
    }

    /**
     * 获取berkeleyDb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BerkeleyDbStorageProviderType }
     *     
     */
    public BerkeleyDbStorageProviderType getBerkeleyDb() {
        return berkeleyDb;
    }

    /**
     * 设置berkeleyDb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BerkeleyDbStorageProviderType }
     *     
     */
    public void setBerkeleyDb(BerkeleyDbStorageProviderType value) {
        this.berkeleyDb = value;
    }

    /**
     * 获取customStorageProvider属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomElementType }
     *     
     */
    public CustomElementType getCustomStorageProvider() {
        return customStorageProvider;
    }

    /**
     * 设置customStorageProvider属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomElementType }
     *     
     */
    public void setCustomStorageProvider(CustomElementType value) {
        this.customStorageProvider = value;
    }

}
