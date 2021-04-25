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

	List<Pessoa> findByDataNascimento(LocalDate dataNascimento);
	
	List<Pessoa> findByDataNascimentoLessThan(LocalDate dataNascimento);

	List<Pessoa> findByProfSaude(Boolean profSaude);
	
	boolean existsByCpf(String cpf);
	
	boolean existsByEmail(String email);

	List<Pessoa> findByDataVacinacaoBetween(LocalDate dataInicial, LocalDate dataFinal);
	
}
