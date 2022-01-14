package code.send.email;

import java.io.File;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import code.send.email.model.Mensagem;
import code.send.email.service.SendEmailService;
import static code.send.email.util.FileReaderUtil.*;

@SpringBootApplication
public class SendEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(SendEmailService sendEmail) throws Exception {
		return args -> {
			
			// Local de um arquivo CSV
			String destino = "emails.csv";
			File file = getFile(destino);

			List<String> linhas = getFileLines(file.getAbsolutePath());

			linhas.forEach(linha -> {
				String[] colunas = linha.split(";");
				
				String destinatario = colunas[1];
				String conteudo = colunas[2];
				String corpo = String.format("%s\nAcabamos de enviar um e-mail com conteúdo \n%s ", colunas[0], conteudo);
				
				Mensagem mensagem = new Mensagem();
				mensagem.setDestinatario(destinatario);
				mensagem.setTitulo("Digytal Code - Exemplo de Envio de E-mail");
				mensagem.setCorpo(corpo);
				
				sendEmail.send(mensagem);
			});

			System.out.println("FIM ENVIO");
		};
	}
	
}
