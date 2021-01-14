package com.treinamento.projetofinal.service.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.UsuarioDto;
import com.treinamento.projetofinal.domain.models.Usuario;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ContaService contaService;
	
	private Usuario dtoToModel(UsuarioDto dto) {
		return modelMapper.map(dto, Usuario.class);
	}
	
	@Transactional
	public Usuario retornaUsuario(Long id) throws UsuarioNaoEncontradoException {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new UsuarioNaoEncontradoException();
		}
	}
	
	@Transactional
	public Usuario criarUsuario(UsuarioDto dto) {
		Usuario usuario = dtoToModel(dto);
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario atualizaUmUsuario(Long id, Usuario usuario) throws UsuarioNaoEncontradoException {
		Usuario usuarioAchado = retornaUsuario(id);
		
		return usuarioRepository.save(usuario.verificaDadosNulos(usuarioAchado));
	}
	
	@Transactional
	public String adcionarSaldo(Long id, Double saldo) throws UsuarioNaoEncontradoException {
		Usuario usuario = retornaUsuario(id);
		Double saldoTotal = usuario.getSaldo() + saldo;
		usuario.setSaldo(saldoTotal);
		usuarioRepository.save(usuario);
		return "Saldo adicionado com sucesso";
	}
	
	@Transactional
	public String retirarSaldo(Long id, Double quantia) throws UsuarioNaoEncontradoException {
		Usuario usuario = retornaUsuario(id);
		Double saldoRestante = usuario.getSaldo() - quantia;
		usuario.setSaldo(saldoRestante);
		usuarioRepository.save(usuario);
		return "Quantia retirada com sucesso";
	}
	
	@Transactional
	public String apagarUsuario(Long id) {
		usuarioRepository.deleteById(id);
		
		return "Usuário apagado com sucesso";
	}
	
	
}
