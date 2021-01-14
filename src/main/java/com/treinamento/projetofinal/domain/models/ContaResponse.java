package com.treinamento.projetofinal.domain.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContaResponse {

	private Long id;
	private String descricao;
	private String tipo_gasto;
	private Double preco;
	private Date data_vencimento;
	private Boolean paga;
	
	
}
