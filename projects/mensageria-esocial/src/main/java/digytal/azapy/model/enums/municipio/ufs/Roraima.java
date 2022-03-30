package digytal.azapy.model.enums.municipio.ufs;

import digytal.azapy.model.enums.municipio.Municipio;

public enum Roraima implements Municipio {
	ALTO_ALEGRE (1400050,"ALTO ALEGRE"),
	AMAJARI (1400027,"AMAJARI"),
	BOA_VISTA (1400100,"BOA VISTA"),
	BONFIM (1400159,"BONFIM"),
	CANTA (1400175,"CANTA"),
	CARACARAI (1400209,"CARACARAI"),
	CAROEBE (1400233,"CAROEBE"),
	IRACEMA (1400282,"IRACEMA"),
	MUCAJAI (1400308,"MUCAJAI"),
	NORMANDIA (1400407,"NORMANDIA"),
	PACARAIMA (1400456,"PACARAIMA"),
	RORAINOPOLIS (1400472,"RORAINOPOLIS"),
	SAO_JOAO_DA_BALIZA (1400506,"SAO JOAO DA BALIZA"),
	SAO_LUIZ (1400605,"SAO LUIZ"),
	UIRAMUTA (1400704,"UIRAMUTA"),

	;
	private Integer codigo;
	private String nome;
	private Roraima(Integer codigo, String nome) {
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
		return "RORAIMA";
	}
	public String getSigla() {
		return "RR";
	}
	public Integer getUf() {
		return 14;
	}
	@Override
	public Integer getIbge() {
		return Integer.valueOf(codigo);
	}
}
