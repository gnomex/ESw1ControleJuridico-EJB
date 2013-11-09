package br.unioeste.controle.juridico.model.endereco;

import java.sql.ResultSet;

import br.unioeste.addressBO.*;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.unioeste.controle.juridico.model.bairro.ColBairro;
import br.unioeste.controle.juridico.model.cidade.ColCidade;
import br.unioeste.controle.juridico.model.logradouro.ColLogradouro;

public class ColEndereco {
	
	public Endereco obterEnderecoPorCEP(String cep) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM Endereco WHERE cep = '" + cep + "'");
	
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		Endereco end = new Endereco();
		Logradouro log = new Logradouro();
		
		Bairro bairro = new Bairro();
		Cidade cidade = new Cidade();
		
		rs.next();
			
		log.setId(rs.getInt("codLogr"));
		end.setRua(log);
			
		bairro.setId(rs.getInt("codBairro"));
		end.setBairro(bairro);	
			
		cidade.setId(rs.getInt("codCidade"));
		end.setCidade(cidade);
			
		end.setCodEnd(rs.getInt("codEnd"));
		end.setCEP(cep);	
		
		ColLogradouro colLog = new ColLogradouro();
		end.setRua(colLog.obterLogradouroPorID(log.getId()));
		
		ColBairro colBairro = new ColBairro();
		end.setBairro(colBairro.obterBairroPorID(bairro.getId()));
		
		ColCidade colCid = new ColCidade();
		end.setCidade(colCid.obterCidadePorID(cidade.getId()));
		
		return end;
	}
	
	public Endereco obterEnderecoPorID(int id) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM Endereco WHERE codEnd = " + id);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		rs.next();
		
		Endereco end = new Endereco();
		Logradouro log = new Logradouro();
		
		Bairro bairro = new Bairro();
		Cidade cidade = new Cidade();

		log.setId(rs.getInt("codLogr"));
		end.setRua(log);

		bairro.setId(rs.getInt("codBairro"));
		end.setBairro(bairro);

		cidade.setId(rs.getInt("codCidade"));
		end.setCidade(cidade);

		end.setCodEnd(rs.getInt("codEnd"));
		end.setCEP(rs.getString("cep"));			
		
		ColLogradouro colLog = new ColLogradouro();
		end.setRua(colLog.obterLogradouroPorID(log.getId()));
		
		ColBairro colBairro = new ColBairro();
		end.setBairro(colBairro.obterBairroPorID(bairro.getId()));
		
		ColCidade colCid = new ColCidade();
		end.setCidade(colCid.obterCidadePorID(cidade.getId()));
		
		return end;
	}
	
}
