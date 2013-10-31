package br.unioeste.controle.juridico.model.advogado;

import java.sql.ResultSet;

import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.uniotes.controle.juridico.advogado.Advogado;

public class ColAdvogado {

	/**
	 * <h3><b>Retorna dados do advogado</b></h3><br/>
	 * @param nome <code>Nome do cliente</code><br/>
	 * @return <code>Pessoa F�sica</code>
	 * @throws Exception 
	 */
	public Advogado obterAdvogado(Integer codigo) throws Exception{
				
		StringBuilder sql = new StringBuilder();
		Advogado adv = new Advogado();
		
		sql.append("SELECT * FROM advogado WHERE codAdv = "+codigo);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);

		rs.next();
		adv.setCodAdv(rs.getInt(1));
		adv.setNome(rs.getString("nome"));
		adv.setSobreNome(rs.getString("sobrenome"));
		adv.setCPF(rs.getString("cpf"));
		adv.setNroOAB(rs.getString("nroOAB"));		
		
		return adv;
	}
}
