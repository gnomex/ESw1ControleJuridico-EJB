package br.dados.pessoa;

import java.io.Serializable;

import br.dados.endereco.Endereco;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	private int nro;
	private String complemento;
	private Endereco end;
	private String telefone;
	private String nome;
	private String email;
	
	public Pessoa(){}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	
}
