package com.treinamento.projetofinal.domain.models.exceptions;

public class ContaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = -4129267349386687436L;
	private String msg = "A conta indicada não foi encontrada";

	public ContaNaoEncontradaException() {
		super();
	}

	public String getMsg() {
		return msg;
	}
	
}
