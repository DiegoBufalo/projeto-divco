package com.ucusjt.projetocovid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.model.Pergunta;
import com.ucusjt.projetocovid.repository.PerguntaRepository;
import com.ucusjt.projetocovid.service.PerguntaService;

@Service
public class PerguntaServiceImpl implements PerguntaService {

	@Autowired
	private PerguntaRepository repository;
	
	@Override
	public Long buscarIdResposta(String pergunta) {
		
		if(pergunta != null) {
			
			String[] palavras = pergunta.split(" ");

			for (String palavra : palavras) {
				
				String busca = palavra
						.replace(" ", "")
						.replace("?", "")
						.replace(",", "")
						.replace(".", "");
				
				Pergunta palavraEncontrada = repository.findFirstByPalavraChaveIgnoringCase(busca);
				
				if(palavraEncontrada != null)
					return palavraEncontrada.getIdResposta().getId();
			}		
			
		}else {
			return null;
		}
		
		return null;
	}
}
