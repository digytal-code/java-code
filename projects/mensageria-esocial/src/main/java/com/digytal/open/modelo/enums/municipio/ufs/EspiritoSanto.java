package com.digytal.open.modelo.enums.municipio.ufs;

import com.digytal.open.modelo.enums.municipio.Municipio;

public enum EspiritoSanto implements Municipio {
	AFONSO_CLAUDIO (3200102,"AFONSO CLAUDIO"),
	AGUA_DOCE_DO_NORTE (3200169,"AGUA DOCE DO NORTE"),
	AGUIA_BRANCA (3200136,"AGUIA BRANCA"),
	ALEGRE (3200201,"ALEGRE"),
	ALFREDO_CHAVES (3200300,"ALFREDO CHAVES"),
	ALTO_RIO_NOVO (3200359,"ALTO RIO NOVO"),
	ANCHIETA (3200409,"ANCHIETA"),
	APIACA (3200508,"APIACA"),
	ARACRUZ (3200607,"ARACRUZ"),
	ATILIO_VIVACQUA (3200706,"ATILIO VIVACQUA"),
	BAIXO_GUANDU (3200805,"BAIXO GUANDU"),
	BARRA_DE_SAO_FRANCISCO (3200904,"BARRA DE SAO FRANCISCO"),
	BOA_ESPERANCA (3201001,"BOA ESPERANCA"),
	BOM_JESUS_DO_NORTE (3201100,"BOM JESUS DO NORTE"),
	BREJETUBA (3201159,"BREJETUBA"),
	CACHOEIRO_DE_ITAPEMIRIM (3201209,"CACHOEIRO DE ITAPEMIRIM"),
	CARIACICA (3201308,"CARIACICA"),
	CASTELO (3201407,"CASTELO"),
	COLATINA (3201506,"COLATINA"),
	CONCEICAO_DA_BARRA (3201605,"CONCEICAO DA BARRA"),
	CONCEICAO_DO_CASTELO (3201704,"CONCEICAO DO CASTELO"),
	DIVINO_DE_SAO_LOURENCO (3201803,"DIVINO DE SAO LOURENCO"),
	DOMINGOS_MARTINS (3201902,"DOMINGOS MARTINS"),
	DORES_DO_RIO_PRETO (3202009,"DORES DO RIO PRETO"),
	ECOPORANGA (3202108,"ECOPORANGA"),
	FUNDAO (3202207,"FUNDAO"),
	GOVERNADOR_LINDENBERG (3202256,"GOVERNADOR LINDENBERG"),
	GUACUI (3202306,"GUACUI"),
	GUARAPARI (3202405,"GUARAPARI"),
	IBATIBA (3202454,"IBATIBA"),
	IBIRACU (3202504,"IBIRACU"),
	IBITIRAMA (3202553,"IBITIRAMA"),
	ICONHA (3202603,"ICONHA"),
	IRUPI (3202652,"IRUPI"),
	ITAGUACU (3202702,"ITAGUACU"),
	ITAPEMIRIM (3202801,"ITAPEMIRIM"),
	ITARANA (3202900,"ITARANA"),
	IUNA (3203007,"IUNA"),
	JAGUARE (3203056,"JAGUARE"),
	JERONIMO_MONTEIRO (3203106,"JERONIMO MONTEIRO"),
	JOAO_NEIVA (3203130,"JOAO NEIVA"),
	LARANJA_DA_TERRA (3203163,"LARANJA DA TERRA"),
	LINHARES (3203205,"LINHARES"),
	MANTENOPOLIS (3203304,"MANTENOPOLIS"),
	MARATAIZES (3203320,"MARATAIZES"),
	MARECHAL_FLORIANO (3203346,"MARECHAL FLORIANO"),
	MARILANDIA (3203353,"MARILANDIA"),
	MIMOSO_DO_SUL (3203403,"MIMOSO DO SUL"),
	MONTANHA (3203502,"MONTANHA"),
	MUCURICI (3203601,"MUCURICI"),
	MUNIZ_FREIRE (3203700,"MUNIZ FREIRE"),
	MUQUI (3203809,"MUQUI"),
	NOVA_VENECIA (3203908,"NOVA VENECIA"),
	PANCAS (3204005,"PANCAS"),
	PEDRO_CANARIO (3204054,"PEDRO CANARIO"),
	PINHEIROS (3204104,"PINHEIROS"),
	PIUMA (3204203,"PIUMA"),
	PONTO_BELO (3204252,"PONTO BELO"),
	PRESIDENTE_KENNEDY (3204302,"PRESIDENTE KENNEDY"),
	RIO_BANANAL (3204351,"RIO BANANAL"),
	RIO_NOVO_DO_SUL (3204401,"RIO NOVO DO SUL"),
	SANTA_LEOPOLDINA (3204500,"SANTA LEOPOLDINA"),
	SANTA_MARIA_DE_JETIBA (3204559,"SANTA MARIA DE JETIBA"),
	SANTA_TERESA (3204609,"SANTA TERESA"),
	SAO_DOMINGOS_DO_NORTE (3204658,"SAO DOMINGOS DO NORTE"),
	SAO_GABRIEL_DA_PALHA (3204708,"SAO GABRIEL DA PALHA"),
	SAO_JOSE_DO_CALCADO (3204807,"SAO JOSE DO CALCADO"),
	SAO_MATEUS (3204906,"SAO MATEUS"),
	SAO_ROQUE_DO_CANAA (3204955,"SAO ROQUE DO CANAA"),
	SERRA (3205002,"SERRA"),
	SOORETAMA (3205010,"SOORETAMA"),
	VARGEM_ALTA (3205036,"VARGEM ALTA"),
	VENDA_NOVA_DO_IMIGRANTE (3205069,"VENDA NOVA DO IMIGRANTE"),
	VIANA (3205101,"VIANA"),
	VILA_PAVAO (3205150,"VILA PAVAO"),
	VILA_VALERIO (3205176,"VILA VALERIO"),
	VILA_VELHA (3205200,"VILA VELHA"),
	VITORIA (3205309,"VITORIA"),

	;
	private Integer codigo;
	private String nome;
	private EspiritoSanto(Integer codigo, String nome) {
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
		return "ESPIRITO SANTO";
	}
	public String getSigla() {
		return "ES";
	}
	public Integer getUf() {
		return 32;
	}
	@Override
	public Integer getIbge() {
		return Integer.valueOf(codigo);
	}
}
