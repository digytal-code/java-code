package digytal.azapy.model.enums.municipio;

import digytal.azapy.model.enums.Enumeracao;

public interface Municipio extends Enumeracao {
	String getEstado();
	String getSigla();
	Integer getUf();
	Integer getIbge();
}
