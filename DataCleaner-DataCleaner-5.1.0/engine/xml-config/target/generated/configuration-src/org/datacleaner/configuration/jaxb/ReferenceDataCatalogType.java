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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>referenceDataCatalogType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="referenceDataCatalogType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dictionaries" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;element name="text-file-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}textFileDictionaryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="value-list-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}valueListDictionaryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="datastore-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datastoreDictionaryType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="custom-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="synonym-catalogs" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;element name="text-file-synonym-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}textFileSynonymCatalogType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="datastore-synonym-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datastoreSynonymCatalogType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="custom-synonym-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="string-patterns" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;element name="regex-pattern" type="{http://eobjects.org/analyzerbeans/configuration/1.0}regexPatternType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="simple-pattern" type="{http://eobjects.org/analyzerbeans/configuration/1.0}simplePatternType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/choice&gt;
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
@XmlType(name = "referenceDataCatalogType", propOrder = {
    "dictionaries",
    "synonymCatalogs",
    "stringPatterns"
})
public class ReferenceDataCatalogType {

    protected ReferenceDataCatalogType.Dictionaries dictionaries;
    @XmlElement(name = "synonym-catalogs")
    protected ReferenceDataCatalogType.SynonymCatalogs synonymCatalogs;
    @XmlElement(name = "string-patterns")
    protected ReferenceDataCatalogType.StringPatterns stringPatterns;

    /**
     * 获取dictionaries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataCatalogType.Dictionaries }
     *     
     */
    public ReferenceDataCatalogType.Dictionaries getDictionaries() {
        return dictionaries;
    }

    /**
     * 设置dictionaries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataCatalogType.Dictionaries }
     *     
     */
    public void setDictionaries(ReferenceDataCatalogType.Dictionaries value) {
        this.dictionaries = value;
    }

    /**
     * 获取synonymCatalogs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataCatalogType.SynonymCatalogs }
     *     
     */
    public ReferenceDataCatalogType.SynonymCatalogs getSynonymCatalogs() {
        return synonymCatalogs;
    }

    /**
     * 设置synonymCatalogs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataCatalogType.SynonymCatalogs }
     *     
     */
    public void setSynonymCatalogs(ReferenceDataCatalogType.SynonymCatalogs value) {
        this.synonymCatalogs = value;
    }

    /**
     * 获取stringPatterns属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDataCatalogType.StringPatterns }
     *     
     */
    public ReferenceDataCatalogType.StringPatterns getStringPatterns() {
        return stringPatterns;
    }

    /**
     * 设置stringPatterns属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDataCatalogType.StringPatterns }
     *     
     */
    public void setStringPatterns(ReferenceDataCatalogType.StringPatterns value) {
        this.stringPatterns = value;
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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;element name="text-file-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}textFileDictionaryType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="value-list-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}valueListDictionaryType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="datastore-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datastoreDictionaryType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="custom-dictionary" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "textFileDictionaryOrValueListDictionaryOrDatastoreDictionary"
    })
    public static class Dictionaries {

        @XmlElements({
            @XmlElement(name = "text-file-dictionary", type = TextFileDictionaryType.class),
            @XmlElement(name = "value-list-dictionary", type = ValueListDictionaryType.class),
            @XmlElement(name = "datastore-dictionary", type = DatastoreDictionaryType.class),
            @XmlElement(name = "custom-dictionary", type = CustomElementType.class)
        })
        protected List<Object> textFileDictionaryOrValueListDictionaryOrDatastoreDictionary;

        /**
         * Gets the value of the textFileDictionaryOrValueListDictionaryOrDatastoreDictionary property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the textFileDictionaryOrValueListDictionaryOrDatastoreDictionary property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTextFileDictionaryOrValueListDictionaryOrDatastoreDictionary().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TextFileDictionaryType }
         * {@link ValueListDictionaryType }
         * {@link DatastoreDictionaryType }
         * {@link CustomElementType }
         * 
         * 
         */
        public List<Object> getTextFileDictionaryOrValueListDictionaryOrDatastoreDictionary() {
            if (textFileDictionaryOrValueListDictionaryOrDatastoreDictionary == null) {
                textFileDictionaryOrValueListDictionaryOrDatastoreDictionary = new ArrayList<Object>();
            }
            return this.textFileDictionaryOrValueListDictionaryOrDatastoreDictionary;
        }

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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;element name="regex-pattern" type="{http://eobjects.org/analyzerbeans/configuration/1.0}regexPatternType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="simple-pattern" type="{http://eobjects.org/analyzerbeans/configuration/1.0}simplePatternType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "regexPatternOrSimplePattern"
    })
    public static class StringPatterns {

        @XmlElements({
            @XmlElement(name = "regex-pattern", type = RegexPatternType.class),
            @XmlElement(name = "simple-pattern", type = SimplePatternType.class)
        })
        protected List<Object> regexPatternOrSimplePattern;

        /**
         * Gets the value of the regexPatternOrSimplePattern property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the regexPatternOrSimplePattern property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRegexPatternOrSimplePattern().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RegexPatternType }
         * {@link SimplePatternType }
         * 
         * 
         */
        public List<Object> getRegexPatternOrSimplePattern() {
            if (regexPatternOrSimplePattern == null) {
                regexPatternOrSimplePattern = new ArrayList<Object>();
            }
            return this.regexPatternOrSimplePattern;
        }

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
     *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;element name="text-file-synonym-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}textFileSynonymCatalogType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="datastore-synonym-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datastoreSynonymCatalogType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="custom-synonym-catalog" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog"
    })
    public static class SynonymCatalogs {

        @XmlElements({
            @XmlElement(name = "text-file-synonym-catalog", type = TextFileSynonymCatalogType.class),
            @XmlElement(name = "datastore-synonym-catalog", type = DatastoreSynonymCatalogType.class),
            @XmlElement(name = "custom-synonym-catalog", type = CustomElementType.class)
        })
        protected List<Object> textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog;

        /**
         * Gets the value of the textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTextFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TextFileSynonymCatalogType }
         * {@link DatastoreSynonymCatalogType }
         * {@link CustomElementType }
         * 
         * 
         */
        public List<Object> getTextFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog() {
            if (textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog == null) {
                textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog = new ArrayList<Object>();
            }
            return this.textFileSynonymCatalogOrDatastoreSynonymCatalogOrCustomSynonymCatalog;
        }

    }

}
