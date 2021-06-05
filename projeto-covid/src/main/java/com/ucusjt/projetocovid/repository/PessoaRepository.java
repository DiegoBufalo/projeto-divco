package com.ucusjt.projetocovid.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucusjt.projetocovid.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{	
	
	Pessoa findByEmail(String email);
	
	Pessoa findByCpf(String cpf);
	
	boolean existsByCpf(String cpf);
	
	boolean existsByEmail(String email);
	
	List<Pessoa> findAllByOrderById();
	
	List<Pessoa> findByDataNascimentoLessThanOrderById(LocalDate dataNascimento);

	List<Pessoa> findByProfSaudeOrderById(Boolean profSaude);	
}
