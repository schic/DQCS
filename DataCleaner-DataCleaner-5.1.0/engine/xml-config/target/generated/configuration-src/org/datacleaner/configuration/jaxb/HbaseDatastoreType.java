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
 * <p>hbaseDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="hbaseDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="zookeeper-hostname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="zookeeper-port" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="table-def" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
 *                   &lt;element name="column" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hbaseDatastoreType", propOrder = {
    "zookeeperHostname",
    "zookeeperPort",
    "tableDef"
})
public class HbaseDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(name = "zookeeper-hostname")
    protected String zookeeperHostname;
    @XmlElement(name = "zookeeper-port")
    protected Integer zookeeperPort;
    @XmlElement(name = "table-def")
    protected List<HbaseDatastoreType.TableDef> tableDef;

    /**
     * 获取zookeeperHostname属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZookeeperHostname() {
        return zookeeperHostname;
    }

    /**
     * 设置zookeeperHostname属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZookeeperHostname(String value) {
        this.zookeeperHostname = value;
    }

    /**
     * 获取zookeeperPort属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getZookeeperPort() {
        return zookeeperPort;
    }

    /**
     * 设置zookeeperPort属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setZookeeperPort(Integer value) {
        this.zookeeperPort = value;
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
     * {@link HbaseDatastoreType.TableDef }
     * 
     * 
     */
    public List<HbaseDatastoreType.TableDef> getTableDef() {
        if (tableDef == null) {
            tableDef = new ArrayList<HbaseDatastoreType.TableDef>();
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
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
     *         &lt;element name="column" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
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
        "name",
        "column"
    })
    public static class TableDef {

        @XmlElement(required = true)
        @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
        @XmlSchemaType(name = "normalizedString")
        protected String name;
        @XmlElement(required = true)
        protected List<HbaseDatastoreType.TableDef.Column> column;

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
         * Gets the value of the column property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the column property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getColumn().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HbaseDatastoreType.TableDef.Column }
         * 
         * 
         */
        public List<HbaseDatastoreType.TableDef.Column> getColumn() {
            if (column == null) {
                column = new ArrayList<HbaseDatastoreType.TableDef.Column>();
            }
            return this.column;
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
         *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}normalizedString" minOccurs="0"/&gt;
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}normalizedString"/&gt;
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
            "family",
            "name",
            "type"
        })
        public static class Column {

            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String family;
            @XmlElement(required = true)
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String name;
            @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
            @XmlSchemaType(name = "normalizedString")
            protected String type;

            /**
             * 获取family属性的值。
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFamily() {
                return family;
            }

            /**
             * 设置family属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFamily(String value) {
                this.family = value;
            }

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
