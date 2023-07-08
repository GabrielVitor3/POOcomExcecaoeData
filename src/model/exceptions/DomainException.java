package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	//para para o construtor,para permitir que posso instanciar minha exceção personalizada 
	public DomainException(String msg) {
		super(msg);
	}

}
