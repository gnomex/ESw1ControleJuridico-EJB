package br.unioeste.controle.juridico.model.forum;

import java.sql.ResultSet;

import br.dados.endereco.Endereco;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.uniotes.controle.juridico.forum.Forum;

public class ColForum {

	/**
	 * <h3><b>Retorna dados do Forum</b></h3>
	 * @param codForum c�digo do forum
	 * @return Forum
	 * @throws Exception
	 */
	public Forum obterForum(int codForum) throws Exception{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM Forum WHERE codForum = " + codForum);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		Forum forum = new Forum();
		
		rs.next();
			
		forum.setCodForum(rs.getInt("codForum"));
		forum.setNome(rs.getString("nome"));
		forum.setNomeFantasia(rs.getString("nomeFantasia"));
		forum.setCNPJ(rs.getString("cnpj"));
		Endereco end = new Endereco();
		end.setCodEnd(rs.getInt("codEnd"));
		forum.setEnd(end);
		
		DataBaseConnection.getInstance().commit();
		
		return forum;
	}
}
