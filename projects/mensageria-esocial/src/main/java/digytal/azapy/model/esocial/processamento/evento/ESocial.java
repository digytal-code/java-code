
package digytal.azapy.model.esocial.processamento.evento;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.xml.bind.annotation.XmlRootElement;

import digytal.azapy.model.esocial.processamento.evento.retorno.TRetornoEvento;

@XmlRootElement(name = "eSocial")
@Embeddable
public class ESocial {
	@Embedded
	private TRetornoEvento retornoEvento;
	public TRetornoEvento getRetornoEvento() {
		return retornoEvento;
	}
	public void setRetornoEvento(TRetornoEvento retornoEvento) {
		this.retornoEvento = retornoEvento;
	}
}
