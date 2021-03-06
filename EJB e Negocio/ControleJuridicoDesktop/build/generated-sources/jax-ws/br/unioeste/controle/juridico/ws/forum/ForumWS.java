
package br.unioeste.controle.juridico.ws.forum;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ForumWS", targetNamespace = "http://forum.ws.juridico.controle.unioeste.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ForumWS {


    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obterForum", targetNamespace = "http://forum.ws.juridico.controle.unioeste.br/", className = "br.unioeste.controle.juridico.ws.forum.ObterForum")
    @ResponseWrapper(localName = "obterForumResponse", targetNamespace = "http://forum.ws.juridico.controle.unioeste.br/", className = "br.unioeste.controle.juridico.ws.forum.ObterForumResponse")
    @Action(input = "http://forum.ws.juridico.controle.unioeste.br/ForumWS/obterForumRequest", output = "http://forum.ws.juridico.controle.unioeste.br/ForumWS/obterForumResponse")
    public String obterForum(
        @WebParam(name = "id", targetNamespace = "")
        int id);

}
