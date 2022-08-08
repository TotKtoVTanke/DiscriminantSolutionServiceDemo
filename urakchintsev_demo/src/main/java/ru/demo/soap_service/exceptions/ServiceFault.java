package ru.demo.soap_service.exceptions;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceFault", propOrder = {
        "formula",
        "discriminant"
})
public class ServiceFault {

    @XmlElement(name = "formula")
    private String formula;

    @XmlElement(name = "D")
    private String discriminant;

    public ServiceFault() {
    }

    public ServiceFault(String formula, String discriminant) {
        this.formula = formula;
        this.discriminant = discriminant;
    }

    public String getCode() {
        return formula;
    }

    public void setCode(String code) {
        this.formula = code;
    }

    public String getDescription() {
        return discriminant;
    }

    public void setDescription(String description) {
        this.discriminant = description;
    }
}
