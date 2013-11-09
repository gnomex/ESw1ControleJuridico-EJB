package br.unioeste.controle.juridico.controller.cliente;

import br.unioeste.controle.juridico.controller.IUCManterClienteManager;
import br.unioeste.controle.juridico.model.cliente.ColCliente;
import br.uniotes.controle.juridico.cliente.Cliente;

public class UCManterClienteManager implements IUCManterClienteManager {

	private ColCliente colCli = new ColCliente();
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.cliente.IUCManterClienteManager#retrieveClient(java.lang.Integer)
	 */
	@Override
	public Cliente retrieveClient(Integer codigo) throws Exception{
		return colCli.retrieveClient(codigo);
	}
}