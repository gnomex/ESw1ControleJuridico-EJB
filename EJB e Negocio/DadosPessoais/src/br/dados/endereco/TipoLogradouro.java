package br.dados.endereco;

import java.io.Serializable;

public class TipoLogradouro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipo; //Av.
	private String descricao; //Avenida
	
	public TipoLogradouro(){}
	
	public TipoLogradouro(String tipo,String descricao,Integer id){
		this.descricao = descricao;
		this.tipo = tipo;
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
