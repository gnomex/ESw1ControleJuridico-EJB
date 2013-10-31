package util.com.exception;

public class FaltaDados extends Exception{
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public FaltaDados(String msg,String cause){
		super(msg, new Exception(cause));
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
}
