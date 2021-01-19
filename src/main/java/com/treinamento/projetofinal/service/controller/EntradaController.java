package com.treinamento.projetofinal.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.application.dto.EntradaDto;
import com.treinamento.projetofinal.domain.models.Entrada;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.service.service.EntradaService;

@RestController
@RequestMapping({ "/entradas" })
public class EntradaController {

	@Autowired
	private EntradaService entradaService;
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<Entrada>> retornaPorUsuario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(entradaService.retornarListaPorUsuario(idUsuario));
	}
	
	@GetMapping("/entrada/{id}")
	public ResponseEntity<Entrada> retornaPorId(@PathVariable Long id) throws NotFound{
		return ResponseEntity.ok(entradaService.retornaPorId(id));
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Entrada> criaNovaEntrada(@RequestBody EntradaDto dto) throws NotFound{
		return ResponseEntity.ok(entradaService.adicionarEntrada(dto));
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarDescricaoEntrada(@PathVariable Long id, @RequestBody EntradaDto dto) throws NotFound {
		return ResponseEntity.ok(entradaService.atualizarEntrada(id, dto));
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<String> apagaUmaEntrada(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(entradaService.apagarEntrada(id));
	}
}
