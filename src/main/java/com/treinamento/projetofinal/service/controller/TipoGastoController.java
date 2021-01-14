package com.treinamento.projetofinal.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.domain.enums.TipoGasto;

@RestController
@RequestMapping({ "/tipo" })
public class TipoGastoController {

	@GetMapping
	@ResponseBody
	public TipoGasto[] retornaTodosOsTipoGasto() {
		return TipoGasto.values();
	}
}
