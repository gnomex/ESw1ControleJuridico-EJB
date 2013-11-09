package br.unioeste.personBO.fisica;

public class Genero {

	private Type tipo;
	private Integer id;

	public Type getTipo() {
		return tipo;
	}

	public void setTipo(Type tipo) {
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String toString()	{
		return this.tipo == Type.MALE ? "M" : "F";
	}
	
	static enum Type {
		MALE, FEMALE;
	}	
}
