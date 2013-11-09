package br.unioeste.controle.juridico.controller;

import br.uniotes.controle.juridico.cliente.Cliente;

public interface IUCManterClienteManager {

	public Cliente retrieveClient(Integer codigo) throws Exception;

}