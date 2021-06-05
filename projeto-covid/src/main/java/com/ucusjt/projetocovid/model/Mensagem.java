package com.ucusjt.projetocovid.model;

import java.util.Map;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class Mensagem{
	
	@Singular
	private Set<String> destinatarios;
	private String assunto;
	private String corpo;
	
	@Singular("variavel")
	private Map<String, Object> variaveis;
}