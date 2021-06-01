package com.ucusjt.projetocovid.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucusjt.projetocovid.dto.PessoaAtualizarDto;
import com.ucusjt.projetocovid.dto.PessoaDto;
import com.ucusjt.projetocovid.erros.EmailException;
import com.ucusjt.projetocovid.model.Pessoa;
import com.ucusjt.projetocovid.repository.PessoaRepository;
import com.ucusjt.projetocovid.service.EnvioEmailService;
import com.ucusjt.projetocovid.service.EnvioEmailService.Mensagem;
import com.ucusjt.projetocovid.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private EnvioEmailService envioEmail;
	
	@Override
	@Transactional(readOnly = true)
	public List<PessoaDto> buscarPessoas() {
		
		List<PessoaDto> listaPessoas = new ArrayList<PessoaDto>();
		for (Pessoa pessoas : repository.findAll()) {
			listaPessoas.add(new PessoaDto().fromEntity(pessoas));
		}
		return listaPessoas;
	}

	@Override
	@Transactional(readOnly = true)
	public PessoaDto buscarPessoaPorCpf(String cpf) {
		return new PessoaDto()
						.fromEntity(
								repository.findByCpf(cpf)
								);
	}
	
	@Override
	@Transactional(readOnly = true)
	public PessoaDto buscarPessoa(Long id) {
		return new PessoaDto()
				.fromEntity(
						repository.findById(id).get()
							);
	}
	
	
	@Override
	@Transactional
	public PessoaDto cadastrarPessoa(PessoaDto pessoa) throws Exception {// exist by
		
		if(repository.existsByCpf(pessoa.getCpf())) {
			throw new DuplicateKeyException("Cpf já cadastrado na base de dados");
		}else if (repository.existsByEmail(pessoa.getEmail())) {
			throw new DuplicateKeyException("Email já cadastrado na base de dados");
		}else {
			try {
				Pessoa pessoaSalva = repository.save(new PessoaDto().fromModel(pessoa));
				pessoaSalva.setDataVacinacao(null);
				enviarEmail(pessoa);
				
				return new PessoaDto().fromEntity(pessoaSalva);				
			}catch (Exception e) {
				throw new EmailException("Algo ocorreu fora do previsto. Estamos trabalhando para arrumar o mais rapido possivel", e);
			}
		}
	}

	@Override
	@Transactional
	public PessoaDto atualizarPessoa(Long id, PessoaAtualizarDto pessoa) {
		Pessoa pessoaEncontrada = repository.getOne(id);
		pessoaEncontrada.setNome(pessoa.getNome());
		pessoaEncontrada.setSobrenome(pessoa.getSobrenome());
		pessoaEncontrada.setEmail(pessoa.getEmail());
		pessoaEncontrada.setSenha(pessoa.getSenha());
		pessoaEncontrada.setTipoUsuario(pessoa.getTipoUsuario());
		pessoaEncontrada.setProfSaude(pessoa.getProfSaude());
		pessoaEncontrada.setEndereco(pessoa.getEndereco());
		
		return new PessoaDto().fromEntity(repository.save(pessoaEncontrada));
	}

	@Override
	@Transactional
	public void deletarPessoa(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public PessoaDto confirmarVacinacao(Long id) {
		
		try {
				Pessoa pessoaEncontrada = repository.findById(id).get();
				pessoaEncontrada.setDataVacinacao(LocalDate.now());
				repository.save(pessoaEncontrada);
				
				enviarConfirmVacinacao(pessoaEncontrada);
				
				return new PessoaDto().fromEntity(pessoaEncontrada);	
				
			}catch (Exception e) {
				throw new Error("Ocorreu um erro, mas ja estamos trabalhando para arrumar isso", e);
			}
	}


	@Override
	@Transactional(readOnly = true)
	public List<PessoaDto> filaVacinacao() {
			List<PessoaDto> listaPessoas = new ArrayList<PessoaDto>();
			List<Long> listaId = new ArrayList<Long>();
		
		for (Pessoa pessoas : repository.findByDataNascimentoLessThanOrderById(LocalDate.now().minusYears(70))) {
			if (pessoas.getDataVacinacao() == null) {
				listaPessoas.add(new PessoaDto().fromEntity(pessoas));
				listaId.add(pessoas.getId());				
			}
		}
		for(Pessoa pessoas : repository.findByProfSaudeOrderById(true)) {
			if (!listaId.contains(pessoas.getId()) && pessoas.getDataVacinacao() == null) {
				listaPessoas.add(new PessoaDto().fromEntity(pessoas));
				listaId.add(pessoas.getId());
			}
		}
		for(Pessoa pessoas : repository.findAll()) {
			if (!listaId.contains(pessoas.getId()) && pessoas.getDataVacinacao() == null) {
				listaPessoas.add(new PessoaDto().fromEntity(pessoas));
			}
		}
		return listaPessoas;
	}

	
	
	
	
	public void enviarEmail(PessoaDto pessoa) {
		String msg = "Olá " + pessoa.getNome() +" "+ pessoa.getSobrenome() +", você foi cadastrado para a fila de vacinação com sucesso, "
				+ "fique atento ao seu e-mail: "+ pessoa.getEmail() + ". Você reberá mensagens de possiveis alterações por ele.";
		
		var mesagem = Mensagem.builder().assunto("Cadastro Sistema DIVCO GERENCIAMENTO")
										.corpo(msg)
										.destinatario(pessoa.getEmail())
										.build();
		
		envioEmail.enviar(mesagem);
	}
	
	public void enviarConfirmVacinacao(Pessoa pessoa) {
		String msg = "Parabéns " + pessoa.getNome() +" "+ pessoa.getSobrenome() +", você acaba de ser vacinado com sucesso.\n "
				+ "Mas lembre-se a luta contra o COVID-19 ainda não acabou, continue se cuidando.";
		
		var mesagem = Mensagem.builder().assunto("CONFIRMACAO DE VACINACAO")
										.corpo(msg)
										.destinatario(pessoa.getEmail())
										.build();
		envioEmail.enviar(mesagem);
	}

	
	
}

