package com.treinamento.projetofinal.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.domain.enums.TipoEntrada;

@RestController
@RequestMapping({ "/tipoEntrada" })
public class TipoEntradaController {

	
	@GetMapping
	public TipoEntrada[] retornaDados() {
		return TipoEntrada.values();
	}
}
