import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.demo.soap_service.DiscriminantSolutionService;
import ru.demo.soap_service.DiscriminantSolutionServiceDefaultImpl;
import ru.demo.soap_service.Response;
import ru.demo.soap_service.exceptions.SolveNotFoundException;

public class DiscriminantSolutionServiceTest {

    DiscriminantSolutionService discriminantSolutionService = new DiscriminantSolutionServiceDefaultImpl();

    @Test
    public void solutionWithTwoRoot() throws SolveNotFoundException {
        int a = -1;
        int b = 7;
        int c = 8;
        String formula = "-1x^2+7x+8 = 0";
        ru.demo.soap_service.Request request = new ru.demo.soap_service.Request();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        Response responseWithTwoRoots = new Response();
        Response response = discriminantSolutionService.getSolveEquationRequest(request);
        responseWithTwoRoots.setX1(-1d);
        responseWithTwoRoots.setX2(8d);
        responseWithTwoRoots.setDiscriminant(81);
        Assertions.assertEquals(response.getX1(), responseWithTwoRoots.getX1());
        Assertions.assertEquals(response.getX2(), responseWithTwoRoots.getX2());
        Assertions.assertEquals(response.getDiscriminant(), responseWithTwoRoots.getDiscriminant());
        Assertions.assertEquals(response.getFormula(), formula);
    }
    @Test
    public void solutionWithOneRoot() throws SolveNotFoundException {
        int a = 4;
        int b = 4;
        int c = 1;
        String formula = "4x^2+4x+1 = 0";
        ru.demo.soap_service.Request request = new ru.demo.soap_service.Request();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        Response responseWithOneRoots = new Response();
        Response response = discriminantSolutionService.getSolveEquationRequest(request);
        responseWithOneRoots.setX1(-0.5d);
        responseWithOneRoots.setX2(null);
        responseWithOneRoots.setDiscriminant(0);
        Assertions.assertEquals(response.getX1(), responseWithOneRoots.getX1());
        Assertions.assertEquals(response.getX2(), responseWithOneRoots.getX2());
        Assertions.assertEquals(response.getDiscriminant(), responseWithOneRoots.getDiscriminant());
        Assertions.assertEquals(response.getFormula(), formula);
    }
    @Test
    public void solutionWithoutRoot() throws SolveNotFoundException {
        int a = 2;
        int b = 1;
        int c = 1;
        ru.demo.soap_service.Request request = new ru.demo.soap_service.Request();
        request.setA(a);
        request.setB(b);
        request.setC(c);
        Response responseWithOneRoots = new Response();
        Assertions.assertThrows(SolveNotFoundException.class,
                ()->{Response response = discriminantSolutionService.getSolveEquationRequest(request);});

    }

    private boolean doubleEquals(double d1, double d2){
        return (Math.abs(d1) - Math.abs(d2) <= 0.0001);
    }
}
