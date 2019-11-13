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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>datahubDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="datahubDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="https" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="acceptunverifiedsslpeers" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="datahubsecuritymode" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datahubsecuritymodeEnum"/&gt;
 *       &lt;/all&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datahubDatastoreType", propOrder = {
    "host",
    "port",
    "username",
    "password",
    "https",
    "acceptunverifiedsslpeers",
    "datahubsecuritymode"
})
public class DatahubDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(required = true)
    protected String host;
    protected int port;
    @XmlElement(required = true)
    protected String username;
    @XmlElement(required = true)
    protected String password;
    protected boolean https;
    protected boolean acceptunverifiedsslpeers;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected DatahubsecuritymodeEnum datahubsecuritymode;

    /**
     * 获取host属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHost() {
        return host;
    }

    /**
     * 设置host属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHost(String value) {
        this.host = value;
    }

    /**
     * 获取port属性的值。
     * 
     */
    public int getPort() {
        return port;
    }

    /**
     * 设置port属性的值。
     * 
     */
    public void setPort(int value) {
        this.port = value;
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
     * 获取https属性的值。
     * 
     */
    public boolean isHttps() {
        return https;
    }

    /**
     * 设置https属性的值。
     * 
     */
    public void setHttps(boolean value) {
        this.https = value;
    }

    /**
     * 获取acceptunverifiedsslpeers属性的值。
     * 
     */
    public boolean isAcceptunverifiedsslpeers() {
        return acceptunverifiedsslpeers;
    }

    /**
     * 设置acceptunverifiedsslpeers属性的值。
     * 
     */
    public void setAcceptunverifiedsslpeers(boolean value) {
        this.acceptunverifiedsslpeers = value;
    }

    /**
     * 获取datahubsecuritymode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DatahubsecuritymodeEnum }
     *     
     */
    public DatahubsecuritymodeEnum getDatahubsecuritymode() {
        return datahubsecuritymode;
    }

    /**
     * 设置datahubsecuritymode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DatahubsecuritymodeEnum }
     *     
     */
    public void setDatahubsecuritymode(DatahubsecuritymodeEnum value) {
        this.datahubsecuritymode = value;
    }

}
