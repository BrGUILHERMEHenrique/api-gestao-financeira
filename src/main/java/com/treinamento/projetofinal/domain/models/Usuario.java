package com.treinamento.projetofinal.domain.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "usuario")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private Double saldo = 0D;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private Set<Conta> contas;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private Set<Entrada> entradas;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private Set<Fixa> despesasFixas;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private Set<Investimento> investimentos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private Set<Retirada> retiradas;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario", orphanRemoval = true)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	private Set<Variavel> despesasVariaveis;

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contas == null) ? 0 : contas.hashCode());
		result = prime * result + ((despesasFixas == null) ? 0 : despesasFixas.hashCode());
		result = prime * result + ((despesasVariaveis == null) ? 0 : despesasVariaveis.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((entradas == null) ? 0 : entradas.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((investimentos == null) ? 0 : investimentos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((retiradas == null) ? 0 : retiradas.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contas == null) {
			if (other.contas != null)
				return false;
		} else if (!contas.equals(other.contas))
			return false;
		if (despesasFixas == null) {
			if (other.despesasFixas != null)
				return false;
		} else if (!despesasFixas.equals(other.despesasFixas))
			return false;
		if (despesasVariaveis == null) {
			if (other.despesasVariaveis != null)
				return false;
		} else if (!despesasVariaveis.equals(other.despesasVariaveis))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (entradas == null) {
			if (other.entradas != null)
				return false;
		} else if (!entradas.equals(other.entradas))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (investimentos == null) {
			if (other.investimentos != null)
				return false;
		} else if (!investimentos.equals(other.investimentos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (retiradas == null) {
			if (other.retiradas != null)
				return false;
		} else if (!retiradas.equals(other.retiradas))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	
	
}
