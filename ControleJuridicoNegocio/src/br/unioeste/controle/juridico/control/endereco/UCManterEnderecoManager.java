package br.unioeste.controle.juridico.control.endereco;

import br.dados.endereco.Endereco;
import br.unioeste.controle.juridico.model.endereco.ColEndereco;

public class UCManterEnderecoManager {

	public Endereco obterEnderecoPorCEP(String cep) throws Exception{
		ColEndereco colEnd = new ColEndereco();
		return colEnd.obterEnderecoPorCEP(cep);
	}
	
	public Endereco obterEnderecoPorID(int id) throws Exception{
		
		ColEndereco colEnd = new ColEndereco();
		return colEnd.obterEnderecoPorID(id);
	}
}
