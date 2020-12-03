package com.SearchingCar.SearchingCar.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "",namespace= "http://spring.io/guides/gs-producing-web-service", propOrder = {        "searchCriteria","searchKey" })
@XmlRootElement(name = "getCarRequest")
public class GetCarRequest {

    @XmlElement(required = true)
    protected String searchCriteria;
    @XmlElement(required = true)
    protected String searchKey;


    public String getsearchCriteria() {
        return searchCriteria;
    }

    public void setsearchCriteria(String value) {
        this.searchCriteria = value;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
