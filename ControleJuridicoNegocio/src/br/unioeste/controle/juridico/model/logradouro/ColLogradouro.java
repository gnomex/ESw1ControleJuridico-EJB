package br.unioeste.controle.juridico.model.logradouro;

import java.sql.ResultSet;

import br.unioeste.addressBO.Logradouro;
import br.unioeste.addressBO.TipoLogradouro;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.model.tipologradouro.ColTipoLogradouro;

public class ColLogradouro {

	public Logradouro obterLogradouroPorID(Integer cod) throws Exception{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM Logradouro WHERE codLogr = " + cod);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		Logradouro log = new Logradouro();
		
		log.setId(rs.getInt(1));
		log.setNome(rs.getString(2));
		
		TipoLogradouro tipo = new TipoLogradouro();
		tipo.setId(rs.getInt(3));
		
		ColTipoLogradouro colTipo = new ColTipoLogradouro();
		
		log.setTipo(colTipo.obterTipoLogradouroPorID(tipo.getId()));
		
		return log;
	}
}
