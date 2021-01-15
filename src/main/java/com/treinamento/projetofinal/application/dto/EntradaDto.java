package com.treinamento.projetofinal.application.dto;

public class EntradaDto {

	private Long usuario;
	private String descricao;
	private String tipoEntrada;
	private Double quantia;
	
	public EntradaDto() {
		super();
	}
	public EntradaDto(Long usuario, String descricao, String tipoEntrada, Double quantia) {
		super();
		this.usuario = usuario;
		this.descricao = descricao;
		this.tipoEntrada = tipoEntrada;
		this.quantia = quantia;
	}
	public Long getUsuario() {
		return usuario;
	}
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipoEntrada() {
		return tipoEntrada;
	}
	public void setTipoEntrada(String tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
	}
	public Double getQuantia() {
		return quantia;
	}
	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}
	
	
}
