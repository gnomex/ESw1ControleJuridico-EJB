package br.unioeste.controle.juridico.control.processo;

import java.util.Date;
import java.util.List;

import br.unioeste.controle.juridico.exception.NoMoreProcess;
import br.unioeste.controle.juridico.model.processo.ColProcesso;
import br.uniotes.controle.juridico.processo.Processo;

public class UCManterProcessoManager {

	public Processo insertProcesso(Processo proc) throws Exception{
		if(isInvalidate(proc)) 
			throw new NoMoreProcess("Cliente não pode entrar com outro processo", "Processos do mesmo tipo");
		
		if(isLawyerOverflow(proc))
			throw new NoMoreProcess("Advogado cheio de processo", "Não pode ser cadastrado novo processo");
		
		ColProcesso colProc = new ColProcesso();
		
		return colProc.insertProcesso(proc);
	}
	
	public Processo retrieveProcesso(Integer codProc) throws Exception{
		ColProcesso colProc = new ColProcesso();
		return colProc.retrieveProcesso(codProc);
	}
	
	public Processo retrieveProcessoOfNro(String nroProcesso) throws Exception{
		ColProcesso colProc = new ColProcesso();
		return colProc.retrieveProcessoOfNro(nroProcesso);
	}
	
	public List<Processo> retrieveAllProcesso() throws Exception{
		ColProcesso colProc = new ColProcesso();
		return colProc.retrieveAllProcesso();
	}
	
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) throws Exception{
		ColProcesso colProc = new ColProcesso();
		return colProc.retrieveAllProcessoAdvogado(codAdv);
	}
	
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) throws Exception{
		ColProcesso colProc = new ColProcesso();
		return colProc.retrieveAllProcessoCliente(codCli);
	}
	
	public Processo updateProcesso(Processo newProc) throws Exception{
		ColProcesso colProc = new ColProcesso();
		return colProc.updateProcesso(newProc);
	}
	
	/**
	 * <h3><b>Verifica se o cliente est� tentando entrar com o mesmo processo no mesmo m�s</b></h3><br/>
	 * @param proc <code>Processo</code><br/>
	 * @return <code>true</code> ou <code>false</code>
	 * @throws Exception
	 */
	private boolean isInvalidate(Processo proc) throws Exception{
		List<Processo> lista = retrieveAllProcessoCliente(proc.getCliente().getCodCli());
		
		Date now = new Date(System.currentTimeMillis());
		int m = now.getMonth() + 1;
		
		for(Processo p : lista){
			
			if(proc.getTipo().getTipo().equals(p.getTipo().getTipo())){
				Date d = new Date(p.getDtAbertura());
				if(d.getDate() == m) return true;
			}
		}
		
		return false;
	}
	/**
	 * <h3><b>Verifica se o advogado j� possui 3 processo com a siatua��o 0 (Aberto)</b></h3><br/>
	 * @param proc <code>Processo</code><br/>
	 * @return <code>true</code> ou <code>false</code>
	 * @throws Exception
	 */
	private boolean isLawyerOverflow(Processo proc) throws Exception{
		List<Processo> list = retrieveAllProcessoAdvogado(proc.getAdvogado().getCodAdv());
		int i = 0;
		
		for(Processo p : list){
			if(p.getSituacao() == 0) i++;
			
			if(i == 3) return true;
		}
		
		return false;
	}
}
