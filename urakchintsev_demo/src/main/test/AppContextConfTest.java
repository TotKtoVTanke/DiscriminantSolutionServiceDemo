
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import ru.demo.client.soap_client.SoapClient;


@Configuration
public class AppContextConfTest {
    @Autowired
    ApplicationContext context;

    @Mock
    SoapClient soapClient;


}
