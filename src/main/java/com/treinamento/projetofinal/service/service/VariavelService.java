package com.treinamento.projetofinal.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.VariavelRequest;
import com.treinamento.projetofinal.domain.models.Variavel;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.repositories.VariavelRepository;

@Service
public class VariavelService {

	@Autowired
	private VariavelRepository variavelREepository;
	@Autowired
	private UsuarioService usuarioService;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	private Variavel requestToModel(VariavelRequest req) {
		return modelMapper.map(req, Variavel.class);
	}
	
	public Variavel retornaPorid(Long id ) throws NotFound {
		Optional<Variavel> variavel = variavelREepository.findById(id);
		if(variavel.isPresent()) {
			return variavel.get();
		} else {
			throw new NotFound("Despesa Variavel não encontrada");
		}
	}
	
	public List<Variavel> retornaListaPorUsuario(Long idUsuario) {
		return variavelREepository.findByIdUsuario(idUsuario);
	}
	
	@Transactional 
	public Variavel adicionarVariavel(VariavelRequest req) throws UsuarioNaoEncontradoException {
		Variavel variavel = requestToModel(req);
		variavel.setUsuario(usuarioService.retornaUsuario(req.getUsuario()));
		
		return variavelREepository.save(variavel);
	}
	@Transactional
	public String atualizarVariavel(Long id, VariavelRequest req) throws NotFound {
		Variavel variavel = retornaPorid(id);

		if(req.getDescricacao() != null && req.getDescricacao() != "" ) {
			variavel.setDescricacao(req.getDescricacao());
		}
		if(req.getQuantia() != null) {
			variavel.setQuantia(req.getQuantia());
		}
		
		variavelREepository.save(variavel);
		
		return "Variavel atualizada com sucesso";
	}
	
	public String apagarVariavel(Long id) throws NotFound {
		Variavel variavel = retornaPorid(id);
		
		variavelREepository.delete(variavel);
		
		return "Variavel apagada com sucesso";
	}
}
