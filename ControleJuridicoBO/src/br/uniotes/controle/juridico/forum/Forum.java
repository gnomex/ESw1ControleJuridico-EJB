package br.uniotes.controle.juridico.forum;

import br.unioeste.personBO.juridica.PessoaJuridica;


public class Forum extends PessoaJuridica{

	private static final long serialVersionUID = 1L;
	private int codForum;
	
	public int getCodForum() {
		return codForum;
	}
	
	public void setCodForum(int codForum) {
		this.codForum = codForum;
	}
	
}
