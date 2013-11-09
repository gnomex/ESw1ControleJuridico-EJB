package br.unioeste.personBO.fisica;

import br.unioeste.addressBO.Estado;


public class OrgaoExpedidor {

	private String nome;
	private Estado estado;
	
	public OrgaoExpedidor(){}

	public OrgaoExpedidor(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
