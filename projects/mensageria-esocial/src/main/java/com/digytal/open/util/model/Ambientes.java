package com.digytal.open.util.model;

public enum Ambientes {
	PRODUCAO("PRODUÇÃO"),
	HOMOLOGACAO("HOMOLOGAÇÃO"),
	DESENVOLVIMENTO("DESENVOLVIMENTO");
	
	private String nome;
	private Ambientes(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
}
