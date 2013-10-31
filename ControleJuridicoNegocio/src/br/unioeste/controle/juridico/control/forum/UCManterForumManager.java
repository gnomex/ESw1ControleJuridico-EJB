package br.unioeste.controle.juridico.control.forum;

import br.unioeste.controle.juridico.model.forum.ColForum;
import br.uniotes.controle.juridico.forum.Forum;

public class UCManterForumManager {

	public Forum obterForum(int codForum) throws Exception{
		ColForum colForum = new ColForum();
		return colForum.obterForum(codForum);
	}
}
