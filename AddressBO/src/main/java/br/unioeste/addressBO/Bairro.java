package br.unioeste.addressBO;

import java.io.Serializable;


public class Bairro implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer id;
	
	public Bairro(){}

	public Bairro(String nome, Integer id){
		this.nome = nome;
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
