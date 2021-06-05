package com.ucusjt.projetocovid.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ucusjt.projetocovid.config.EmailProperties;
import com.ucusjt.projetocovid.erros.EmailException;
import com.ucusjt.projetocovid.model.Mensagem;
import com.ucusjt.projetocovid.service.EnvioEmailService;

@Service
public class SmtpEnvioEmailService  implements EnvioEmailService{

	@Autowired JavaMailSender mailSender;
	
	@Autowired
	private EmailProperties emailProperties;
	
	@Override
	public void enviar(Mensagem mensagem) {

		try {
			String corpo = mensagem.getCorpo();
			
			var mimeMessage = mailSender.createMimeMessage();
			
			var helper = new MimeMessageHelper(mimeMessage, "UTF-8");
			helper.setFrom(emailProperties.getRemetente());
			helper.setTo(mensagem.getDestinatarios().toArray(new String[0]));
			helper.setSubject(mensagem.getAssunto());
			helper.setText(corpo, true);
			
			mailSender.send(mimeMessage);
			
		}catch (Exception e) {
			throw new EmailException("Não foi possível enviar o e-mail", e);
		}
		
	}

}
