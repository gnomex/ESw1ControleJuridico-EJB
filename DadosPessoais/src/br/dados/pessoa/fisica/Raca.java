package br.dados.pessoa.fisica;

public class Raca {

	private String tipo;
	private Integer id;
	
	public Raca(Integer id,String tipo){
		this.tipo = tipo;
		this.id = id;
	}
	
	public Raca(){}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
