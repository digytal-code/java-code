package com.digytal.open.modelo.entidade.comum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_comum_emp_cert")
public class EntidadeCertificado extends Entidade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_certificado")
	private Integer id;
	@Column(length=200)
	private String pfx;
	@Column(length=200)
	private String alias;
	@Column(length=50)
	private String senha;
	@Column(length=200)
	private String cacerts;
	@Column(length=200)
	private String transmissor;
	@Column(length=50)
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPfx() {
		return pfx;
	}
	public void setPfx(String pfx) {
		this.pfx = pfx;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCacerts() {
		return cacerts;
	}
	public void setCacerts(String cacerts) {
		this.cacerts = cacerts;
	}
	public String getTransmissor() {
		return transmissor;
	}
	public void setTransmissor(String transmissor) {
		this.transmissor = transmissor;
	}
	public Integer getId() {
		return id;
	}
	
}
