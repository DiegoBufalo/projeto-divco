package com.ucusjt.projetocovid.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ValidationError extends Exception {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	private String mensagem;
}
