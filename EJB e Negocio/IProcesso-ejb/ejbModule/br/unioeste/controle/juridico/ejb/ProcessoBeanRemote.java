package br.unioeste.controle.juridico.ejb;

import java.util.List;

import javax.ejb.Remote;

import br.uniotes.controle.juridico.processo.Processo;

@Remote
public interface ProcessoBeanRemote {

	Processo insertProcesso(Processo proc);
	Processo retrieveProcesso(Integer codProc);
	Processo retrieveProcessoOfNro(String nroProcesso);
	List<Processo> retrieveAllProcesso();
	List<Processo> retrieveAllProcessoAdvogado(Integer codAdv);
	List<Processo> retrieveAllProcessoCliente(Integer codCli);
	Processo updateProcesso(Processo newProc);
}
