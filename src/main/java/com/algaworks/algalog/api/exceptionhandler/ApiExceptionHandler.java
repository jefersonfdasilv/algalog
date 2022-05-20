package com.algaworks.algalog.api.exceptionhandler;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algalog.domain.exception.ClientDomainException;
import com.algaworks.algalog.domain.exception.DomainException;
import com.algaworks.algalog.domain.exception.EntityNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private MessageSource messageSource;
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		var error = new Error();
		error.setStatus(status.value());
		error.setTitle("Bad request");
		
		
		for ( ObjectError fieldError : ex.getBindingResult().getAllErrors()) {
			var name = ((FieldError) fieldError).getField();
			var message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			 error.addFild(name, message);
		}
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	@ExceptionHandler(ClientDomainException.class)
	public ResponseEntity<Object> handleClientDomainException(ClientDomainException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handleDomainException(ex, request, status);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return handleDomainException(ex, request, status);
	}
	
	@ExceptionHandler(DomainException.class)
	public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return handleDomainException(ex, request, status);
	}
	
	private ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request, HttpStatus status) {
		var error = new Error();
		error.setStatus(status.value());
		error.setTitle(ex.getMessage());
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}

	
}
