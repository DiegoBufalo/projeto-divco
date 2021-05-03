package com.ucusjt.projetocovid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.dto.PessoaAtualizarDto;
import com.ucusjt.projetocovid.dto.PessoaDto;
import com.ucusjt.projetocovid.model.Pessoa;
import com.ucusjt.projetocovid.model.Relatorio;

@Service
public interface PessoaService {

	public PessoaDto cadastrarPessoa(PessoaDto pessoa) throws Exception;
	
	public List<PessoaDto> buscarPessoas();
	
	public List<Pessoa> buscarPessoa(Long id);
	
	public PessoaDto atualizarPessoa(Long 	id, PessoaAtualizarDto pessoa);
	
	public void deletarPessoa(Long id);
	
	public void clearDatabase();
	
	public PessoaDto confirmarVacinacao(Long id);
	
	public List<PessoaDto> filaVacinacao();
	
	public List<Relatorio> gerarRelatorio();
}
