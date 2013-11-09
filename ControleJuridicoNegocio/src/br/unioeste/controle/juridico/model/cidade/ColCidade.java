package br.unioeste.controle.juridico.model.cidade;

import java.sql.ResultSet;

import br.unioeste.addressBO.Cidade;
import br.unioeste.addressBO.Estado;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.model.estado.ColEstado;

public class ColCidade {

	public Cidade obterCidadePorID(Integer cod) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Cidade WHERE codCidade = " + cod);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		Cidade cidade = new Cidade();
		cidade.setId(rs.getInt(1));
		cidade.setNome(rs.getString(2));
		
		Estado est = new Estado();
		est.setId(rs.getInt(3));
		
		ColEstado colEstado = new ColEstado();
		
		cidade.setEstado(colEstado.obterEstadoPorID(est.getId()));
		
		return cidade;
	}
}
