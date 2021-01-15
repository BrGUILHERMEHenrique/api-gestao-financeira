package com.treinamento.projetofinal.domain.models.exceptions;

public class EntradaNaoEncontradaException extends Exception {


	private static final long serialVersionUID = 1343343066219515700L;

	private String msg = "Entrada indicada não foi encontrada";

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public EntradaNaoEncontradaException() {
		super();
	}
	
	
}
