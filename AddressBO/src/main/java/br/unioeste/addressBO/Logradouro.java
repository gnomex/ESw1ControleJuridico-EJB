package br.unioeste.addressBO;

import java.io.Serializable;

public class Logradouro implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer id;
	private TipoLogradouro tipo;
	
	public Logradouro(){}
	
	public Logradouro(String nome,TipoLogradouro tipo,Integer id){
		this.nome = nome;
		this.id = id;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoLogradouro getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogradouro tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
