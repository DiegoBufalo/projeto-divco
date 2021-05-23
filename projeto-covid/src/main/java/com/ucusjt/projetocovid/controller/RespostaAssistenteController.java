package com.ucusjt.projetocovid.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ucusjt.projetocovid.beans.Erro;
import com.ucusjt.projetocovid.dto.RespostaAssistenteDTO;
import com.ucusjt.projetocovid.service.RespostaAssistenteService;

@RestController
@RequestMapping("/chatbot")
public class RespostaAssistenteController {
	
	@Autowired
	private RespostaAssistenteService service;
	
	private static final String MESSAGE_RESPOSTA_NOTFOUND="Desculpe, não entendi a sua pergunta";
	
	@GetMapping("/bemvindo")
	@ResponseStatus(value = HttpStatus.OK)
	public RespostaAssistenteDTO apresentacaoInicial() {
		return service.apresentacaoInicial();
	}
	
	@GetMapping("/{palavra}")
	@ResponseStatus(value = HttpStatus.OK)
	public RespostaAssistenteDTO buscarResposta(@PathVariable String palavra) {
		return service.buscarResposta(palavra);
	}
	
	@ExceptionHandler(Exception.class)
	public Erro validationError(Exception ex) {
        String result = MESSAGE_RESPOSTA_NOTFOUND;
        List<String> erro = new ArrayList<String>();
        erro.add(result);
        return new Erro(MESSAGE_RESPOSTA_NOTFOUND, erro);
    }
	
}