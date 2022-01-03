package code.desktop.desktop.ss;

import javax.swing.*;

import code.desktop.desktop.ss.evento.SSValidacaoEvento;
import code.desktop.desktop.ss.evento.SSValidacaoListener;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;


/**
 *@beaninfo
 *   attribute: isContainer false
 * description: Painel para componente rotulado.
 *
 * @author  Frank Marlon M. dos Santos
 * @version 1.0 08/18/08
 */
public abstract class SSComponenteRotulado extends JPanel implements SSComponente {
    private JLabel lblRotulo = new JLabel();
    private SSPosicaoRotulo rotuloPosicao;
    private boolean simples;    
    private JComponent componente;
    private String campoLigacao;
    private boolean obrigatorio;
    private String tipoValidacao;
    private boolean validarAoSair = true;
    private boolean alterado;
    private boolean validarSomenteAlteracao;
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private boolean componenteNegrito;
    private boolean campoAtualizavel = true;
            
    public SSComponenteRotulado() {        
        this(null);
    }
        
    public SSComponenteRotulado(JComponent componente) {
        setComponente(componente);        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void jbInit() throws Exception {
        
        this.setLayout(gridBagLayout1);

        lblRotulo.setText("Rotulo");
        lblRotulo.setOpaque(false);
        this.setOpaque(false);
        
        this.add(lblRotulo, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
                                               new Insets(0, 0, 0, 0), 0, 0));
        
        if (componente != null) {
            this.add(componente, null);            
        }        
        setRotuloPosicao(SSPosicaoRotulo.TOPO);
    }
    public void somenteLeitura() {
    	setSomenteLeitura(new Color(0, 0, 139));
    }
    public void setSomenteLeitura(Color color) {
    	componente.setForeground(color);
    	setComponenteCorFonte(color);
    	setComponenteNegrito(true);
    	setEditavel(false);
    }
    public void setRotuloPosicao(SSPosicaoRotulo rotuloPosicao) {
        this.rotuloPosicao = rotuloPosicao;        
        atualizarPosicaoRotulo();
    }
    
