package com.digytal.open.util;

public class Filtro {
	private String campo;
    private String operador;
    private Object valor;
    private String juncao;
    private boolean ordem;
    private boolean todos;
    private boolean expressao;
    public Filtro() {
   
    }
    public void setExpressao(boolean expressao) {
		this.expressao = expressao;
	}
    public boolean isExpressao() {
		return expressao;
	}
    public void setTodos(boolean todos) {
        this.todos = todos;
    }

    public boolean isTodos() {
        return todos;
    }

    public boolean isOrdem() {
        return ordem;
    }
    public void setOrdem(boolean ordem) {
        this.ordem = ordem;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setJuncao(String juncao) {
        this.juncao = juncao;
    }
    public String getCampo() {
        return campo;
    }

    public String getParametro() {
    	String sufixo = Texto.caso(operador, Filtros.ORDEM,"og",Filtros.IGUAL,"i",Filtros.PARECIDO,"p",Filtros.MAIOR_IGUAL,"mi",Filtros.MENOR_IGUAL,"im");
        return sufixo + campo.replaceAll("[\\.]", "");
    }

    public String getOperador() {
        return operador;
    }

    public Object getValor() {
        return valor;
    }

    public String getJuncao() {
        return juncao;
    }
	@Override
	public String toString() {
		return "Filtro [juncao=" + juncao + ", campo=" + campo + ", operador=" + operador + ", valor=" + valor
				+ ", ordem=" + ordem + "]";
	}
	
	
}
