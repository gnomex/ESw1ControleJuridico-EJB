package br.unioeste.controle.juridico.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.unioeste.controle.juridico.control.advogado.UCManterAdvogadoManager;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.pool.ConnectionFactory;
import br.uniotes.controle.juridico.advogado.Advogado;

/**
 * Session Bean implementation class AdvogadoBean
 */
@Stateless
@Remote(AdvogadoBeanRemote.class)
public class AdvogadoBean implements AdvogadoBeanRemote {

    /**
     * Default constructor. 
     */
    public AdvogadoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Advogado obterAdvogado(Integer codigo) {
		DataBaseConnection.getInstance().setConnection(ConnectionFactory.getInstance().getConnection());
		UCManterAdvogadoManager adv = new UCManterAdvogadoManager();
		
		try {
			return adv.obterAdvogado(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