    private void atualizarPosicaoRotulo() {
        GridBagConstraints constraints = null;
        int constantePreenchimento = GridBagConstraints.HORIZONTAL;
        
        if (componente instanceof JTextArea)
            constantePreenchimento = GridBagConstraints.BOTH;
        
        if (this.rotuloPosicao == SSPosicaoRotulo.ESQUERDA) {

            constraints = new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,GridBagConstraints.WEST, constantePreenchimento,
                                                   new Insets(0, 0, 0, 0), 0, 0);
            
        } else if (this.rotuloPosicao == SSPosicaoRotulo.TOPO) {
            
            constraints = new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, constantePreenchimento,
                                               new Insets(0, 0, 0, 0), 0, 0);
            
        }
        
        if (componente != null) {
            this.remove(componente);
            this.add(componente, constraints);                   
        }
        
        updateUI();
    }
    
    public void setFocusable(boolean focusable) {
        componente.setFocusable(focusable);
        super.setFocusable(focusable);
    }
    
    public SSPosicaoRotulo getRotuloPosicao() {
        return rotuloPosicao;
    }
    
    public String getRotulo() {
        return lblRotulo.getText();
    }
    
    public void setRotulo(String rotulo) {
        lblRotulo.setText(rotulo);
    }
    
    public void setSimples(boolean simples) {
        this.simples = simples;
        lblRotulo.setVisible(!simples);
    }

    public boolean isSimples() {
        return simples;
    }
    
    public Font getRotuloFonte() {
        return lblRotulo.getFont();
    }
    
    public void setRotuloFonte(Font fonte) {
        lblRotulo.setFont(fonte);
    }
    
    public Font getComponenteFonte() {
        return componente.getFont();
    }
    
    public int getRotuloLargura() {
        return lblRotulo.getWidth();
    }
    
    public void setRotuloLargura(int largura) {
        lblRotulo.setPreferredSize(new Dimension(largura, (int)lblRotulo.getPreferredSize().getHeight()));
    }
    
    public void setComponenteFonte(Font fonte) {
        componente.setFont(fonte);
    }
    
    public void setComponente(JComponent componente) {
        if (componente != null && this.componente != componente) {
            if (this.componente != null)
                this.remove(this.componente);
            this.componente = componente;
            componente.addFocusListener(new FocusAdapter() {                    
                    public void focusLost(FocusEvent e) {
                        componente_focusLost(e);
                    }
                });
            componente.setInputVerifier(new InputVerifier() {
                public boolean verify(JComponent input) {
                    return componente_verify(input);
                }
            });
            atualizarPosicaoRotulo();
        }
    }

    public JComponent getComponente() {
        return componente;
    }
    
    public Color getRotuloCorFundo() {
        return lblRotulo.getBackground();
    }
    
    public void setRotuloCorFundo(Color cor) {
        lblRotulo.setBackground(cor);
    }
    
    public Color getComponenteCorFonte() {
        return componente.getForeground();              
    }
    
    public void setComponenteCorFonte(Color cor) {
        componente.setForeground(cor);
    }
    
    public Color getComponenteCorFundo() {
        return componente.getBackground();              
    }
    
    public void setComponenteCorFundo(Color cor) {
        componente.setBackground(cor);
    }
   
    public void setRotuloAlinhamento(int alinhamento) {
        lblRotulo.setHorizontalAlignment(alinhamento);
    }
    
    public int getRotuloAlinhamento() {
        return lblRotulo.getHorizontalAlignment();
    }
            
    public Dimension getTamanhoComponente() {        
        return componente.getSize();
    }
    
    public abstract String getText();
    
    public abstract void setText(String text);

    public void setCampoLigacao(String campoLigacao) {
        this.campoLigacao = campoLigacao;
    }

    public String getCampoLigacao() {
        return campoLigacao;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setTipoValidacao(String tipoValidacao) {
        this.tipoValidacao = tipoValidacao;
    }

    public String getTipoValidacao() {
        return tipoValidacao;
    }
    
    public void setComponenteTamanhoPreferido(Dimension tamanho) {
        componente.setPreferredSize(tamanho);
    }
    
    public Dimension getComponenteTamanhoPreferido() {
        return componente.getPreferredSize();
    }
    
    public void setComponenteTamanho(Dimension tamanho) {
        componente.setSize(tamanho);
    }
    
    public Dimension getComponenteTamanho() {
        return componente.getSize();
    }
    
    @Override
    public void requestFocus() {
        componente.requestFocus();
    }

    @Override
    public boolean requestFocusInWindow() {
        return componente.requestFocusInWindow();
    }

    @Override
    public boolean requestFocus(boolean temporary) {
        return componente.requestFocus(temporary);
    }

    public void setValidarAoSair(boolean validarAoSair) {
        this.validarAoSair = validarAoSair;
    }

    public boolean isValidarAoSair() {
        return validarAoSair;
    }
    
    public void setEnabled(boolean enabled) {
        lblRotulo.setEnabled(enabled);
        componente.setEnabled(enabled);
        super.setEnabled(enabled);        
    }
    
    public abstract boolean isEditavel();
    public abstract void setEditavel(boolean editavel);
    
    private void componente_focusLost(FocusEvent e) {
        if (isValidarAoSair()) {
            if (getTipoValidacao() != null) {
                //String msg = Formulario.validarCampo(this, false);
                //if (msg != null) {
                //    Mensagem.erro(msg);
                //}
            }
        }            
    }

    @Override
    public synchronized void addKeyListener(KeyListener l) {
        super.addKeyListener(l);
        componente.addKeyListener(l);
    }
    
    public synchronized void removeKeyListener(KeyListener l) {
        super.removeKeyListener(l);
        componente.removeKeyListener(l);
    }
    
    public synchronized void addFocusListener(FocusListener l) {
        super.addFocusListener(l);
        componente.addFocusListener(l);
    }
    
    public synchronized void removeFocusListener(FocusListener l) {
        super.removeFocusListener(l);
        componente.removeFocusListener(l);
    }

    @Override
    public void setToolTipText(String text) {
        super.setToolTipText(text);
        lblRotulo.setToolTipText(text);
        componente.setToolTipText(text);
    }
    
    protected void setAlterado(boolean alterado) {
        this.alterado = alterado;
    }

    public boolean isAlterado() {
        return alterado;
    }

    public void setValidarSomenteAlteracao(boolean validarSomenteAlteracao) {
        this.validarSomenteAlteracao = validarSomenteAlteracao;
    }

    public boolean isValidarSomenteAlteracao() {
        return validarSomenteAlteracao;
    }
    
    public synchronized void addValidacaoListener(SSValidacaoListener pl) {
        listenerList.add(SSValidacaoListener.class, pl);
    }

    public synchronized void removeValidacaoListener(SSValidacaoListener pl) {        
        listenerList.remove(SSValidacaoListener.class, pl);
    }
    
    public synchronized SSValidacaoListener[] getValidacaoListeners() {        
        return listenerList.getListeners(SSValidacaoListener.class);
    }
    
    private boolean componente_verify(JComponent input) {
        if (isValidarSomenteAlteracao() && !isAlterado())
            return true;
        
        //Dispara ação validação
        SSValidacaoListener[] listeners = getValidacaoListeners(); 
        SSValidacaoEvento evento;
        //Dispara ação
        for (SSValidacaoListener listener : listeners) {
            evento = new SSValidacaoEvento(this);
            listener.validacaoListener(evento);
            if (!evento.isValidado())
                return false;
        }
        return true;
    }

    public void setComponenteNegrito(boolean componenteNegrito) {        
        this.componenteNegrito = componenteNegrito;
        if (this.componenteNegrito)
            setComponenteFonte(getComponenteFonte().deriveFont(Font.BOLD));
    }

    public boolean isComponenteNegrito() {
        return componenteNegrito;
    }

    public void setCampoAtualizavel(boolean campoAtualizavel) {
        this.campoAtualizavel = campoAtualizavel;
    }

    public boolean isCampoAtualizavel() {
        return campoAtualizavel;
    }
    
    public abstract Object getValue();
    public abstract void setValue(Object value);
    
}
