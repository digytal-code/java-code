/*
o * Created on 01/09/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package java.code.desktop.desktop.ss.util;

import java.util.Random;

/**
 * @author Administrador
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SSTexto  {
    
    private static String getValueMaskFormat(String pMask, String pValue, boolean pReturnValueEmpty){   
      
        /*  
         * Verifica se se foi configurado para nao retornar a    
         * mascara se a string for nulo ou vazia se nao  
         * retorna somente a mascara.  
         */   
        if (pReturnValueEmpty == true   
                && (pValue == null || pValue.trim().equals("")))   
            return "";   
      
        /*  
         * Substituir as mascaras passadas como  9, X, * por # para efetuar a formatcao  
         */   
        pMask = pMask.replaceAll("[*]", "#");   
        pMask = pMask.replaceAll("[9]", "#");   
        pMask = pMask.toUpperCase().replaceAll("[X]", "#");   
      
        /*  
         * Formata valor com a mascara passada    
         */   
        int i;
        int ultimaPosicaoSubstituida = -1;
        for(i = 0; i < pValue.length(); i++){   
            ultimaPosicaoSubstituida = pMask.indexOf("#");
            pMask = pMask.replaceFirst("#", pValue.substring(i, i + 1));   
        }   
      
        /*  
         * Subistitui por string vazia os digitos restantes da mascara  
         * quando o valor passado e menor que a mascara    
         */   
        //return pMask.replaceAll("#", "");   
        return pMask.substring(0, ultimaPosicaoSubstituida + 1);
    }  
    
    public static String aplicaMascara(String texto, String mascara) {
        return getValueMaskFormat(mascara, texto, false);
    }
    
    public static String retiraSeparadores(String texto) {
        String retorno;
        
        retorno = texto.replaceAll("[)(.,/,-]", "");
                
        return retorno;
    }
    
    /*
     * Retira acentos de uma string
     * Exemplo: 'Açúcar' retorna 'Acucar'
     */
    public static String retirarAcentos(String str) {            
        String temp = null;
        //temp = sun.text.Normalizer.normalize(str, sun.text.Normalizer.DECOMP, 0);
        temp = java.text.Normalizer.normalize(str, java.text.Normalizer.Form.NFD);
        temp = temp.replaceAll("[^\\p{ASCII}]", "");
        return temp;
    }
     
    /**
     * Retorna uma string com barras invertidas antes de caracteres que precisam 
     * ser escapados para serem escapados em query a banco de dados, etc. 
     * Estes caracteres sao aspas simples ('), aspas duplas ("), 
     * barra invertida (\) e NUL (o byte NULL).
     */
    public static String barraCaracteresEspeciais(String valor) {
        String retorno = valor;
        //SUSTITUI BARRAS
        String s = retorno, f = "\\", r = f + f;
        int index01 = s.indexOf( f );
        while (index01 != -1) {
            s = s.substring(0,index01) + r + s.substring(index01+f.length());
            index01 += r.length();
            index01 = s.indexOf( f, index01 );
        }
        retorno = s;
        //SUBSTITUI ASPAS SIMPLES
        retorno = substitui(retorno, "'", "\\\\'");
        //SUBSTITUI ASPAS DUPLAS
        retorno = substitui(retorno, "\"", "\\\\\"");
        return retorno;
    }
        
    public static String primeiraPalavra(String texto) {
        if (texto.trim().equals(""))
            return "";
        return meio(texto, 1, localiza(texto, " ") - 1);
    }
    
    public static String ultimaPalavra(String texto) {
        int ultimoEspaco = texto.lastIndexOf(" ");
        
        if (ultimoEspaco < 0)
            return texto;
        
        return texto.substring(ultimoEspaco + 1);
    }
    
    public static String repete(String texto, int quantidade) {
        return repete(texto, quantidade, null);
    }
    
    public static String repete(String texto, int quantidade, String separador) {
        String resultado = "";
        for (int i = 0; i < quantidade; i++) {
            if (i > 0 && separador != null)
                resultado += separador;
            resultado += texto;
        }
        return resultado;
    }
    
    public static String primeiraMinuscula(String texto) {
        return SSTexto.minuscula(SSTexto.esquerda(texto, 1)) + SSTexto.meio(texto, 2);
    }
    
    public static String primeiraMaiuscula(String texto) {
        return SSTexto.maiuscula(SSTexto.esquerda(texto, 1)) + SSTexto.meio(texto, 2);
    }
    
    public static String substitui(String texto, String textoLocalizar, String textoSubstituir) {
        return texto.replaceAll("[" + textoLocalizar + "]", textoSubstituir);
    }
    
    public static String suprimeEspaco(String texto){
        return texto.trim();        
    }
    
    /**
     * Retorna um inteiro que e a posição da string <I>localiza</I> encontrada na string <I>texto</I>.
     * Se não encontrar nenhuma ocorrência retorna 0;
     * Ex.:
     * <CODE>Texto.localiza("Frank Marlon", "k"); //Retorna 5
     * Texto.localiza("Frank Marlon", "J"); //Retorna 0</CODE>
     */
    public static int localiza(String texto, String localiza){
        return localiza(1, texto, localiza);
    }
    
    
        
    public static int localiza(int inicio, String texto, String localiza){
        int retorno = -1;
        if (inicio == 0) inicio=1;
        
        retorno = texto.indexOf(localiza, inicio - 1);
        
        return retorno + 1;
    }
    
    public static String minuscula(String texto){
        return texto.toLowerCase();
    }
    
    
    
    public static String maiuscula(String texto){
        return texto.toUpperCase();
    }
            
    public static int tamanho(String texto){
        return texto.length();
    }
    
    public static String esquerda(String texto, int tamanho){
        if (tamanho > texto.length())
            tamanho = texto.length();
        return texto.substring(0,tamanho);
    }
    
    public static String direita(String texto, int tamanho){
        return texto.substring(texto.length() - tamanho);
    }
    
    public static String meio(String texto, int inicio, int tamanho){
        inicio = inicio - 1; 
        if (tamanho + inicio > texto.length())
            return texto.substring(inicio);
        else
            return texto.substring(inicio).substring(0, tamanho);
    }
    
    public static String meio(String texto, int inicio){
        inicio = inicio - 1;
        if (inicio < 0) 
            inicio=0;
        return texto.substring(inicio);
    }
        
    public static String seNumero(String valor, String retorno){
        if (valor == null)
            return retorno;
        else if (!SSValidacao.numero(valor))
            return retorno;
        else
            return valor;
    }
    
    public static String seNumero(String valor){
        return seNulo(valor, "0");
    }
    
    public static String seNulo(Object valor, String retorno){
        if (valor == null)
            return retorno;
        else
            return valor.toString();
    }
    
    public static String seNulo(String valor){
        return seNulo(valor, "");
    }
    public static String seVazio(String valor, String retorno) {
        if (valor.equals(""))
            return retorno;
        else
            return valor;
    }
    
    public static String seNuloVazio(Object valor){
        return seNulo(valor, "");
    }
    
    public static String seNuloZero(Object valor){        
        return seNulo(valor, "0");
    }
    
    public static String gerarTextoAleatorio(int tamanho) {
        Random r = new Random();
        long num = r.nextLong();
        
        return esquerda(Long.toHexString(num), tamanho);
    }
    
    public static String complementaEsquerda(String texto, int tamanho, String complemento) {   
        while (texto.length() < tamanho) {   
            texto = complemento + texto;   
        }   
        return texto;   
    }   
       
    public static String complementaDireita(String texto, int tamanho, String complemento) {   
        while (texto.length() < tamanho) {   
            texto = texto+complemento;   
        }   
        return texto;   
    }  
    
    public static String remove(String texto, int inicio, int fim) {
        return esquerda(texto, inicio - 1) + meio(texto, fim + 1);        
    }
    
    public static void main(String[] args) {
		try {
			//System.out.println(md5("gso12356"));
			
			Integer num = getNumero("ABC123");
			System.out.println(num);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static Integer getNumero(String valor) {
    	return Integer.valueOf(valor.replaceAll("\\D", ""));
    }
    
}
