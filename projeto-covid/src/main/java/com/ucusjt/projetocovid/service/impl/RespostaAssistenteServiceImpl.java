package com.ucusjt.projetocovid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.dto.RespostaAssistenteDTO;
import com.ucusjt.projetocovid.repository.RespostaAssistenteRepository;
import com.ucusjt.projetocovid.service.PerguntaService;
import com.ucusjt.projetocovid.service.RespostaAssistenteService;

@Service
public class RespostaAssistenteServiceImpl implements RespostaAssistenteService{
	
	@Autowired
	private RespostaAssistenteRepository repository;
	
	@Autowired
	private PerguntaService servicePergunta;

	private static final String MESSAGE_RESPOSTA_NOTFOUND="Desculpe, não entendi a sua pergunta";
	
	@Override
	public RespostaAssistenteDTO apresentacaoInicial() {
		return new RespostaAssistenteDTO().fromEntity(repository.findById(1L).get());
	}
	

	@Override
	public RespostaAssistenteDTO buscarRespostaAtt(String palavra) {
		
		try {
			Long idResposta = servicePergunta.buscarIdResposta(palavra);
			
			if (idResposta != null) {
				return new RespostaAssistenteDTO()
						.fromEntity(
								repository.findById(idResposta).get());
			}else {
				return new RespostaAssistenteDTO(0L, MESSAGE_RESPOSTA_NOTFOUND);
			}
			
		} catch (Exception e) {
			throw new Error(MESSAGE_RESPOSTA_NOTFOUND, e);
		}
	}
}
