package br.com.zup.academy.jefferson.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidatorError extends StandardError{

	private List<FieldMessageError> listError = new ArrayList<>();
	
	public ValidatorError(LocalDateTime timesTamp, Integer status, String error, String message, String path) {
		super(timesTamp, status, error, message, path);
	}
	
	public void addError(String fieldMessage, String defaultMessage) {
		listError.add(new FieldMessageError(fieldMessage, defaultMessage));
	}
	
	public List<FieldMessageError> getListError() {
		return listError;
	}
}