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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>fixedWidthDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="fixedWidthDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="width-specification"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="fixed-value-width" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="value-width" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="encoding" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="header-line-number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fail-on-inconsistencies" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="skip-ebcdic-header" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="eol-present" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fixedWidthDatastoreType", propOrder = {
    "filename",
    "widthSpecification",
    "encoding",
    "headerLineNumber",
    "failOnInconsistencies",
    "skipEbcdicHeader",
    "eolPresent"
})
public class FixedWidthDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(required = true)
    protected String filename;
    @XmlElement(name = "width-specification", required = true)
    protected FixedWidthDatastoreType.WidthSpecification widthSpecification;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String encoding;
    @XmlElement(name = "header-line-number", defaultValue = "1")
    protected Integer headerLineNumber;
    @XmlElement(name = "fail-on-inconsistencies")
    protected Boolean failOnInconsistencies;
    @XmlElement(name = "skip-ebcdic-header")
    protected Boolean skipEbcdicHeader;
    @XmlElement(name = "eol-present")
    protected Boolean eolPresent;

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
     * 获取widthSpecification属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FixedWidthDatastoreType.WidthSpecification }
     *     
     */
    public FixedWidthDatastoreType.WidthSpecification getWidthSpecification() {
        return widthSpecification;
    }

    /**
     * 设置widthSpecification属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FixedWidthDatastoreType.WidthSpecification }
     *     
     */
    public void setWidthSpecification(FixedWidthDatastoreType.WidthSpecification value) {
        this.widthSpecification = value;
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
     * 获取skipEbcdicHeader属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkipEbcdicHeader() {
        return skipEbcdicHeader;
    }

    /**
     * 设置skipEbcdicHeader属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkipEbcdicHeader(Boolean value) {
        this.skipEbcdicHeader = value;
    }

    /**
     * 获取eolPresent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEolPresent() {
        return eolPresent;
    }

    /**
     * 设置eolPresent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEolPresent(Boolean value) {
        this.eolPresent = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="fixed-value-width" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="value-width" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fixedValueWidth",
        "valueWidth"
    })
    public static class WidthSpecification {

        @XmlElement(name = "fixed-value-width", defaultValue = "10")
        protected Integer fixedValueWidth;
        @XmlElement(name = "value-width", type = Integer.class, defaultValue = "5")
        protected List<Integer> valueWidth;

        /**
         * 获取fixedValueWidth属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getFixedValueWidth() {
            return fixedValueWidth;
        }

        /**
         * 设置fixedValueWidth属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setFixedValueWidth(Integer value) {
            this.fixedValueWidth = value;
        }

        /**
         * Gets the value of the valueWidth property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the valueWidth property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValueWidth().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Integer }
         * 
         * 
         */
        public List<Integer> getValueWidth() {
            if (valueWidth == null) {
                valueWidth = new ArrayList<Integer>();
            }
            return this.valueWidth;
        }

    }

}
