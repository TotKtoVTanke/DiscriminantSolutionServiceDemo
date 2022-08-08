package ru.demo.soap_service;

import ru.demo.soap_service.exceptions.SolveNotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DiscriminantSolutionService {
    @WebMethod()
    @WebResult(name = "getSolveEquationResponse")
    Response getSolveEquationRequest(@WebParam(name = "Request") Request request) throws SolveNotFoundException;
}
