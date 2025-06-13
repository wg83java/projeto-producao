package wg.mspedido.services.exceptions;

public class ResourceNotFondException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFondException(Object id) {
		super("Recurso não encontrado id: " +id);
	}

}
