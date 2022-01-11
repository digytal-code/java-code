package code.desktop.ss;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;


public class SSCampoNumero extends SSCampoMascara {
    private NumberFormatter formatadorPadrao;
    private NumberFormatter formatadorExibicao;
    private NumberFormatter formatadorEdicao;
    private boolean permitirZero = true;
    private int tipoNumero = 1;
    private String mascara;
    private String formato;
    
    
    public static final int INTEIRO = 0;
    public static final int DECIMAL = 1;
    public static final int MOEDA = 2;
    
    public SSCampoNumero() {
        super();
        setTipoValidacao("numero");
        String formato = null;
        String mascara = null;
        
        getCaixaTexto().setHorizontalAlignment(SwingConstants.RIGHT);        
        
        if (this.getDefaultFormatterFactory() == null)
            setDefaultFormatterFactory(new DefaultFormatterFactory());
        
        formato = "#,###.00";
        mascara = "#,###.00";
        formatadorPadrao = new SSFormatadorNumero(new DecimalFormat());
        
        getDefaultFormatterFactory().setDefaultFormatter(formatadorPadrao);
        getDefaultFormatterFactory().setDisplayFormatter(formatadorExibicao);
        getDefaultFormatterFactory().setEditFormatter(formatadorEdicao);
        
        //setFormato(formato);
        //setMascara(mascara);
        //setNumero(0);
    }
    
    public Number getNumero() {
        if (getValue() instanceof Number)
            return (Number)getValue();
        else
            return null;
    }
    
    public Float getFloat() {
        if (getValue() == null)
            return null;
        else if (getValue() instanceof Float)
            return (Float)getValue();
        else
            return getNumero().floatValue();
    }
    public Double getDoubleOuZero() {
    	return getDouble() !=null ? getDouble() : 0.0d;
    }
    public Double getDouble() {
        if (getValue() == null)
            return null;
        else if (getValue() instanceof Double)
            return (Double)getValue();
        else
            return getNumero().doubleValue();
    }
    
    public BigDecimal getBigDecimal() {
        if (getValue() == null)
            return null;
        else if (getValue() instanceof BigDecimal)
            return (BigDecimal)getValue();
        else
            return BigDecimal.valueOf(getNumero().doubleValue());
    }
    
    public Long getLong() {
        if (getNumero() == null)
            return null;
        else if (getNumero() instanceof Long)
            return (Long)getNumero();
        else
            return getNumero().longValue();
    }
    
    public Integer getInteger() {
        if (getValue() == null)
            return null;
        else if (getValue() instanceof Integer)
            return (Integer)getValue();
        else
            return getNumero().intValue();
    }
    
    public void setNumero(Number numero) {
        setValue(numero);
    }

    public void setFormato(String formato) {
        this.formato = formato;
        atualizarFormato();
    }
    
    private void atualizarFormato() {
        if (formato == null || formato.length() == 0) {
            formatadorExibicao = null;
            getDefaultFormatterFactory().setDisplayFormatter(formatadorExibicao);
        } else {
            if (formatadorExibicao == null) {
                formatadorExibicao = new SSFormatadorNumero();
            }
            formatadorExibicao.setFormat(new DecimalFormat(formato));
            getDefaultFormatterFactory().setDisplayFormatter(formatadorExibicao);
        }
    }

    public String getFormato() {
        return formato;
    }
    
    public void setMascara(String mascara) {
        this.mascara = mascara;
        definirMascara();
    }
    
    private void definirMascara() {
        if (mascara == null || mascara.length() == 0) {
            formatadorEdicao = null;
            getDefaultFormatterFactory().setEditFormatter(null);
        } else {
            formatadorEdicao = new SSFormatadorNumero(new DecimalFormat(mascara));
            formatadorEdicao.setAllowsInvalid(false);
            formatadorEdicao.setOverwriteMode(false);
            formatadorEdicao.setCommitsOnValidEdit(true);
            getDefaultFormatterFactory().setEditFormatter(formatadorEdicao);
        }
    }
    
    public String getMascara() {
        /*if (formatadorEdicao == null)
            return null;
        else
            return ((DecimalFormat)formatadorEdicao.getFormat()).toPattern();*/
        return mascara;
    }
    
    public void setTipoNumero(int tipoNumero) {
        this.tipoNumero = tipoNumero;
    }

    public int getTipoNumero() {
        return tipoNumero;
    }

    public void setPermitirZero(boolean permitirZero) {
        this.permitirZero = permitirZero;
    }

    public boolean isPermitirZero() {
        return permitirZero;
    }    
}

class SSFormatadorNumero extends NumberFormatter {
    public SSFormatadorNumero() {
        super();
    }
    
    public SSFormatadorNumero(NumberFormat numberFormat) {
        super(numberFormat);
    }
    
    public Object stringToValue(String texto) throws ParseException {                       
        Object value;
                //System.out.println("Classe: " + this.getClass().getSimpleName());
        //System.out.println("stringToValue: str: " + texto + " - clip: " + clipText);
        
        if (texto == null || texto.length() == 0) {            
            value = null;
        } else
            value = super.stringToValue(texto);
                
        //System.out.println("stringToValue: value: " + value);
        
        return value;        
    }
    
    public String valueToString(Object value) throws ParseException {        
        String string;
        //System.out.println("Classe: " + this.getClass().getSimpleName());
        //System.out.println("valueToString: value: " + value);
        
        string = super.valueToString(value);
        
        //System.out.println("valueToString: str: " + string);
        
        return string;
    }
}
