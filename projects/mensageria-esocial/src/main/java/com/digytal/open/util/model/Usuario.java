package com.digytal.open.util.model;

import java.util.ArrayList;
import java.util.List;

import com.digytal.open.util.model.embedded.Estabelecimento;

public class Usuario {
	private String cpf;
	private String login;
	private String nome;
	private String email;
	private String senha;
	private List<Estabelecimento> empresas = new ArrayList<Estabelecimento>();
	public List<Estabelecimento> getEmpresas() {
		return empresas;
	}
	public void addEmpresa(Estabelecimento empresa) {
		this.empresas.add(empresa);
	}
	public String getLogin() {
		return login;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
