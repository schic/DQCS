//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.11 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.11.12 时间 04:02:39 PM CST 
//


package org.datacleaner.monitor.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>chartOptionsType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="chartOptionsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="horizontal-axis" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="rolling-axis"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="latest-number-of-days" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="fixed-axis"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;all&gt;
 *                             &lt;element name="begin-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="end-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                           &lt;/all&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/choice&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="vertical-axis" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                   &lt;element name="logarithmic-scale" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *                   &lt;element name="minimum-value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                   &lt;element name="maximum-value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chartOptionsType", namespace = "http://eobjects.org/datacleaner/timeline/1.0", propOrder = {

})
public class ChartOptionsType {

    @XmlElement(name = "horizontal-axis")
    protected ChartOptionsType.HorizontalAxis horizontalAxis;
    @XmlElement(name = "vertical-axis")
    protected ChartOptionsType.VerticalAxis verticalAxis;

    /**
     * 获取horizontalAxis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChartOptionsType.HorizontalAxis }
     *     
     */
    public ChartOptionsType.HorizontalAxis getHorizontalAxis() {
        return horizontalAxis;
    }

    /**
     * 设置horizontalAxis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChartOptionsType.HorizontalAxis }
     *     
     */
    public void setHorizontalAxis(ChartOptionsType.HorizontalAxis value) {
        this.horizontalAxis = value;
    }

    /**
     * 获取verticalAxis属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChartOptionsType.VerticalAxis }
     *     
     */
    public ChartOptionsType.VerticalAxis getVerticalAxis() {
        return verticalAxis;
    }

    /**
     * 设置verticalAxis属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChartOptionsType.VerticalAxis }
     *     
     */
    public void setVerticalAxis(ChartOptionsType.VerticalAxis value) {
        this.verticalAxis = value;
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
     *       &lt;choice&gt;
     *         &lt;element name="rolling-axis"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="latest-number-of-days" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="fixed-axis"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;all&gt;
     *                   &lt;element name="begin-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="end-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                 &lt;/all&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
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
        "rollingAxis",
        "fixedAxis"
    })
    public static class HorizontalAxis {

        @XmlElement(name = "rolling-axis", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
        protected ChartOptionsType.HorizontalAxis.RollingAxis rollingAxis;
        @XmlElement(name = "fixed-axis", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
        protected ChartOptionsType.HorizontalAxis.FixedAxis fixedAxis;

        /**
         * 获取rollingAxis属性的值。
         * 
         * @return
         *     possible object is
         *     {@link ChartOptionsType.HorizontalAxis.RollingAxis }
         *     
         */
        public ChartOptionsType.HorizontalAxis.RollingAxis getRollingAxis() {
            return rollingAxis;
        }

        /**
         * 设置rollingAxis属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ChartOptionsType.HorizontalAxis.RollingAxis }
         *     
         */
        public void setRollingAxis(ChartOptionsType.HorizontalAxis.RollingAxis value) {
            this.rollingAxis = value;
        }

        /**
         * 获取fixedAxis属性的值。
         * 
         * @return
         *     possible object is
         *     {@link ChartOptionsType.HorizontalAxis.FixedAxis }
         *     
         */
        public ChartOptionsType.HorizontalAxis.FixedAxis getFixedAxis() {
            return fixedAxis;
        }

        /**
         * 设置fixedAxis属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link ChartOptionsType.HorizontalAxis.FixedAxis }
         *     
         */
        public void setFixedAxis(ChartOptionsType.HorizontalAxis.FixedAxis value) {
            this.fixedAxis = value;
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
         *       &lt;all&gt;
         *         &lt;element name="begin-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="end-date" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *       &lt;/all&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class FixedAxis {

            @XmlElement(name = "begin-date", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar beginDate;
            @XmlElement(name = "end-date", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar endDate;

            /**
             * 获取beginDate属性的值。
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getBeginDate() {
                return beginDate;
            }

            /**
             * 设置beginDate属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setBeginDate(XMLGregorianCalendar value) {
                this.beginDate = value;
            }

            /**
             * 获取endDate属性的值。
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEndDate() {
                return endDate;
            }

            /**
             * 设置endDate属性的值。
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEndDate(XMLGregorianCalendar value) {
                this.endDate = value;
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
         *       &lt;all&gt;
         *         &lt;element name="latest-number-of-days" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
         *       &lt;/all&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class RollingAxis {

            @XmlElement(name = "latest-number-of-days", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
            protected int latestNumberOfDays;

            /**
             * 获取latestNumberOfDays属性的值。
             * 
             */
            public int getLatestNumberOfDays() {
                return latestNumberOfDays;
            }

            /**
             * 设置latestNumberOfDays属性的值。
             * 
             */
            public void setLatestNumberOfDays(int value) {
                this.latestNumberOfDays = value;
            }

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
     *       &lt;all&gt;
     *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *         &lt;element name="logarithmic-scale" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
     *         &lt;element name="minimum-value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *         &lt;element name="maximum-value" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class VerticalAxis {

        @XmlElement(namespace = "http://eobjects.org/datacleaner/timeline/1.0")
        protected Integer height;
        @XmlElement(name = "logarithmic-scale", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
        protected boolean logarithmicScale;
        @XmlElement(name = "minimum-value", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
        protected Integer minimumValue;
        @XmlElement(name = "maximum-value", namespace = "http://eobjects.org/datacleaner/timeline/1.0")
        protected Integer maximumValue;

        /**
         * 获取height属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getHeight() {
            return height;
        }

        /**
         * 设置height属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setHeight(Integer value) {
            this.height = value;
        }

        /**
         * 获取logarithmicScale属性的值。
         * 
         */
        public boolean isLogarithmicScale() {
            return logarithmicScale;
        }

        /**
         * 设置logarithmicScale属性的值。
         * 
         */
        public void setLogarithmicScale(boolean value) {
            this.logarithmicScale = value;
        }

        /**
         * 获取minimumValue属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMinimumValue() {
            return minimumValue;
        }

        /**
         * 设置minimumValue属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMinimumValue(Integer value) {
            this.minimumValue = value;
        }

        /**
         * 获取maximumValue属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMaximumValue() {
            return maximumValue;
        }

        /**
         * 设置maximumValue属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMaximumValue(Integer value) {
            this.maximumValue = value;
        }

    }

}
