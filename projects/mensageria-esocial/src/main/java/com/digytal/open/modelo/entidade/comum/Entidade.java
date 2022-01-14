package com.digytal.open.modelo.entidade.comum;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.digytal.open.util.model.embedded.Estabelecimento;

//https://www.baeldung.com/database-auditing-jpa
@MappedSuperclass
public abstract class Entidade implements Serializable {
	protected Estabelecimento estabelecimento;
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}
