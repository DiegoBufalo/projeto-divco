package com.ucusjt.projetocovid.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.ucusjt.projetocovid.dto.PessoaDto;
import com.ucusjt.projetocovid.enums.TipoUsuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa", schema = "filacovid")
@Builder
@Entity
public class Pessoa {

	@Id
	@Column(name = "id", updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "senha")
	private String senha; 
	
	@Column(name = "cpf", unique = true, updatable = false)
	private String cpf;
	
	@Column(name = "data_nascimento", updatable = false)
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataNascimento;
	
	@Column(name = "tipo_usuario")
	@Enumerated(value = EnumType.STRING)
	private	TipoUsuario tipoUsuario;
	
	@Column(name = "prof_saude")
	private Boolean profSaude;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "data_vacinacao", nullable = true)
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataVacinacao;
	
	
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
