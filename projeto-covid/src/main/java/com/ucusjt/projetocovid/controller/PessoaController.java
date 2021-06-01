		package com.ucusjt.projetocovid.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ucusjt.projetocovid.beans.Erro;
import com.ucusjt.projetocovid.dto.PessoaAtualizarDto;
import com.ucusjt.projetocovid.dto.PessoaDto;
import com.ucusjt.projetocovid.service.PessoaService;

@RestController
@RequestMapping("pessoa")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<PessoaDto> buscarPessoas() {
		return service.buscarPessoas();
	}
	
	@GetMapping("/fila")
	@ResponseStatus(value = HttpStatus.OK)
	public List<PessoaDto> filaVacinacao() {
		return service.filaVacinacao();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaDto buscarPessoa(@PathVariable Long id) {
		return service.buscarPessoa(id);
	}
	
	@GetMapping("/cpf/{cpf}")
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaDto buscarPessoa(@PathVariable String cpf) {
		return service.buscarPessoaPorCpf(cpf);
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public PessoaDto cadastrarPessoa(@RequestBody @Valid PessoaDto pessoa) throws Exception {
		return service.cadastrarPessoa(pessoa);
	}
	
	@PutMapping("/atualizar/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaDto atualizarPessoa(@PathVariable Long id,@RequestBody @Valid PessoaAtualizarDto pessoa) {
		return service.atualizarPessoa(id, pessoa);
	}
	
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletarPessoa(@PathVariable Long id) {
		service.deletarPessoa(id);
	}

	
	@GetMapping("/confirmar/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public PessoaDto confirmarVacinacao(@PathVariable Long id) {
		return service.confirmarVacinacao(id);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Erro validationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        
        return new Erro("Erro de Validacao", fieldErrors.stream().map(s -> s.getDefaultMessage()).collect(Collectors.toList()));
    }
	
	@ExceptionHandler(ConstraintViolationException.class)
	public Erro validationErrorSql(ConstraintViolationException ex) {
        String result = "CPF ou E-mail já cadastrados";
        List<String> erro = new ArrayList<String>();
        erro.add(result);
        return new Erro("Erro de Validacao", erro);
    }
}
