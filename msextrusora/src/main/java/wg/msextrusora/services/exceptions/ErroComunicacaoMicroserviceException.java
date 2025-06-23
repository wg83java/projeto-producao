package wg.msextrusora.services.exceptions;

import lombok.Getter;

public class ErroComunicacaoMicroserviceException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int status;
	
	public ErroComunicacaoMicroserviceException(String msg,int status) {
		super(msg);
		this.status = status;
		
	}

}
