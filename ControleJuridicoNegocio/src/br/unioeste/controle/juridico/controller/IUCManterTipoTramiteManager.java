package br.unioeste.controle.juridico.controller;

import br.uniotes.controle.juridico.processo.tramite.TipoTramite;

public interface IUCManterTipoTramiteManager {

	public TipoTramite insertTipoTramite(TipoTramite tipo) throws Exception;

	public TipoTramite retrieveTipoTramite(Integer codTipoTramite)
			throws Exception;

}