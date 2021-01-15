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

import com.treinamento.projetofinal.application.dto.VariavelRequest;
import com.treinamento.projetofinal.domain.models.Variavel;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.service.service.VariavelService;

@RestController
@RequestMapping({ "/variaveis" })
public class VariavelController {

	@Autowired
	private VariavelService variavelService;
	
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<List<Variavel>> retornarListaPorUsuario(@PathVariable Long idUsuario) {
		return ResponseEntity.ok(variavelService.retornaListaPorUsuario(idUsuario));
	}
	@GetMapping("variavel/{id}")
	public ResponseEntity<Variavel> retornaPorId(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(variavelService.retornaPorid(id));
	}
	@PostMapping("/criar")
	public ResponseEntity<Variavel> adicionarVariavel(@RequestBody VariavelRequest req) throws UsuarioNaoEncontradoException {
		return ResponseEntity.ok(variavelService.adicionarVariavel(req));
	}
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<String> atualizarVariavel(@PathVariable Long id, @RequestBody VariavelRequest req) throws NotFound {
		return ResponseEntity.ok(variavelService.atualizarVariavel(id, req));
	}
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<String> apagarVariavel(@PathVariable Long id) throws NotFound {
		return ResponseEntity.ok(variavelService.apagarVariavel(id));
	}
}
