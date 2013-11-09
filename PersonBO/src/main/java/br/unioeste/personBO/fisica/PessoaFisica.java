package br.unioeste.personBO.fisica;

import br.unioeste.personBO.Pessoa;

public class PessoaFisica extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String sobreNome;
	private String CPF;
	private String email;
	private RG rg;
	private Sexo sexo;
	
	public PessoaFisica(){}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

}
