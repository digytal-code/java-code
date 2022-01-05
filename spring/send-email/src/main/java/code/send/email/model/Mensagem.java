package code.send.email.model;

public class Mensagem {

	private String tema;
	private String titulo;
	private String corpo;
	private String remetente;
	private String destinatario;

	public Mensagem(String tema, String titulo, String corpo, String remetente, String destinatario) {
		this.tema = tema;
		this.titulo = titulo;
		this.corpo = corpo;
		this.remetente = remetente;
		this.destinatario = destinatario;
	}

	public Mensagem() {
		
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "Informações sobre a mensagem\n"
		   + "\tTema = " + tema + "\n"
		   + "\tTítulo = " + titulo + "\n"
		   + "\tCorpo = " + corpo + "\n"
		   + "\tRemetente = " + remetente + "\n"
		   + "\tDestinatário = " + destinatario;
	}
}
