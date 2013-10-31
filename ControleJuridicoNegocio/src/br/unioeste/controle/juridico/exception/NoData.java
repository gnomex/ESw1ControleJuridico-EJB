package br.unioeste.controle.juridico.exception;

public class NoData extends Exception{

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public NoData(String msg,String cause){
		super(msg, new Exception(cause));
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
	
}
