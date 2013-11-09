package br.uniotes.controle.juridico.advogado;

import br.dados.pessoa.fisica.PessoaFisica;

public class Advogado extends PessoaFisica{

	private static final long serialVersionUID = 1L;
	private int codAdv;
	private String nroOAB;

	public String getNroOAB() {
		return nroOAB;
	}

	public void setNroOAB(String nroOAB) {
		this.nroOAB = nroOAB;
	}

	public int getCodAdv() {
		return codAdv;
	}

	public void setCodAdv(int codAdv) {
		this.codAdv = codAdv;
	}
	
}
