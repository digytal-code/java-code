package digytal.azapy.model.esocial.processamento.evento;

import javax.xml.bind.annotation.XmlAttribute;

import digytal.azapy.model.esocial.processamento.Tot;

public class Evento {
	private String id;
	private Boolean evtDupl;
	private RetornoEvento retornoEvento;
	private Tot tot;	
	
	@XmlAttribute(name="Id")
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getEvtDupl() {
		return evtDupl;
	}
	public void setEvtDupl(Boolean evtDupl) {
		this.evtDupl = evtDupl;
	}
	public RetornoEvento getRetornoEvento() {
		return retornoEvento;
	}
	public void setRetornoEvento(RetornoEvento retornoEvento) {
		this.retornoEvento = retornoEvento;
	}
	public Tot getTot() {
		return tot;
	}
	public void setTot(Tot tot) {
		this.tot = tot;
	}
	public String getId() {
		return id;
	}
	
}
