package com.treinamento.projetofinal.application.dto;

import java.io.Serializable;

public class UsuarioDtoLogin implements Serializable{

	private static final long serialVersionUID = 4693465232734594426L;

	private String email;
	private String senha;
	
	
	public UsuarioDtoLogin() {
		super();
	}
	public UsuarioDtoLogin(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
