package br.dados.pessoa.fisica;

public class RG {

	private String numero;
	private OrgaoExpedidor orgao;
	
	public RG(){}
	
	public RG(String numero,OrgaoExpedidor orgao){
		this.numero = numero;
		this.orgao = orgao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public OrgaoExpedidor getOrgao() {
		return orgao;
	}

	public void setOrgao(OrgaoExpedidor orgao) {
		this.orgao = orgao;
	}
	
	
}
