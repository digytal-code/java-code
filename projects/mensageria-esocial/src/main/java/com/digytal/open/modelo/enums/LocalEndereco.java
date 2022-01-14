package com.digytal.open.modelo.enums;

public enum LocalEndereco {
    C("C", "CASA"),
    A("A", "APARTAMENTO"),
    L("L", "LOJA"),;
    private String codigo;
    private String nome;
    
    private LocalEndereco(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public String getCodigo() {
		return codigo;
	}

}

