package com.digytal.open.modelo.entidade.esocial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_esocial_evento_xml")
public class EntidadeEventoXml {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_evento_xml")
	private Long id;
	@Column(nullable=false,length=100000)
	private String conteudo;
	@OneToOne(mappedBy = "xml")
    private EntidadeEvento evento;
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public EntidadeEvento getEvento() {
		return evento;
	}
	public void setEvento(EntidadeEvento evento) {
		this.evento = evento;
	}
	public Long getId() {
		return id;
	}
	
}
