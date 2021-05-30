package com.ucusjt.projetocovid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@Table(name = "pergunta", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Entity	
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false, unique = true)
	private Long id;
	
	@Column(name = "palavra_chave")
	private String palavraChave;
	
	@ManyToOne
	@JoinColumn(name = "idResposta")
	private RespostaAssistente idResposta;
}
