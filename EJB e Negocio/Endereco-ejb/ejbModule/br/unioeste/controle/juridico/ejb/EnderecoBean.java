package br.unioeste.controle.juridico.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.dados.endereco.Endereco;
import br.unioeste.controle.juridico.control.endereco.UCManterEnderecoManager;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.pool.ConnectionFactory;

/**
 * Session Bean implementation class EnderecoBean
 */
@Stateless
@Remote(EnderecoBeanRemote.class)
public class EnderecoBean implements EnderecoBeanRemote {

    /**
     * Default constructor. 
     */
    public EnderecoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Endereco obterEnderecoPorCEP(String cep) {
		DataBaseConnection.getInstance().setConnection(ConnectionFactory.getInstance().getConnection());
		UCManterEnderecoManager end = new UCManterEnderecoManager();
		
		try {
			return end.obterEnderecoPorCEP(cep);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Endereco obterEnderecoPorID(int id) {
		DataBaseConnection.getInstance().setConnection(ConnectionFactory.getInstance().getConnection());
		UCManterEnderecoManager end = new UCManterEnderecoManager();
		
		try {
			return end.obterEnderecoPorID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
