package com.digytal.open.modelo.embeddable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.digytal.open.modelo.enums.LocalEndereco;

@Embeddable
public class Endereco {
	@Column(name="end_cep",length=10)
	private String cep;
	@Column(name="end_nome",length=60)
	private String nome;
	@Column(name="end_numero",length=5)
	private String numero;
	@Column(name="end_compl",length=60)
	private String complemento;
	@Column(name="end_telefone",length=20)
	private String telefone;
	@Enumerated(EnumType.STRING)
	@Column(name="end_local",length=10)
	private LocalEndereco local;
	@Column(name="end_bairro",length=40)
	private String bairro;
	@Column(name="end_cd_logradouro",length=8)
	private Integer logradouro;

	@Embedded
	private Cidade cidade;
	public Endereco(){
	    cidade = new Cidade();
    	local=LocalEndereco.C;
    }

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone1(String telefone) {
		this.telefone = telefone;
	}

	public LocalEndereco getLocal() {
		return local;
	}

	public void setLocal(LocalEndereco local) {
		this.local = local;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Integer logradouro) {
		this.logradouro = logradouro;
	}
	
    
	/*
	public void setFone2(String fone2) {
		if(fone2!=null) {
			String foneTemp = fone2.replaceAll("[-)(\\s]", "");
			if(foneTemp.trim().length() >0)
				this.fone2 = fone2;
		}else
			this.fone2 = null;
	}
	*/
}