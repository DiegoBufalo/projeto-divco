package com.ucusjt.projetocovid.service;

import org.springframework.stereotype.Service;

@Service
public interface PerguntaService {

	public Long buscarIdResposta(String palavra);
}
