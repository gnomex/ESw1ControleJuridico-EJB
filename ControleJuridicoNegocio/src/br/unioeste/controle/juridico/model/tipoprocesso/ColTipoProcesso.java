package br.unioeste.controle.juridico.model.tipoprocesso;

import java.sql.ResultSet;

import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.exception.NoData;
import br.uniotes.controle.juridico.processo.TipoProcesso;

public class ColTipoProcesso {
	
	/**
	 * <h3><b>insere um novo tipo de processo (Penal, Civel)</b></h3>
	 * @param tipo
	 * @return
	 * @throws Exception
	 */
	public TipoProcesso insertTipoProcesso(TipoProcesso tipo) throws Exception{
		if(tipo.getTipo() == null && isTypeProcess(tipo.getTipo()) ){
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO TipoProcesso(tipo) VALUES ('" + tipo.getTipo() + "')");
			
			DataBaseConnection.getInstance().execute(sql);
			
			tipo.setCodTipoProcesso(getLastID());
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
		
		sql.append("SELECT MAX(codTipoProc) FROM TipoProcesso");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		while(rs.next()){
			id = rs.getInt(1);
		}
		
		return id;
	}
	/**
	 * <h3><b>Retorna dados do Tipo de processo</b></h3>
	 * @param codTipoProc
	 * @return
	 * @throws Exception
	 */
	public TipoProcesso retrieveTipoProcesso(Integer codTipoProc) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM TipoProcesso WHERE codTipoProc = " + codTipoProc + "");
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		TipoProcesso tipo = new TipoProcesso();
		
		while(rs.next()){
			tipo.setCodTipoProcesso(rs.getInt(1));
			tipo.setTipo(rs.getString(2));
		}
		
		return tipo;
	}
	
	private boolean isTypeProcess(String tipo){
		if(tipo.equals("Processo Civel")) return true;
		else if(tipo.equals("Processo Penal")) return true;
		else if(tipo.equals("Ação Trabalhista")) return true;
		else if(tipo.equals("Ação Tributária")) return true;
		else return false;
	}
}
