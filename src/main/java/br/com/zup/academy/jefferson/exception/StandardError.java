package br.com.zup.academy.jefferson.exception;

import java.time.LocalDateTime;

public class StandardError {

	private LocalDateTime timesTamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError(LocalDateTime timesTamp, Integer status, String error, String message, String path) {
		this.timesTamp = timesTamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

	public Integer getStatus() {
		return status;
	}

	public LocalDateTime getTimesTamp() {
		return timesTamp;
	}

}