package code.desktop.desktop.ss.evento;

import java.awt.*;


public class SSValidacaoEvento extends AWTEvent {    
    private boolean validado = true;
    
    public SSValidacaoEvento(Object source) {
        super(source, 200803);        
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public boolean isValidado() {
        return validado;
    }
}
