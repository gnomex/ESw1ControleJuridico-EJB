package br.unioeste.controle.juridico.control.tipoprocesso;

import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.uniotes.controle.juridico.processo.TipoProcesso;

public class UCManterTipoProcessoManager {

	public TipoProcesso retrieveTipoProcesso(Integer codTipoProc) throws Exception{
		ColTipoProcesso colTipo = new ColTipoProcesso();
		return colTipo.retrieveTipoProcesso(codTipoProc);
	}
}
