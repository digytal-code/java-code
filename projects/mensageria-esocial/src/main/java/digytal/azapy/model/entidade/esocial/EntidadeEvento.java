package digytal.azapy.model.entidade.esocial;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//TODO:VALIDAR STATUS PARA ENVIO
@Entity
@Table(name="tb_esocial_evento")
public class EntidadeEvento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_evento")
	private Long id;
	@Column(name="esocial_id",length=60)
	private String esocialId;
	@Column(name="esocial_recibo",length=60)
	private String recibo;
	@Column(name="esocial_hash",length=60)
	private String hash;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cd_lote",nullable=false)
	private EntidadeLote lote;
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "cd_evento_xml", referencedColumnName = "id_evento_xml")
	private EntidadeEventoXml xml;
	@Transient
	private Map<Integer,String> ocorrecias;
	public EntidadeEvento() {
		this.esocialId="";
		this.hash="";
		this.recibo="";
	}
	public String getEsocialId() {
		return esocialId;
	}
	public void setEsocialId(String esocialId) {
		this.esocialId = esocialId;
	}
	
	public EntidadeLote getLote() {
		return lote;
	}
	public void setLote(EntidadeLote lote) {
		this.lote = lote;
	}
	public EntidadeEventoXml getXml() {
		return xml;
	}
	public Long getId() {
		return id;
	}
	public void addXml(String conteudo) {
		EntidadeEventoXml xml = new EntidadeEventoXml();
		xml.setConteudo(conteudo);
		xml.setEvento(this);
		this.xml=xml;
	}
	public String getRecibo() {
		return recibo;
	}
	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public void setOcorrecias(Map<Integer, String> ocorrecias) {
		this.ocorrecias = ocorrecias;
	}
	public Map<Integer, String> getOcorrecias() {
		return ocorrecias;
	}
	
}
