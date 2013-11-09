package br.unioeste.controle.juridico.controller.tipoprocesso;

import br.unioeste.controle.juridico.controller.IUCManterTipoProcessoManager;
import br.unioeste.controle.juridico.model.tipoprocesso.ColTipoProcesso;
import br.uniotes.controle.juridico.processo.TipoProcesso;

public class UCManterTipoProcessoManager implements IUCManterTipoProcessoManager {

	private ColTipoProcesso colTipo = new ColTipoProcesso();

	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.tipoprocesso.IUCManterTipoProcessoManager#retrieveTipoProcesso(java.lang.Integer)
	 */
	@Override
	public TipoProcesso retrieveTipoProcesso(Integer codTipoProc) throws Exception{
		return colTipo.retrieveTipoProcesso(codTipoProc);
	}

	@Override
	public TipoProcesso insertTipoProcesso(TipoProcesso tipo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

