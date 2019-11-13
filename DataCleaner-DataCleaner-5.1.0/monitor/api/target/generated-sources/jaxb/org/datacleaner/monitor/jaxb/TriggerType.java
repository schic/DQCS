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
 * <p>trigger-type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="trigger-type"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PERIODIC"/&gt;
 *     &lt;enumeration value="DEPENDENT"/&gt;
 *     &lt;enumeration value="MANUAL"/&gt;
 *     &lt;enumeration value="ONETIME"/&gt;
 *     &lt;enumeration value="HOTFOLDER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "trigger-type", namespace = "http://eobjects.org/datacleaner/execution-log/1.0")
@XmlEnum
public enum TriggerType {

    PERIODIC,
    DEPENDENT,
    MANUAL,
    ONETIME,
    HOTFOLDER;

    public String value() {
        return name();
    }

    public static TriggerType fromValue(String v) {
        return valueOf(v);
    }

}
