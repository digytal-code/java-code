package com.digytal.open.util.model;

public enum Sistema {
	ESOCIAL(){
		@Override
		public String descricao() {
			return "Gestão de Envio de Eventos";
		}
	},
	CFIP(){
		@Override
		public String descricao() {
			return "Controle Financeiro Pessoal";
		}
		@Override
		public String hsqlPorta() {
			return "5455";
		}
		
	},
	
	;
	public String lowercase() {
		return name().toLowerCase();
	}
	public String hsqlPorta() {
		return "5454";
	}
	public String descricao() {
		return "";
	}
}
