package br.unioeste.controle.juridico.control.cliente;

import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.uniotes.controle.juridico.cliente.Cliente;

public class UCManterClienteManager {

	public Cliente obterClientePeloID(Integer codigo) throws Exception{
		ColCliente colCli = new ColCliente();
		return colCli.obterClientePeloID(codigo);
	}
}
