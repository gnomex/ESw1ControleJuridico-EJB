package br.uniotes.controle.juridico.cliente;

import java.io.Serializable;

import br.dados.pessoa.Pessoa;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codCli;
	private Pessoa pessoa;
	
	public Cliente(){}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	
}
