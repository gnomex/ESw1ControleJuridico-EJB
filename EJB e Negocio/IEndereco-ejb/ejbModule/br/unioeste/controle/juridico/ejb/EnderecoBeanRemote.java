package br.unioeste.controle.juridico.ejb;

import javax.ejb.Remote;

import br.dados.endereco.Endereco;

@Remote
public interface EnderecoBeanRemote {

	Endereco obterEnderecoPorCEP(String cep);
	Endereco obterEnderecoPorID(int id);
}
