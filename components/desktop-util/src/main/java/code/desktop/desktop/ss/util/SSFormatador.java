package code.desktop.desktop.ss.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SSFormatador {
    
    public static String extenso(Number numero) {
        String res = extensoMonetario(numero);
        res = res.replace(" reais", "");
        return res;
    }
    
    public static String extensoMonetario(Number numero) {
        if (numero == null)
            return null;
        
        SSExtenso ex;
        if (numero instanceof BigDecimal)
          ex = new SSExtenso((BigDecimal)numero);
        else
          ex = new SSExtenso(numero.doubleValue());
        return ex.toString();
    }
    
    public static String formatarPeriodo(Integer periodo) {
        if (periodo.toString().length() == 4) //Somente ano
            return periodo.toString();
        else
            return formatarPeriodo(periodo, "MM/yyyy");
    }
    
    public static String formatarCep(Integer cep) {
        if (cep == null)
            return null;
        else
            return formatarCep(formatar(cep, "00000000"));
    }
    
    public static String formatarCep(String cep) {
        String textoCep = SSTexto.retiraSeparadores(cep);
        return SSTexto.aplicaMascara(textoCep, "##.###-###");
    }
    public static String formatarPeriodo(Integer periodo, String formato) {
        Date data;

        try {
            if (periodo == null)
                return null;
            if (periodo.equals(0))
                return "0";
            if (periodo.toString().length() > 4)
                data = SSConversao.data(periodo.toString(), "yyyyMM");
            else
                data = SSConversao.data(periodo.toString(), "yyyy");
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao converter o período em data", e);
        }
        
        return formatar(data, formato);
    }
    
    public static String formatarPeriodo(String periodo) {
        String periodoFormatado = String.valueOf(periodo);
        if (periodoFormatado.length() > 4)
            periodoFormatado = periodo.substring(0,2) + "/" + periodo.substring(2,6);
        return periodoFormatado;
    }
    public static String formatarData(Date dataHora) {
    	return formatar(dataHora,"dd/MM/yyyy");
    }
    public static String formatar(Date dataHora, String formato) {
        if (dataHora == null)
            return null;
        else {
            SimpleDateFormat formatador = new SimpleDateFormat(formato);
            return formatador.format(dataHora);
        }
    }
    
    public static String formatar(Number numero, String formato) {
        if (numero == null)
            return null;
        else {
            NumberFormat formatador = new DecimalFormat(formato);
            return formatador.format(numero);
        }
    }
    
    public static String formatar(String texto, String formato) {
        if (texto == null)
            return null;
        else {
            if (formato.equals(">"))
                return texto.toUpperCase();
            else if (formato.equals("<"))
                return texto.toLowerCase();
            else
                return SSTexto.aplicaMascara(texto, formato);
        }
    }
    
    public static String formatar(long numero) {
        return formatar(numero, "#,##0");
    }
    
    public static String formatar(double numero) {
        return formatar(numero, "#,##0.00");
    }
    
    public static String formatar(BigDecimal numero) {
        return formatar(numero, "#,##0.00");
    }
    
    public static String formatarCpf(Long cpf) {
        String textoCpf = SSTexto.complementaEsquerda(cpf.toString(), 11, "0");
        return formatarCpf(textoCpf);
    }
    
    public static String formatarCpf(String cpf) {        
        return SSTexto.aplicaMascara(cpf, "###.###.###-##");
    }
    
    public static String formatarCnpj(String cnpj) {        
        if (cnpj.length() ==12 ){
            cnpj =    "00" +  cnpj;
        }
        if (cnpj.length() ==13 ){
            cnpj =    "0" +  cnpj;
        }
        return SSTexto.aplicaMascara(cnpj, "##.###.###/####-##");
    }
    
    public static String formatarCnpj(Long cnpj) {
        String textoCpf = SSTexto.complementaEsquerda(cnpj.toString(), 14, "0");
        return formatarCnpj(textoCpf);
    }
    
    public static String formatarCpfCnpj(Long cpfCnpj) {
        if (cpfCnpj.toString().length() > 11)
            return formatarCnpj(cpfCnpj);
        else {
            String cpf = SSTexto.complementaEsquerda(cpfCnpj.toString(), 11, "0");
            if (cpf.length()<14)
                return formatarCpf(cpfCnpj);
            else
                return formatarCnpj(cpfCnpj);
        }
    }
    
    public static String formatarCpfCnpj(String cpfCnpj) {
        if (cpfCnpj.toString().length() > 11)
            return formatarCnpj(cpfCnpj);
        else             
            return formatarCpf(cpfCnpj);            
    }

    public static String formatarTelefone(String telefone){
        if (telefone == null)
            return null;
        return SSTexto.aplicaMascara(telefone, "(##)####-####");
    }
    public static String formatarCelular(String celular){
        if (celular == null)
            return null;
        celular = SSTexto.retiraSeparadores(celular);
        return SSTexto.aplicaMascara(celular, "(##)#####-####");
    }
    public static String formatarFoneCelular(String telefone){
        if (telefone == null)
            return null;
        if(telefone.trim().length()<10)
            return null;
        if(telefone.trim().length()>10)
            return formatarCelular(telefone);
        else
            return formatarTelefone(telefone);
    }
    
}
