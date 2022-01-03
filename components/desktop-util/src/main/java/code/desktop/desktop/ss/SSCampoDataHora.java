package code.desktop.desktop.ss;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import code.desktop.desktop.ss.evento.SSValidacaoEvento;
import code.desktop.desktop.ss.evento.SSValidacaoListener;
import code.desktop.desktop.ss.util.SSTexto;


public class SSCampoDataHora extends SSCampoMascara {
    private DateFormatter formatadorPadrao;
    private MaskFormatter formatadorEdicao;
    private DateFormatter formatadorExibicao;
    
    public SSCampoDataHora() {
        super();
        setTipoValidacao("data");        
        try {
            
            //Adiciona validação para data/hora
            addValidacaoListener(new SSValidacaoListener() {
                public void validacaoListener(SSValidacaoEvento evento) {
                    this_validacaoListener(evento);
                }
            });
            
            //formatadorPadrao = new SSFormatadorDataHora(new SimpleDateFormat());
            formatadorPadrao = new SSFormatadorDataHora(new SimpleDateFormat());
            if (getDefaultFormatterFactory() == null)
                setDefaultFormatterFactory(new DefaultFormatterFactory());
            getDefaultFormatterFactory().setDefaultFormatter(formatadorPadrao);
            getDefaultFormatterFactory().setDisplayFormatter(formatadorExibicao);
            
            setFormato("dd/MM/yy");
            setMascara("##/##/##");
        } catch (Exception e) {
            e.printStackTrace();
        }       
    }
    
    public void setValue(Object value) {
        if (value instanceof Date) {
            try {
                value = formatadorPadrao.valueToString(value);
            } catch (ParseException e) {
                throw new RuntimeException("Data inválida: " + value , e);
            }
        }
        super.setValue(value);        
    }
    
    public Object getValue() {
        Object valor = super.getValue();
        if (valor instanceof String) {
            try {
                valor = formatadorPadrao.stringToValue((String)valor);             
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return valor;
    }
    
    public LocalDate getLocalDate() {
    	Date date = getDataHora();
    	if(date!=null) {
    		return new java.sql.Date(date.getTime()).toLocalDate();
    	}else
    		return null;
    }
    public Date getDataHora() {
        if (getValue() instanceof Date)
            return (Date)getValue();
        else
            return null;
    }
    public void setData(LocalDate localDate) {
    	if(localDate!=null) {
    		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        	setDataHora(date);
    	}
    }
  
    public void setDataHora(LocalDateTime localDateTime) {
    	if(localDateTime!=null) {
    		Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        	setDataHora(date);
    	}
    }
    public void setDataHora(Date dataHora) {
        setValue(dataHora);
    }
    
    public void setFormato(String formato) {        
        if (formato == null) {
            formatadorExibicao = null;
            getDefaultFormatterFactory().setDisplayFormatter(null);
        } else {
            if (formatadorExibicao == null) {
                formatadorExibicao = new SSFormatadorDataHora();
            }
            SimpleDateFormat formatoData = new SimpleDateFormat(formato);
            formatoData.setLenient(false);
            formatadorExibicao.setFormat(formatoData);
            getDefaultFormatterFactory().setDisplayFormatter(formatadorExibicao);
            formatadorPadrao.setFormat(formatadorExibicao.getFormat());            
        }
    }

    public String getFormato() {
        if (formatadorExibicao == null) {
            if (formatadorPadrao != null)
                return ((SimpleDateFormat)formatadorPadrao.getFormat()).toPattern();
            else
                return null;
        } else {
            SimpleDateFormat df = (SimpleDateFormat)formatadorExibicao.getFormat();
            return df.toPattern();
        }
    }
    
    public void setMascara(String mascara) throws ParseException {
        if (mascara == null) {
            formatadorEdicao = null;
            getDefaultFormatterFactory().setEditFormatter(null);
        } else {
            formatadorEdicao = new SSFormatadorMascara(mascara);
            //formatadorEdicao = new MaskFormatter(mascara);
            formatadorEdicao.setAllowsInvalid(false);
            formatadorEdicao.setOverwriteMode(true);
            formatadorEdicao.setCommitsOnValidEdit(true);
            getDefaultFormatterFactory().setEditFormatter(formatadorEdicao);            
        }
    }
    
    public String getMascara() {
        if (formatadorEdicao == null)
            return null;
        else
            return formatadorEdicao.getMask();
    }
    
    private void this_validacaoListener(SSValidacaoEvento evento) {
        if (getClipText() == null || getClipText().equals(":") || getClipText().trim().length() == 0)
            return;
        try {
            formatadorPadrao.getFormat().parseObject(getText());
            evento.setValidado(true);
        } catch (ParseException e) {
            evento.setValidado(false);
            SSMensagem.erro(this.getRootPane().getParent(), "Data inválida.\n Informe um data no formato: " + getFormato());
        }
    }

    
}

class SSFormatadorDataHora extends DateFormatter {
    
    public SSFormatadorDataHora() {
        super();
    }
    
    public SSFormatadorDataHora(DateFormat format) {
        super(format);
    }
    
    public Object stringToValue(String texto) throws ParseException {
        Object value;
        //System.out.println("Classe: " + this.getClass().getSimpleName());
        //System.out.println("stringToValue: str: " + texto);
        if (texto == null || texto.length() == 0)
            value = null;
        else
            value = super.stringToValue(texto);
        //System.out.println("stringToValue: value: " + value);
        return value;
    }
    
    public String valueToString(Object value) throws ParseException {        
        String string;
        //System.out.println("Classe: " + this.getClass().getSimpleName());
        //System.out.println("valueToString: value: " + value);
        if (value instanceof String) {
            value = stringToValue((String)value);
        }
        string = super.valueToString(value);        
        //System.out.println("valueToString: str: " + string);
        return string;
    }    
}

class SSFormatadorMascara extends MaskFormatter {
    public SSFormatadorMascara() {
        super();
    }
    
    public SSFormatadorMascara(String mask) throws ParseException {
        super(mask);
    }
    
    private String getClipText() {
        /*boolean valorAtual = getValueContainsLiteralCharacters();
        setValueContainsLiteralCharacters(false);
        String clipText = (String)getFormattedTextField().getValue();
        setValueContainsLiteralCharacters(valorAtual); 
        return clipText;*/
        if (getFormattedTextField().getText() == null || getFormattedTextField().getText().length() == 0)
            return null;
        String clipText = SSTexto.retiraSeparadores(getFormattedTextField().getText()).trim();
        clipText = clipText.replace('_', " ".toCharArray()[0]);        
        clipText = clipText.replace(':', " ".toCharArray()[0]);        
      
        return clipText;
    }
    
    public Object stringToValue(String texto) throws ParseException {                       
        Object value;
        String clipText = getClipText();
        //System.out.println("Classe: " + this.getClass().getSimpleName());
        //System.out.println("stringToValue: str: " + texto + " - clip: " + clipText);
        
        if (clipText == null || clipText.length() == 0) {
            texto = null;
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
