package com.ucusjt.projetocovid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucusjt.projetocovid.model.Pergunta;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

	Pergunta findFirstByPalavraChaveIgnoringCase(String palavraChave);
}
