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
 * <p>datastoreCatalogType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="datastoreCatalogType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element name="jdbc-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}jdbcDatastoreType"/&gt;
 *           &lt;element name="access-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}accessDatastoreType"/&gt;
 *           &lt;element name="csv-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}csvDatastoreType"/&gt;
 *           &lt;element name="salesforce-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}salesforceDatastoreType"/&gt;
 *           &lt;element name="sugar-crm-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}sugarCrmDatastoreType"/&gt;
 *           &lt;element name="datahub-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}datahubDatastoreType"/&gt;
 *           &lt;element name="hbase-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}hbaseDatastoreType"/&gt;
 *           &lt;element name="mongodb-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}mongodbDatastoreType"/&gt;
 *           &lt;element name="elasticsearch-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}elasticSearchDatastoreType"/&gt;
 *           &lt;element name="cassandra-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}cassandraDatastoreType"/&gt;
 *           &lt;element name="couchdb-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}couchdbDatastoreType"/&gt;
 *           &lt;element name="neo4j-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}neo4jDatastoreType"/&gt;
 *           &lt;element name="fixed-width-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}fixedWidthDatastoreType"/&gt;
 *           &lt;element name="sas-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}sasDatastoreType"/&gt;
 *           &lt;element name="excel-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}excelDatastoreType"/&gt;
 *           &lt;element name="json-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}jsonDatastoreType"/&gt;
 *           &lt;element name="dbase-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}dbaseDatastoreType"/&gt;
 *           &lt;element name="odb-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}openOfficeDatabaseDatastoreType"/&gt;
 *           &lt;element name="xml-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}xmlDatastoreType"/&gt;
 *           &lt;element name="pojo-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}pojoDatastoreType"/&gt;
 *           &lt;element name="composite-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}compositeDatastoreType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="custom-datastore" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datastoreCatalogType", propOrder = {
    "jdbcDatastoreOrAccessDatastoreOrCsvDatastore",
    "customDatastore"
})
public class DatastoreCatalogType {

    @XmlElements({
        @XmlElement(name = "jdbc-datastore", type = JdbcDatastoreType.class),
        @XmlElement(name = "access-datastore", type = AccessDatastoreType.class),
        @XmlElement(name = "csv-datastore", type = CsvDatastoreType.class),
        @XmlElement(name = "salesforce-datastore", type = SalesforceDatastoreType.class),
        @XmlElement(name = "sugar-crm-datastore", type = SugarCrmDatastoreType.class),
        @XmlElement(name = "datahub-datastore", type = DatahubDatastoreType.class),
        @XmlElement(name = "hbase-datastore", type = HbaseDatastoreType.class),
        @XmlElement(name = "mongodb-datastore", type = MongodbDatastoreType.class),
        @XmlElement(name = "elasticsearch-datastore", type = ElasticSearchDatastoreType.class),
        @XmlElement(name = "cassandra-datastore", type = CassandraDatastoreType.class),
        @XmlElement(name = "couchdb-datastore", type = CouchdbDatastoreType.class),
        @XmlElement(name = "neo4j-datastore", type = Neo4JDatastoreType.class),
        @XmlElement(name = "fixed-width-datastore", type = FixedWidthDatastoreType.class),
        @XmlElement(name = "sas-datastore", type = SasDatastoreType.class),
        @XmlElement(name = "excel-datastore", type = ExcelDatastoreType.class),
        @XmlElement(name = "json-datastore", type = JsonDatastoreType.class),
        @XmlElement(name = "dbase-datastore", type = DbaseDatastoreType.class),
        @XmlElement(name = "odb-datastore", type = OpenOfficeDatabaseDatastoreType.class),
        @XmlElement(name = "xml-datastore", type = XmlDatastoreType.class),
        @XmlElement(name = "pojo-datastore", type = PojoDatastoreType.class),
        @XmlElement(name = "composite-datastore", type = CompositeDatastoreType.class)
    })
    protected List<AbstractDatastoreType> jdbcDatastoreOrAccessDatastoreOrCsvDatastore;
    @XmlElement(name = "custom-datastore")
    protected List<CustomElementType> customDatastore;

    /**
     * Gets the value of the jdbcDatastoreOrAccessDatastoreOrCsvDatastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jdbcDatastoreOrAccessDatastoreOrCsvDatastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJdbcDatastoreOrAccessDatastoreOrCsvDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JdbcDatastoreType }
     * {@link AccessDatastoreType }
     * {@link CsvDatastoreType }
     * {@link SalesforceDatastoreType }
     * {@link SugarCrmDatastoreType }
     * {@link DatahubDatastoreType }
     * {@link HbaseDatastoreType }
     * {@link MongodbDatastoreType }
     * {@link ElasticSearchDatastoreType }
     * {@link CassandraDatastoreType }
     * {@link CouchdbDatastoreType }
     * {@link Neo4JDatastoreType }
     * {@link FixedWidthDatastoreType }
     * {@link SasDatastoreType }
     * {@link ExcelDatastoreType }
     * {@link JsonDatastoreType }
     * {@link DbaseDatastoreType }
     * {@link OpenOfficeDatabaseDatastoreType }
     * {@link XmlDatastoreType }
     * {@link PojoDatastoreType }
     * {@link CompositeDatastoreType }
     * 
     * 
     */
    public List<AbstractDatastoreType> getJdbcDatastoreOrAccessDatastoreOrCsvDatastore() {
        if (jdbcDatastoreOrAccessDatastoreOrCsvDatastore == null) {
            jdbcDatastoreOrAccessDatastoreOrCsvDatastore = new ArrayList<AbstractDatastoreType>();
        }
        return this.jdbcDatastoreOrAccessDatastoreOrCsvDatastore;
    }

    /**
     * Gets the value of the customDatastore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customDatastore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomDatastore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomElementType }
     * 
     * 
     */
    public List<CustomElementType> getCustomDatastore() {
        if (customDatastore == null) {
            customDatastore = new ArrayList<CustomElementType>();
        }
        return this.customDatastore;
    }

}
