package com.digytal.open.modelo.enums.municipio;

import com.digytal.open.modelo.enums.Enumeracao;

public interface Municipio extends Enumeracao {
	String getEstado();
	String getSigla();
	Integer getUf();
	Integer getIbge();
}
