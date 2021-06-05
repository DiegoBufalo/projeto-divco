package com.ucusjt.projetocovid.service;

import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.model.Mensagem;

@Service
public interface EnvioEmailService {
	
	void enviar(Mensagem mensagem);

}
