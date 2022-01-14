package com.digytal.open.modelo.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.digytal.open.modelo.enums.municipio.Pais;

@Embeddable
public class Cidade {
	@Column(name="end_cd_ibge", length=8)
	private Integer ibge;
	@Column(name="end_cidade",length=60)
	private String nome;
	@Column(name="end_estado",length=60)
	private String estado;
	@Column(name="end_uf",length=4)
	private Integer uf;
	@Column(name="end_pais",length=60)
	private String pais;
	public Cidade() {
		this.pais=Pais.BRASIL.name();
	}
	public Integer getIbge() {
		return ibge;
	}
	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getUf() {
		return uf;
	}
	public void setUf(Integer uf) {
		this.uf = uf;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
