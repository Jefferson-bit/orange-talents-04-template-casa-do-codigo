package br.com.zup.academy.jefferson.exception;

public class FieldMessageError {

	private String fieldMessage;
	private String defaultMessage;

	public FieldMessageError(String fieldMessage, String defaultMessage) {
		this.fieldMessage = fieldMessage;
		this.defaultMessage = defaultMessage;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}
}
