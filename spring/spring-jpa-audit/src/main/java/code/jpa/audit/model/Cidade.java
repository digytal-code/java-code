package code.jpa.audit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import code.jpa.audit.infra.Auditable;

@Entity
public class Cidade implements Auditable {
	
	@Id
	private Integer id;
	
	private String nome;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Dados da cidade\n"
		     + "\tCódigo do IBGE = " + id + "\n"
		     + "\tNome = " + nome;
	}
	
}
