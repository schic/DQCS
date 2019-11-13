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
 * <p>compositeDatastoreType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="compositeDatastoreType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://eobjects.org/analyzerbeans/configuration/1.0}abstractDatastoreType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="datastore-name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "compositeDatastoreType", propOrder = {
    "datastoreName"
})
public class CompositeDatastoreType
    extends AbstractDatastoreType
{

    @XmlElement(name = "datastore-name", required = true)
    protected List<String> datastoreName;

    /**
     * Gets the value of the datastoreName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datastoreName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatastoreName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDatastoreName() {
        if (datastoreName == null) {
            datastoreName = new ArrayList<String>();
        }
        return this.datastoreName;
    }

}
