package ru.demo.client.soap_client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.demo.client.generated_classes.*;

@Component
public class SoapClient {

    String wsdlAddress;

    JaxWsProxyFactoryBean factoryBean;

    @Autowired
    public SoapClient(@Value("${myServiceAddress}")String wsdlAddress) {
        this.wsdlAddress = wsdlAddress;
        factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(DiscriminantSolutionService.class);
        factoryBean.setAddress(wsdlAddress);
    }

    public Response getSolveEquation(int a, int b, int c) throws SolveNotFoundException_Exception {
        ObjectFactory objectFactory = new ObjectFactory();
        Request request = objectFactory.createRequest();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        DiscriminantSolutionService solutionService = (DiscriminantSolutionService)factoryBean.create();
        return solutionService.getSolveEquationRequest(request);
    }

}
