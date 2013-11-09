package br.unioeste.controle.juridico.control.endereco;

import br.unioeste.addressBO.Endereco;
import br.unioeste.controle.juridico.model.endereco.ColEndereco;

public class UCManterEnderecoManager {

	public Endereco obterEnderecoPorCEP(String cep) throws Exception{
		ColEndereco colEnd = new ColEndereco();
		return colEnd.obterEnderecoPorCEP(cep);
		//New way: AddressService.getAddressByCEP( .... ;
	}
	
	public Endereco obterEnderecoPorID(int id) throws Exception{
		ColEndereco colEnd = new ColEndereco();
		return colEnd.obterEnderecoPorID(id);
		// New way: AddressService.getAddressByID( .... ;
	}
}
