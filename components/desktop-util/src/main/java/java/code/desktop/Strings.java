package java.code.desktop;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Strings {
	
	public static boolean isBlank(String string) {
		return string == null || string.trim().isEmpty();
	}
	
	public static String ifBlank(String string, String defaultValue) {
		return isBlank(string) ? defaultValue : string;
	}
	
	public static String ifNull(String string, String defaultValue) {
		return string == null ? defaultValue : string;
	}
	
	public static Integer isNUll(Integer value,Integer defaultValue) {
		if (value  == null){
			return defaultValue;
		}else{
			return value;
		}
	}
	
	public static boolean isEmpty(String string) {
		return string == null || string.isEmpty();
	}
	
	public static String safe(String string) {
		return safe(string, "");
	}
	
	public static String safe(String string, String defaulValue) {
		return string != null ? string : defaulValue;
	}
	
	public static String involve(String text, String exp) {
		return involve(text, exp, exp);
	}
	
	public static String involve(String text, String start, String end) {
		if (text == null) return null;
		return start + text + end;
	}
	
	public static String prefix(String text, String exp) {
		if (text == null) return null;
		return exp + text;
	}
	
	public static String suffix(String text, String exp) {
		if (text == null) return null;
		return text + exp;
	}
	
	public static String encriptaMD5(String texto) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(texto.getBytes(), 0, texto.length());

			return new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("Algoritmo de encriptação M5 não encontrado", e);
		}
	}

	public static String toUndercoreCase(String text) {
		if (text == null) return null;
		String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        String result = text.replaceAll(regex, replacement);
        result = result.replaceAll("-", "_");
		return result;
	}
	
	public static String removeSeparators(String text) {
		if (text == null) return null;
		return text.replaceAll("[\\.\\-/\\(\\)\\s\\s<\\>\\:\\;]", "");
	}
	
	public static String formatDateString(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		return dateFormat.format(date);
	}
	
	public static String formatValor(BigDecimal valor){
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		return decimalFormat.format(valor);
	}
	
	public static String firstLowerCase(String string) {
		if (string == null || string.isEmpty()) return string;
		return string.substring(0, 1).toLowerCase() + string.substring(1);
	}

}
