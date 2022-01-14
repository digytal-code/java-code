package com.digytal.open.util.api;

public class Resposta {
	private boolean sucesso;
	private int codigo;
    private String mensagem;

    public Resposta() {
    }
    
	public Resposta(int codigo, String mensagem, boolean sucesso) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
		this.sucesso = sucesso;
	}
	
	public Resposta(boolean sucesso, String mensagem) {
		super();
		this.sucesso = sucesso;
		this.mensagem = mensagem;
		this.codigo=0;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

   
}
