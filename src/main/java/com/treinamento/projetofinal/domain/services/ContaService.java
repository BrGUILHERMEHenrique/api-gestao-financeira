package com.treinamento.projetofinal.domain.services;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.domain.dtos.ContaDto;
import com.treinamento.projetofinal.domain.models.Conta;
import com.treinamento.projetofinal.domain.models.ModeloPagamentoConta;
import com.treinamento.projetofinal.domain.models.exceptions.UsuarioNaoEncontradoException;
import com.treinamento.projetofinal.infrastructure.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	private Conta dtoToModel(ContaDto dto) {
		return modelMapper.map(dto, Conta.class);
	}
	
	
	@Transactional
	public Conta retornaConta (Long id) {
		return contaRepository.findById(id).get();
	}
	@Transactional
	public List<Conta> retornaContasUsuario(Long idUsuario) {
		List<Conta> listaPorDataVencimento = contaRepository.findByIdUsuario(idUsuario);
		Collections.sort(listaPorDataVencimento);
		return listaPorDataVencimento;
	}
	
	@Transactional 
	public Conta criarConta(ContaDto dto) throws UsuarioNaoEncontradoException {
		Conta conta = dtoToModel(dto);
		conta.setUsuario(usuarioService.retornaUsuario(dto.getUsuario()));
		return contaRepository.save(conta);
	}
	
	@Transactional
	public String pagarConta(ModeloPagamentoConta modelo) throws UsuarioNaoEncontradoException {
		Conta conta = retornaConta(modelo.getIdConta());
		if(Boolean.FALSE.equals(conta.getPaga())) {
			conta.setPaga(!conta.getPaga());
			usuarioService.retirarSaldo(modelo.getIdUsuario(), conta.getPreco());
			return "Conta paga e saldo retirado com sucesso";
		} else {
			return "Essa conta já foi paga!";
		}
		
	}
}
