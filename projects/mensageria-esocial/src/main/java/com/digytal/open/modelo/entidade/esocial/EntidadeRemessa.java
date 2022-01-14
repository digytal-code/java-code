package com.digytal.open.modelo.entidade.esocial;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.digytal.open.modelo.entidade.comum.Entidade;
import com.digytal.open.modelo.enums.esocial.RemessaStatus;
import com.digytal.open.modelo.enums.esocial.TipoEvento;

@Entity
@Table(name="tb_esocial_remessa")
public class EntidadeRemessa extends Entidade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_remessa")
	private Long id;
	@Column(length=50,nullable=false)
	private String nome;
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private TipoEvento tipo;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dthr_recepcao",nullable=false)
	private Date dataHoraRecepcao;
	@Column(nullable=false,name="fl_excluido")
	private boolean excluida;
	@Column(nullable=false,name="fl_lote_automatico")
	private boolean loteAutomatico;
	@OneToMany(mappedBy="remessa", cascade=CascadeType.PERSIST)
	private List<EntidadeLote> lotes;
	@Column(name="nr_lotes",nullable=false)
	private Integer numeroLotes;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false,length=30)
	private RemessaStatus status;
	public EntidadeRemessa() {
		this.status=RemessaStatus.NOVA;
		this.dataHoraRecepcao=new Date();
		this.lotes = new ArrayList<EntidadeLote>();
	}
	public RemessaStatus getStatus() {
		return status;
	}
	public void setStatus(RemessaStatus status) {
		this.status = status;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isExcluida() {
		return excluida;
	}
	public void setExcluida(boolean excluida) {
		this.excluida = excluida;
	}
	public Long getId() {
		return id;
	}
	public boolean isLoteAutomatico() {
		return loteAutomatico;
	}
	public void setLoteAutomatico(boolean loteAutomatico) {
		this.loteAutomatico = loteAutomatico;
	}
	public void addLote(EntidadeLote lote) {
		lote.setRemessa(this);
		lotes.add(lote);
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public EntidadeLote getUltimoLote() {
		return lotes.get(lotes.size()-1);
	}
	@PrePersist
	private void prePersist() {
		this.numeroLotes=lotes.size();
	}
	public Date getDataHoraRecepcao() {
		return dataHoraRecepcao;
	}
	public void setDataHoraRecepcao(Date dataHoraRecepcao) {
		this.dataHoraRecepcao = dataHoraRecepcao;
	}
	public Integer getNumeroLotes() {
		return numeroLotes;
	}
	
}
