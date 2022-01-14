package com.digytal.open.util;


import static com.digytal.open.util.DataHora.*;import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Calendario implements DataHoraConstants {
    public static final int ADICIONAR=1;
    public static final int ROLAR=2;
    public static final int SUBTRAIR =3;
    public static Calendar calendario(int dia, int mes, int ano, int hora, int minuto, int segundo){
        Calendar calendar = new GregorianCalendar(ano,mes-1, dia, hora,minuto, segundo);
        return calendar;
    }
    public static Calendar calendario(int dia, int mes, int ano){
        return calendario(dia,mes,ano,0,0,0);
    }
    public static Date dataHora(int dia, int mes, int ano, int hora, int minuto, int segundo){
        return calendario(dia,mes,ano,hora,minuto,segundo).getTime();
    }
    public static Date data(int dia, int mes, int ano){
        return dataHora(dia,mes,ano,0,0,0);
    }
    public static Date calcular(Date data, int operacao, int campo, int valor){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        if(operacao == ADICIONAR)
            calendar.add(campo,valor);
        else if(operacao == ROLAR)
            calendar.roll(campo,valor);
        else if(operacao == SUBTRAIR)
            calendar.add(campo,valor*-1);

        return calendar.getTime();
    }
    public static Date adicionar(Date data,int campo, int valor){
        return calcular(data,ADICIONAR,campo,valor);
    }
    public static Date adicionarDia(Date data,int valor){
        return adicionar(data,DIA,valor);
    }
    public static Date adicionarMes(Date data,int valor){
        return adicionar(data,MES,valor);
    }
    public static Date adicionarAno(Date data,int valor){
        return adicionar(data,ANO,valor);
    }
    public static Date adicionarHora(Date data,int valor){
        return adicionar(data,HORA,valor);
    }
    public static Date adicionarMinuto(Date data,int valor){
        return adicionar(data,MINUTO,valor);
    }
    public static Date adicionarSegundo(Date data,int valor){
        return adicionar(data,SEGUNDO,valor);
    }
    public static Date rolar(Date data,int campo, int valor){
        return calcular(data,ROLAR,campo,valor);
    }
    public static Date rolarMes(Date data,int valor){
        return calcular(data,ROLAR,MES,valor);
    }
    public static Date subtrair(Date data,int campo, int valor){
        return calcular(data,SUBTRAIR,campo,valor);
    }
    public static Date subtrairDia(Date data,int valor){
        return subtrair(data,DIA,valor);
    }
    public static Date subtrairMes(Date data,int valor){
        return subtrair(data,MES,valor);
    }
    public static Date subtrairAno(Date data,int valor){
        return subtrair(data,ANO,valor);
    }
    public static Date subtrairHora(Date data,int valor){
        return subtrair(data,HORA,valor);
    }
    public static Date subtrairMinuto(Date data,int valor){
        return subtrair(data,MINUTO,valor);
    }
    public static Date subtrairSegundo(Date data,int valor){
        return subtrair(data,SEGUNDO,valor);
    }
    
    public static Date diaInicio(){
    	return diaInicio(null);
    }
    public static Date diaFim(){
    	return diaFim(null);
    }
    public static Date diaInicio(Date dataHora){
        return diaInicio(dataHora, 0);
    }
    public static Date diaInicio(int dia){
        return diaInicio(null, dia);
    }
    public static Date diaInicio(Date dataHora, int dia){
        return diaInicioFim(dataHora, dia, 0, 0, 0, 0);
    }
    public static Date diaFim(Date dataHora){
        return diaFim(dataHora, 0);
    }
    public static Date diaFim(int dia){
        return diaFim(null, dia);
    }
    public static Date semana(){
    	return semana(new Date());
    }
    public static Date semana(Date dataHora){
        int sete = DataHora.dia(dataHora) + 7;
    	return diaFim(dataHora, sete);
    }
    public static Date diaFim(Date dataHora, int dia){
        return diaInicioFim(dataHora, dia, 23,59,59, 999);
    }
    private static Date diaInicioFim(Date dataHora, int dia, int hora, int minuto, int segundo,int milisegundo){
        Calendar instance = Calendar.getInstance();
        if(dataHora!=null)
        	instance.setTime(dataHora);
        if(dia>0)
        	instance.set(Calendar.DAY_OF_MONTH, dia);
        instance.set(Calendar.HOUR_OF_DAY, hora);
        instance.set(Calendar.MINUTE, minuto);
        instance.set(Calendar.SECOND, segundo);
        instance.set(Calendar.MILLISECOND, milisegundo);
        return instance.getTime();
    }

}
