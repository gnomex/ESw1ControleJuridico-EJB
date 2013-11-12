/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unioeste.controle.juridico.ws.cliente;

import br.dados.pessoa.fisica.PessoaFisica;
import br.dados.pessoa.juridica.PessoaJuridica;
import br.unioeste.controle.juridico.control.cliente.UCManterClienteManager;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.pool.ConnectionFactory;
import br.uniotes.controle.juridico.cliente.Cliente;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hismahil
 */
@WebService(serviceName = "ClienteWS")
public class ClienteWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "obterClientePeloID")
    public String obterClientePeloID(@WebParam(name = "id") int id) {
        UCManterClienteManager manager = new UCManterClienteManager();
        DataBaseConnection.getInstance().setConnection(ConnectionFactory.getInstance().getConnection());
        StringBuilder str = new StringBuilder();

        try {
            Cliente cliente = manager.obterClientePeloID(id);

            str.append(cliente.getCodCli() + ",");

            if (cliente.getPessoa() instanceof PessoaFisica) {
                PessoaFisica pessoa = (PessoaFisica) cliente.getPessoa();

                str.append(pessoa.getNome() + ",");
                str.append(pessoa.getSobreNome() + ",");
                str.append(pessoa.getCPF() + ",");
                str.append(pessoa.getEnd().getCodEnd());
            } else {
                PessoaJuridica pessoa = (PessoaJuridica) cliente.getPessoa();

                str.append(pessoa.getNome() + ",");
                str.append(pessoa.getNomeFantasia() + ",");
                str.append(pessoa.getCNPJ() + ",");
                str.append(pessoa.getEnd().getCodEnd());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str.toString();
    }
    
    
}
