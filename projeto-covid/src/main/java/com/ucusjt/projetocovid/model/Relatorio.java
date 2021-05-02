package com.ucusjt.projetocovid.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "relatorio", schema = "public")
public class Relatorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "data")
	private LocalDate data;

	@Column(name = "media_diaria")
	private Integer mediaDiaria;
}
