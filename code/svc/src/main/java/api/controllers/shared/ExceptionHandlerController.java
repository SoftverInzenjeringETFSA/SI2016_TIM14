package api.controllers.shared;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import common.exception.EntityNotFoundException;

/*
 * Controller used for handling previously unhandled exceptions
 * 
 */
@ControllerAdvice
public class ExceptionHandlerController {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { EntityNotFoundException.class })
	public void entityNotFoundException(Exception e) {
		// TODO: log to db
	}
	
}
