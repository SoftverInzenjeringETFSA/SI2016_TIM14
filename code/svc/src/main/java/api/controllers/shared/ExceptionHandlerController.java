package api.controllers.shared;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import common.exception.EntityNotFoundException;
import common.exception.ExpiredAuthenticationException;
import common.exception.UnauthorizedException;
import models.dto.BaseResponse;
import models.enums.OperationResponseStatus;

/*
 * Controller used for handling previously unhandled exceptions
 * 
 */
@ControllerAdvice
public class ExceptionHandlerController {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { EntityNotFoundException.class })
	public void entityNotFoundException(Exception e) {

	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	@ExceptionHandler(value = { UnauthorizedException.class })
	public BaseResponse unauthorizedException(Exception e) {
		return new BaseResponse(OperationResponseStatus.UNAUTHORIZED);
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ResponseBody
	@ExceptionHandler(value = { ExpiredAuthenticationException.class })
	public BaseResponse expiredAuthenticationException(Exception e) {
		return new BaseResponse(OperationResponseStatus.TOKEN_EXPIRED);
	}
}
