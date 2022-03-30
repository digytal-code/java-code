package digytal.azapy.model.esocial.processamento;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Tot implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String tipo;
	private String eSocial;
	
	@XmlAttribute(name="tipo")
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@XmlAnyElement(StringDomHandler.class)
	public String getESocial() {
		return eSocial;
	}
	
	public void setESocial(String eSocial) {
		this.eSocial = eSocial;
	}
	
	public static class StringDomHandler implements DomHandler<String, StreamResult> {
		 
	    private StringWriter xmlWriter = new StringWriter(); 
	 
	    public StreamResult createUnmarshaller(ValidationEventHandler errorHandler) {
	        return new StreamResult(xmlWriter);
	    }
	 
	    public String getElement(StreamResult rt) {
	        return rt.getWriter().toString();
	    }
	 
	    public Source marshal(String xml, ValidationEventHandler errorHandler) {
	        try {
	            StringReader xmlReader = new StringReader(xml);
	            return new StreamSource(xmlReader);
	        } catch(Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	}
	
}
