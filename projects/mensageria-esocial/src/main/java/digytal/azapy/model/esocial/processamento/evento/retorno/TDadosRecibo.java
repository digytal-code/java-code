
package digytal.azapy.model.esocial.processamento.evento.retorno;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDadosRecibo", propOrder = {
    "nrRecibo",
    "hash"
})
@Embeddable
public class TDadosRecibo {

    @XmlElement
    private String nrRecibo;
    @XmlElement()
    private String hash;
    public String getNrRecibo() {
        return nrRecibo;
    }
    public void setNrRecibo(String value) {
        this.nrRecibo = value;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String value) {
        this.hash = value;
    }
	@Override
	public String toString() {
		return "TDadosRecibo [nrRecibo=" + nrRecibo + ", hash=" + hash + "]";
	}
}
