package com.ucusjt.projetocovid.config;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Component
@Getter
@Setter
public class EmailProperties {
	
	private String remetente = "projetodivco.uc@gmail.com";

}
