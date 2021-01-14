package com.treinamento.projetofinal.domain.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.sun.istack.NotNull;
import com.treinamento.projetofinal.domain.enums.TipoGasto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="conta")
public class Conta implements Comparable<Conta>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private TipoGasto tipoGasto;
	
	@NotNull
	private Double preco;
	
	@NotNull
	private Date dataVencimento;
	
	@NotNull
	private Boolean paga = false;

	public Conta() {
		super();
	}

	public Conta(Long id, Usuario usuario, String descricao, TipoGasto tipoGasto, Double preco, Date dataVencimento,
			Boolean paga) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.preco = preco;
		this.dataVencimento = dataVencimento;
		this.paga = paga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Boolean getPaga() {
		return paga;
	}

	public void setPaga(Boolean paga) {
		this.paga = paga;
	}

	@Override
	public int compareTo(Conta o) {
		return this.dataVencimento.compareTo(o.getDataVencimento());
	}
	
	
	
}
