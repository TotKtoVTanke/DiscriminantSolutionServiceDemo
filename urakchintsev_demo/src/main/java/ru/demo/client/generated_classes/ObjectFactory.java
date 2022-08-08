
package ru.demo.client.generated_classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.demo.soap_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SolveNotFoundException_QNAME = new QName("http://soap_service.demo.ru/", "SolveNotFoundException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.demo.soap_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolveNotFoundException }
     * 
     */
    public SolveNotFoundException createSolveNotFoundException() {
        return new SolveNotFoundException();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link ServiceFault }
     * 
     */
    public ServiceFault createServiceFault() {
        return new ServiceFault();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap_service.demo.ru/", name = "SolveNotFoundException")
    public JAXBElement<SolveNotFoundException> createSolveNotFoundException(SolveNotFoundException value) {
        return new JAXBElement<SolveNotFoundException>(_SolveNotFoundException_QNAME, SolveNotFoundException.class, null, value);
    }

}
