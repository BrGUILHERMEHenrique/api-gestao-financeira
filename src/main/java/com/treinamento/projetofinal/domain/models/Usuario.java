package com.treinamento.projetofinal.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@Column(unique = true)
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private Double saldo = 0D;


	public Usuario() {
		super();
	}


	public Usuario(Long id, String nome, String email, String senha, Double saldo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.saldo = saldo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public Usuario verificaDadosNulos(Usuario usuarioAtualizado) {
		if(this.email != null) {
			usuarioAtualizado.email = this.email;
		}
		if(this.nome != null) {
			usuarioAtualizado.nome = this.nome;
		}
		if(this.senha != null) {
			usuarioAtualizado.senha = this.senha;
		}
		
		return usuarioAtualizado;
	}
	
	
}
