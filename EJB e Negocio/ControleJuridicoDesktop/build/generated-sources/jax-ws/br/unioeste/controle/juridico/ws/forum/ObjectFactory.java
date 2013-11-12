
package br.unioeste.controle.juridico.ws.forum;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.unioeste.controle.juridico.ws.forum package. 
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

    private final static QName _ObterForumResponse_QNAME = new QName("http://forum.ws.juridico.controle.unioeste.br/", "obterForumResponse");
    private final static QName _ObterForum_QNAME = new QName("http://forum.ws.juridico.controle.unioeste.br/", "obterForum");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.unioeste.controle.juridico.ws.forum
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObterForumResponse }
     * 
     */
    public ObterForumResponse createObterForumResponse() {
        return new ObterForumResponse();
    }

    /**
     * Create an instance of {@link ObterForum }
     * 
     */
    public ObterForum createObterForum() {
        return new ObterForum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObterForumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forum.ws.juridico.controle.unioeste.br/", name = "obterForumResponse")
    public JAXBElement<ObterForumResponse> createObterForumResponse(ObterForumResponse value) {
        return new JAXBElement<ObterForumResponse>(_ObterForumResponse_QNAME, ObterForumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObterForum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://forum.ws.juridico.controle.unioeste.br/", name = "obterForum")
    public JAXBElement<ObterForum> createObterForum(ObterForum value) {
        return new JAXBElement<ObterForum>(_ObterForum_QNAME, ObterForum.class, null, value);
    }

}
