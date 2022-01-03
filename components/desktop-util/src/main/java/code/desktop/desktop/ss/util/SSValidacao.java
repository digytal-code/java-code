
package code.desktop.desktop.ss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author  Administrador
 */
public class SSValidacao {
    
    public static boolean ano(int ano) {
        if (ano < 1000 || ano > 9999)
            return false;
        return true;
    }
    
    public static boolean ano(String ano) {
        if (ano == null)
            return false;
        if (!SSValidacao.numero(ano))
            return false;
        return ano(Integer.valueOf(ano));
    }
    
    public static boolean preenchido(Object valor) {
        return !nuloOuVazio(valor);
    }
    
    public static boolean periodo(String periodo){
        try {
            if (periodo.substring(2, 3).equals("/") || periodo.substring(2, 3).equals("-"))
                periodo = periodo.substring(0,2) + periodo.substring(3);
            int ano = Integer.valueOf(periodo.substring(2));
            int mes = Integer.valueOf(periodo.substring(0,2));
            if (ano < 1000 || ano > 9999)
                return false;
            if (mes < 1 || mes > 12)
                return false;
            return true;
        }catch(Exception pe) {
            return false;
        }
    }
    
    public static boolean email(String email){
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");   
        Matcher m = p.matcher(email);   
        
        if (!m.find()) 
            return false;   
        
        return true;
    }
    
    public static boolean numero(String valor){
        if (valor == null) 
            return false;
        
        String Valor = valor.toString();
        
        Valor = SSTexto.substitui(Valor, ".", "");
        Valor = SSTexto.substitui(Valor, ",", ".");
        
        try{
            Double num = new Double(Valor);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    
    public static boolean nuloOuVazio(Object valor){
        if (nulo(valor))
            return true;
        if (valor instanceof Collection)
            return ((Collection)valor).size() == 0;
        else
            return vazio(valor.toString());
    }
    
    public static boolean vazio(String valor){
        if (valor == null)
            return true;
        if (valor.trim().length() == 0) 
            return true;
        return false;
    }
    
    public static boolean nulo(Object valor){
        if (valor == null)
            return true;
        else
            return false;
    }
    
    public static boolean hora(String valor){
        int hora, minuto, segundo;
                
        if (valor.equals("")) 
           return false;
        if (valor.length() != 5) 
           if (valor.length() != 8)
               return false;
        
        /*        
        if (digito(Texto.meio(valor, 1, 2)) == false) 
            return false;
        if (digito(Texto.meio(valor, 4, 2)) == false) 
            return false;
        if (valor.length() > 5) {
            if (digito(Texto.meio(valor, 7, 2)) == false) 
                return false;
            segundo = Conversao.inteiro(Texto.meio(valor, 7, 2));
        }
        */
        
        try{
            hora = Integer.parseInt(SSTexto.meio(valor, 1, 2));
            minuto = Integer.parseInt(SSTexto.meio(valor, 4, 2));
            segundo = 0;
            if (valor.length() > 5) 
                segundo = Integer.parseInt(SSTexto.meio(valor, 7, 2));

            if (hora > 23) 
                return false;
            if (minuto > 59) 
                return false;
            if (segundo > 59) 
                return false;
        }catch(Exception pe) {
            return false;
        }
        return true;
    }
    
    public static boolean data(String data) {
        return data(data, "dd/MM/yyyy");
    }
    
    public static boolean data(String data, String formato) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    
    private static boolean dataManual(String data){
        int ano, mes, dia;
                
        if (data.trim().equals("")) 
            return false;
        //data = Formato.data(data, "dd/MM/yyyy");

        try{
            ano = Integer.parseInt(SSTexto.meio(data, 7));
            mes = Integer.parseInt(SSTexto.meio(data, 4, 2));
            dia = Integer.parseInt(SSTexto.meio(data, 1, 2));

            if (dia <= 0) 
                return false;
            if (mes <= 0) 
                return false;
            if (dia > 31) 
                return false;
            if (mes > 12) 
                return false;
            if (ano <= 0) 
                return false;
            if (ano > 9999) 
                return false;

            int diaMes[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};

            //VERIFICA SE O DIA ESTA NO INTERVALO VALIDO PARA O MES
            if (dia > diaMes[mes]) 
                return false;

            //VERIFICA SE HA ANOS BISSEXTOS
            if (mes == 2 && dia == 29)
               if (ano % 400 != 0 || ano % 4 != 0 && ano % 100 == 0)
                   return false;
        }catch(Exception pe) {
            return false;
        }
                
        return true;
    }
    
    public static boolean dataHora(String dataHora){
        String data, hora;
        //01/05/2004 10:00:00
        //1234567890123456789
        if (dataHora.length() == 16 || dataHora.length() == 19) {
            data = SSTexto.meio(dataHora, 1, 10);
            hora = SSTexto.meio(dataHora, 12);
            
            if (data(data) && hora(hora))
                return true;             
        } 
            
        return false;
    }
    
    public static boolean digito(String valor){
        int digitos[] = {0,1,2,3,4,5,6,7,8,9};
        int i; 
        String digito = "";
        boolean encontrou = false;
        if (valor.equals("")) return false;
       
        for (int x = 0; x < valor.length(); x++) {
            digito = SSTexto.meio(valor, x + 1, 1);
            for (i = 0; i < digitos.length; i++){
                if (digito.equals(String.valueOf(digitos[i]))){
                    encontrou = true;
                    break;
                }
            }
            if (encontrou == false) 
                return false;
            else 
                encontrou = false;
        }
       return true;
    }
    
    public static boolean zerado(double valor){
        return (valor == 0.0);
    }
    
    public static boolean zerado(String valor) throws ParseException {
        return zerado(Double.parseDouble(valor));
    }
    
    public  static String gerarDigitoVerificador(String numero,Integer base ){
        
            Integer dvInsc = 0;
            //String inscricaoTemp = Texto.repete("0",12 - numero.length()) + numero ;
                   
            for (Integer i = 1 ; i <= numero.length(); i++){
                dvInsc = dvInsc + Integer.parseInt(SSTexto.meio(numero, i, 1).toString()) * (((numero.length()  - i) % (base - 1)) + 2);
            }
            dvInsc = dvInsc % 10;
            if (Integer.parseInt(numero.toString()) > 1){
                dvInsc = 10 - dvInsc;
            }else{
                dvInsc = 0;
            }
            if (dvInsc >= 10)
            dvInsc = dvInsc % 10;
            
            return dvInsc.toString();
        
    }
    
    public static void main(String[] args) {
        String data = "29/02/2012";
        System.out.println(data(data));
        System.out.println(data("28/02/2012")); 
        System.out.println(data("30/02/2012")); 
    }
    
}
