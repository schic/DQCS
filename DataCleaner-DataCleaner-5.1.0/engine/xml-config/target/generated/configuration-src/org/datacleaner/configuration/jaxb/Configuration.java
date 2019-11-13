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
 *         &lt;element name="configuration-metadata" type="{http://eobjects.org/analyzerbeans/configuration/1.0}configurationMetadataType" minOccurs="0"/&gt;
 *         &lt;element name="datastore-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datastoreCatalogType"/&gt;
 *         &lt;element name="reference-data-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}referenceDataCatalogType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="multithreaded-taskrunner" type="{http://eobjects.org/analyzerbeans/configuration/1.0}multithreadedTaskrunnerType"/&gt;
 *           &lt;element name="singlethreaded-taskrunner" type="{http://eobjects.org/analyzerbeans/configuration/1.0}singlethreadedTaskrunnerType"/&gt;
 *           &lt;element name="custom-taskrunner" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="storage-provider" type="{http://eobjects.org/analyzerbeans/configuration/1.0}storageProviderType" minOccurs="0"/&gt;
 *         &lt;element name="descriptor-providers" type="{http://eobjects.org/analyzerbeans/configuration/1.0}descriptorProvidersType" minOccurs="0"/&gt;
 *         &lt;element name="servers" type="{http://eobjects.org/analyzerbeans/configuration/1.0}serversType" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="classpath-scanner" type="{http://eobjects.org/analyzerbeans/configuration/1.0}classpathScannerType"/&gt;
 *           &lt;element name="custom-descriptor-provider" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType"/&gt;
 *         &lt;/choice&gt;
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
    "configurationMetadata",
    "datastoreCatalog",
    "referenceDataCatalog",
    "multithreadedTaskrunner",
    "singlethreadedTaskrunner",
    "customTaskrunner",
    "storageProvider",
    "descriptorProviders",
    "servers",
    "classpathScanner",
    "customDescriptorProvider"
})
@XmlRootElement(name = "configuration")
public class Configuration {

    @XmlElement(name = "configuration-metadata")
    protected ConfigurationMetadataType configurationMetadata;
    @XmlElement(name = "datastore-catalog", required = true)
    protected DatastoreCatalogType datastoreCatalog;
    @XmlElement(name = "reference-data-catalog")
    protected ReferenceDataCatalogType referenceDataCatalog;
    @XmlElement(name = "multithreaded-taskrunner")
    protected MultithreadedTaskrunnerType multithreadedTaskrunner;
    @XmlElement(name = "singlethreaded-taskrunner")
    protected SinglethreadedTaskrunnerType singlethreadedTaskrunner;
    @XmlElement(name = "custom-taskrunner")
    protected CustomElementType customTaskrunner;
    @XmlElement(name = "storage-provider")
    protected StorageProviderType storageProvider;
    @XmlElement(name = "descriptor-providers")
    protected DescriptorProvidersType descriptorProviders;
    protected ServersType servers;
    @XmlElement(name = "classpath-scanner")
    protected ClasspathScannerType classpathScanner;
    @XmlElement(name = "custom-descriptor-provider")
    protected CustomElementType customDescriptorProvider;

    /**
     * 获取configurationMetadata属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ConfigurationMetadataType }
     *     
     */
    public ConfigurationMetadataType getConfigurationMetadata() {
        return configurationMetadata;
    }

    /**
     * 设置configurationMetadata属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ConfigurationMetadataType }
     *     
     */
    public void setConfigurationMetadata(ConfigurationMetadataType value) {
        this.configurationMetadata = value;
    }

    /**
     * 获取datastoreCatalog属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DatastoreCatalogType }
     *     
     */
    public DatastoreCatalogType getDatastoreCatalog() {
        return datastoreCatalog;
    }

    /**
     * 设置datastoreCatalog属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DatastoreCatalogType }
     *     
     */
    public void setDatastoreCatalog(DatastoreCatalogType value) {
        this.datastoreCatalog = value;
    }

    /**
     * 获取referenceDataCatalog属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataCatalogType }
     *     
     */
    public ReferenceDataCatalogType getReferenceDataCatalog() {
        return referenceDataCatalog;
    }

    /**
     * 设置referenceDataCatalog属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataCatalogType }
     *     
     */
    public void setReferenceDataCatalog(ReferenceDataCatalogType value) {
        this.referenceDataCatalog = value;
    }

    /**
     * 获取multithreadedTaskrunner属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MultithreadedTaskrunnerType }
     *     
     */
    public MultithreadedTaskrunnerType getMultithreadedTaskrunner() {
        return multithreadedTaskrunner;
    }

    /**
     * 设置multithreadedTaskrunner属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MultithreadedTaskrunnerType }
     *     
     */
    public void setMultithreadedTaskrunner(MultithreadedTaskrunnerType value) {
        this.multithreadedTaskrunner = value;
    }

    /**
     * 获取singlethreadedTaskrunner属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SinglethreadedTaskrunnerType }
     *     
     */
    public SinglethreadedTaskrunnerType getSinglethreadedTaskrunner() {
        return singlethreadedTaskrunner;
    }

    /**
     * 设置singlethreadedTaskrunner属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SinglethreadedTaskrunnerType }
     *     
     */
    public void setSinglethreadedTaskrunner(SinglethreadedTaskrunnerType value) {
        this.singlethreadedTaskrunner = value;
    }

    /**
     * 获取customTaskrunner属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomElementType }
     *     
     */
    public CustomElementType getCustomTaskrunner() {
        return customTaskrunner;
    }

    /**
     * 设置customTaskrunner属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomElementType }
     *     
     */
    public void setCustomTaskrunner(CustomElementType value) {
        this.customTaskrunner = value;
    }

    /**
     * 获取storageProvider属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StorageProviderType }
     *     
     */
    public StorageProviderType getStorageProvider() {
        return storageProvider;
    }

    /**
     * 设置storageProvider属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StorageProviderType }
     *     
     */
    public void setStorageProvider(StorageProviderType value) {
        this.storageProvider = value;
    }

    /**
     * 获取descriptorProviders属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DescriptorProvidersType }
     *     
     */
    public DescriptorProvidersType getDescriptorProviders() {
        return descriptorProviders;
    }

    /**
     * 设置descriptorProviders属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptorProvidersType }
     *     
     */
    public void setDescriptorProviders(DescriptorProvidersType value) {
        this.descriptorProviders = value;
    }

    /**
     * 获取servers属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServersType }
     *     
     */
    public ServersType getServers() {
        return servers;
    }

    /**
     * 设置servers属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServersType }
     *     
     */
    public void setServers(ServersType value) {
        this.servers = value;
    }

    /**
     * 获取classpathScanner属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClasspathScannerType }
     *     
     */
    public ClasspathScannerType getClasspathScanner() {
        return classpathScanner;
    }

    /**
     * 设置classpathScanner属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClasspathScannerType }
     *     
     */
    public void setClasspathScanner(ClasspathScannerType value) {
        this.classpathScanner = value;
    }

    /**
     * 获取customDescriptorProvider属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomElementType }
     *     
     */
    public CustomElementType getCustomDescriptorProvider() {
        return customDescriptorProvider;
    }

    /**
     * 设置customDescriptorProvider属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomElementType }
     *     
     */
    public void setCustomDescriptorProvider(CustomElementType value) {
        this.customDescriptorProvider = value;
    }

}
