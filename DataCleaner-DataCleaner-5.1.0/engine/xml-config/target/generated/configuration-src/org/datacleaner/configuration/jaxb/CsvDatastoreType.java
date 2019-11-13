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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>csvDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="csvDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="quote-char" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="separator-char" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="escape-char" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="encoding" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="fail-on-inconsistencies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="multiline-values" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="header-line-number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csvDatastoreType", propOrder = {
    "filename",
    "quoteChar",
    "separatorChar",
    "escapeChar",
    "encoding",
    "failOnInconsistencies",
    "multilineValues",
    "headerLineNumber"
})
public class CsvDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(required = true)
    protected String filename;
    @XmlElement(name = "quote-char")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String quoteChar;
    @XmlElement(name = "separator-char")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String separatorChar;
    @XmlElement(name = "escape-char")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String escapeChar;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String encoding;
    @XmlElement(name = "fail-on-inconsistencies")
    protected Boolean failOnInconsistencies;
    @XmlElement(name = "multiline-values")
    protected Boolean multilineValues;
    @XmlElement(name = "header-line-number", defaultValue = "1")
    protected Integer headerLineNumber;

    /**
     * 获取filename属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置filename属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * 获取quoteChar属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteChar() {
        return quoteChar;
    }

    /**
     * 设置quoteChar属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteChar(String value) {
        this.quoteChar = value;
    }

    /**
     * 获取separatorChar属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeparatorChar() {
        return separatorChar;
    }

    /**
     * 设置separatorChar属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeparatorChar(String value) {
        this.separatorChar = value;
    }

    /**
     * 获取escapeChar属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEscapeChar() {
        return escapeChar;
    }

    /**
     * 设置escapeChar属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEscapeChar(String value) {
        this.escapeChar = value;
    }

    /**
     * 获取encoding属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * 设置encoding属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncoding(String value) {
        this.encoding = value;
    }

    /**
     * 获取failOnInconsistencies属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFailOnInconsistencies() {
        return failOnInconsistencies;
    }

    /**
     * 设置failOnInconsistencies属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFailOnInconsistencies(Boolean value) {
        this.failOnInconsistencies = value;
    }

    /**
     * 获取multilineValues属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultilineValues() {
        return multilineValues;
    }

    /**
     * 设置multilineValues属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultilineValues(Boolean value) {
        this.multilineValues = value;
    }

    /**
     * 获取headerLineNumber属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHeaderLineNumber() {
        return headerLineNumber;
    }

    /**
     * 设置headerLineNumber属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHeaderLineNumber(Integer value) {
        this.headerLineNumber = value;
    }

}
