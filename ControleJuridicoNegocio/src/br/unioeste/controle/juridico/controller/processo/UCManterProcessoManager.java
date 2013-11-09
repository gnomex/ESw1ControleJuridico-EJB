package br.unioeste.controle.juridico.controller.processo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.unioeste.controle.juridico.controller.IUCManterProcessoManager;
import br.unioeste.controle.juridico.controller.tramite.UCManterTramiteManager;
import br.unioeste.controle.juridico.exception.NoMoreProcess;
import br.unioeste.controle.juridico.exception.NoUpdateProcess;
import br.unioeste.controle.juridico.model.processo.ColProcesso;
import br.unioeste.controle.juridico.model.tramite.ColTramite;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.tramite.TipoTramite;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;

public class UCManterProcessoManager implements IUCManterProcessoManager {

	private ColProcesso colProc = new ColProcesso();
	private SimpleDateFormat sdf;
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#insertProcesso(br.uniotes.controle.juridico.processo.Processo)
	 */
	@Override
	public Processo insertProcesso(Processo proc) throws Exception{
		if(isInvalidate(proc)) 
			throw new NoMoreProcess("client can not enter the process", "Process equals");
		
		if(isLawyerOverflow(proc))
			throw new NoMoreProcess("Lawyer is full of process", "Can not enter the process");
		
		proc = colProc.insertProcesso(proc);
		
		createTramiteAbertura(proc);
		
		return proc; 
	}
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#retrieveProcesso(java.lang.Integer)
	 */
	@Override
	public Processo retrieveProcesso(Integer codProc) throws Exception{
		return colProc.retrieveProcesso(codProc);
	}
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#retrieveAllProcesso()
	 */
	@Override
	public List<Processo> retrieveAllProcesso() throws Exception{
		return colProc.retrieveAllProcesso();
	}
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#retrieveProcessoOfNro(java.lang.String)
	 */
	@Override
	public Processo retrieveProcessoOfNro(String nroProcesso) throws Exception{
		return colProc.retrieveProcessoOfNro(nroProcesso);
	}
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#retrieveAllProcessoAdvogado(java.lang.Integer)
	 */
	@Override
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) throws Exception{
		return colProc.retrieveAllProcessoAdvogado(codAdv);
	}
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#retrieveAllProcessoCliente(java.lang.Integer)
	 */
	@Override
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) throws Exception{
		return colProc.retrieveAllProcessoCliente(codCli);
	}
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.processo.IUCManterProcessoManager#updateProcesso(br.uniotes.controle.juridico.processo.Processo, br.uniotes.controle.juridico.processo.Processo)
	 */
	@Override
	public Processo updateProcesso(Processo newProc,Processo oldProc) throws Exception{
		if(oldProc.getSituacao() == 0){
			ColTramite colTramite = new ColTramite();
			TramiteProcesso tramite = new TramiteProcesso();
			
			tramite = colTramite.retrieveTramiteProcesso(oldProc.getDtAbertura());
			
			if(tramite.getTipo().getTipo().equals("Abertura")){
				
				if(newProc.getSituacao() != oldProc.getSituacao()){
					sdf = new SimpleDateFormat("dd/MM/yyyy");  
					
					UCManterTramiteManager manager = new UCManterTramiteManager();
					
					tramite = new TramiteProcesso();
					tramite.setDtTramite(sdf.format( new Date( System.currentTimeMillis() ) ));
					tramite.setObservacoes("Lan�amento da situa��o");
					
					TipoTramite tipo = new TipoTramite();
					tipo.setTipo(getSituacao(newProc.getSituacao()));
					tramite.setTipo(tipo);
					
					tramite.setProc(oldProc);
					
					tramite = manager.insertTramiteProcesso(tramite);
				}
				
				return colProc.updateProcesso(newProc, oldProc);
			}
			else 
				throw new NoUpdateProcess("Processo n�o pode ser atualizado", 
						"O Tr�mite do processo n�o � Abertura");
		}
		else
			throw new NoUpdateProcess("Processo n�o pode ser atualizado", 
					"Situa��o do Processo n�o � de Aberto");
		
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
	
	/**
	 * <h3><b>Cria o tr�mite de abertura do processo</b></h3><br/>
	 * @param proc <code>Processo</code>
	 * @throws Exception
	 */
	private void createTramiteAbertura(Processo proc) throws Exception{
		sdf = new SimpleDateFormat("dd/MM/yyyy");  
		
		UCManterTramiteManager manager = new UCManterTramiteManager();
		
		TramiteProcesso tramite = new TramiteProcesso();
		tramite.setDtTramite(sdf.format( new Date( System.currentTimeMillis() ) ));
		tramite.setObservacoes("Cria��o do processo no escrit�rio");
		
		TipoTramite tipo = new TipoTramite();
		tipo.setTipo("Abertura");
		tramite.setTipo(tipo);
		
		tramite.setProc(proc);
		
		tramite = manager.insertTramiteProcesso(tramite);
	}
	
	private String getSituacao(Integer situacao){
		switch(situacao){
			case 0: return "Aberto";
			case 1: return "Em Julgamento";
			case 2: return "Julgado";
			case 3: return "Cancelado";
		}
		return null;
	}
}