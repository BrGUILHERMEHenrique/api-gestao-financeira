package com.treinamento.projetofinal.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.EntradaDto;
import com.treinamento.projetofinal.domain.enums.TipoEntrada;
import com.treinamento.projetofinal.domain.models.Entrada;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.infrastructure.repositories.EntradaRepository;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	@Autowired
	private UsuarioService usuarioService;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	private Entrada modelToDto(EntradaDto dto) {
		return modelMapper.map(dto, Entrada.class);
	}
	

	public List<Entrada> retornarListaPorUsuario(Long idUsuario) {
		return entradaRepository.findByIdUsuario(idUsuario);
	}
	
	@Transactional
	public Entrada adicionarEntrada(EntradaDto dto) throws NotFound  {
		usuarioService.adcionarSaldo(dto.getUsuario(), dto.getQuantia());
		Entrada entrada = modelToDto(dto);
		entrada.setTipoEntrada(TipoEntrada.valueOf(dto.getTipoEntrada()));
		entrada.setUsuario(usuarioService.retornaUsuario(dto.getUsuario()));
		return entradaRepository.save(entrada);
		
	}
	
	public Entrada retornaPorId(Long id) throws NotFound {
		Optional<Entrada> entrada = entradaRepository.findById(id);
		if(entrada.isPresent()) {
			return entrada.get();
		} else {
			throw new NotFound("Usuário não encontrado");
		}
	}
	
	@Transactional
	public String atualizarEntrada(Long id, EntradaDto dto) throws NotFound{
		Entrada entradaAtualizada = retornaPorId(id);
		if(dto.getDescricao() != null && Boolean.FALSE.equals(dto.getDescricao().equals(""))) {
			entradaAtualizada.setDescricao(dto.getDescricao());
		}
		
		entradaRepository.save(entradaAtualizada);
		
		return "Entrada atualizada com sucesso";
	}
	
	@Transactional
	public String apagarEntrada(Long id) throws NotFound {
		Entrada entradaEncontrada = retornaPorId(id);
		
		entradaRepository.delete(entradaEncontrada);
		
		return "Entrada apagada com sucesso";
	}

}
