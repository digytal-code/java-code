package com.digytal.open.util.model;

import java.util.Date;

import com.digytal.open.util.Texto;
import com.digytal.open.util.model.embedded.Estabelecimento;

public class Sessao {
	private Usuario usuario;
	private Estabelecimento estabelecimento;
	private Date expiracao;
	private String token;
	private String ambiente;
	private String profile;
	private String versao;
	public static String KEY="sessao";
	public Sessao() {
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setExpiracao(Date expiracao) {
		this.expiracao = expiracao;
	}
	public Date getExpiracao() {
		return expiracao;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento empresa) {
		this.estabelecimento = empresa;
	}
	public Long getMatriz() {
		return estabelecimento.getMatriz();
	}
	public Long getFilial() {
		return estabelecimento.getId();
	}
}
