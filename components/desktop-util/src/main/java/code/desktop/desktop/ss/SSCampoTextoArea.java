package code.desktop.desktop.ss;

import javax.swing.*;

public class SSCampoTextoArea extends SSComponenteRotulado implements SSTextoComponente {
    private JTextArea textArea = new JTextArea();
    private JScrollPane pnlTextArea = new JScrollPane(textArea);
    
    public SSCampoTextoArea() {       
       try {
           jbInit();
       } catch (Exception e) {
           e.printStackTrace();
       }    
     }
    
    private void jbInit() throws Exception {
        textArea.setTabSize(4);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setComponente(pnlTextArea);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public boolean isEditavel() {
        return textArea.isEditable();
    }

    public void setEditavel(boolean editavel) {
        textArea.setEditable(editavel);
    }

    public void setSelecionarAoEntrar(boolean selecionarAoEntrar) {
    }

    public boolean isSelecionarAoEntrar() {
        return false;
    }

    public int getColunas() {
        return textArea.getColumns();
    }

    public void setColunas(int colunas) {
        textArea.setColumns(colunas);
    }
    
    public void setRows(int rows) {
        textArea.setRows(rows);
    }
    
    public int getRows() {
        return textArea.getRows();
    }    
    
    public Object getValue() {
        return getText();
    }
  
    public void setValue(Object value) {        
        setText(value != null? value.toString(): null);
    }
    
}
