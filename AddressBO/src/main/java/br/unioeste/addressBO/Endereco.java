package br.unioeste.addressBO;

import java.io.Serializable;

public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codEnd;
	private Logradouro rua;
	private Bairro bairro;
	private Cidade cidade;
	private String CEP;
	
	public Endereco(){}

	public Logradouro getRua() {
		return rua;
	}

	public void setRua(Logradouro rua) {
		this.rua = rua;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public Integer getCodEnd() {
		return codEnd;
	}

	public void setCodEnd(Integer codEnd) {
		this.codEnd = codEnd;
	}
	
	
}
