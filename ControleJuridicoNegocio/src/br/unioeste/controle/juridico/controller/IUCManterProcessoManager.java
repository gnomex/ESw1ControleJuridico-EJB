package br.unioeste.controle.juridico.controller;

import java.util.List;

import br.uniotes.controle.juridico.processo.Processo;

public interface IUCManterProcessoManager {

	/**
	 * <h3><b>Insere processo</b></h3><br/>
	 * @param proc <code>Processo</code><br/>
	 * @return <code>Processo</code>
	 * @throws Exception
	 */
	public Processo insertProcesso(Processo proc) throws Exception;

	public Processo retrieveProcesso(Integer codProc) throws Exception;

	public List<Processo> retrieveAllProcesso() throws Exception;

	public Processo retrieveProcessoOfNro(String nroProcesso) throws Exception;

	public List<Processo> retrieveAllProcessoAdvogado(Integer codAdv)
			throws Exception;

	public List<Processo> retrieveAllProcessoCliente(Integer codCli)
			throws Exception;

	public Processo updateProcesso(Processo newProc, Processo oldProc)
			throws Exception;

}