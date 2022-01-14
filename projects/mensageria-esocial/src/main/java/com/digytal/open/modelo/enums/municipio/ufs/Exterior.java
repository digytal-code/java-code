package com.digytal.open.modelo.enums.municipio.ufs;

import com.digytal.open.modelo.enums.municipio.Municipio;

public enum Exterior implements Municipio {
	EXTERIOR (9999999,"EXTERIOR"),
	;
	private Integer codigo;
	private String nome;
	private Exterior(Integer codigo, String nome) {
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
		return "EXTERIOR";
	}
	public String getSigla() {
		return "EX";
	}
	public Integer getUf() {
		return 0;
	}
	@Override
	public Integer getIbge() {
		return Integer.valueOf(codigo);
	}
}
