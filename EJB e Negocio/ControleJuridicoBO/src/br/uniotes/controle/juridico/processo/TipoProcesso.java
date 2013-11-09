package br.uniotes.controle.juridico.processo;

import java.io.Serializable;

public class TipoProcesso implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codTipoProcesso;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCodTipoProcesso() {
		return codTipoProcesso;
	}

	public void setCodTipoProcesso(Integer codTipoProcesso) {
		this.codTipoProcesso = codTipoProcesso;
	}
	
	
}
