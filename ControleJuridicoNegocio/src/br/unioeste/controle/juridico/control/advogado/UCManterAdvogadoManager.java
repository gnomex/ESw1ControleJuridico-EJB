package br.unioeste.controle.juridico.control.advogado;

import br.unioeste.controle.juridico.model.advogado.ColAdvogado;
import br.uniotes.controle.juridico.advogado.Advogado;

public class UCManterAdvogadoManager {

	public Advogado obterAdvogado(Integer codigo) throws Exception{
		
		ColAdvogado colAdv = new ColAdvogado();
		Advogado adv = colAdv.obterAdvogado(codigo);
		
		return adv;
	}
}
