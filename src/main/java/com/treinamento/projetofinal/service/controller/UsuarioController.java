package com.treinamento.projetofinal.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.projetofinal.application.dto.UsuarioDto;
import com.treinamento.projetofinal.domain.models.Usuario;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.service.service.UsuarioService;

@RestController
@RequestMapping({ "/usuarios" })
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/criar")
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody UsuarioDto dto) {
		return ResponseEntity.ok(usuarioService.criarUsuario(dto));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> retornaUsuario(@PathVariable Long id) throws UsuarioNaoEncontradoException {
		return ResponseEntity.ok(usuarioService.retornaUsuario(id));
	}
	
	@PutMapping("/adicionar/{id}/{quantia}")
	public ResponseEntity<String> adicionarSaldo(@PathVariable Long id, @PathVariable Double quantia) throws UsuarioNaoEncontradoException {
		return ResponseEntity.ok(usuarioService.adcionarSaldo(id, quantia));
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) throws UsuarioNaoEncontradoException {
		return ResponseEntity.ok(usuarioService.atualizaUmUsuario(id, usuario));
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<String> apagarUsuario(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.apagarUsuario(id));
	}

}
