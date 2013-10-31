package br.uniotes.controle.juridico.processo.tramite;

import java.io.Serializable;

import br.uniotes.controle.juridico.processo.Processo;

public class TramiteProcesso implements Serializable{

	private static final long serialVersionUID = 1L;
	private Processo proc;
	private String observacoes;
	private String dtTramite;
	private TipoTramite tipo;
	
	public String getObservacoes() {
		return observacoes;
	}
	
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getDtTramite() {
		return dtTramite;
	}
	
	public void setDtTramite(String dtTramite) {
		this.dtTramite = dtTramite;
	}
	
	public TipoTramite getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoTramite tipo) {
		this.tipo = tipo;
	}

	public Processo getProc() {
		return proc;
	}

	public void setProc(Processo proc) {
		this.proc = proc;
	}
	
	
}
