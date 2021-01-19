package com.treinamento.projetofinal.domain.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="investimento")
public class Investimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", updatable = true, nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;
	
	@Column(nullable = false)
	private Double valorRetirada;
	
	@Column(nullable = false)
	private Double lucroAtual = 0D;

	
	public Investimento() {
		super();
	}

	public Investimento(Long id, String descricao, Usuario usuario, Double valorRetirada, Double lucroAtual) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.usuario = usuario;
		this.valorRetirada = valorRetirada;
		this.lucroAtual = lucroAtual;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getValorRetirada() {
		return valorRetirada;
	}

	public void setValorRetirada(Double valorRetirada) {
		this.valorRetirada = valorRetirada;
	}

	public Double getLucroAtual() {
		return lucroAtual;
	}

	public void setLucroAtual(Double lucroAtual) {
		this.lucroAtual = lucroAtual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lucroAtual == null) ? 0 : lucroAtual.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((valorRetirada == null) ? 0 : valorRetirada.hashCode());
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
		Investimento other = (Investimento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lucroAtual == null) {
			if (other.lucroAtual != null)
				return false;
		} else if (!lucroAtual.equals(other.lucroAtual))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valorRetirada == null) {
			if (other.valorRetirada != null)
				return false;
		} else if (!valorRetirada.equals(other.valorRetirada))
			return false;
		return true;
	}
	
	
	
}
