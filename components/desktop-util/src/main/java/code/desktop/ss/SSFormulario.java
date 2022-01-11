package code.desktop.ss;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import code.desktop.ss.util.SSReflexao;
import code.desktop.ss.util.SSTexto;
import code.desktop.ss.util.SSValidacao;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class SSFormulario {
    private static Object respostaDialogo;    
    
    public static Color getCorFonteSomenteLeitura() {
        return UIManager.getColor("TitledBorder.titleColor");
    }
    
    public static Color getCorFonteNormal() {
        return SystemColor.controlText;
    }
    
    public static void ocuparCursor(Component c) {        
        //c = c.getParent();        
        c.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));        
    }
    
    public static void normalizarCursor(Component c) {        
        //c = c.getParent();        
        c.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    
    public static void desativarControles(JComponent[] controles) {
        for (JComponent controle : controles) {
            controle.setEnabled(false);
        }
    }
    
    public static boolean validarCampos(JComponent painel) {
        SSComponenteRotulado componente;
        String mensagem = null;
        for (int i = 0; i < painel.getComponentCount(); i++) {            
            if (painel.getComponent(i) instanceof SSComponenteRotulado) {
                componente = ((SSComponenteRotulado)painel.getComponent(i));
                mensagem = validarCampo(componente);
                if (mensagem != null) {
                    //Verifica se o campo está dentro de uma aba
                    if (componente.getParent() != null) {
                        Container parent = componente.getParent();
                        if (parent.getParent() != null && parent.getParent() instanceof JTabbedPane) {
                            ((JTabbedPane)parent.getParent()).setSelectedComponent(parent);
                        }
                    }
                    
                    SSMensagem.avisa(mensagem);
                    componente.requestFocus();
                    return false;
                }
            } else {
                if (painel.getComponent(i) instanceof JComponent)
                    if (!validarCampos((JComponent)painel.getComponent(i)))
                        return false;
            }
        }
        return true;
    }
    
    public static String validarCampo(SSComponenteRotulado campo)  {
        return validarCampo(campo, true);
    }
    
    public static String validarCampo(SSComponenteRotulado campo, boolean validarCampoObrigatorio)  {
        String mensagem = null;
        if (campo.isObrigatorio() && validarCampoObrigatorio) {
            mensagem = "Campo '" + campo.getRotulo() + "' não informado";
            if (campo instanceof SSCampoMascara) {
                if (((SSCampoMascara)campo).getClipText() == null) {
                    return mensagem;
                }
                if (((SSCampoMascara)campo).getClipText().trim().length() == 0) {
                    return mensagem;
                }
            } else {
                if (campo.getText() == null) {
                    return mensagem;
                }
                if (campo.getText().trim().length() == 0) {
                    return mensagem;            
                }
            }
        } else {
            if (campo.getText() == null || campo.getText().length() == 0)
                return null;
        }
        
        if (campo instanceof SSCampoNumero) {
            if (!((SSCampoNumero)campo).isPermitirZero()) {
                if (((SSCampoNumero)campo).getValue() != null) {
                    if (((SSCampoNumero)campo).getNumero().doubleValue() == 0) {
                        mensagem = "Informe um valor maior que zero";
                        return mensagem;
                    }
                }
            }
        }
        
        //Verifica validações de dados
        if (campo.getTipoValidacao() == null)
            return null;
        else {         
            try {
                Method metodo;
                metodo = SSValidacao.class.getMethod(campo.getTipoValidacao(), String.class);
                Object retorno;
                retorno = metodo.invoke(null, campo.getText());
                mensagem = getMensagemValidacao(campo.getTipoValidacao());
                if (retorno.equals(false))
                    return mensagem;
                else
                    return null;
            }catch(NoSuchMethodException e) {
                System.err.println("Erro ao validar campo: " + e.toString());
            } catch (IllegalAccessException e) {
                System.err.println("Erro ao validar campo: " + e.toString());
            } catch (InvocationTargetException e) {
                System.err.println("Erro ao validar campo: " + e.toString());
            }
        }
        
        return mensagem;
    }
    
    public static String getMensagemValidacao(String tipo) {
        Map mensagens = new HashMap();
        mensagens.put("cpf", "CPF inválido");
        mensagens.put("cnpj", "CNPJ inválido");
        mensagens.put("data", "Data incorreta");
        mensagens.put("hora", "Hora incorreta");
        mensagens.put("dataHora", "Data/Hora inválida");
        mensagens.put("email", "Formato de e-mail incorreto");
        mensagens.put("numero", "Número inválido");
        
        return (String)mensagens.get(tipo);
    }
    
    public static void selecionarCampo(JTextComponent controle) {
        if (controle.getText() == null)
            return;
        controle.setSelectionStart(0);        
        controle.setSelectionEnd(controle.getText().length());
    }
    
    public static void configurarEnterTab(JPanel frame) {
        // Colocando enter para pular de campo        
        HashSet conj = new HashSet(frame.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS)); 
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
        frame.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
    }
    
    public static void centralizarFormularioInterno(JDesktopPane mdi, JInternalFrame form) {
        Dimension screenSize = mdi.getSize();
        Dimension frameSize = form.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        form.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );        
    }
    
    private static void centralizarComponente(Component form) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = form.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        form.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );        
    }
    
    public static void centralizarFormulario(JWindow form) {
        centralizarComponente(form);
    }
    
    public static void centralizarFormulario(JDialog form) {
        centralizarComponente(form);
    }
    
    public static void fecharDialogo(JPanel form, Object resposta) {
        setRespostaDialogo(resposta);
        fecharFormulario(form);
    }
    
    public static void fecharFormulario(JPanel form) {
        Component comp = form.getRootPane().getParent();
        if (comp instanceof JFrame) {
            ((JFrame)comp).dispose();
        } else if (comp instanceof JDialog) {
            ((JDialog)comp).setVisible(false);
        } else {
            ((JInternalFrame)comp).dispose();
        }
    }
    
    public static String buscarTitulo(JPanel formulario) {
        String titulo = null;
        
        
        for (int i = 0; i < formulario.getComponentCount(); i++) {
            if (formulario.getComponent(i) instanceof SSCabecalho) {
                titulo = ((SSCabecalho)formulario.getComponent(i)).getTitulo();
            }
        }
        
        return titulo;
    }    
    
    public static JInternalFrame abrirFormularioInterno(JDesktopPane desktopPanel, JPanel formulario) {       
        return abrirFormularioInterno(desktopPanel, formulario, true);
    }
    
    public static JInternalFrame abrirFormularioInterno(JDesktopPane desktopPanel, JPanel formulario, boolean ajustarTamanho) {        
        //Verifica se o form já está aberto
        for (JInternalFrame inFrame : desktopPanel.getAllFrames()) {
            if (inFrame.getContentPane().getComponent(0).getClass() == formulario.getClass()) {                                
                desktopPanel.getDesktopManager().activateFrame(inFrame);
                try {
                    inFrame.setMaximum(true);
                    inFrame.setMaximum(false);
                } catch (PropertyVetoException e) {
                    e.printStackTrace();
                }
                return inFrame;
            }
        }
        
        String titulo = buscarTitulo(formulario);
        
        JInternalFrame inFrame = new JInternalFrame(titulo, true, true, false, true);        
        /*inFrame.setMaximizable(false);
        inFrame.setResizable(true); 
        inFrame.setIconifiable(true);
        inFrame.setClosable(true);   */
           
        inFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //FrmConsultaTabelaGenerica form = new FrmConsultaTabelaGenerica();        
        inFrame.add(formulario, BorderLayout.CENTER);                
        
        if (ajustarTamanho) {
            int largura, altura;
            
            Dimension tamanhoMaximo = new Dimension();
            
            largura = (int)desktopPanel.getSize().getWidth() - 10;
            altura = (int)desktopPanel.getSize().getHeight() - 10;
            
            tamanhoMaximo.setSize(largura, altura);
            inFrame.setMaximumSize(tamanhoMaximo);
            
            inFrame.pack();
            
            largura = (int)inFrame.getSize().getWidth() + 10;
            altura = (int)inFrame.getSize().getHeight() + 10;        
            
            altura = (int)Math.min(altura, tamanhoMaximo.getHeight());
            largura = (int)Math.min(largura, tamanhoMaximo.getWidth());
            
            //Ajusta o pack()            
            inFrame.setSize(largura, altura);
        } else
            inFrame.setSize(formulario.getSize());
        
        desktopPanel.add(inFrame);
        centralizarFormularioInterno(desktopPanel, inFrame);
        inFrame.setVisible(true);  
        try {
            inFrame.setIcon(true);      
            //inFrame.setFrameIcon(((JFrame)desktopPanel.getRootPane().getParent()).);            
            inFrame.setResizable(true);
            inFrame.setMaximum(true);
            inFrame.setMaximum(false);
        } catch (PropertyVetoException e) {            
            e.printStackTrace();
        }
        
        return inFrame;
                
    }
    
    public static Object abrirDialogo(JPanel form, JDialog frmDono) { 
        return abrirDialogoGeral(form, frmDono);
    }
    
    public static Object abrirDialogo(JPanel form, JFrame frmDono) { 
        return abrirDialogoGeral(form, frmDono);
    }
    
    public static Object abrirDialogo(JFrame form, JFrame frmDono) { 
        return abrirDialogoGeral((JFrame)form, frmDono);
    }
    
    public static Object abrirDialogo(JPanel form, JPanel frmDono) {
        Container conteiner = frmDono.getRootPane().getParent();
        if (conteiner instanceof JDialog) {
            return abrirDialogo(form, (JDialog)conteiner);
        } else         if (conteiner instanceof JDialog) {
            return abrirDialogo(form, (JFrame)conteiner);
        } else {
            return abrirDialogo(form, (JFrame)null);
        }
    }
    
    private static Object abrirDialogoGeral(Container form, Container frmDono) { 
        setRespostaDialogo(null);
        JDialog dialog;
        if (frmDono instanceof JFrame)
            dialog = new JDialog((JFrame)frmDono);
        else if (frmDono instanceof JDialog)
            dialog = new JDialog((JDialog)frmDono);
        else
            dialog = new JDialog();
        if (form instanceof JPanel) {
            dialog.setTitle(buscarTitulo((JPanel)form));
            //JFrame frame = new JFrame();
            //frame.setTitle(buscarTitulo((JPanel)form));
            //frame.getContentPane().add(form);
            //form = frame;
        }
        if (form instanceof JFrame)        
            dialog.setTitle(((JFrame)form).getTitle());
        dialog.setResizable(true);
        dialog.setModal(true);
        dialog.setContentPane(form);
        //dialog.setSize(form.getSize());
        dialog.pack();
        dialog.setLocationRelativeTo(frmDono);
        //centralizarFormulario(dialog);        
        dialog.setVisible(true);        
        //dialog.pack();
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.dispose();
        return getRespostaDialogo();
    }

    private static void setRespostaDialogo(Object respostaDialogo) {
        SSFormulario.respostaDialogo = respostaDialogo;
    }

    private static Object getRespostaDialogo() {
        return respostaDialogo;
    }
    
    public static void definirCamposEditaveis(JComponent painel, boolean editavel) {
        for (Component comp : painel.getComponents()) {            
            if (comp instanceof SSCaixaCombinacao) {
                ((SSCaixaCombinacao)comp).setSomenteLeitura(!editavel);
            } else if (comp instanceof SSComponenteRotulado) {
                ((SSComponenteRotulado)comp).setEditavel(editavel);
            } else if (comp instanceof JPanel) { 
                //comp.setEnabled(editavel);
                definirCamposEditaveis((JComponent)comp, editavel);
            } else if (comp instanceof JTabbedPane || comp instanceof JScrollPane || comp instanceof JViewport) {
                definirCamposEditaveis((JComponent)comp, editavel);            
            } else if (comp instanceof JTextPane) {
                ((JTextPane)comp).setEditable(editavel);
                if (!editavel)
                    comp.setBackground(SystemColor.control);
            } else if (comp instanceof JTextArea) {
                ((JTextArea)comp).setEditable(editavel);
                if (!editavel)
                    comp.setBackground(SystemColor.control);                
            } else if (comp instanceof JCheckBox) {
                JCheckBox chk = (JCheckBox)comp;
                if (!editavel)
                    chk.setModel(new SSModeloCheckBoxBloqueado(chk));
            }
        }
    }
    
    public static void preencherCampos(JComponent painel, Object objeto) {
        for (Component comp : painel.getComponents()) {
            if (comp instanceof SSComponenteRotulado)
                preencherCampo((SSComponenteRotulado)comp, objeto);
            else if (comp instanceof JComponent)
                preencherCampos((JComponent)comp, objeto);
        }
    }

    private static void preencherCampo(SSComponenteRotulado comp, Object objeto) {
        Object valor;

        try {
            valor = SSReflexao.buscarValorCampoRecursivo(objeto, comp.getCampoLigacao());
            if (valor == null)
                comp.setText(null);
            else {
                if (comp instanceof SSCampoMascara) {                                        
                    if (comp.getClass() == SSCampoMascara.class && ((SSCampoMascara)comp).getMascara() != null) {
                        comp.setText(SSTexto.aplicaMascara(valor.toString(), ((SSCampoMascara)comp).getMascara()));  
                    } else {
                        ((SSCampoMascara)comp).setValue(valor);
                    }
                } else if (comp instanceof SSCaixaCombinacao)
                    ((SSCaixaCombinacao)comp).setValue(valor);
                else
                    comp.setText(valor.toString());
            }
        } catch (Exception e) {
            if (e instanceof IllegalAccessException)
                throw new RuntimeException("Erro ao carregar valor para o campo: " + comp.getCampoLigacao(), e);
        }
    }
    
    public static void preencherObjeto(Object objeto, JComponent painel) {
        for (Component comp : painel.getComponents()) {
            if (comp instanceof SSComponenteRotulado) {
                if (((SSComponenteRotulado)comp).isCampoAtualizavel() && ((SSComponenteRotulado)comp).getCampoLigacao() != null)
                    preencherCampoObjeto((SSComponenteRotulado)comp, objeto);
            }
            else if (comp instanceof JComponent)
                preencherObjeto(objeto, (JComponent)comp);
        }
    }
  
    private static void preencherCampoObjeto(SSComponenteRotulado comp, Object objeto) {
        Object valor;        
        
        try {
            if (comp instanceof SSCampoMascara) {
                SSCampoMascara mask = ((SSCampoMascara)comp);
                if (comp.getClass() == SSCampoMascara.class && mask.getMascara() != null) {
                    valor = mask.getValue();
                    if (valor == null && mask.getClipText() != null && mask.getClipText().trim().length() > 0)
                        valor = mask.getClipText();
                } else {
                    valor = mask.getValue();
                }
                
            } else if (comp instanceof SSCaixaCombinacao && !((SSCaixaCombinacao)comp).isEditavel())
                valor = ((SSCaixaCombinacao)comp).getValue();
            else
                valor = comp.getText();
                        
            SSReflexao.definirValorCampoRecursivo(objeto, comp.getCampoLigacao(), valor);
        } catch (Exception e) {
            //if (e instanceof IllegalAccessException)
            throw new RuntimeException("Erro ao definir valor para o campo: " + comp.getCampoLigacao(), e);
        }
    }
    
    public static void limparCampos(JComponent painel) {
        for (Component comp : painel.getComponents()) {
            if (comp instanceof SSComponenteRotulado) {
                ((SSComponenteRotulado)comp).setValue(null);
            } 
            else if (comp instanceof JTextComponent)
                ((JTextComponent)comp).setText(null);
            else if (comp instanceof JComboBox)
                ((JComboBox)comp).setSelectedItem(null);
            else if (comp instanceof JComponent)
                limparCampos((JComponent)comp);
        }
    }
    
    public static void definirAtivacaoRecursiva(JComponent painel, boolean ativo) {
        painel.setEnabled(ativo);
        for (Component comp : painel.getComponents()) {            
            if (comp instanceof JComponent)
                definirAtivacaoRecursiva((JComponent)comp, ativo);            
        }
    }
    
}
