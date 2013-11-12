package br.unioeste.controle.juridico.model.tipologradouro;

import java.sql.ResultSet;

import br.dados.endereco.TipoLogradouro;
import br.unioeste.controle.juridico.db.DataBaseConnection;

public class ColTipoLogradouro {

	public TipoLogradouro obterTipoLogradouroPorID(Integer cod) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TipoLogradouro WHERE codTipo = " + cod);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		TipoLogradouro tipo = new TipoLogradouro();
		tipo.setId(rs.getInt(1));
		tipo.setTipo(rs.getString(2));
		tipo.setDescricao(rs.getString(3));
		
		return tipo;
	}

}
