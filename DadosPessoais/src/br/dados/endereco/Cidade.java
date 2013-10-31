package br.dados.endereco;

import java.io.Serializable;


public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer id;
	private Estado estado;
	
	public Cidade(){}
	
	public Cidade(String nome,Estado estado,Integer id){
		this.nome = nome;
		this.estado = estado;
		this.id = id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
