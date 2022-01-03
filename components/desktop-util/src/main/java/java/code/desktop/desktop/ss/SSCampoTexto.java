package java.code.desktop.desktop.ss;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.code.desktop.desktop.ss.evento.SSAlteracaoEvento;
import java.code.desktop.desktop.ss.evento.SSAlteracaoListener;
import java.code.desktop.desktop.ss.evento.SSPesquisaEvento;
import java.code.desktop.desktop.ss.evento.SSPesquisaListener;


/**
 *@beaninfo
 *   attribute: isContainer false
 * description: Caixa de texto.
 *
 * @author  Frank Marlon M. dos Santos
 * @version 1.0 08/18/08
 * @see SSCampoMascara
 */
public class SSCampoTexto extends SSComponenteRotulado implements SSTextoComponente {    
    private JTextField txtCaixaTexto = new JTextField();
    private boolean selecionarAoEntrar = true;    
    private String valorAnterior;
    private boolean pesquisa;
    private SSBotao btnPesquisa;
        
    public SSCampoTexto() {        
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    private void jbInit() throws Exception {
    	setComponente(txtCaixaTexto);
        
        //txtCaixaTexto.setColumns(15);        
        txtCaixaTexto.addFocusListener(new FocusAdapter() {
                    public void focusGained(FocusEvent e) {
                        txtCaixaTexto_focusGained(e);
                    }

                    public void focusLost(FocusEvent e) {
                        //txtCaixaTexto_focusLost(e);
                    }
                });        
        txtCaixaTexto.setDocument(new DocCampoTexto());       
        
    }
    
    public void setHorizontalAlignment(int alinhamento) {
        txtCaixaTexto.setHorizontalAlignment(alinhamento);
    }
    
    public int getHorizontalAlignment() {
        return txtCaixaTexto.getHorizontalAlignment();
    }
    
    public int getColunas() {
        return txtCaixaTexto.getColumns();
    }
   
    
    public void setColunas(int colunas) {
        txtCaixaTexto.setColumns(colunas);
    }     

    public void setSelecionarAoEntrar(boolean selecionarAoEntrar) {
        this.selecionarAoEntrar = selecionarAoEntrar;
    }

    public boolean isSelecionarAoEntrar() {
        return selecionarAoEntrar;
    }

    public DocCampoTexto getDocCampoTexto() {
        return (SSCampoTexto.DocCampoTexto)txtCaixaTexto.getDocument();
    }

    private void txtCaixaTexto_focusGained(FocusEvent e) {
        if (isSelecionarAoEntrar()) {
            if (txtCaixaTexto.getText() != null)
                txtCaixaTexto.select(0, txtCaixaTexto.getText().length());;
        }
        setAlterado(false);
        valorAnterior = this.getText();
    }

    public String getText() {
        return txtCaixaTexto.getText();
    }

    public void setText(String text) {
        txtCaixaTexto.setText(text);
    }

    /**
     * Adds the specified action listener to receive
     * action events from this textfield.
     *
     * @param l the action listener to be added
     */
    public synchronized void addActionListener(ActionListener l) {
        txtCaixaTexto.addActionListener(l);
    }

    public synchronized void removeActionListener(ActionListener l) {
        txtCaixaTexto.removeActionListener(l);
    }

    public synchronized ActionListener[] getActionListeners() {
        return txtCaixaTexto.getActionListeners();
    }

    public synchronized void addAlteracaoListener(SSAlteracaoListener l) {
        listenerList.add(SSAlteracaoListener.class, l);
    }

    public synchronized void removeAlteracaoListener(SSAlteracaoListener l) {
        listenerList.remove(SSAlteracaoListener.class, l);
    }

    public synchronized SSAlteracaoListener[] getAlteracaoListeners() {
        return listenerList.getListeners(SSAlteracaoListener.class);
    }

    public synchronized void addPesquisaListener(SSPesquisaListener pl) {
        listenerList.add(SSPesquisaListener.class, pl);
    }

    public synchronized void removePesquisaListener(SSPesquisaListener pl) {
        listenerList.remove(SSPesquisaListener.class, pl);
    }

    public synchronized SSPesquisaListener[] getPesquisaListeners() {
        return listenerList.getListeners(SSPesquisaListener.class);
    }

    protected void setCaixaTexto(JTextField txtCaixaTexto) {
        this.remove(this.txtCaixaTexto);
        this.txtCaixaTexto = txtCaixaTexto;
        try {
            jbInit();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected JTextField getCaixaTexto() {
        return txtCaixaTexto;
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        getDocCampoTexto().setTamanhoMaximo(tamanhoMaximo);
    }

    public int getTamanhoMaximo() {
        return getDocCampoTexto().getTamanhoMaximo();
    }

    public void setTudoMaiusculo(boolean tudoMaiusculo) {
        getDocCampoTexto().setTudoMaisculo(tudoMaiusculo);
    }

    public boolean isTudoMaiusculo() {
        return getDocCampoTexto().isTudoMaisculo();
    }

    public boolean isEditavel() {
        return txtCaixaTexto.isEditable();
    }
    public void setEditavel(boolean editavel) {
    	setEditavel(editavel, editavel);
    }
    public void setEditavel(boolean editavel,boolean pesquisaEditavel) {
        txtCaixaTexto.setEditable(editavel);

        if (editavel) {
            //setComponenteCorFundo(SystemColor.activeCaptionText);
            setComponenteCorFonte(SystemColor.controlText);
        } else {
            //setComponenteCorFundo(SystemColor.control);
            setComponenteCorFonte(SSFormulario.getCorFonteSomenteLeitura());
        }
        setFocusable(editavel);
        if (btnPesquisa != null)
            btnPesquisa.setEnabled(pesquisaEditavel);
        //setOpaque(editavel);
    }

    private void txtCaixaTexto_focusLost(FocusEvent e) {
        String valorAtual = getText();
        if (valorAnterior == valorAtual)
            return;
        if (valorAtual != null && valorAtual.equals(valorAnterior))
            return;
        if (valorAnterior != null && valorAnterior.equals(valorAtual))
            return;
    }

    public void setPesquisa(boolean pesquisa) {
        this.pesquisa = pesquisa;

        if (pesquisa) {
            if (btnPesquisa == null)
                adicionarBotaoPesquisa();
            else {
                if (!btnPesquisa.isVisible())
                    btnPesquisa.setVisible(true);
            }
        } else {
            removerBotaoPesquisa();
        }
    }

    public boolean isPesquisa() {
        return pesquisa;
    }

    private void criarBotaoPesquisa() {
        if (btnPesquisa == null) {
            btnPesquisa = new SSBotao();
            btnPesquisa.setText(null);
            btnPesquisa.setFocusable(false);
            btnPesquisa.setIcone("pasta");
            btnPesquisa.setMargin(new Insets(0, 0, 0, 0));

            btnPesquisa.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SSPesquisaListener[] pls = listenerList.getListeners(SSPesquisaListener.class);
                    for (SSPesquisaListener pl : pls) {
                        pl.pesquisaListener(new SSPesquisaEvento(e.getSource()));
                    }
                }
            });

        }
    }

