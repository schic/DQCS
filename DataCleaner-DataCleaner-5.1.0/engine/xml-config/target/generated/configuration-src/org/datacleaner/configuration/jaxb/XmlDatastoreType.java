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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>xmlDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="xmlDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="table-def" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="rowXpath" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="valueXpath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlDatastoreType", propOrder = {
    "filename",
    "tableDef"
})
public class XmlDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(required = true)
    protected String filename;
    @XmlElement(name = "table-def")
    protected List<XmlDatastoreType.TableDef> tableDef;

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
     * {@link XmlDatastoreType.TableDef }
     * 
     * 
     */
    public List<XmlDatastoreType.TableDef> getTableDef() {
        if (tableDef == null) {
            tableDef = new ArrayList<XmlDatastoreType.TableDef>();
        }
        return this.tableDef;
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
     *         &lt;element name="rowXpath" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="valueXpath" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
        "rowXpath",
        "valueXpath"
    })
    public static class TableDef {

        @XmlElement(required = true)
        protected String rowXpath;
        @XmlElement(required = true)
        protected List<String> valueXpath;

        /**
         * 获取rowXpath属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRowXpath() {
            return rowXpath;
        }

        /**
         * 设置rowXpath属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRowXpath(String value) {
            this.rowXpath = value;
        }

        /**
         * Gets the value of the valueXpath property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the valueXpath property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValueXpath().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getValueXpath() {
            if (valueXpath == null) {
                valueXpath = new ArrayList<String>();
            }
            return this.valueXpath;
        }

    }

}
