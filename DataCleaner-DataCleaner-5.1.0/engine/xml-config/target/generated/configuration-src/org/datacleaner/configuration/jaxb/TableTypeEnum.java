//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.13 时间 02:22:46 PM CST 
//


package org.datacleaner.configuration.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>tableTypeEnum的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="tableTypeEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TABLE"/&gt;
 *     &lt;enumeration value="VIEW"/&gt;
 *     &lt;enumeration value="SYSTEM_TABLE"/&gt;
 *     &lt;enumeration value="GLOBAL_TEMPORARY"/&gt;
 *     &lt;enumeration value="LOCAL_TEMPORARY"/&gt;
 *     &lt;enumeration value="ALIAS"/&gt;
 *     &lt;enumeration value="SYNONYM"/&gt;
 *     &lt;enumeration value="OTHER"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tableTypeEnum")
@XmlEnum
public enum TableTypeEnum {

    TABLE,
    VIEW,
    SYSTEM_TABLE,
    GLOBAL_TEMPORARY,
    LOCAL_TEMPORARY,
    ALIAS,
    SYNONYM,
    OTHER;

    public String value() {
        return name();
    }

    public static TableTypeEnum fromValue(String v) {
        return valueOf(v);
    }

}
