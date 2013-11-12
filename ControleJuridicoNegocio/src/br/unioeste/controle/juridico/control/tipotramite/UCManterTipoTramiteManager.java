package br.unioeste.controle.juridico.control.tipotramite;

import br.unioeste.controle.juridico.model.tipotramite.ColTipoTramite;
import br.uniotes.controle.juridico.processo.tramite.TipoTramite;

public class UCManterTipoTramiteManager {

	public TipoTramite insertTipoTramite(TipoTramite tipo) throws Exception{
		ColTipoTramite colTipo = new ColTipoTramite();
		return colTipo.insertTipoTramite(tipo);
	}
	
	public TipoTramite retrieveTipoTramite(Integer codTipoTramite) throws Exception{
		ColTipoTramite colTipo = new ColTipoTramite();
		return colTipo.retrieveTipoTramite(codTipoTramite);
	}
}
