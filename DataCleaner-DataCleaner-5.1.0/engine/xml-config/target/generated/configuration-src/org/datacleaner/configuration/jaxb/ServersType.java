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
 * <p>serversType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="serversType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="hadoop-clusters" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *                   &lt;element name="hadoop-cluster" type="{http://eobjects.org/analyzerbeans/configuration/1.0}hadoopClusterType"/&gt;
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
@XmlType(name = "serversType", propOrder = {
    "hadoopClusters"
})
public class ServersType {

    @XmlElement(name = "hadoop-clusters")
    protected ServersType.HadoopClusters hadoopClusters;

    /**
     * 获取hadoopClusters属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ServersType.HadoopClusters }
     *     
     */
    public ServersType.HadoopClusters getHadoopClusters() {
        return hadoopClusters;
    }

    /**
     * 设置hadoopClusters属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServersType.HadoopClusters }
     *     
     */
    public void setHadoopClusters(ServersType.HadoopClusters value) {
        this.hadoopClusters = value;
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
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
     *         &lt;element name="hadoop-cluster" type="{http://eobjects.org/analyzerbeans/configuration/1.0}hadoopClusterType"/&gt;
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
        "hadoopCluster"
    })
    public static class HadoopClusters {

        @XmlElement(name = "hadoop-cluster")
        protected List<HadoopClusterType> hadoopCluster;

        /**
         * Gets the value of the hadoopCluster property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hadoopCluster property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHadoopCluster().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HadoopClusterType }
         * 
         * 
         */
        public List<HadoopClusterType> getHadoopCluster() {
            if (hadoopCluster == null) {
                hadoopCluster = new ArrayList<HadoopClusterType>();
            }
            return this.hadoopCluster;
        }

    }

}
