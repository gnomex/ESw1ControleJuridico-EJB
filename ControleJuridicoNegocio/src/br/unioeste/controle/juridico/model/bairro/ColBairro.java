package br.unioeste.controle.juridico.model.bairro;

import java.sql.ResultSet;

import br.dados.endereco.Bairro;
import br.unioeste.controle.juridico.db.DataBaseConnection;

public class ColBairro {

	public Bairro obterBairroPorID(Integer cod) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Bairro WHERE codBairro = " + cod);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		Bairro bairro = new Bairro();
		
		bairro.setId(rs.getInt(1));
		bairro.setNome(rs.getString(2));
		
		return bairro;
	}
}
