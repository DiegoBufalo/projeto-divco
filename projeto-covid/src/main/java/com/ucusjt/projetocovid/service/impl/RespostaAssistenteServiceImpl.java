package com.ucusjt.projetocovid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.dto.RespostaAssistenteDTO;
import com.ucusjt.projetocovid.repository.RespostaAssistenteRepository;
import com.ucusjt.projetocovid.service.RespostaAssistenteService;

@Service
public class RespostaAssistenteServiceImpl implements RespostaAssistenteService{
	
	@Autowired
	private RespostaAssistenteRepository repository;

	private static final String MESSAGE_RESPOSTA_NOTFOUND="Desculpe, não entendi a sua pergunta";
	
	@Override
	public RespostaAssistenteDTO apresentacaoInicial() {
		return new RespostaAssistenteDTO().fromEntity(repository.findById(1L).get());
	}

	@Override
	public RespostaAssistenteDTO buscarResposta(String palavra) {
		
		try {
			return new RespostaAssistenteDTO()
					.fromEntity(
							repository
								.findFirstByRespostaContainingIgnoringCase(palavra));
		}catch (Exception e) {
			throw new Error(MESSAGE_RESPOSTA_NOTFOUND, e.getCause());
		}
	}
}
