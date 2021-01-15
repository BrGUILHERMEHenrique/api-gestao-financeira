package com.treinamento.projetofinal.application.dto;


public class InvestimentoRequest {

	private String descricao;
	private Long usuario;
	private Double valorRetirada;
	private Double lucroAtual = 0D;
	public InvestimentoRequest(String descricao, Long usuario, Double valorRetirada, Double lucroAtual) {
		super();
		this.descricao = descricao;
		this.usuario = usuario;
		this.valorRetirada = valorRetirada;
		this.lucroAtual = lucroAtual;
	}
	public InvestimentoRequest() {
		super();
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
	
	
}
