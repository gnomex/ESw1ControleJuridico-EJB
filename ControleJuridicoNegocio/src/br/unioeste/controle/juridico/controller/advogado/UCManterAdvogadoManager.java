package br.unioeste.controle.juridico.controller.advogado;

import br.unioeste.controle.juridico.controller.IUCManterAdvogadoManager;
import br.unioeste.controle.juridico.model.advogado.ColAdvogado;
import br.uniotes.controle.juridico.advogado.Advogado;

public class UCManterAdvogadoManager implements IUCManterAdvogadoManager {

	private ColAdvogado colAdv = new ColAdvogado();
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.advogado.IUCManterAdvogadoManager#retrieveAdvogado(java.lang.Integer)
	 */
	@Override
	public Advogado retrieveAdvogado(Integer codigo) throws Exception{
		return colAdv.obterAdvogado(codigo);
	}
}

