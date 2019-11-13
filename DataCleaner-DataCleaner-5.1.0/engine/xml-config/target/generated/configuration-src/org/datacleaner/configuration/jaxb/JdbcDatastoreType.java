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


/**
 * <p>jdbcDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="jdbcDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;sequence&gt;
 *             &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="driver" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *             &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *             &lt;element name="multiple-connections" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *           &lt;/sequence&gt;
 *           &lt;element name="datasource-jndi-url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="table-types" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="table-type" type="{http://eobjects.org/analyzerbeans/configuration/1.0}tableTypeEnum" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="catalog-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jdbcDatastoreType", propOrder = {
    "url",
    "driver",
    "username",
    "password",
    "multipleConnections",
    "datasourceJndiUrl",
    "tableTypes",
    "catalogName"
})
public class JdbcDatastoreType
    extends AbstractDatastoreType
{

    protected String url;
    protected String driver;
    protected String username;
    protected String password;
    @XmlElement(name = "multiple-connections", defaultValue = "true")
    protected Boolean multipleConnections;
    @XmlElement(name = "datasource-jndi-url")
    protected String datasourceJndiUrl;
    @XmlElement(name = "table-types")
    protected JdbcDatastoreType.TableTypes tableTypes;
    @XmlElement(name = "catalog-name")
    protected String catalogName;

    /**
     * 获取url属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * 获取driver属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriver() {
        return driver;
    }

    /**
     * 设置driver属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriver(String value) {
        this.driver = value;
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
     * 获取multipleConnections属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultipleConnections() {
        return multipleConnections;
    }

    /**
     * 设置multipleConnections属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultipleConnections(Boolean value) {
        this.multipleConnections = value;
    }

    /**
     * 获取datasourceJndiUrl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasourceJndiUrl() {
        return datasourceJndiUrl;
    }

    /**
     * 设置datasourceJndiUrl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasourceJndiUrl(String value) {
        this.datasourceJndiUrl = value;
    }

    /**
     * 获取tableTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JdbcDatastoreType.TableTypes }
     *     
     */
    public JdbcDatastoreType.TableTypes getTableTypes() {
        return tableTypes;
    }

    /**
     * 设置tableTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JdbcDatastoreType.TableTypes }
     *     
     */
    public void setTableTypes(JdbcDatastoreType.TableTypes value) {
        this.tableTypes = value;
    }

    /**
     * 获取catalogName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 设置catalogName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatalogName(String value) {
        this.catalogName = value;
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
     *         &lt;element name="table-type" type="{http://eobjects.org/analyzerbeans/configuration/1.0}tableTypeEnum" maxOccurs="unbounded"/&gt;
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
        "tableType"
    })
    public static class TableTypes {

        @XmlElement(name = "table-type", required = true)
        @XmlSchemaType(name = "string")
        protected List<TableTypeEnum> tableType;

        /**
         * Gets the value of the tableType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tableType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTableType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TableTypeEnum }
         * 
         * 
         */
        public List<TableTypeEnum> getTableType() {
            if (tableType == null) {
                tableType = new ArrayList<TableTypeEnum>();
            }
            return this.tableType;
        }

    }

}
