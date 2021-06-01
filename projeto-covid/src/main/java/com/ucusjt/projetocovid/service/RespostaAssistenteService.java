package com.ucusjt.projetocovid.service;

import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.dto.RespostaAssistenteDTO;

@Service
public interface RespostaAssistenteService {

	public RespostaAssistenteDTO apresentacaoInicial();
	
	public RespostaAssistenteDTO buscarRespostaAtt(String palavra);
	
	
}
