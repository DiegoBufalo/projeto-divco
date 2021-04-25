package com.ucusjt.projetocovid.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ucusjt.projetocovid.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaAtualizarDto {

	private Long id;

	@NotNull(message = "nome nao pode ser nulo")
	@NotBlank(message = "nome nao pode estar vazio")
	private String nome;

	@NotNull(message = "sobrenome nao pode ser nulo")
	@NotBlank(message = "sobrenome nao pode estar vazio")
	private String sobrenome;

	@NotNull(message = "email nao pode ser nulo")
	@Email(message = "email incorreto")
	private String email;

	@NotNull(message = "senha nao pode ser nulo")
	@NotBlank(message = "senha nao pode estar vazio")
	private String senha; 
	

	@NotNull(message = "profissional da saude nao pode ser nulo")
	private	TipoUsuario tipoUsuario;

	@NotNull(message = "profissional da saude nao pode ser nulo")
	private Boolean profSaude;
	
	@NotNull(message = "endereco nao pode ser nulo")
	private String endereco;
	
	
//	public PessoaAtualizarDto fromEntity(Pessoa pessoa) {
//		PessoaAtualizarDto model = new PessoaAtualizarDto(pessoa.getId(),
//				pessoa.getNome(),
//				pessoa.getSobrenome(),
//				pessoa.getEmail(),
//				pessoa.getSenha(),
//				pessoa.getCpf(),
//				pessoa.getDataNascimento(),
//				pessoa.getTipoUsuario(),
//				pessoa.getProfSaude(),
//				pessoa.getEndereco(),
//				pessoa.getDataVacinacao());
//		return model;
//	}
//	
//	public Pessoa fromModel(PessoaAtualizarDto pessoa) {
//		Pessoa entity = new Pessoa(pessoa.getId(),
//				pessoa.getNome(),
//				pessoa.getSobrenome(),
//				pessoa.getEmail(),
//				pessoa.getSenha(),
//				pessoa.getCpf(),
//				pessoa.getDataNascimento(),
//				pessoa.getTipoUsuario(),
//				pessoa.getProfSaude(),
//				pessoa.getEndereco(),
//				pessoa.getDataNascimento());
//		return entity;
//	}
	
}
