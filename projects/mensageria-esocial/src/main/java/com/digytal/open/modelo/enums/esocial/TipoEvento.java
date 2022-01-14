package com.digytal.open.modelo.enums.esocial;

public enum TipoEvento {
	S1000 ("S1000", "evtInfoEmpregador" , 1, "Informações do Empregador/Contribuinte/Orgão Público"), 
	S1005 ("S1005", "evtTabEstab"       , 1, "Tabela de Estabelecimentos, Obras de Constru??o Civil ou Unidades de ?rg?os P?blicos"), 
	S1010 ("S1010", "evtTabRubrica"     , 1, "Tabela de Rubricas"), 
	S1020 ("S1020", "evtTabLotacao"     , 1, "Tabela de Lotações Tributárias"), 
	S1030 ("S1030", "evtTabCargo"       , 1, "Tabela de Cargos/Empregos P?blicos"), 
	S1035 ("S1035", "evtTabCarreira"    , 1, "Tabela de Carreiras P?blicas"), 
	S1040 ("S1040", "evtTabFuncao"      , 1, "Tabela de Funções/Cargos em Comiss?o"), 
	S1050 ("S1050", "evtTabHorTur"      , 1, "Tabela de Horários/Turnos de Trabalho"), 
	S1060 ("S1060", "evtTabAmbiente"    , 1, "Tabela de Ambientes de Trabalho"), 
	S1070 ("S1070", "evtTabProcesso"    , 1, "Tabela de Processos Administrativos/Judiciais"), 
	S1080 ("S1080", "evtTabOperPort"    , 1, "Tabela de Operadores Portu?rios"), 
	S1200 ("S1200", "evtRemun"          , 3, "Remunera??o do Trabalhador vinculado ao Regime Geral de Previd?ncia Social - RGPS"), 
	S1202 ("S1202", "evtRmnRPPS"        , 2, "Remunera??o do Trabalhador vinculado a Regime Pr?prio de Previd?ncia Social - RPPS"), 
	S1207 ("S1207", "evtBenPrRP"        , 2, "Benef?cios Previdenci?rios - RPPS"), 
	S1210 ("S1210", "evtPgtos"          , 3, "Pagamentos de Rendimentos do Trabalho"), 
	S1250 ("S1250", "evtAqProd"         , 2, "Aquisi??o de Produ??o Rural"), 
	S1260 ("S1260", "evtComProd"        , 2, "Comercializa??o da Produ??o Rural Pessoa F?sica"), 
	S1270 ("S1270", "evtContratAvNP"    , 2, "Contrata??o de Trabalhadores Avulsos N?o Portu?rios"), 
	S1280 ("S1280", "evtInfoComplPer"   , 3, "Informa??es Complementares aos Eventos Peri?dicos"), 
	S1295 ("S1295", "evtTotConting"     , 2, "Solicita??o de Totaliza??o para Pagamento em Conting?ncia"), 
	S1298 ("S1298", "evtReabreEvPer"    , 3, "Reabertura dos Eventos Periodicos"), 
	S1299 ("S1299", "evtFechaEvPer"     , 3, "Fechamento dos Eventos Periodicos"), 
	S1300 ("S1300", "evtContrSindPatr"  , 3, "Contribuição Sindical Patronal"), 
	S2190 ("S2190", "evtAdmPrelim"      , 2, "Admissão de Trabalhador - Registro Preliminar"), 
	S2200 ("S2200", "evtAdmissao"       , 2, "Admissão / Ingresso de Trabalhador"), 
	S2205 ("S2205", "evtAltCadastral"   , 2, "Alteração de Dados Cadastrais do Trabalhador"), 
	S2206 ("S2206", "evtAltContratual"  , 2, "Alteração de Contrato de Trabalho"), 
	S2210 ("S2210", "evtCAT"            , 2, "Comunica??o de Acidente de Trabalho"), 
	S2220 ("S2220", "evtMonit"          , 2, "Monitoramento da sa?de do trabalhador"), 
	S2230 ("S2230", "evtAfastTemp"      , 2, "Afastamento Tempor?rio"), 
	S2240 ("S2240", "evtExpRisco"       , 2, "Condições Ambientais do Trabalho - Fatores de Risco"), 
	S2245 ("S2245", "evtTreiCap"        , 2, "Treinamentos Capacitações Exercícios Simulados e Outras Anotações"),
	S2241 ("S2241", "evtInsApo"         , 2, "Insalubridade/Periculosidade/Aposentadoria Especial"), 
	S2250 ("S2250", "evtAvPrevio"       , 2, "Aviso Pr?vio"), 
	S2260 ("S2260", "evtConvInterm"     , 2, "Convoca??o para Trabalho Intermitente"), 
	S2298 ("S2298", "evtReintegr"       , 2, "Reintegra??o"), 
	S2299 ("S2299", "evtDeslig"         , 2, "Desligamento"), 
	S2300 ("S2300", "evtTSVInicio"      , 2, "Trabalhador Sem V?nculo de Emprego/Estatut?rio - In?cio"), 
	S2306 ("S2306", "evtTSVAltContr"    , 2, "Trabalhador Sem V?nculo de Emprego/Estatut?rio - Altera??o Contratual"), 
	S2399 ("S2399", "evtTSVTermino"     , 2, "Trabalhador Sem V?nculo de Emprego/Estatut?rio - T?rmino"), 
	S2400 ("S2400", "evtCdBenPrRP"      , 2, "Cadastro de Beneficios Previdenci?rios - RPPS"), 
	S3000 ("S3000", "evtExclusao"       , 2, "Exclus?o de Eventos"), 
	S5001 ("S5001", "evtBasesTrab"      , 2, "Informa??es das contribui??es sociais por Trabalhador"), 
	S5002 ("S5002", "evtIrrfBenef"      , 2, "Imposto de Renda Retido na Fonte por Trabalhador"), 
	S5011 ("S5011", "evtCS"             , 2, "Informa??es das contribui??es sociais consolidadas por contribuinte"), 
	S5012 ("S5012", "evtIrrf"           , 2, "Informa??es do IRRF consolidadas por Contribuinte");
	
	private String codigo;
	private String nome;
	private Integer grupo;
	private String descricao;
		
	private TipoEvento(String codigo, String nome, Integer grupo, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.grupo = grupo;
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Integer getGrupo() {
		return grupo;
	}
	public String getTag() {
		return String.format("<%s>",nome);
	}
	
}
