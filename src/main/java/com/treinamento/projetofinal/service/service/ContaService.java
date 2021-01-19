package com.treinamento.projetofinal.service.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.projetofinal.application.dto.ContaDto;
import com.treinamento.projetofinal.domain.models.Conta;
import com.treinamento.projetofinal.domain.models.ModeloPagamentoConta;
import com.treinamento.projetofinal.domain.models.exceptions.NotFound;
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

	public Conta retornaConta(Long id) throws NotFound {
		Optional<Conta> conta = contaRepository.findById(id);
		if (conta.isPresent()) {
			return conta.get();
		} else {
			throw new NotFound("Conta não encontrada");
		}
	}

	public List<Conta> retornaContasUsuario(Long idUsuario) {
		List<Conta> listaPorDataVencimento = contaRepository.findByIdUsuario(idUsuario);
		Collections.sort(listaPorDataVencimento);
		return listaPorDataVencimento;
	}

	@Transactional
	public Conta criarConta(ContaDto dto) throws NotFound {
		Conta conta = dtoToModel(dto);
		conta.setUsuario(usuarioService.retornaUsuario(dto.getUsuario()));
		return contaRepository.save(conta);
	}

	@Transactional
	public String pagarConta(ModeloPagamentoConta modelo) throws NotFound {
		Conta conta = retornaConta(modelo.getIdConta());
		if (Boolean.FALSE.equals(conta.getPaga())) {
			conta.setPaga(!conta.getPaga());
			usuarioService.retirarSaldo(modelo.getIdUsuario(), conta.getPreco());
			return "Conta paga e saldo retirado com sucesso";
		} else {
			return "Essa conta já foi paga!";
		}

	}

	@Transactional
	public String apagarConta(Long id) throws NotFound {
		Conta conta = retornaConta(id);
		contaRepository.delete(conta);

		return "Conta apagar com sucesso";
	}
}
