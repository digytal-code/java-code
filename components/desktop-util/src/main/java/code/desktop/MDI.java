package code.desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import code.Imagens;

public abstract class MDI extends JFrame {
    private JDesktopPane areaTrabalho = new JDesktopPane();
    protected JMenuBar barraMenu = new JMenuBar();
    private JLabel cEmpresa = new JLabel("EMPRESA");
    private JLabel cLogin = new JLabel("LOGIN");
    private JLabel cAmbiente = new JLabel("PRODUÇÃO");
    private JLabel cConexao = new JLabel("CONEXÃO");

    private JLabel imagemFundo = new JLabel();
    private ImageIcon imgFundo;
    private FormularioSessao sessao;
    
    public MDI() {
        areaTrabalho.setBackground(Color.LIGHT_GRAY);
        areaTrabalho.setVisible(true);
        getContentPane().setLayout(new BorderLayout());


        JLabel lblName = new JLabel("EMPRESA:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblUser = new JLabel("LOGIN:");
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblEnv = new JLabel("AMBIENTE:");
        lblEnv.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblVersao = new JLabel("Versão: 1.0");
        lblVersao.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblCnn = new JLabel("CONEXÃO");
        lblCnn.setFont(new Font("Tahoma", Font.BOLD, 11));

        lblVersao.setFont(new Font("Tahoma", Font.BOLD, 11));
        cLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
        cEmpresa.setFont(new Font("Tahoma", Font.BOLD, 11));
        cAmbiente.setFont(new Font("Tahoma", Font.BOLD, 11));
        cConexao.setFont(new Font("Tahoma", Font.BOLD, 11));

        cLogin.setForeground(Color.BLUE);
        cEmpresa.setForeground(Color.BLUE);
        cAmbiente.setForeground(Color.BLUE);
        cConexao.setForeground(Color.BLUE);

        JPanel barraSessao = new JPanel();
        barraSessao.setLayout(new FlowLayout(FlowLayout.LEFT));
        getContentPane().add(barraSessao,BorderLayout.NORTH);

        barraSessao.add(lblUser);
        barraSessao.add(cLogin);

        barraSessao.add(lblName);
        barraSessao.add(cEmpresa);

        barraSessao.add(lblEnv);
        barraSessao.add(cAmbiente);

        barraSessao.add(lblCnn);
        barraSessao.add(cConexao);

        barraSessao.add(lblVersao);

        getContentPane().add(areaTrabalho, BorderLayout.CENTER);
        setJMenuBar(barraMenu);
        setTitle("Digytal");

        this.setIconImage(Imagens.png("app").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(1200, 820);
        setLocationRelativeTo(null);

        imgFundo = Imagens.jpg("fundo");
        imagemFundo.setIcon(imgFundo);
        areaTrabalho.add(imagemFundo);
        areaTrabalho.setBackground(Color.LIGHT_GRAY);
        areaTrabalho.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                desktopPane_componentResized(e);
            }
        });
    }
    private void desktopPane_componentResized(ComponentEvent e) {
        if (imgFundo == null)
            return;

        int top, left;

        top = (areaTrabalho.getWidth() / 2) - (imgFundo.getIconWidth() / 2);
        left = (areaTrabalho.getHeight() / 2) - (imgFundo.getIconHeight() / 2);

        imagemFundo.setBounds(top, left - 20, imgFundo.getIconWidth(), imgFundo.getIconHeight());
    }
    
    public void setSessao(FormularioSessao sessao) {
		this.sessao = sessao;
	}
    public void exibir() {
    	setVisible(true);
    }
    public JDesktopPane getAreaTrabalho() {
        return areaTrabalho;
    }
   
    public JMenuBar getBarraMenu() {
        return barraMenu;
    }
    public void exibir(Formulario formulario) {
		formulario.setMdi(this);
		formulario.preExibir();
		formulario.exibir();
	}
    
}
