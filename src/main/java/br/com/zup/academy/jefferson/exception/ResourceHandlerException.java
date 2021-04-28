package br.com.zup.academy.jefferson.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceHandlerException {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidatorError> validatoError(MethodArgumentNotValidException ex,
			HttpServletRequest request) {
		ValidatorError validatorError = new ValidatorError(LocalDateTime.now(), 
		HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage(), "Error Validator", request.getRequestURI());
		for (FieldError e  : ex.getBindingResult().getFieldErrors()) {
			String defaultMessage = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			validatorError.addError(e.getField(), defaultMessage);
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validatorError);
	}	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> notFound(ResourceNotFoundException ex,
			HttpServletRequest request) {
		StandardError validatorError = new StandardError(LocalDateTime.now(), 
		HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Resource not found", request.getRequestURI());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validatorError);
	}	
}
