package br.unioeste.controle.juridico.model.tipotramite;

import java.sql.ResultSet;

import util.com.text.validator.TextValidator;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.exception.NoData;
import br.uniotes.controle.juridico.processo.tramite.TipoTramite;

public class ColTipoTramite {	
	/**
	 * <h3><b>Insere dados do tipo de tr�mite</b></h3>
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	public TipoTramite insertTipoTramite(TipoTramite tipo) throws Exception{
		if(TextValidator.getInstance().isString(tipo.getTipo())){
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO TipoTramite(tipo) VALUES ('" + tipo.getTipo() + "')");
			
			DataBaseConnection.getInstance().execute(sql);
			
			tipo.setCodTipoTramite(getLastID());
			
		}
		else
			throw new NoData("Sem dados ou dados invalidos", "Sem dados ou dados invalidos");
		return tipo;
	}
	
	/**
	 * <h3><b>Apenas verifica o c�digo da ultima inser��o</b></h3><br/>
	 * @return <code>C�digo do ultimo registro</code>
	 * @throws Exception 
	 */
	private int getLastID() throws Exception{
		
		StringBuilder sql = new StringBuilder();
		int id = 0;
		
		sql.append("SELECT MAX(codTipoTramite) FROM TipoTramite");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		while(rs.next()){
			id = rs.getInt(1);
		}
		
		return id;
	}
	/**
	 * <h3><b>Retorna dados do Tipo de tr�mite</b></h3>
	 * @param codTipoTramite
	 * @return
	 * @throws Exception
	 */
	public TipoTramite retrieveTipoTramite(Integer codTipoTramite) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM TipoTramite WHERE codTipoTramite = " + codTipoTramite + "");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		TipoTramite tipo = new TipoTramite();
		
		rs.next();
		tipo.setCodTipoTramite(rs.getInt(1));
		tipo.setTipo(rs.getString(2));
		
		
		return tipo;
	}
}
