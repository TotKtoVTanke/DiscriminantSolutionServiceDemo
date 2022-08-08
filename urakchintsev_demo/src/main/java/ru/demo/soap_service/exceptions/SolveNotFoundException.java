package ru.demo.soap_service.exceptions;

public class SolveNotFoundException extends Exception {

    private ServiceFault serviceFault;

    public SolveNotFoundException(String message, ServiceFault serviceFault) {
        super(message);
        this.serviceFault = serviceFault;
    }

    public SolveNotFoundException(String message, Throwable e, ServiceFault serviceFault) {
        super(message, e);
        this.serviceFault = serviceFault;
    }

    public ServiceFault getServiceFault() {
        return serviceFault;
    }

    public void setServiceFault(ServiceFault serviceFault) {
        this.serviceFault = serviceFault;
    }
}
