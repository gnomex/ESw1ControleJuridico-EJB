package br.unioeste.controle.juridico.controller;

import br.uniotes.controle.juridico.processo.TipoProcesso;


public interface IUCManterTipoProcessoManager {

	public TipoProcesso insertTipoProcesso(TipoProcesso tipo) throws Exception;

	public TipoProcesso retrieveTipoProcesso(Integer codTipoProc)
			throws Exception;

}