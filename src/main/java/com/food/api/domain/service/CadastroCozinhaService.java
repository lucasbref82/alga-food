package com.food.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.api.domain.exception.EntidadeNaoEncontradaException;
import com.food.api.domain.model.Cozinha;
import com.food.api.domain.repository.CozinhaRepository;
import com.food.api.utilitarios.Constantes;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	public void excluir(Long cozinhaId) {
		cozinhaRepository.deleteById(cozinhaId);

	}

	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId).orElseThrow(
				() -> new EntidadeNaoEncontradaException(String.format(Constantes.COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}

}
