package br.unioeste.controle.juridico.controller.forum;

import br.unioeste.controle.juridico.controller.IUCManterForumManager;
import br.unioeste.controle.juridico.model.forum.ColForum;
import br.uniotes.controle.juridico.forum.Forum;

public class UCManterForumManager implements IUCManterForumManager {

	private ColForum colForum = new ColForum();
	
	/* (non-Javadoc)
	 * @see br.unioeste.controle.juridico.controller.forum.IUCManterForumManager#retrieveForum(int)
	 */
	@Override
	public Forum retrieveForum(int codForum) throws Exception{
		return colForum.retrieveForum(codForum);
	}
}
