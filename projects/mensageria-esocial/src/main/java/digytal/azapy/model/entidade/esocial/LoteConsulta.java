package digytal.azapy.model.entidade.esocial;

import java.util.ArrayList;
import java.util.List;

public class LoteConsulta {
	private String xml; 
	private List<LoteEventoConsulta> eventos;
	public LoteConsulta() {
		this.eventos=new ArrayList<LoteEventoConsulta>();
	}
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public List<LoteEventoConsulta> getEventos() {
		return eventos;
	}
	public void setEventos(List<LoteEventoConsulta> eventos) {
		this.eventos = eventos;
	}
	
}
