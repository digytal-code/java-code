/*
 * DataHora.java
 *
 * Created on 13 de Setembro de 2004, 15:28
 */

package code.desktop.ss.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public  class SSDataHora {
    
    public static final int HORA = GregorianCalendar.HOUR;
    public static final int MINUTO = GregorianCalendar.MINUTE;
    public static final int SEGUNDO = GregorianCalendar.SECOND;
    public static final int DIA = GregorianCalendar.DATE;
    public static final int MES = GregorianCalendar.MONTH;
    public static final int ANO = GregorianCalendar.YEAR;
    public static final int SEMANA = GregorianCalendar.WEEK_OF_MONTH;
    

    public static final String MESES[] = new String[] {
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    public static Date ultimoDiaDoMes() {
    	return ultimoDiaDoMes(new Date());
    }
    public static Date ultimoDiaDoMes(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.set(DIA, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }
    public static Date primeiroDiaDoMes() {
    	return primeiroDiaDoMes(new Date());
    }
    public static Date primeiroDiaDoMes(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);

        calendar.set(DIA, 1);

        return calendar.getTime();
    }

    public static Date horaMinima(Date data) {
        data = SSDataHora.definir(data, SSDataHora.HORA, 0);
        data = SSDataHora.definir(data, SSDataHora.MINUTO, 0);
        data = SSDataHora.definir(data, SSDataHora.SEGUNDO, 0);
        return data;
    }

    public static Date horaMaxima(Date data) {
        data = SSDataHora.definir(data, SSDataHora.HORA, 23);
        data = SSDataHora.definir(data, SSDataHora.MINUTO, 59);
        data = SSDataHora.definir(data, SSDataHora.SEGUNDO, 59);
        return data;
    }

    public static int converterPeriodo(String periodo) {
        periodo = SSTexto.substitui(periodo, "/", "");
        if (periodo.length() > 4)
            periodo = periodo.substring(2) + periodo.substring(0, 2);
        return Integer.parseInt(periodo);
    }

    public static Date copiarHora(Date origem, Date destino) {
        Calendar calDestino = GregorianCalendar.getInstance();
        calDestino.setTime(destino);
        Calendar calOrigem = GregorianCalendar.getInstance();
        calOrigem.setTime(origem);

        calDestino.set(Calendar.HOUR_OF_DAY, calOrigem.get(Calendar.HOUR_OF_DAY));
        calDestino.set(Calendar.MINUTE, calOrigem.get(Calendar.MINUTE));
        calDestino.set(Calendar.SECOND, calOrigem.get(Calendar.SECOND));

        return calDestino.getTime();
    }

    private static int pega(Date dataHora, int item) {
        Calendar gc = GregorianCalendar.getInstance();
        gc.setTime(dataHora);
        return gc.get(item);
    }

    public static Integer pegaPeriodo(Date dataHora) {
        String periodo = pegaAno(dataHora) + "" + SSFormatador.formatar(pegaMes(dataHora), "00");
        return Integer.parseInt(periodo);
    }

    public static int pegaAno(Date dataHora) {
        return pega(dataHora, ANO);
    }

    public static int pegaMes(Date dataHora) {
        return pega(dataHora, MES) + 1;
    }

    public static int pegaDia(Date dataHora) {
        return pega(dataHora, DIA);
    }

    public static java.sql.Time horaAtual() {
        return new java.sql.Time(new Date().getTime());
    }

    public static Date dataAtual() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.AM_PM, Calendar.AM);
        Date res =  calendar.getTime();
        return res;
    }

    public static java.sql.Timestamp dataHoraAtual() {
        return new java.sql.Timestamp(new Date().getTime());
    }

    public static Date adiciona(int intervalo, int numero, Date data){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        gc.add(intervalo,  numero);
        return gc.getTime();
    }

    public static Date definir(Date data, int intervalo, int numero){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        gc.set(intervalo,  numero);
        return gc.getTime();
    }
    
    public static java.sql.Timestamp adiciona(int intervalo, int numero, java.sql.Timestamp dataHora){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(dataHora);
        gc.add(intervalo,  numero);
        return new java.sql.Timestamp(gc.getTime().getTime());
    }
    
    public static java.sql.Time adiciona(int intervalo, int numero, java.sql.Time hora){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(hora);
        gc.add(intervalo,  numero);
        return new java.sql.Time(gc.getTime().getTime());
    }
    
    public static java.sql.Date adiciona(int intervalo, int numero, java.sql.Date data){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(data);
        gc.add(intervalo,  numero);
        return new java.sql.Date(gc.getTime().getTime());
    }

    /**     
     * @param Intervalo Intervalo da diferença das datas: DataHora.DIA, DataHora.MES, DataHora.ANO
     * @param Data1 Primeira data que vai ser tirada a diferença (geralmente a data menor)
     * @param Data2 Segunda data que vai ser tirada a diferença (geralmente a data maior)
     * @return Retorna a diferença de acordo com o intervalo informado da (Data2 - Data1)
     */
    public static int diferenca(int Intervalo, Date Data1, Date Data2){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        int dif=0;
        long intervalo = 24L * 60L * 60L * 1000L;
        
        //try{
            Date d1 = Data1;
            Date d2 = Data2;
            cal1.setTime(d1); cal2.setTime(d2);
            int days1=(int)(d1.getTime()/intervalo);
            int days2=(int)(d2.getTime()/intervalo);

            int dateDiff  = days2 - days1;
            int weekOffset = (cal2.get(Calendar.DAY_OF_WEEK) - cal1.get(Calendar.DAY_OF_WEEK))<0 ? 1 : 0;
            int weekDiff  = dateDiff/7 + weekOffset;
            int yearDiff  = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
            int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);

            switch (Intervalo){
                case DIA:
                    dif = dateDiff;
                    break;
                case MES:
                    dif = monthDiff;
                    break;
                case ANO:
                    dif = yearDiff;
                    break;
                case SEMANA:
                    dif = weekDiff;
                    break;
            }

        //}catch(Exception e){
        //    System.out.println("Erro em DateDif: " + e.toString());
        //}
        return dif;
    }
    
    public static List pegaListaDias() {
        List lista = new ArrayList();
        for (int i = 1; i <= 31; i++) {
            if (i < 10)
                lista.add("0" + i);
            else
                lista.add(String.valueOf(i));
        }
        return lista;
    }
    
    public static List pegaListaMeses() {
        List lista = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            if (i < 10)
                lista.add("0" + i);
            else
                lista.add(String.valueOf(i));
        }
        return lista;
    }
    
     
    public static Date converteParaData(String data) throws Exception {   
       /** 
           * Converte uma String para um objeto Date. Caso a String seja vazia ou nula,  
           * retorna null - para facilitar em casos onde formulários podem ter campos 
           * de datas vazios. 
           * FONTE:http://www.guj.com.br/posts/list/41935.java/
           * @param data String no formato dd/MM/yyyy a ser formatada 
           * @return Date Objeto Date ou null caso receba uma String vazia ou nula 
           * @throws Exception Caso a String esteja no formato errado 
           */
        
       if (data == null || data.equals(""))  
           return null;  
         
       Date date = null;  
       try {  
           DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
           date = formatter.parse(data);  
       } catch (ParseException e) {              
           throw e;  
       }  
       return date;  
   }  
    public String pegaMes(int mes){
        String mesNome = null;
        for (int i = 1; i < 12 ; i++){
            if (mes == i){
                
            }
        }
        return mesNome;
    }
    
    public static String nomeMes(Date data) {
        int codMes = pegaMes(data);
        return MESES[codMes - 1];
    }    
    
    public static String nomeCompletoData(Date data) {
        String dia = SSFormatador.formatar(data, "dd");
        String mes = nomeMes(data);
        Integer ano = pegaAno(data);
        
        return dia + " de " + mes + " de " + ano;
    }
}
