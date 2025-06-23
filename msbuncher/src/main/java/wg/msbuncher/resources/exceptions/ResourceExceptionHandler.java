package wg.msbuncher.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import wg.msbuncher.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		
		String error = "NOT FOUND";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
}
