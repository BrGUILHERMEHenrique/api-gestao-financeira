package com.treinamento.projetofinal.domain.models.exceptions;

public class RetiradaNaoEncontradaException extends Exception {

	private static final long serialVersionUID = 2077397779939886648L;

	private String msg = "A retirada indicada não foi encontrada";

	public RetiradaNaoEncontradaException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
