package com.ucusjt.projetocovid.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucusjt.projetocovid.model.Relatorio;

public interface RelatorioRepository extends JpaRepository<Relatorio, LocalDate> {
	
	List<Relatorio> findAllByDataBetween(LocalDate dataInicial, LocalDate dataFinal);

}
