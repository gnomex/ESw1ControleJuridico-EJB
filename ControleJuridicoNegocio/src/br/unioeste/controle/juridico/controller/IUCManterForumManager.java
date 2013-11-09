package br.unioeste.controle.juridico.controller;

import br.uniotes.controle.juridico.forum.Forum;

public interface IUCManterForumManager {

	public Forum retrieveForum(int codForum) throws Exception;

}