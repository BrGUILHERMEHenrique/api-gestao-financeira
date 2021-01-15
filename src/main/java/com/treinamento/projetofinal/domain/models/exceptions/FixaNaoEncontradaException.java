package com.treinamento.projetofinal.domain.models.exceptions;

public class FixaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 5068147868135533270L;

	private String msg = "Despesa Fixa não encontrada";

	
	public FixaNaoEncontradaException() {
		super();
	}


	public String getMsg() {
		return msg;
	}
	
	
}
