package com.treinamento.projetofinal.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.domain.models.Conta;
import com.treinamento.projetofinal.domain.models.Usuario;
import com.treinamento.projetofinal.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ContaService contaService;
	
	@Transactional
	public Usuario retornaUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	@Transactional 
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario atualizaUmUsuario(Long id, Usuario usuario) {
		Usuario usuarioAchado = retornaUsuario(id);
		
		return usuarioRepository.save(usuario.verificaDadosNulos(usuarioAchado));
	}
	
	@Transactional
	public String adcionarSaldo(Long id, Double saldo) {
		Usuario usuario = retornaUsuario(id);
		Double saldoTotal = usuario.getSaldo() + saldo;
		usuario.setSaldo(saldoTotal);
		usuarioRepository.save(usuario);
		return "Saldo adicionado com sucesso";
	}
	
	@Transactional
	public String retirarSaldo(Long id, Double quantia) {
		Usuario usuario = retornaUsuario(id);
		Double saldoRestante = usuario.getSaldo() - quantia;
		usuario.setSaldo(saldoRestante);
		usuarioRepository.save(usuario);
		return "Quantia retirada com sucesso";
	}
	
	public List<Conta> retornaListaContasUsaurio(Long id) {
		return contaService.retornaContasUsuario(id);
	}
	
}
