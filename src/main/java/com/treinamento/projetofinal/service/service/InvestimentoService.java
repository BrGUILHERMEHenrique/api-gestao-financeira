package com.treinamento.projetofinal.service.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.InvestimentoRequest;
import com.treinamento.projetofinal.domain.models.Investimento;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.repositories.InvestimentoRepository;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository investimentoRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	private Investimento requestToModel(InvestimentoRequest req) {
		return modelMapper.map(req, Investimento.class);
	}
	
	public List<Investimento> retornaPorUsuario(Long idUsuario) {
		return investimentoRepository.findByIdUsuario(idUsuario);
	}
	
	public Investimento retornaPorId(Long id) throws NotFound {
		Optional<Investimento> investimento = investimentoRepository.findById(id);
		
		if(investimento.isPresent()) {
			return investimento.get();
		} else {
			throw new NotFound("Investimento não encontrado");
		}
	}
	
	@Transactional
	public Investimento adicionarInvestimento(InvestimentoRequest req) throws UsuarioNaoEncontradoException {
		Investimento investimento = requestToModel(req);
		investimento.setUsuario(usuarioService.retornaUsuario(req.getUsuario()));
		
		return investimentoRepository.save(investimento);
	}
	
	@Transactional
	public String atualizarInvestimento(Long id, InvestimentoRequest req) throws NotFound {
		Investimento investimentoAtualizado = retornaPorId(id);
		if(req.getDescricao() != null && req.getDescricao() != "") {
			investimentoAtualizado.setDescricao(req.getDescricao());
		}
		
		investimentoRepository.save(investimentoAtualizado);
		return "Investimento atualizado com sucesso";
	}
	
	@Transactional
	public String atualizarLucro(Long id, Double quantia) throws NotFound {
		Investimento investimento = retornaPorId(id);
		if(!quantia.equals(investimento.getLucroAtual())) {
			investimento.setLucroAtual(quantia);
		}
		return "Lucro atualizado com sucesso";
	}
	
	public String verificarPorcetagemLucro(Long id) throws NotFound {
		Investimento investimento = retornaPorId(id);
		Double porcentagem = ((investimento.getLucroAtual() - investimento.getValorRetirada()) / 100);
		
		return "A porcentagem de lucro atual é de: " + porcentagem;
	}
	
	public String apagarInvestimento(Long id) throws NotFound {
		Investimento investimento = retornaPorId(id);
		
		investimentoRepository.delete(investimento);
		
		return "Investimento apagado com sucesso";
	}
}
