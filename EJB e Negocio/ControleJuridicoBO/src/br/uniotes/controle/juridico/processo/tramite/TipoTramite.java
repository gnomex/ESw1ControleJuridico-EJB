package br.uniotes.controle.juridico.processo.tramite;

import java.io.Serializable;

public class TipoTramite implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codTipoTramite;
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCodTipoTramite() {
		return codTipoTramite;
	}

	public void setCodTipoTramite(Integer codTipoTramite) {
		this.codTipoTramite = codTipoTramite;
	}
	
	
}
