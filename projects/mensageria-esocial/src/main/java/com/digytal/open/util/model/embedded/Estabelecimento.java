package com.digytal.open.util.model.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Estabelecimento {
	@Column(name="cd_filial",nullable=false)
	private Long id;
	@Column(name="cd_matriz",nullable=false)
	private Long matriz;
	@Transient
	private String cpfCnpj;
	@Transient
	private String nome;
	public Estabelecimento() {
		this.id=0l;
		this.matriz=0l;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMatriz() {
		return matriz;
	}
	public void setMatriz(Long matriz) {
		this.matriz = matriz;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

		
}