    private void adicionarBotaoPesquisa() {
        criarBotaoPesquisa();
        int topo, esquerda, largura, altura;

        altura = (int)txtCaixaTexto.getSize().getHeight() - 1;
        largura = altura;

        esquerda = txtCaixaTexto.getWidth() - largura - 1;
        topo = 0;

        //btnPesquisa.setBounds(esquerda, topo, largura, altura);
        //txtCaixaTexto.add(btnPesquisa);
        int constantePreenchimento = GridBagConstraints.BOTH;

        GridBagConstraints constraints;

        if (getRotuloPosicao() == SSPosicaoRotulo.TOPO)
            constraints = new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,GridBagConstraints.WEST,
                                                                constantePreenchimento, new Insets(0, 0, 2, 0), 0, 0);
        else
            constraints = new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,GridBagConstraints.WEST,
                                                              constantePreenchimento, new Insets(0, 0, 2, 0), 0, 0);

        this.add(btnPesquisa, constraints);
        updateUI();
    }

    private void removerBotaoPesquisa() {
        this.remove(btnPesquisa);
        btnPesquisa = null;
        updateUI();
    }

    public void setSelectionStart(int inicio) {
        txtCaixaTexto.setSelectionStart(inicio);
    }

    public void setSelectionEnd(int fim) {
        txtCaixaTexto.setSelectionEnd(fim);
    }

    public void select(int inicio, int fim) {
        txtCaixaTexto.select(inicio, fim);
    }

    private void dispararValorAlteradoListener(String valorAnterior, String valorAtual) {
        //Dispara ação valor alterado
        SSAlteracaoListener[] listeners = getAlteracaoListeners();

        //Dispara ação
        for (SSAlteracaoListener listener : listeners) {
            listener.alteracaoListener(new SSAlteracaoEvento(this, valorAnterior, valorAtual));
        }
    }

    public Object getValue() {
        return getText();
    }

    public void setValue(Object value) {
        setText(value != null? value.toString(): null);
    }

    public class DocCampoTexto extends PlainDocument {
        private int tamanhoMaximo;
        // optional uppercase conversion
        private boolean tudoMaisculo = true;

        DocCampoTexto() {
            super();
        }

        public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {
            if (str == null) return;

            if (tamanhoMaximo > 0) {
                if ((getLength() + str.length()) > tamanhoMaximo)
                    return;
            }

            if (tudoMaisculo) str = str.toUpperCase();
            super.insertString(offset, str, attr);
        }



        public void setTamanhoMaximo(int tamanhoMaximo) {
            this.tamanhoMaximo = tamanhoMaximo;
        }

        public int getTamanhoMaximo() {
            return tamanhoMaximo;
        }

        public void setTudoMaisculo(boolean tudoMaisculo) {
            this.tudoMaisculo = tudoMaisculo;
        }

        public boolean isTudoMaisculo() {
            return tudoMaisculo;
        }

        @Override
        protected void removeUpdate(DefaultDocumentEvent chng) {
            super.removeUpdate(chng);
            setAlterado(true);
            dispararValorAlteradoListener(valorAnterior, txtCaixaTexto.getText());
        }


        @Override
        protected void insertUpdate(DefaultDocumentEvent chng, AttributeSet attr) {
            super.insertUpdate(chng, attr);
            setAlterado(true);
            dispararValorAlteradoListener(valorAnterior, txtCaixaTexto.getText());
        }
    }

}
