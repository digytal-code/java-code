package com.digytal.open.modelo.entidade.esocial;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.digytal.open.modelo.enums.esocial.LoteStatus;

@Entity
@Table(name="tb_esocial_lote")
@NamedEntityGraph(name = "graph.lote.eventos", 
attributeNodes = @NamedAttributeNode("eventos"))
public class EntidadeLote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_lote")
	private Long id;
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private LoteStatus status;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_remessa",nullable=false)
	private EntidadeRemessa remessa;
	@OneToMany(mappedBy="lote", cascade=CascadeType.ALL)
	private List<EntidadeEvento> eventos;
	@Column(name="nr_eventos",nullable=false)
	private Integer numeroEventos;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "cd_lote_xml", referencedColumnName = "id_lote_xml")
	private EntidadeLoteXml xml;
	@Embedded
	private LoteTransmissao transmissao;
	public EntidadeLote() {
		this.status=LoteStatus.NOVO;
		this.eventos = new ArrayList<EntidadeEvento>();
		this.transmissao=new LoteTransmissao();
	}
	public LoteTransmissao getTransmissao() {
		return transmissao;
	}
	public List<EntidadeEvento> getEventos() {
		return eventos;
	}
	public void addEvento(String conteudo) {
		EntidadeEvento evento = new EntidadeEvento();
		evento.addXml(conteudo);
		evento.setLote(this);
		eventos.add(evento);
	}
	public void setRemessa(EntidadeRemessa remessa) {
		this.remessa = remessa;
	}
	public LoteStatus getStatus() {
		return status;
	}
	public void setStatus(LoteStatus status) {
		this.status = status;
	}
	@PrePersist
	private void prePersist() {
		this.numeroEventos=eventos.size();
	}
	public Long getId() {
		return id;
	}
	public void addXml(String conteudo) {
		EntidadeLoteXml xml = new EntidadeLoteXml();
		xml.setConteudo(conteudo);
		xml.setLote(this);
		this.xml=xml;
	}
	public EntidadeLoteXml getXml() {
		return xml;
	}
	public void setTransmissao(LoteTransmissao transmissao) {
		this.transmissao = transmissao;
	}
	public Integer getNumeroEventos() {
		return numeroEventos;
	}
	
	
}
