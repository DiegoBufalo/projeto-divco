package com.ucusjt.projetocovid.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Erro {
	
	private String mensagem;
	
	private List<String> listaErro;

}
