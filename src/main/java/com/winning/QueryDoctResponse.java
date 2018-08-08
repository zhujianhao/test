
package com.winning;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueryDoctResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OutXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "queryDoctResult",
    "outXml"
})
@XmlRootElement(name = "QueryDoctResponse")
public class QueryDoctResponse {

    @XmlElement(name = "QueryDoctResult")
    protected boolean queryDoctResult;
    @XmlElement(name = "OutXml")
    protected String outXml;

    /**
     * ��ȡqueryDoctResult���Ե�ֵ��
     * 
     */
    public boolean isQueryDoctResult() {
        return queryDoctResult;
    }

    /**
     * ����queryDoctResult���Ե�ֵ��
     * 
     */
    public void setQueryDoctResult(boolean value) {
        this.queryDoctResult = value;
    }

    /**
     * ��ȡoutXml���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutXml() {
        return outXml;
    }

    /**
     * ����outXml���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutXml(String value) {
        this.outXml = value;
    }

}
