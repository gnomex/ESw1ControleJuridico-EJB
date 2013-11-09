package br.unioeste.controle.juridico.model.estado;

import java.sql.ResultSet;

import br.unioeste.addressBO.Estado;
import br.unioeste.controle.juridico.db.DataBaseConnection;

public class ColEstado {

	public Estado obterEstadoPorID(Integer cod) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Estado WHERE codEstado = " + cod);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		Estado estado = new Estado();
		
		estado.setId(rs.getInt(1));
		estado.setNome(rs.getString(2));
		estado.setUF(rs.getString(3));
		
		return estado;
	}

}
