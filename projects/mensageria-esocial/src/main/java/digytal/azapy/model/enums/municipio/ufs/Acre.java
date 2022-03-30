package digytal.azapy.model.enums.municipio.ufs;

import digytal.azapy.model.enums.municipio.Municipio;

public enum Acre implements Municipio {
	ACRELANDIA (1200013,"ACRELANDIA"),
	ASSIS_BRASIL (1200054,"ASSIS BRASIL"),
	BRASILEIA (1200104,"BRASILEIA"),
	BUJARI (1200138,"BUJARI"),
	CAPIXABA (1200179,"CAPIXABA"),
	CRUZEIRO_DO_SUL (1200203,"CRUZEIRO DO SUL"),
	EPITACIOLANDIA (1200252,"EPITACIOLANDIA"),
	FEIJO (1200302,"FEIJO"),
	JORDAO (1200328,"JORDAO"),
	MANCIO_LIMA (1200336,"MANCIO LIMA"),
	MANOEL_URBANO (1200344,"MANOEL URBANO"),
	MARECHAL_THAUMATURGO (1200351,"MARECHAL THAUMATURGO"),
	PLACIDO_DE_CASTRO (1200385,"PLACIDO DE CASTRO"),
	PORTO_ACRE (1200807,"PORTO ACRE"),
	PORTO_WALTER (1200393,"PORTO WALTER"),
	RIO_BRANCO (1200401,"RIO BRANCO"),
	RODRIGUES_ALVES (1200427,"RODRIGUES ALVES"),
	SANTA_ROSA_DO_PURUS (1200435,"SANTA ROSA DO PURUS"),
	SENA_MADUREIRA (1200500,"SENA MADUREIRA"),
	SENADOR_GUIOMARD (1200450,"SENADOR GUIOMARD"),
	TARAUACA (1200609,"TARAUACA"),
	XAPURI (1200708,"XAPURI"),
	;
	private Integer codigo;
	private String nome;
	private Acre(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getEstado() {
		return "ACRE";
	}
	public String getSigla() {
		return "AC";
	}
	public Integer getUf() {
		return 12;
	}
	@Override
	public Integer getIbge() {
		return Integer.valueOf(codigo);
	}
	

}
