package com.digytal.open.modelo.entidade.esocial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_esocial_lote_xml")
public class EntidadeLoteXml {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_lote_xml")
	private Long id;
	@Column(nullable=false,length=100000)
	private String conteudo;
	@Transient
	private String resposta;
	@OneToOne(mappedBy = "xml")
    private EntidadeLote lote;
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public EntidadeLote getLote() {
		return lote;
	}
	public void setLote(EntidadeLote lote) {
		this.lote = lote;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
}
