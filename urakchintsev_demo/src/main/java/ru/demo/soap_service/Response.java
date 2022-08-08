package ru.demo.soap_service;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)

public class Response {

    @XmlElement(name = "formula")
    private String formula;

    @XmlElement(name = "D")
    private Integer discriminant;

    @XmlElement(name = "x1")
    private Double x1;

    @XmlElement(name = "x2")
    private Double x2;


    public String getFormula() {
        return formula;
    }

    public Response setFormula(String formula) {
        this.formula = formula;
        return this;
    }

    public Integer getDiscriminant() {
        return discriminant;
    }

    public Response setDiscriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;

    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }
}
