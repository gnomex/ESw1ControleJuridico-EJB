package br.unioeste.address.service;

import java.util.List;

import br.unioeste.addressBO.CEP;
import br.unioeste.addressBO.Endereco;

public interface AddressService {

	public List<Endereco> getAddressByCEP(CEP cep);
	
	public Endereco getAddressByID(Integer id);
	
}
