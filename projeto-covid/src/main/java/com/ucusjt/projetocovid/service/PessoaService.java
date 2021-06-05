package com.ucusjt.projetocovid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.dto.PessoaAtualizarDto;
import com.ucusjt.projetocovid.dto.PessoaDto;

@Service
public interface PessoaService {

	public PessoaDto cadastrarPessoa(PessoaDto pessoa) throws Exception;
	
	public List<PessoaDto> buscarPessoas();
	
	public PessoaDto buscarPessoa(Long id);
	
	public PessoaDto buscarPessoaPorCpf(String cpf);
	
	public PessoaDto atualizarPessoa(Long 	id, PessoaAtualizarDto pessoa);
	
	public void deletarPessoa(Long id);
	
	public PessoaDto confirmarVacinacao(Long id) throws Exception;
	
	public List<PessoaDto> filaVacinacao();
}
