package com.ucusjt.projetocovid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ucusjt.projetocovid.dto.PerguntaDTO;
import com.ucusjt.projetocovid.dto.RespostaAssistenteDTO;
import com.ucusjt.projetocovid.service.RespostaAssistenteService;

@RestController
@RequestMapping("/chatbot")
@CrossOrigin(origins = "http://localhost:4200")
public class RespostaAssistenteController {
	
	@Autowired
	private RespostaAssistenteService service;
	
	@GetMapping("/bemvindo")
	@ResponseStatus(value = HttpStatus.OK)
	public RespostaAssistenteDTO apresentacaoInicial() {
		return service.apresentacaoInicial();
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public RespostaAssistenteDTO buscarRespostaAtt(@RequestBody PerguntaDTO palavra) throws Exception {
		if(palavra.getPergunta().equals("bemvindo"))
			return service.apresentacaoInicial();
		else
			return service.buscarRespostaAtt(palavra.getPergunta());
	}
}
