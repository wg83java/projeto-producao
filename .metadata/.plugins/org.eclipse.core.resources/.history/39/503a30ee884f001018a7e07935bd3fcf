package wg.mscontrole.resources.exceptions;

import java.net.ConnectException;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import wg.mscontrole.services.exceptions.DataBaseException;
import wg.mscontrole.services.exceptions.ErroComunicacaoMicroservicoException;
import wg.mscontrole.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		
		String error = "NOT FOUND";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandarError> dabase(DataBaseException e,HttpServletRequest request){
		
		String error = "Erro conexao base de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandarError> recursoInsuficiente(IllegalArgumentException e,HttpServletRequest request){
		
		String error = "Quantidade insuficiente";
		HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<StandarError> erroComunicacaoMicroservico(ConnectException e,HttpServletRequest  request){
		
		String error = "Servico indisponivel temporariamente";
		HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

}
