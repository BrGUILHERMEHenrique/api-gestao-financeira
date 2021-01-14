package com.treinamento.projetofinal.domain.models.exceptions;

public class UsuarioNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String msg = "O usuário não foi encontrado no nosso banco de dados";
	
	

	public UsuarioNaoEncontradoException() {
		super();
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
