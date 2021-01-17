package com.treinamento.projetofinal.service.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treinamento.projetofinal.application.dto.UsuarioDto;
import com.treinamento.projetofinal.domain.models.Usuario;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.configJWT.JwtUtil;
import com.treinamento.projetofinal.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ContaService contaService;
	
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    ObjectMapper objectMapper;
	
	private Usuario dtoToModel(UsuarioDto dto) {
		return modelMapper.map(dto, Usuario.class);
	}
	public String generateToken(Usuario usuario) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
//        String usuarioString = objectMapper.writeValueAsString(usuario);
        return jwtUtil.generateToken(usuario.getEmail());
    }
	
	public Usuario retornaPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	

	public Usuario retornaUsuario(Long id) throws UsuarioNaoEncontradoException {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		} else {
			throw new UsuarioNaoEncontradoException();
		}
	}
	

	public String login(UsuarioDto dto) throws Exception {
		Usuario usuario = usuarioRepository.findByEmail(dto.getEmail());
		return generateToken(usuario);
	}
	@Transactional
	public String criarUsuario(UsuarioDto dto) throws Exception {
		Usuario usuario = dtoToModel(dto);
		return generateToken(usuarioRepository.save(usuario));
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
