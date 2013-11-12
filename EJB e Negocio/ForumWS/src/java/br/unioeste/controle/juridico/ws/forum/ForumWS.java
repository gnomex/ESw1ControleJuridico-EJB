/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.ws.forum;

import br.unioeste.controle.juridico.control.forum.UCManterForumManager;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.pool.ConnectionFactory;
import br.uniotes.controle.juridico.forum.Forum;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hismahil
 */
@WebService(serviceName = "ForumWS")
public class ForumWS {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obterForum")
    public String obterForum(@WebParam(name = "id") int id) {
        UCManterForumManager manager = new UCManterForumManager();
        DataBaseConnection.getInstance().setConnection(ConnectionFactory.getInstance().getConnection());
        
        StringBuilder str = new StringBuilder();
        
        try {
            Forum forum = manager.obterForum(id);
            
            str.append(forum.getCodForum() + ",");
            str.append(forum.getNome() + ",");
            str.append(forum.getNomeFantasia() + ",");
            str.append(forum.getCNPJ() + ",");
            str.append(forum.getEnd().getCodEnd());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str.toString();
    }
}
