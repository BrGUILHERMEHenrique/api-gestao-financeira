package com.treinamento.projetofinal.application.dto;

import java.util.Date;


public class ContaDto {

	private String descricao;
	private Long usuario;
	private Date dataVencimento;
	private String tipoGasto;
	private Double preco;
	
	public ContaDto() {
		super();
	}
	public ContaDto(String descricao, Long usuario, Date dataExpiracao, String tipoGasto, Double preco) {
		super();
		this.descricao = descricao;
		this.usuario = usuario;
		this.dataVencimento = dataExpiracao;
		this.tipoGasto = tipoGasto;
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
