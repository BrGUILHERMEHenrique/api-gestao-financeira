package com.treinamento.projetofinal.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.FixaRequest;
import com.treinamento.projetofinal.domain.models.Fixa;
import com.treinamento.projetofinal.domain.models.exceptions.FixaNaoEncontradaException;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.repositories.FixaRepository;

@Service
public class FixaService {

	@Autowired
	private FixaRepository fixaRepository;

	@Autowired
	private UsuarioService usuarioService;

	private final ModelMapper modelMapper = new ModelMapper();

	private Fixa requestToModel(FixaRequest req) {
		return modelMapper.map(req, Fixa.class);
	}

	public List<Fixa> retornaListaporUsuario(Long idUsuario) {
		return fixaRepository.findByIdUsuario(idUsuario);
	}

	public Fixa retornaPorId(Long id) throws FixaNaoEncontradaException {
		Optional<Fixa> fixa = fixaRepository.findById(id);
		if (fixa.isPresent()) {
			return fixa.get();
		} else {
			throw new FixaNaoEncontradaException();
		}
	}

	@Transactional
	public Fixa criarDespesaFixa(FixaRequest req) throws UsuarioNaoEncontradoException {
		Fixa fixa = requestToModel(req);
		fixa.setUsuario(usuarioService.retornaUsuario(req.getUsuario()));

		return fixaRepository.save(fixa);
	}

	@Transactional
	public String atualizarDespesaFixa(Long id, FixaRequest req) throws FixaNaoEncontradaException {
		Fixa fixaAtualizada = retornaPorId(id);
		if (req.getDescricao() != null && !req.getDescricao().equals("")) {
			fixaAtualizada.setDescricao(req.getDescricao());
		}
		if (req.getQuantia() != null) {
			fixaAtualizada.setQuantia(req.getQuantia());
		}
		fixaRepository.save(fixaAtualizada);
		return "Despesa fixa atualizada com sucesso";
	}

	@Transactional
	public String apagarDespesaFixa(Long id) throws FixaNaoEncontradaException {
		Fixa fixa = retornaPorId(id);

		fixaRepository.delete(fixa);

		return "Despesa fixa apagada com sucesso";
	}

}
