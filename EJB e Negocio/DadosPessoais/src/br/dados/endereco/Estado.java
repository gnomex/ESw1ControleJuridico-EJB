package br.dados.endereco;

import java.io.Serializable;

public class Estado implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer id;
	private String UF;
	
	public Estado(String nome,String UF,Integer id){
		this.nome = nome;
		this.UF = UF;
		this.id = id;
	}
	
	public Estado(){}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
