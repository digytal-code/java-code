package code.desktop.desktop.ss;

import javax.swing.*;
import java.awt.*;


public class SSMensagem {
    
    public static void definirPadraoBrasil() {
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        JOptionPane.getRootFrame().setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    public static boolean confirma(String mensagem) {      
        Object o;
        if (mensagem.length() > 300) {
            JTextArea tf = new JTextArea(mensagem);
            tf.setEditable(false);
            tf.setOpaque(false);
            tf.setBackground(SystemColor.control);
            //tf.setDragEnabled(true);
            tf.setLineWrap(true);
            JScrollPane jsp = new JScrollPane(tf);
            jsp.setPreferredSize(new Dimension(400, 200));
            o = jsp;
        } else
            o = mensagem;
        if (JOptionPane.showConfirmDialog(null, o, "Confirmação", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) 
            return true;
        else
            return false;
    }
    
    public static boolean pergunta(String mensagem) {        
        Object o;
        if (mensagem.length() > 300) {
            JTextArea tf = new JTextArea(mensagem, 8, 50);
            tf.setEditable(false);
            tf.setOpaque(false);        
            tf.setBackground(SystemColor.control);
            //tf.setDragEnabled(true);
            tf.setLineWrap(true);
            JScrollPane jsp = new JScrollPane(tf);
            jsp.setPreferredSize(new Dimension(400, 200));
            o = jsp;
        } else
            o = mensagem;
        if (JOptionPane.showConfirmDialog(null, mensagem, "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) 
            return true;
        else
            return false;
    }
    
    public static void erro(String mensagem) {
        erro(null, mensagem);
    }
    
    public static void erro(Component parent, String mensagem) {
        JTextArea tf = new JTextArea(mensagem, 8, 50);
        tf.setEditable(false);
        tf.setOpaque(false);        
        tf.setBackground(SystemColor.control);
        //tf.setDragEnabled(true);
        tf.setLineWrap(true);
        JScrollPane sp = new JScrollPane(tf);
        JOptionPane.showMessageDialog(parent, sp, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void erro(Exception e) {
        erro((Component)null, e);
    }
    
    public static void erro(Component parent, Exception e) {
        String mensagem = "Uma operação ilegal resultou em um erro." ;
        erro(parent, mensagem, e);
    }
    
    public static void erro(String mensagem, Exception e) {                
        erro(null, mensagem, e);
    }
    
    public static void erro(Component parent, String mensagem, Exception e) {                
        mensagem += "\n\nErro: " + e.getClass().getName();
        
        if (e.getMessage() != null && e.getMessage().length() > 0)
            mensagem += "\nMensagem: "  + e.getMessage();
        
        e.printStackTrace();
        
        erro(mensagem);
    }
    
    public static void informa(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    public static void informa(JComponent componente, String mensagem) {
        JOptionPane.showMessageDialog(componente, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    public static void avisa(String mensagem) {
        avisa("",mensagem);        
    }
    
    public static void avisa(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso " + titulo, JOptionPane.WARNING_MESSAGE);        
    }
    public static void avisa(JComponent componente, String mensagem) {
        Object o;
        if (mensagem.length() > 300) {
            JTextArea tf = new JTextArea(mensagem, 8, 50);
            tf.setEditable(false);
            tf.setOpaque(false);        
            tf.setBackground(SystemColor.control);
            //tf.setDragEnabled(true);
            tf.setLineWrap(true);
            o = new JScrollPane(tf);
        } else {
            o = mensagem;
        }
        
        JOptionPane.showMessageDialog(componente, o, "Aviso", JOptionPane.WARNING_MESSAGE);        
    }
    
}
