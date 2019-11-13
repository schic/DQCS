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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>elasticSearchDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="elasticSearchDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hostname" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="cluster-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="index-name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="table-def" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="document-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="field" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="client-type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ssl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="keystore-path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="keystore-password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elasticSearchDatastoreType", propOrder = {
    "hostname",
    "port",
    "clusterName",
    "indexName",
    "tableDef",
    "clientType",
    "username",
    "password",
    "ssl",
    "keystorePath",
    "keystorePassword"
})
public class ElasticSearchDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(required = true)
    protected String hostname;
    protected Integer port;
    @XmlElement(name = "cluster-name", required = true)
    protected String clusterName;
    @XmlElement(name = "index-name", required = true)
    protected String indexName;
    @XmlElement(name = "table-def")
    protected List<ElasticSearchDatastoreType.TableDef> tableDef;
    @XmlElement(name = "client-type")
    protected String clientType;
    protected String username;
    protected String password;
    protected Boolean ssl;
    @XmlElement(name = "keystore-path")
    protected String keystorePath;
    @XmlElement(name = "keystore-password")
    protected String keystorePassword;

    /**
     * 获取hostname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * 设置hostname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostname(String value) {
        this.hostname = value;
    }

    /**
     * 获取port属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 设置port属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    /**
     * 获取clusterName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * 设置clusterName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClusterName(String value) {
        this.clusterName = value;
    }

    /**
     * 获取indexName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndexName() {
        return indexName;
    }

    /**
     * 设置indexName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndexName(String value) {
        this.indexName = value;
    }

    /**
     * Gets the value of the tableDef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableDef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTableDef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElasticSearchDatastoreType.TableDef }
     * 
     * 
     */
    public List<ElasticSearchDatastoreType.TableDef> getTableDef() {
        if (tableDef == null) {
            tableDef = new ArrayList<ElasticSearchDatastoreType.TableDef>();
        }
        return this.tableDef;
    }

    /**
     * 获取clientType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientType() {
        return clientType;
    }

    /**
     * 设置clientType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientType(String value) {
        this.clientType = value;
    }

    /**
     * 获取username属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置username属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * 获取password属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * 获取ssl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSsl() {
        return ssl;
    }

    /**
     * 设置ssl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSsl(Boolean value) {
        this.ssl = value;
    }

    /**
     * 获取keystorePath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeystorePath() {
        return keystorePath;
    }

    /**
     * 设置keystorePath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeystorePath(String value) {
        this.keystorePath = value;
    }

    /**
     * 获取keystorePassword属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeystorePassword() {
        return keystorePassword;
    }

    /**
     * 设置keystorePassword属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeystorePassword(String value) {
        this.keystorePassword = value;
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
     *       &lt;sequence&gt;
     *         &lt;element name="document-type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="field" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "documentType",
        "field"
    })
    public static class TableDef {

        @XmlElement(name = "document-type", required = true)
        protected String documentType;
        @XmlElement(required = true)
        protected List<ElasticSearchDatastoreType.TableDef.Field> field;

        /**
         * 获取documentType属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDocumentType() {
            return documentType;
        }

        /**
         * 设置documentType属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDocumentType(String value) {
            this.documentType = value;
        }

        /**
         * Gets the value of the field property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the field property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ElasticSearchDatastoreType.TableDef.Field }
         * 
         * 
         */
        public List<ElasticSearchDatastoreType.TableDef.Field> getField() {
            if (field == null) {
                field = new ArrayList<ElasticSearchDatastoreType.TableDef.Field>();
            }
            return this.field;
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
         *       &lt;sequence&gt;
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
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
            "name",
            "type"
        })
        public static class Field {

            @XmlElement(required = true)
            protected String name;
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String type;

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
             * 获取type属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getType() {
                return type;
            }

            /**
             * 设置type属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setType(String value) {
                this.type = value;
            }

        }

    }

}
