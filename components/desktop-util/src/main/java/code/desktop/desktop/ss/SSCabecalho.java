package code.desktop.desktop.ss;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;


public class SSCabecalho extends JPanel {
    private JLabel lblTitulo = new JLabel();
    private JLabel lblDescricao = new JLabel();    
    private GridBagLayout gridBagLayout1 = new GridBagLayout();

    public SSCabecalho() {
        super();
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(431, 54));        
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(gridBagLayout1);
        lblTitulo.setText("Título do Formulário");
        lblTitulo.setFont(new Font("Dialog", 1, 15));
        lblDescricao.setText("Descrição do formulário");
        lblDescricao.setAlignmentY((float) 10.0);        
        this.add(lblTitulo,
                 new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                        GridBagConstraints.HORIZONTAL,
                                        new Insets(5, 5, 0, 5), 0, 0));
        this.add(lblDescricao,
                 new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                                        GridBagConstraints.HORIZONTAL,
                                        new Insets(5, 20, 5, 5), 0, 0));        
    }
    public void setTitulo(String titulo) {
        lblTitulo.setText(titulo);
    }
    
    public String getTitulo() {
        return lblTitulo.getText();
    }
    
    public void setDescricao(String descricao) {
        lblDescricao.setText(descricao);
    }
    
    public String getDescricao() {
        return lblDescricao.getText();
    }    
    
    protected void paintComponent(Graphics g) {
       Graphics2D g2 = (Graphics2D)g;
    
       int w = getWidth();
       int h = getHeight();
       
       Color color1 = Color.white;
       Color color2 = UIManager.getColor("control");
        
       GradientPaint gradient = new  GradientPaint(0, 0, color1, w, h, color2, true);
       g2.setPaint(gradient); 
       g2.fillRect(0, 0, w, h);
    }
    
}
