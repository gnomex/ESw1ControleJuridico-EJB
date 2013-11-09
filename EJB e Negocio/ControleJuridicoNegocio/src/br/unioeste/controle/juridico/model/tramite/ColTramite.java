package br.unioeste.controle.juridico.model.tramite;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.com.text.validator.TextValidator;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.exception.NoData;
import br.unioeste.controle.juridico.model.tipotramite.ColTipoTramite;
import br.uniotes.controle.juridico.processo.Processo;
import br.uniotes.controle.juridico.processo.tramite.TramiteProcesso;
import br.uniotes.controle.juridico.processo.tramite.TipoTramite;

public class ColTramite {

	/**
	 * <h3><b>Insere dados de um Tramite e seu tipo</b></h3>
	 * @param tramite
	 * @return
	 * @throws Exception
	 */
	public TramiteProcesso insertTramiteProcesso(TramiteProcesso tramite) throws Exception{
		if(tramite.getProc().getCodProc() != null && TextValidator.getInstance().isString(tramite.getObservacoes()) &&
		   TextValidator.getInstance().isDate(tramite.getDtTramite())){
			
			StringBuilder sql = new StringBuilder();
			
			ColTipoTramite colTipo = new ColTipoTramite();
			tramite.setTipo(colTipo.insertTipoTramite(tramite.getTipo()));
			
			sql.append("INSERT INTO TramiteProcesso VALUES ("+tramite.getProc().getCodProc()+ ","
					+ tramite.getTipo().getCodTipoTramite() + ",'"
					+ tramite.getObservacoes() + "','"
					+ tramite.getDtTramite() + "')");
			
			DataBaseConnection.getInstance().execute(sql);
		}
		else
			throw new NoData("Sem dados ou dados invalidos", "Sem dados ou dados invalidos");
		return retrieveTramiteProcesso(tramite.getDtTramite());
	}
	/**
	 * <h3><b>Retorna dados de um tr�mite e seu tipo</b></h3>
	 * @param dataTramite
	 * @return
	 * @throws Exception
	 */
	public TramiteProcesso retrieveTramiteProcesso(String dataTramite) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM TramiteProcesso WHERE dtTramite = '"+ dataTramite + "'");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		TramiteProcesso tramite = new TramiteProcesso();
		TipoTramite tipo = new TipoTramite();
		Processo proc = new Processo();
		
		while(rs.next()){
			tramite.setDtTramite(rs.getString("dtTramite"));
			tramite.setObservacoes(rs.getString("observacoes"));
			
			proc.setCodProc(rs.getInt("codProc"));
			tipo.setCodTipoTramite(rs.getInt("codTipoTramite"));
			tramite.setProc(proc);
			tramite.setTipo(tipo);
		}
		
		ColTipoTramite colTipo = new ColTipoTramite();
		
		tramite.setTipo(colTipo.retrieveTipoTramite(tipo.getCodTipoTramite()));
		
		return tramite;
	}
	
	/**
	 * <h3><b>Retorna dados de um tr�mite e seu tipo</b></h3>
	 * @param dataTramite
	 * @return
	 * @throws Exception
	 */
	public List<TramiteProcesso> retrieveAll(Integer codProc) throws Exception{
		List<TramiteProcesso> lista = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM TramiteProcesso WHERE codProc = "+ codProc);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		TramiteProcesso tramite = null;
		TipoTramite tipo = null;
		Processo proc = null;
		
		while(rs.next()){
			tramite = new TramiteProcesso();
			tipo = new TipoTramite();
			proc = new Processo();
			
			tramite.setDtTramite(rs.getString("dtTramite"));
			tramite.setObservacoes(rs.getString("observacoes"));
			
			proc.setCodProc(rs.getInt("codProc"));
			tipo.setCodTipoTramite(rs.getInt("codTipoTramite"));
			tramite.setProc(proc);
			tramite.setTipo(tipo);
			
			lista.add(tramite);
		}
		
		ColTipoTramite colTipo = new ColTipoTramite();
		
		for(TramiteProcesso t : lista){
			t.setTipo(colTipo.retrieveTipoTramite(t.getTipo().getCodTipoTramite()));
		}
		
		return lista;
	}
}
