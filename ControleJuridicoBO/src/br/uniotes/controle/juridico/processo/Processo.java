package br.uniotes.controle.juridico.processo;

import java.io.Serializable;

import br.uniotes.controle.juridico.advogado.Advogado;
import br.uniotes.controle.juridico.cliente.Cliente;
import br.uniotes.controle.juridico.forum.Forum;

public class Processo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codProc;
	private String nroProcesso;
	private String dtAbertura;
	private String descricao;
	private Forum forum;
	private Cliente cliente;
	private Advogado advogado;
	private Integer situacao;
	private TipoProcesso tipo;
	
	public String getNroProcesso() {
		return nroProcesso;
	}
	
	public void setNroProcesso(String nroProcesso) {
		this.nroProcesso = nroProcesso;
	}
	
	public String getDtAbertura() {
		return dtAbertura;
	}
	
	public void setDtAbertura(String dtAbertura) {
		this.dtAbertura = dtAbertura;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public TipoProcesso getTipo() {
		return tipo;
	}

	public void setTipo(TipoProcesso tipo) {
		this.tipo = tipo;
	}

	public Integer getCodProc() {
		return codProc;
	}

	public void setCodProc(Integer codProc) {
		this.codProc = codProc;
	}
	
}
