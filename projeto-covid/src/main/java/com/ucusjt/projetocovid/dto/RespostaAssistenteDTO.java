package com.ucusjt.projetocovid.dto;

import java.io.Serializable;

import com.ucusjt.projetocovid.model.RespostaAssistente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAssistenteDTO implements Serializable {
    private static final long serialVersionUID=1l;

    private Long id;

    private String mensagem;
    
	public RespostaAssistenteDTO fromEntity(RespostaAssistente pessoa) {
		RespostaAssistenteDTO model = new RespostaAssistenteDTO(pessoa.getId(),
				pessoa.getResposta());
		return model;
	}
	
	public RespostaAssistente fromModel(RespostaAssistenteDTO pessoa) {
		RespostaAssistente entity = new RespostaAssistente(pessoa.getId(),
				pessoa.getMensagem());
		return entity;
	}
}
