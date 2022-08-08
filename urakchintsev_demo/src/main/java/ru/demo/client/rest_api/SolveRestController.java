package ru.demo.client.rest_api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.demo.client.generated_classes.*;
import ru.demo.client.soap_client.SoapClient;


@RestController
@RequestMapping("/api")
public class SolveRestController {

    SoapClient soapClient;

    @Autowired
    public SolveRestController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @RequestMapping("/calc")
    public ResponseDTO calculation(@RequestParam("a")int a, @RequestParam("b")int b, @RequestParam("c")int c){
        ResponseDTO responseDTO;
        try {
        Response response = soapClient.getSolveEquation(a,b,c);
        responseDTO = new ResponseDTO(response);
        return responseDTO;
        } catch (SolveNotFoundException_Exception e) {
            responseDTO = new ResponseDTO();
            responseDTO.setFaultInfo(e.getMessage());
            responseDTO.setFormula(e.getFaultInfo().getServiceFault().getFormula());
            responseDTO.setD(Integer.parseInt(e.getFaultInfo().getServiceFault().getD()));
            return responseDTO;
        }
    }

}
