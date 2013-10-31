package br.unioeste.controle.juridico.model.processo;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.com.text.validator.TextValidator;
import br.unioeste.controle.juridico.control.tramite.UCManterTramiteManager;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.exception.NoData;
import br.unioeste.controle.juridico.exception.NoUpdateProcess;
import br.unioeste.controle.juridico.model.advogado.ColAdvogado;
import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.unioeste.controle.juridico.model.forum.ColForum;
import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.unioeste.controle.juridico.model.tramite.ColTramite;
import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.TipoProcesso;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;
import br.uniotes.controle.juridico.processo.tramite.TipoTramite;

public class ColProcesso {

	private SimpleDateFormat sdf;
	/**
	 * <h3><b>insere um processo (Falta as valida��es que o professor pediu)</b></h3>
	 * @param proc <code>Novo processo</code>
	 * @return <code>Processo com o c�digo</code>
	 * @throws Exception
	 */
	public Processo insertProcesso(Processo proc) throws Exception{	
		if(validaDados(proc)){
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO Processo(dtAbertura, descricao, codTipoProc, codForum, codCli, situacao, nroProcesso, codAdv, nroOAB) VALUES ('" + proc.getDtAbertura() + "','"
					+ proc.getDescricao() + "',"
					+ proc.getTipo().getCodTipoProcesso() + ","
					+ proc.getForum().getCodForum() + ","
					+ proc.getCliente().getCodCli() + ","
					+ proc.getSituacao() + ","
					+ proc.getNroProcesso() + ","
					+ proc.getAdvogado().getCodAdv() + ",'"
					+ proc.getAdvogado().getNroOAB() + "')");
			
			
			DataBaseConnection.getInstance().execute(sql);
			
			proc.setCodProc(getLastID());
			
			createTramiteAbertura(proc); //cria trâmite inicial
		}
		return proc;
	}
	
