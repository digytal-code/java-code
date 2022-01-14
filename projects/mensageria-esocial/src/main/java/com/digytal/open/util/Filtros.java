package com.digytal.open.util;

import java.util.ArrayList;
import java.util.List;

public class Filtros {
	public static final String PARECIDO ="LIKE";
    public static final String IGUAL="=";
    public static final String MAIOR_IGUAL=">=";
    public static final String MENOR_IGUAL="<=";
    public static final String MENOR="<";
    public static final String MAIOR=">";
    
    public static final String ONDE ="WHERE";
    public static final String OU ="OR";
    public static final String E ="AND";

    public static final String ORDEM ="ORDER BY";
    
    private List<Filtro> filtros;
    private String juncao;
    private boolean expressao;
    private static Filtros instance;
    public Filtros(){
    	filtros = new ArrayList<Filtro>();
    }
    public List<Filtro> lista() {
		List<Filtro> lista = instance.filtros;
    	instance=null;
		return lista;
	} 
    public Filtro filtro() {
		Filtro filtro = instance.filtros.get(0);
    	instance=null;
		return filtro;
	} 
    
    public static Filtros igual(String campo, Object valor) {
    	return instance(campo,IGUAL,valor);
    }
    public static Filtros maiorIgual(String campo, Object valor) {
    	return instance(campo,MAIOR_IGUAL,valor);
    }
    public static Filtros menorIgual(String campo, Object valor) {
    	return instance(campo,MENOR_IGUAL,valor);
    }
    public static Filtros parecido(String campo, Object valor) {
    	return instance(campo,PARECIDO,valor);
    }
    public static Filtros e() {
    	instance.juncao=E;
    	return instance;
    }
    public static Filtros orderGroupBy(String orderGroupBy) {
    	return instance(null,ORDEM,orderGroupBy); // MUDAR PARA GRUPO
    }
    public static Filtros ou() {
    	instance.juncao=OU;
    	return instance;
    }
    private static Filtros instance(String campo,String operador, Object valor) {
    	if(instance==null) {
    		instance = new Filtros();
    		instance.juncao=ONDE;
    	}
    	boolean orderGroupBy=false;
    	if(valor!=null) {
    		orderGroupBy = valor.toString().startsWith("ORDER BY") || valor.toString().startsWith("GROUP BY");
    		instance.filtros.add(filtro(instance.juncao, campo, operador, valor,orderGroupBy,instance.expressao));
    	}
    	instance.juncao=E;
    	instance.expressao=false;
    	return instance;
    }
    public static Filtros expressao() {
    	instance.expressao=true;
    	return instance;
    }
	/*
	 * private static Filtro filtro(String juncao, String campo, String operador,
	 * Object valor,boolean order,boolean expressao) { return filtro(juncao, campo,
	 * operador,valor,false,expressao); }
	 */
   
    private static Filtro filtro(String juncao, String campo, String operador, Object valor,boolean ordem,boolean expressao){
    	Filtro filtro = new Filtro();
    	filtro.setOrdem(ordem);
    	filtro.setJuncao(juncao);
        filtro.setValor(valor);
        filtro.setOperador(operador);
        filtro.setCampo(campo);
        filtro.setExpressao(expressao);
        if(!ordem) {
	        if(PARECIDO.equals(operador)) {
	            valor="%"+ valor.toString() + "%";
	        }
	        filtro.setValor(valor);
        }
    	return filtro;
        
    }
    public static List<Filtro> filtros(String criterio){
    	System.out.println(criterio);
    	return null;
    }
}
