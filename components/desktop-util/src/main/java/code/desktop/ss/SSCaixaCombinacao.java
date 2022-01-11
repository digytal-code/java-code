package code.desktop.ss;

import javax.swing.*;

import code.desktop.ss.evento.SSPesquisaEvento;
import code.desktop.ss.evento.SSPesquisaListener;
import code.desktop.ss.util.SSReflexao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 *@beaninfo
 *   attribute: isContainer false
 * description: Caixa de combinação.
 *
 * @author  Frank Marlon M. dos Santos
 * @version 1.0 08/18/08
 */
public class SSCaixaCombinacao extends SSComponenteRotulado {
    private JComboBox cboCombo = new JComboBox();
    private List itens;
    private boolean primeiroElementoVazio = true;
    private String campoExibicao;
    private boolean somenteLeitura;
    private JTextField txtCampo; 
    private SSBotao btnPesquisa;
    private boolean pesquisa;
    public SSCaixaCombinacao() {
        super();
        setComponente(cboCombo);        
    }
    public void setPreferredWidth(int width ) {
    	this.setPreferredSize(new Dimension(width, this.getPreferredSize().height));
    }
    public SSBotao getBtnPesquisa() {
		return btnPesquisa;
	}
    public void limparItens() {
        DefaultComboBoxModel model = (DefaultComboBoxModel)cboCombo.getModel();
        model.removeAllElements();
        updateUI();
    }
    
    public void setItens(List itens) {
        this.itens = itens;
        //Object value = getValue();
        carregarCombo();
        //setValue(value);
    }
    
    public void setItens(List itens, String campoExibicao) {        
        setCampoExibicao(campoExibicao);        
        setItens(itens);
    }

    public Object getItens() {
        return itens;
    }
    
    public void setItens(Object itens[]) {
        setItens(Arrays.asList(itens));
    }
    
    public void setItens(Object itens[], String campoExibicao) {
        setItens(Arrays.asList(itens), campoExibicao);
    }
    
    public void setValue(Object valor) {
        Object novoValor = valor;
        Object valorAtual = getValue();
        
        if (valorAtual == novoValor)
            return;
        if (valorAtual != null && valorAtual.equals(novoValor))
            return;
        
        SSItemSelecao item = null;
        
        DefaultComboBoxModel model = (DefaultComboBoxModel)cboCombo.getModel();
        item = new SSItemSelecao((valor == null? null: valor.toString()), valor);
        int posicao = model.getIndexOf(item);
        item = (SSItemSelecao)model.getElementAt(posicao);
        
        cboCombo.setSelectedItem(item);
        if (txtCampo != null)
            txtCampo.setText(item.getRotulo());
        
    }
    public void setPesquisaIcone(String icone) {
    	btnPesquisa.setIcone(icone);
    }
    public Object getValue() {
        SSItemSelecao item = (SSItemSelecao)cboCombo.getSelectedItem();
        if (item == null)
            return null;
        else
            return item.getValor();        
    }
    
    private void carregarCombo() {
        DefaultComboBoxModel model = (DefaultComboBoxModel)cboCombo.getModel();
        limparItens();
        Object[] array = new Object[0];
        
        if (isPrimeiroElementoVazio()) {
            model.addElement(new SSItemSelecao("", null));
        }
        
        if (itens instanceof Collection)
            array = ((Collection)itens).toArray();
        if (itens instanceof List)
            array = ((List)itens).toArray();
        
        SSItemSelecao item;
        String rotulo;
        
        for (Object obj : array) {
            rotulo = null;
            
            if (getCampoExibicao() != null) {
                Object valor = buscarCampo(getCampoExibicao(), obj);
                if (valor == null)
                    rotulo = null;
                else
                    rotulo = valor.toString();
            } else {
                rotulo = obj != null? obj.toString(): null;
            }
            
            item = new SSItemSelecao(rotulo, obj);
            
            model.addElement(item);
        }
        
    }
    
    private Object buscarCampo(String nomeCampo, Object objeto) {                
        Object valor = null;
                        
        if (nomeCampo != null) {            
            try {
                valor = SSReflexao.buscarValorCampoRecursivo(objeto, nomeCampo);
            } catch (NoSuchFieldException e) {
                System.out.println(nomeCampo + ": " + e.toString());
                return null;
            } catch (IllegalAccessException e) {
                System.out.println(nomeCampo + ": " + e.toString());
                return null;
            }
        }        
        return valor;
    }

    public void setPrimeiroElementoVazio(boolean primeiroElementoVazio) {
        this.primeiroElementoVazio = primeiroElementoVazio;
    }

    public boolean isPrimeiroElementoVazio() {
        return primeiroElementoVazio;
    }

    public void setCampoExibicao(String campoExibicao) {
        this.campoExibicao = campoExibicao;
    }

    public String getCampoExibicao() {
        return campoExibicao;
    }

    public String getText() {
        if (cboCombo.getSelectedItem() == null)
            return null;
        else
            return cboCombo.getSelectedItem().toString();
    }

    public void setText(String text) {
        SSItemSelecao item;
        DefaultComboBoxModel model = (DefaultComboBoxModel)cboCombo.getModel();
        
        for (int i = 0; i < model.getSize(); i++) {
            item = (SSItemSelecao)model.getElementAt(i);            
            if (item != null && item.getRotulo() != null && item.getRotulo().equalsIgnoreCase(text)) {
                cboCombo.setSelectedIndex(i);
                if (txtCampo != null)
                    txtCampo.setText(text);
            }
        }
    }

    public boolean isEditavel() {
        return cboCombo.isEditable();
    }

    public void setEditavel(boolean editavel) {
        cboCombo.setEditable(editavel);
        if (btnPesquisa != null)
            btnPesquisa.setEnabled(editavel);
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
            btnPesquisa.setMargin(new Insets(1, 1, 1, 1));
            
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
        altura = (int)cboCombo.getSize().getHeight() - 1;
        largura = altura;
        esquerda = cboCombo.getWidth() - largura - 1;
        topo = 0;
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
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        cboCombo.setEnabled(enabled);
    }
    
    public void addActionListener(ActionListener l) {
        cboCombo.addActionListener(l);
    }
    
    public void removeActionListener(ActionListener l) {
        cboCombo.removeActionListener(l);
    }
    
    public ActionListener[] getActionListeners() {
        return cboCombo.getActionListeners();
    }
    
    public void setPopupComRolagem(boolean rolagem) {
        if (rolagem)
            cboCombo.setUI(new SSCaixaCombinacaoUI());
    }


    public void setSomenteLeitura(boolean somenteLeitura) {
        boolean alterado = this.somenteLeitura != somenteLeitura;
        this.somenteLeitura = somenteLeitura;
        if (alterado)
            atualizarVisualizacao();
    }

    public boolean isSomenteLeitura() {
        return somenteLeitura;
    }

    private void atualizarVisualizacao() {
        if (somenteLeitura) {
            if (txtCampo == null) {
                txtCampo = new JTextField();
                txtCampo.setEditable(false);
                txtCampo.setFocusable(false);
                //txtCampo.setForeground(SSFormularioUtil.getCorFonteSomenteLeitura());                
                //txtCampo.setBackground(SystemColor.control);
            }
            SSItemSelecao item = (SSItemSelecao)cboCombo.getSelectedItem();
            if (item != null)
                txtCampo.setText(item.getRotulo());
            setComponente(txtCampo);            
        } else
            setComponente(cboCombo);
        getComponente().setEnabled(this.isEnabled());
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
}

