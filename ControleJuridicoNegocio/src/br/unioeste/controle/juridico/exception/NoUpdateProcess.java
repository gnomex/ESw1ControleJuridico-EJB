package br.unioeste.controle.juridico.exception;

public class NoUpdateProcess extends Exception{

	private static final long serialVersionUID = 1L;
	private String msg;
	
	public NoUpdateProcess(String msg,String cause){
		super(msg, new Exception(cause));
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
}
