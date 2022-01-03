package java.code.desktop.desktop.ss;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.code.desktop.desktop.ss.util.SSReflexao;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;


public class SSPainelSelecao extends JPanel {
    private List itens;
    private String campoExibicao;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton radioPadrao = new JRadioButton();
    
    public SSPainelSelecao() {
        super(); 
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        String itens[] = new String[]{"Opção 1", "Opção 2"};
        setItens(itens);
    }
    
    public void setItens(Object itens[]) {
        setItens(Arrays.asList(itens));
    }
    
    public void setItens(Object itens[], String campoExibicao) {
        setItens(Arrays.asList(itens), campoExibicao);
    }
    
    public void setItens(List itens) {
        this.itens = itens;
        carregarItens();
    }
    
    public void setItens(List itens, String campoExibicao) {
        setCampoExibicao(campoExibicao);
        setItens(itens);
    }

    public List getItens() {
        return itens;
    }
    
    private void carregarItens() {                
        JRadioButton radio = null;        
                
        this.removeAll();
        buttonGroup = new ButtonGroup();
        
        for (Object obj : getItens()) {
            String texto = null;
            
            if (getCampoExibicao() == null) {
                texto = obj.toString();
            } else {
                Object valor;                
                try {
                    valor = SSReflexao.buscarValorCampo(obj, getCampoExibicao());
                    if (valor == null)
                        texto = null;
                    else
                        texto = valor.toString();
                } catch (NoSuchFieldException e) {
                    System.err.println(e);
                } catch (IllegalAccessException e) {
                    System.err.println(e);
                }
            }
            
            radio = new JRadioButton(texto);
            
            ActionListener actions[] = radioPadrao.getListeners(ActionListener.class);
            for (ActionListener action : actions)
                radio.addActionListener(action);
            ChangeListener changes[] = radioPadrao.getListeners(ChangeListener.class);
            for (ChangeListener change : changes)
                radio.addChangeListener(change);
            
            buttonGroup.add(radio);
            this.add(radio);
        }        
    }

    public void setCampoExibicao(String campoExibicao) {
        this.campoExibicao = campoExibicao;
    }

    public String getCampoExibicao() {
        return campoExibicao;
    }
    
    public void setValor(Object valor) {
        int index = getItens().indexOf(valor);
        JRadioButton radio = (JRadioButton)getComponent(index);
        buttonGroup.setSelected(radio.getModel(), true);        
    }
    
    public Object getValor() {
        Enumeration elementos = buttonGroup.getElements();
        int indiceSelecionado = -1;
        AbstractButton button;
        
        for(int i = 0; elementos.hasMoreElements(); i++) {
            button = (AbstractButton)elementos.nextElement();
            
            if (buttonGroup.isSelected(button.getModel())){                
                indiceSelecionado = i;
                break;
            }
        }
        
        if (indiceSelecionado == -1)
            return null;
        else        
            return getItens().get(indiceSelecionado);
    }
    
    public void addChangeListener(ChangeListener l) {
        radioPadrao.addChangeListener(l);
    }
    
    public void removeChangeListener(ChangeListener l) {
        radioPadrao.removeChangeListener(l);
    }

    public ChangeListener[] getChangeListeners() {
        return radioPadrao.getChangeListeners();
    }

    public void addActionListener(ActionListener l) {
        radioPadrao.addActionListener(l);
    }
    
    public void removeActionListener(ActionListener l) {
        radioPadrao.removeActionListener(l);
    }

    public ActionListener[] getActionListeners() {
        return radioPadrao.getActionListeners();
    }
    
}
