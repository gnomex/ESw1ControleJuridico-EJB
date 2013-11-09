package br.unioeste.controle.juridico.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.unioeste.controle.juridico.control.processo.UCManterProcessoManager;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.pool.ConnectionFactory;
import br.uniotes.controle.juridico.processo.Processo;

/**
 * Session Bean implementation class ProcessoBean
 */
@Stateless
@Remote(ProcessoBeanRemote.class)
public class ProcessoBean implements ProcessoBeanRemote {

    /**
     * Default constructor. 
     */
    public ProcessoBean() {
    	DataBaseConnection.getInstance().setConnection(ConnectionFactory.getInstance().getConnection());
    }

	@Override
	public Processo insertProcesso(Processo proc) {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.insertProcesso(proc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return proc;
	}

	@Override
	public Processo retrieveProcesso(Integer codProc) {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.retrieveProcesso(codProc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Processo retrieveProcessoOfNro(String nroProcesso) {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.retrieveProcessoOfNro(nroProcesso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Processo> retrieveAllProcesso() {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.retrieveAllProcesso();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.retrieveAllProcessoAdvogado(codAdv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.retrieveAllProcessoCliente(codCli);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Processo updateProcesso(Processo newProc) {
		
		UCManterProcessoManager manager = new UCManterProcessoManager();
		
		try {
			return manager.updateProcesso(newProc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newProc;
	}

}
