package com.ucusjt.projetocovid.service;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Service
public interface EnvioEmailService {
	
	void enviar(Mensagem mensagem);
	
	@Builder
	@Getter
	class Mensagem{
		
		@Singular
		private Set<String> destinatarios;
		private String assunto;
		private String corpo;
		
		@Singular("variavel")
		private Map<String, Object> variaveis;
	}

}
