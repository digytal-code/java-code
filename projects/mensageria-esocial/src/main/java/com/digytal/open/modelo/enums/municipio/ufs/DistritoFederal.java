package com.digytal.open.modelo.enums.municipio.ufs;

import com.digytal.open.modelo.enums.municipio.Municipio;

public enum DistritoFederal implements Municipio {
	BRASILIA (5300108,"BRASILIA"),
	;
	private Integer codigo;
	private String nome;
	private DistritoFederal(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getEstado() {
		return "DISTRITO FEDERAL";
	}
	public String getSigla() {
		return "DF";
	}
	public Integer getUf() {
		return 53;
	}
	@Override
	public Integer getIbge() {
		return Integer.valueOf(codigo);
	}

}
