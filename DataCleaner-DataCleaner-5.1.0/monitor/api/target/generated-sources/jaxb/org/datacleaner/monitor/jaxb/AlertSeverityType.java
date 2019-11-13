//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.12 时间 04:02:39 PM CST 
//


package org.datacleaner.monitor.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>alertSeverityType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="alertSeverityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="INTELLIGENCE"/&gt;
 *     &lt;enumeration value="SURVEILLANCE"/&gt;
 *     &lt;enumeration value="WARNING"/&gt;
 *     &lt;enumeration value="FATAL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "alertSeverityType")
@XmlEnum
public enum AlertSeverityType {

    INTELLIGENCE,
    SURVEILLANCE,
    WARNING,
    FATAL;

    public String value() {
        return name();
    }

    public static AlertSeverityType fromValue(String v) {
        return valueOf(v);
    }

}
