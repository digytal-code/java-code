package com.digytal.open.modelo.enums;
public enum TipoDocumento {
	RG("RG"),
	IE("I. Estadual"),
	CNH("CNH"),
	TE("T. Eleitor"),
	CN("C. Nascto"),
	CS("C. Casto"),
	IM("I. Municipal"),
	;
	private String nome;
	private TipoDocumento(String nome){
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
}
