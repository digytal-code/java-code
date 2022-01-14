package com.digytal.open.modelo.esocial.processamento.evento.retorno;

import com.digytal.open.modelo.esocial.processamento.evento.Evento;

public class TOcorrencia {
    private short tipo;
    private int codigo;
    private String descricao;
    private String localizacao;
    
    private Evento evento;
    public short getTipo() {
        return tipo;
    }

    public void setTipo(short value) {
        this.tipo = value;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int value) {
        this.codigo = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String value) {
        this.localizacao = value;
    }
   
    public Evento getEvento() {
		return evento;
	}
    public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
	
}