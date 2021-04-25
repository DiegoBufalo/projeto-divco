package com.ucusjt.projetocovid.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import com.ucusjt.projetocovid.enums.TipoUsuario;
import com.ucusjt.projetocovid.model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaDto {

	private Long id;

	@NotNull(message = "nome nao pode ser nulo")
	@NotBlank(message = "nome nao pode estar vazio")
	private String nome;

	@NotNull(message = "sobrenome nao pode ser nulo")
	private String sobrenome;

	@NotNull(message = "email nao pode ser nulo")
	@Email(message = "email incorreto")
	private String email;

	@NotNull(message = "senha nao pode ser nulo")
	private String senha; 
	
	@NotNull(message = "cpf nao pode ser nulo")
	@CPF(message = "cpf com formato incorreto" )
	private String cpf;

	@NotNull(message = "data de nascimento nao pode ser nulo")
	@Past(message = "data de nascimento incorreta")
	private LocalDate dataNascimento;

	@NotNull(message = "profissional da saude nao pode ser nulo")
	private	TipoUsuario tipoUsuario;

	@NotNull(message = "profissional da saude nao pode ser nulo")
	private Boolean profSaude;
	
	@NotNull(message = "endereco nao pode ser nulo")
	private String endereco;

	@FutureOrPresent
	private LocalDate dataVacinacao;
	
	
	public PessoaDto fromEntity(Pessoa pessoa) {
		PessoaDto model = new PessoaDto(pessoa.getId(),
				pessoa.getNome(),
				pessoa.getSobrenome(),
				pessoa.getEmail(),
				pessoa.getSenha(),
				pessoa.getCpf(),
				pessoa.getDataNascimento(),
				pessoa.getTipoUsuario(),
				pessoa.getProfSaude(),
				pessoa.getEndereco(),
				pessoa.getDataVacinacao());
		return model;
	}
	
	public Pessoa fromModel(PessoaDto pessoa) {
		Pessoa entity = new Pessoa(pessoa.getId(),
				pessoa.getNome(),
				pessoa.getSobrenome(),
				pessoa.getEmail(),
				pessoa.getSenha(),
				pessoa.getCpf(),
				pessoa.getDataNascimento(),
				pessoa.getTipoUsuario(),
				pessoa.getProfSaude(),
				pessoa.getEndereco(),
				pessoa.getDataNascimento());
		return entity;
	}
	
}
