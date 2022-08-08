package ru.demo.client.rest_api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.demo.client.generated_classes.Response;

@JsonPropertyOrder({"faultInfo", "formula", "d", "x1", "x2"})
public class ResponseDTO {
    @JsonProperty("formula")
    public String formula;

    @JsonProperty("d")
    public Integer d;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("x1")
    public Double x1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("x2")
    public Double x2;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("faultInfo")
    public String faultInfo = null;

    public ResponseDTO() {
    }

    public ResponseDTO(Response response) {
        this.d = response.getD();
        this.formula = response.getFormula();
        this.x1 = response.getX1();
        this.x2 = response.getX2();
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "formula='" + formula + '\'' +
                ", d=" + d +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", faultInfo='" + faultInfo + '\'' +
                '}';
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public String getFormula() {
        return formula;
    }

    public Integer getD() {
        return d;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    public String getFaultInfo() {
        return faultInfo;
    }

    public void setFaultInfo(String faultInfo) {
        this.faultInfo = faultInfo;
    }
}
