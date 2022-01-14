package com.digytal.open.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatador {
	public static final String DATA_BR="dd/MM/yyyy";
	public static final String DATA_ARQUIVO="yyMMdd-HHmmss";
	public static final String DATA_HORA_BR="dd/MM/yyyy";
	public static final String DATA_API="ddMMyyyy";
	public static String formatar(Date dataHora) {
    	return formatar(dataHora,DATA_BR);
    }
	public static String formatarDataArquivo(Date dataHora) {
    	return formatar(dataHora,DATA_ARQUIVO);
    }
    public static String formatarDataHora(Date dataHora) {
        return formatar(dataHora,DATA_HORA_BR);
    }
    public static String formatarDataApi(Date dataHora) {
        return formatar(dataHora,DATA_API);
    }
    public static String formatar(Number numero) {
        return formatar(numero,"#,##0.00");
    }
    public static String formatar(Object valor, String formato) {
        if (valor == null)
            return null;
        else {
            if(valor instanceof java.util.Date){
                SimpleDateFormat formatador = new SimpleDateFormat(formato);
                return formatador.format(valor);
            }else if(valor instanceof java.lang.Number){
                DecimalFormat formatador = new DecimalFormat(formato);
                return formatador.format(valor);
            }else return null;
        }
    }
}
