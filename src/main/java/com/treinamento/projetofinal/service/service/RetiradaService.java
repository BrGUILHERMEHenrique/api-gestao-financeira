package com.treinamento.projetofinal.service.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.RetiradaDto;
import com.treinamento.projetofinal.domain.enums.TipoGasto;
import com.treinamento.projetofinal.domain.models.Retirada;
import com.treinamento.projetofinal.domain.models.exceptions.RetiradaNaoEncontradaException;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.repositories.RetiradaRepository;

@Service
public class RetiradaService {

	@Autowired
	private RetiradaRepository retiradaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	private Retirada dtoToModel(RetiradaDto dto) {
		return modelMapper.map(dto, Retirada.class);
	}
	
	@Transactional
	public Retirada criarRetirada(RetiradaDto dto) throws UsuarioNaoEncontradoException {
		Retirada retirada = dtoToModel(dto);
		retirada.setTipoGasto(TipoGasto.valueOf(dto.getTipoGasto()));
		retirada.setUsuario(usuarioService.retornaUsuario(dto.getUsuario()));
		usuarioService.retirarSaldo(retirada.getUsuario().getId(), retirada.getQuantia());
		return retiradaRepository.save(retirada);
	}
	
	@Transactional
	public Retirada retornaRetirada(Long id) throws RetiradaNaoEncontradaException {
		Optional<Retirada> retirada = retiradaRepository.findById(id);
		if(Boolean.TRUE.equals(retirada.isPresent())) {
			return retirada.get();
		} else {
			throw new RetiradaNaoEncontradaException();
		}
	}

	@Transactional
	public List<Retirada> retornarPorUsuario(Long idUsuario) {
		List<Retirada> listaPorQuantia = retiradaRepository.findByIdUsuario(idUsuario);
		Collections.sort(listaPorQuantia);
		return listaPorQuantia;
	}
	
	@Transactional
	public String atualizarDescricao(Long id, RetiradaDto dto) {
		Retirada retirada = retiradaRepository.findById(id).get();
		
		if(dto.getDescricao() != null) {
			retirada.setDescricao(dto.getDescricao());
			retiradaRepository.save(retirada);
			return "Retirada atualizada com sucesso!";
		} else {
			return "Algo de errado aconteceu";
		}
	}
	
	@Transactional
	public String deletarRetirada(Long id) {
		 retiradaRepository.deleteById(id);
		 
		 return "Retirada apagada com sucesso";
	}
	
}
