package ru.demo.soap_service;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
public class Request {
    @XmlElement(name = "A", required = true, nillable = false)
    private Integer A;
    @XmlElement(name = "B", required = true, nillable = false)
    private Integer B;
    @XmlElement(name = "C", required = true, nillable = false)
    private Integer C;

    public Request() {
    }

    public Request(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public int getA() {
        return A;
    }

    public Request setA(int a) {
        A = a;
        return this;
    }

    public int getB() {
        return B;
    }

    public Request setB(int b) {
        B = b;
        return this;
    }

    public int getC() {
        return C;
    }

    public Request setC(int c) {
        C = c;
        return this;
    }
}
