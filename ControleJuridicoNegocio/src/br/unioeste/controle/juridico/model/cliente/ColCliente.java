package br.unioeste.controle.juridico.model.cliente;

import java.sql.ResultSet;

import br.dados.endereco.Endereco;
import br.dados.pessoa.fisica.PessoaFisica;
import br.dados.pessoa.juridica.PessoaJuridica;
import br.unioeste.controle.juridico.db.DataBaseConnection;
import br.uniotes.controle.juridico.cliente.Cliente;

public class ColCliente {

	/**
	 * <h3><b>Retorna dados de um cliente - Pessoa F�sica ou Jur�dica</b></h3><br/>
	 * @param nome <code>Nome do cliente</code><br/>
	 * @return <code>Pessoa F�sica</code>
	 * @throws Exception 
	 */
	public Cliente obterClientePeloID(Integer codigo) throws Exception{
				
		StringBuilder sql = new StringBuilder();
		Cliente cli = null;
		
		sql.append("SELECT * FROM Cliente WHERE codCli = "+codigo);
		
		ResultSet rs = DataBaseConnection.getInstance().executeSQL(sql);
		
		cli = new Cliente();


		rs.next();

		if (rs.getString("cpf") != null) {
			PessoaFisica pessoa = new PessoaFisica();

			pessoa.setNome(rs.getString("nome"));
			pessoa.setSobreNome(rs.getString("sobrenome"));
			pessoa.setCPF(rs.getString("cpf"));
			Endereco end = new Endereco();
			end.setCodEnd(rs.getInt("codEnd"));
			pessoa.setEnd(end);
			cli.setCodCli(rs.getInt("codCli"));

			cli.setPessoa(pessoa);
		} else {
			PessoaJuridica pessoa = new PessoaJuridica();

			pessoa.setNome(rs.getString("nome"));
			pessoa.setNomeFantasia(rs.getString("sobrenome"));
			pessoa.setCNPJ(rs.getString("cnpj"));
			Endereco end = new Endereco();
			end.setCodEnd(rs.getInt("codEnd"));
			pessoa.setEnd(end);
			
			cli.setCodCli(rs.getInt("codCli"));

			cli.setPessoa(pessoa);
		}
		
		DataBaseConnection.getInstance().commit();
		
		return cli;
	}
	
}
