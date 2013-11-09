package br.unioeste.controle.juridico.ejb;

import javax.ejb.Remote;

import br.uniotes.controle.juridico.advogado.Advogado;

@Remote
public interface AdvogadoBeanRemote {

	Advogado obterAdvogado(Integer codigo);
}
