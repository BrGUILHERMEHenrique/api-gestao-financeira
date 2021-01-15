package com.treinamento.projetofinal.domain.models.exceptions;

public class NotFound extends Exception {

	private static final long serialVersionUID = -2409865470699775950L;
	
	private String msg;
	
	public NotFound(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
