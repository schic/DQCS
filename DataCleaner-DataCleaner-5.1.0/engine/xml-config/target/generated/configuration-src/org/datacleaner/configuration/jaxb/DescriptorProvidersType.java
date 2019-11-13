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
 * <p>descriptorProvidersType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="descriptorProvidersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="custom-class" type="{http://eobjects.org/analyzerbeans/configuration/1.0}customElementType"/&gt;
 *         &lt;element name="classpath-scanner" type="{http://eobjects.org/analyzerbeans/configuration/1.0}classpathScannerType" minOccurs="0"/&gt;
 *         &lt;element name="remote-components" type="{http://eobjects.org/analyzerbeans/configuration/1.0}remoteComponentsType" minOccurs="0"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "descriptorProvidersType", propOrder = {
    "customClassOrClasspathScannerOrRemoteComponents"
})
public class DescriptorProvidersType {

    @XmlElements({
        @XmlElement(name = "custom-class", type = CustomElementType.class),
        @XmlElement(name = "classpath-scanner", type = ClasspathScannerType.class),
        @XmlElement(name = "remote-components", type = RemoteComponentsType.class)
    })
    protected List<Object> customClassOrClasspathScannerOrRemoteComponents;

    /**
     * Gets the value of the customClassOrClasspathScannerOrRemoteComponents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customClassOrClasspathScannerOrRemoteComponents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomClassOrClasspathScannerOrRemoteComponents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomElementType }
     * {@link ClasspathScannerType }
     * {@link RemoteComponentsType }
     * 
     * 
     */
    public List<Object> getCustomClassOrClasspathScannerOrRemoteComponents() {
        if (customClassOrClasspathScannerOrRemoteComponents == null) {
            customClassOrClasspathScannerOrRemoteComponents = new ArrayList<Object>();
        }
        return this.customClassOrClasspathScannerOrRemoteComponents;
    }

}
