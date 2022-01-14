package code.send.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import code.send.email.model.Mensagem;

@Component
public class SendEmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void send(Mensagem msg) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(msg.getRemetente());
		mail.setTo(msg.getDestinatario());
		mail.setSubject(msg.getTitulo());
		mail.setText(msg.getCorpo());

		try {
			mailSender.send(mail);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}
	
}
