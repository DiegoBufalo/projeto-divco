package com.ucusjt.projetocovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucusjt.projetocovid.model.RespostaAssistente;

@Repository
public interface RespostaAssistenteRepository extends JpaRepository<RespostaAssistente, Long> {
	
}