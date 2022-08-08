package ru.demo.soap_service;


import org.springframework.stereotype.Component;
import ru.demo.soap_service.exceptions.ServiceFault;
import ru.demo.soap_service.exceptions.SolveNotFoundException;
import javax.jws.WebService;


@WebService(endpointInterface = "ru.demo.soap_service.DiscriminantSolutionService")
@Component
public class DiscriminantSolutionServiceDefaultImpl implements DiscriminantSolutionService{


    @Override
    public Response getSolveEquationRequest(Request request) throws SolveNotFoundException {
        System.out.println("getSolveEquationRequest +!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try{
        Response response = getQuadraticEquationSolve(request);
            if (response.getDiscriminant() < 0) {
                throw new SolveNotFoundException("SOLVE_NOT_FOUND", new ServiceFault(
                        response.getFormula(), String.valueOf(response.getDiscriminant())));
            }
            return response;}
        catch (Exception exception){
            throw new SolveNotFoundException(exception.getMessage(), new ServiceFault(
                    makeFormulaString(request), String.valueOf(getDiscriminant(request))));
        }
    }

    private String makeFormulaString(Request request){
        return String.format("%dx^2%s%dx%s%d = 0",
                request.getA(),
                (request.getB() >= 0) ? "+" : "",
                request.getB(),
                (request.getC() >= 0) ? "+" : "",
                request.getC());
    }

    private int getDiscriminant(Request request){
        int a = request.getA();
        int b = request.getB();
        int c = request.getC();
        return  (b*b - 4 * a * c);
    }

    private Response getQuadraticEquationSolve(Request request){
        int a = request.getA();
        int b = request.getB();
        int d= getDiscriminant(request);
        Response result = new Response();
        result.setFormula(makeFormulaString(request));
        result.setDiscriminant(d);

        if (result.getDiscriminant().equals(0)) {
            result.setX1((-b / (2d * a)));result.setX2(null);}
        else if (d > 0){
            double x1 = Math.round((-b - Math.sqrt(d))/(2d*a)*100)/100.0;
            double x2 = Math.round((-b + Math.sqrt(d))/(2d*a)*100)/100.0;
            if (x1 < x2) {
                result.setX1(x1);
                result.setX2(x2);
            }
            else {
                result.setX1(x2);
                result.setX2(x1);
            }

        }
        return result;
    }
}

