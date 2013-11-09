package br.unioeste.controle.juridico.controller;

import br.uniotes.controle.juridico.advogado.Advogado;

public interface IUCManterAdvogadoManager {

	public Advogado retrieveAdvogado(Integer codigo) throws Exception;

}