	private boolean validaDados(Processo proc) throws NoData{
		if(!TextValidator.getInstance().isDate(proc.getDtAbertura()))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isString(proc.getDescricao()))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(proc.getNroProcesso() == null)
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isNumber(String.valueOf(proc.getAdvogado().getCodAdv())))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isNumber(String.valueOf(proc.getCliente().getCodCli())))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isNumber(String.valueOf(proc.getForum().getCodForum())))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isNumber(proc.getSituacao().toString()))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isNumber(proc.getTipo().getCodTipoProcesso().toString()))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else if(!TextValidator.getInstance().isString(proc.getAdvogado().getNroOAB()))
			throw new NoData("Dados invalidos", "Ou esta sem dados ou contêm dados invalidos");
		else return true;
	}
	/**
	 * <h3><b>Apenas verifica o c�digo da ultima inser��o</b></h3><br/>
	 * @return <code>C�digo do ultimo registro</code>
	 * @throws Exception 
	 */
	private int getLastID() throws Exception{
		
		StringBuilder sql = new StringBuilder();
		int id = 0;
		
		sql.append("SELECT MAX(codProc) FROM Processo");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		while(rs.next()){
			id = rs.getInt(1);
		}
		
		return id;
	}
	
	/**
	 * <h3><b>Retorna dados do processo</b></h3>
	 * @param codProc <code>C�digo do processo sem ser o numero</code>
	 * @return <code>Processo</code>
	 * @throws Exception
	 */
	public Processo retrieveProcesso(Integer codProc) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM Processo WHERE codProc = " + codProc);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = new Processo();
		TipoProcesso tipo = new TipoProcesso();
		Forum forum = new Forum();
		Cliente cliente = new Cliente();
		Advogado adv = new Advogado();
		
		while(rs.next()){
			proc.setCodProc(rs.getInt("codProc"));
			proc.setDtAbertura(rs.getString("dtAbertura"));
			proc.setDescricao(rs.getString("descricao"));
			proc.setSituacao(rs.getInt("situacao"));
			proc.setNroProcesso(rs.getString("nroProcesso"));
			
			tipo.setCodTipoProcesso(rs.getInt("codTipoProc"));
			proc.setTipo(tipo);
			
			forum.setCodForum(rs.getInt("codForum"));
			proc.setForum(forum);
			
			cliente.setCodCli(rs.getInt("codCli"));
			proc.setCliente(cliente);
			
			adv.setCodAdv(rs.getInt("codAdv"));
			proc.setAdvogado(adv);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		proc.setTipo(colTipo.retrieveTipoProcesso(proc.getTipo().getCodTipoProcesso()));
		
		ColForum colForum = new ColForum();
		proc.setForum(colForum.obterForum(proc.getForum().getCodForum()));
		
		ColCliente colCliente = new ColCliente();
		proc.setCliente(colCliente.obterClientePeloID(proc.getCliente().getCodCli()));
		
		ColAdvogado colAdv = new ColAdvogado();
		proc.setAdvogado(colAdv.obterAdvogado(proc.getAdvogado().getCodAdv()));
		
		return proc;
	}
	
	/**
	 * <h3><b>Retorna dados do processo</b></h3>
	 * @param codProc <code>C�digo do processo sem ser o numero</code>
	 * @return <code>Processo</code>
	 * @throws Exception
	 */
	public Processo retrieveProcessoOfNro(String nroProcesso) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM Processo WHERE nroProcesso = " + nroProcesso);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = new Processo();
		TipoProcesso tipo = new TipoProcesso();
		Forum forum = new Forum();
		Cliente cliente = new Cliente();
		Advogado adv = new Advogado();
		
		while(rs.next()){
			proc.setCodProc(rs.getInt("codProc"));
			proc.setDtAbertura(rs.getString("dtAbertura"));
			proc.setDescricao(rs.getString("descricao"));
			proc.setSituacao(rs.getInt("situacao"));
			proc.setNroProcesso(rs.getString("nroProcesso"));
			
			tipo.setCodTipoProcesso(rs.getInt("codTipoProc"));
			proc.setTipo(tipo);
			
			forum.setCodForum(rs.getInt("codForum"));
			proc.setForum(forum);
			
			cliente.setCodCli(rs.getInt("codCli"));
			proc.setCliente(cliente);
			
			adv.setCodAdv(rs.getInt("codAdv"));
			proc.setAdvogado(adv);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		proc.setTipo(colTipo.retrieveTipoProcesso(proc.getTipo().getCodTipoProcesso()));
		
		ColForum colForum = new ColForum();
		proc.setForum(colForum.obterForum(proc.getForum().getCodForum()));
		
		ColCliente colCliente = new ColCliente();
		proc.setCliente(colCliente.obterClientePeloID(proc.getCliente().getCodCli()));
		
		ColAdvogado colAdv = new ColAdvogado();
		proc.setAdvogado(colAdv.obterAdvogado(proc.getAdvogado().getCodAdv()));
		
		return proc;
	}
	
	
	/**
	 * <h3><b>Retorna todos os processos</b></h3>
	 * @return <code>List<Process></code>
	 * @throws Exception
	 */
	public List<Processo> retrieveAllProcesso() throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Processo> lista = new ArrayList<Processo>();
		
		sql.append("SELECT * FROM Processo");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = null;
		TipoProcesso tipo = null;
		Forum forum = null;
		Cliente cliente = null;
		Advogado adv = null;
		
		while(rs.next()){
			proc = new Processo();
			tipo = new TipoProcesso();
			forum = new Forum();
			cliente = new Cliente();
			adv = new Advogado();
			
			proc.setCodProc(rs.getInt("codProc"));
			proc.setDtAbertura(rs.getString("dtAbertura"));
			proc.setDescricao(rs.getString("descricao"));
			proc.setSituacao(rs.getInt("situacao"));
			proc.setNroProcesso(rs.getString("nroProcesso"));
			
			tipo.setCodTipoProcesso(rs.getInt("codTipoProc"));
			proc.setTipo(tipo);
			
			forum.setCodForum(rs.getInt("codForum"));
			proc.setForum(forum);
			
			cliente.setCodCli(rs.getInt("codCli"));
			proc.setCliente(cliente);
			
			adv.setCodAdv(rs.getInt("codAdv"));
			proc.setAdvogado(adv);
			
			lista.add(proc);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		
		for(Processo p : lista){
			p.setTipo(colTipo.retrieveTipoProcesso(p.getTipo().getCodTipoProcesso()));
		}
		
		return lista;
	}
	
	/**
	 * <h3><b>Retorna todos os processos de um advogado</b></h3>
	 * @param codAdv <code>C�digo do Advogado</code>
	 * @return <code>List<Processo></code>
	 * @throws Exception
	 */
	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv) throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Processo> lista = new ArrayList<Processo>();
		
		sql.append("SELECT * FROM Processo WHERE codAdv = "+codAdv);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = null;
		TipoProcesso tipo = null;
		Forum forum = null;
		Cliente cliente = null;
		Advogado adv = null;
		
		while(rs.next()){
			proc = new Processo();
			tipo = new TipoProcesso();
			forum = new Forum();
			cliente = new Cliente();
			adv = new Advogado();
			
			proc.setCodProc(rs.getInt("codProc"));
			proc.setDtAbertura(rs.getString("dtAbertura"));
			proc.setDescricao(rs.getString("descricao"));
			proc.setSituacao(rs.getInt("situacao"));
			proc.setNroProcesso(rs.getString("nroProcesso"));
			
			tipo.setCodTipoProcesso(rs.getInt("codTipoProc"));
			proc.setTipo(tipo);
			
			forum.setCodForum(rs.getInt("codForum"));
			proc.setForum(forum);
			
			cliente.setCodCli(rs.getInt("codCli"));
			proc.setCliente(cliente);
			
			adv.setCodAdv(rs.getInt("codAdv"));
			proc.setAdvogado(adv);
			
			lista.add(proc);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		
		for(Processo p : lista){
			p.setTipo(colTipo.retrieveTipoProcesso(p.getTipo().getCodTipoProcesso()));
		}
		
		return lista;
	}
	
	/**
	 * <h3><b>Retorna todos os processos de um cliente</b></h3>
	 * @param codCli <code>C�digo do cliente</code>
	 * @return <code>List<Processo></code>
	 * @throws Exception
	 */
	public List<Processo> retrieveAllProcessoCliente(Integer codCli) throws Exception{
		StringBuilder sql = new StringBuilder();
		List<Processo> lista = new ArrayList<Processo>();
		
		sql.append("SELECT * FROM Processo WHERE codCli = "+codCli);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Processo proc = null;
		TipoProcesso tipo = null;
		Forum forum = null;
		Cliente cliente = null;
		Advogado adv = null;
		
		while(rs.next()){
			proc = new Processo();
			tipo = new TipoProcesso();
			forum = new Forum();
			cliente = new Cliente();
			adv = new Advogado();
			
			proc.setCodProc(rs.getInt("codProc"));
			proc.setDtAbertura(rs.getString("dtAbertura"));
			proc.setDescricao(rs.getString("descricao"));
			proc.setSituacao(rs.getInt("situacao"));
			proc.setNroProcesso(rs.getString("nroProcesso"));
			
			tipo.setCodTipoProcesso(rs.getInt("codTipoProc"));
			proc.setTipo(tipo);
			
			forum.setCodForum(rs.getInt("codForum"));
			proc.setForum(forum);
			
			cliente.setCodCli(rs.getInt("codCli"));
			proc.setCliente(cliente);
			
			adv.setCodAdv(rs.getInt("codAdv"));
			proc.setAdvogado(adv);
			
			lista.add(proc);
		}
		
		ColTipoProcesso colTipo = new ColTipoProcesso();
		
		for(Processo p : lista){
			p.setTipo(colTipo.retrieveTipoProcesso(p.getTipo().getCodTipoProcesso()));
		}
		
		return lista;
	}
	
	public Processo updateProcesso(Processo newProc) throws Exception{
		
		Processo oldProc = retrieveProcesso(newProc.getCodProc());
		
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
				
				atualizarProcesso("situacao", newProc.getSituacao().toString(), newProc.getCodProc(),true);
				atualizarProcesso("descricao", newProc.getDescricao(), newProc.getCodProc(),false);
				
				return newProc;
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
	 * <h3><b>Altera dados de uma tabela</b></h3><br/>
	 * @param column <code>Coluna que ser� modificada</code><br/>
	 * @param newValue <code>Novo valor</code><br/>
	 * @param oldValue <code>Valor antigo</code><br/>
	 * @throws Exception 
	 */
	public void atualizarProcesso(String column,String newValue,Integer cod,boolean isInt) throws Exception{
		
		StringBuilder sql = new StringBuilder(); 
		if(isInt)
			sql.append("UPDATE Processo SET " + column + "=" + newValue + " WHERE codProc = " +cod);
		else
			sql.append("UPDATE Processo SET " + column + "='" + newValue + "' WHERE codProc = " +cod);
		
		DataBaseConnection.getInstance().execute(sql);
		
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
