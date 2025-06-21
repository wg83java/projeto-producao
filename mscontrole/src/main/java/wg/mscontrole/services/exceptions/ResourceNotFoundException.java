package wg.mscontrole.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String nameproduto) {
		super("Recurso não encontrado name produto: " +nameproduto);
	}

}
