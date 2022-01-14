package com.digytal.open.modelo.esocial.processamento;

import java.util.List;

import com.digytal.open.modelo.esocial.processamento.evento.Evento;

public class RetornoEventos {
	private List<Evento> evento;
	
	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	public List<Evento> getEvento() {
		return evento;
	}

}
