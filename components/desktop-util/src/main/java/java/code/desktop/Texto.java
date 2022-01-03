package java.code.desktop;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Texto {
	public static int INICIO=0;
    public static int FIM=1;
    public static int MEIO=2;

    public static String md5(String texto) throws Exception {
    	MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(texto.getBytes(),0,texto.length());
        String md5=new BigInteger(1,m.digest()).toString(16);
        return md5;
    }
    public static String base64Encode(String texto) throws Exception{
        String resultado = Base64.getEncoder().encodeToString(texto.getBytes());
        return resultado;
	}
    public static String base64Decore(String encoded) throws Exception{
        byte[] bytes = Base64.getDecoder().decode(encoded);
        String resultado = new String(bytes);
        return resultado;
    }
    public static String removerAcentos(String texto){
       return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    
    private static String extensao(File file) {
        return file.getName().replaceAll("^.*\\.(.*)$", "$1");
    }
    public static String str(Object texto, String textoPadrao) {
    	return Objects.toString(texto, textoPadrao);
    }
    public static String str(Object texto) {
    	return str(texto,"");
    }

    public static String concatenar(String delimitador,List valores) {
    	StringJoiner sj = new StringJoiner(delimitador, "", "");
    	valores.stream().forEach(o -> {
    	    if(o!=null)
    	        sj.add(str(o));
    	});
    	return sj.toString();
    }

    public static String concatenar(String delimitador, Object ... valores) {
    	List strs = new ArrayList<>(Arrays.asList(valores));
    	return concatenar(delimitador, strs);
    }
    public static String prefixo(String simbolo,int comprimento,String texto     ) {
        return completar(texto,INICIO,simbolo,comprimento);
    }
    public static String sufixo(String texto, String simbolo, int comprimento) {
        return completar(texto,INICIO,simbolo,comprimento);
    }
    public static String completar(String texto, int posicao, String simbolo, int comprimento   ) {
        boolean meio=posicao==MEIO;
        while (texto.length() < comprimento) {
            if(meio)
                posicao=posicao==INICIO?FIM:INICIO;

            if(FIM==posicao)
                texto += simbolo;
            else if(INICIO==posicao)
                texto= simbolo+ texto;
        }
        return texto;
    }
    public static String caso(String palavra, String ... opcoes) {
		for(int x=0;x<opcoes.length;x++) {
			if(palavra.equals(opcoes[x])) {
				return opcoes[x+1];
			}
		}
		return null;
	}
    public static void main(String[] args) throws  Exception {
        String[] testes= {"login","testes","contas"};
        
        System.out.println(concatenar("/", testes));
        
        System.out.println(completar("gleyson", FIM, "*", 10));
    }
}
