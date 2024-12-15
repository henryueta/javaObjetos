package loginetapa03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

    private JLabel lblNome;
    private JLabel lblSenha;
    private JTextField nomeTxt;
    private JPasswordField senhaTxt;
    private JButton cadastrar;
    private JButton limpar;
    private JButton logar;
    private JPanel info;
    private JPanel botoes;
    private ArrayList<Usuario> usuarios;
    private boolean temAdministrador;
    private int tentativas;
    private LoginController LoginController;
    private UserText ListaRegistro;

    public Login(ArrayList<Usuario> usuarios,boolean temAdministrador, UserText ListaRegistro) {
        this.usuarios = usuarios;
        Container c = getContentPane();
        this.temAdministrador = temAdministrador;
        this.LoginController = new LoginController(this, usuarios, temAdministrador);
        this.ListaRegistro = ListaRegistro;
        info = new JPanel();
        botoes = new JPanel();
        lblNome = new JLabel("Usu�rio:");
        lblSenha = new JLabel("Senha:");
        nomeTxt = new JTextField();
        senhaTxt = new JPasswordField();
        cadastrar = new JButton("Cadastrar");
        logar = new JButton("Logar");
        limpar = new JButton("Limpar");
        tentativas = 3;
        info.setLayout(new GridLayout(2, 2));
        botoes.setLayout(new FlowLayout());

        info.add(lblNome);
        info.add(nomeTxt);
        info.add(lblSenha);
        info.add(senhaTxt);
        botoes.add(cadastrar);
        cadastrar.addActionListener(this);

        botoes.add(limpar);
        limpar.addActionListener(this);

        botoes.add(logar);
        logar.addActionListener(this);

        c.setLayout(new GridLayout(2, 1));
        c.add(info);
        c.add(botoes);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Login Usuario");
        setSize(900, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrar) {
            Cadastro telaCadastro = new Cadastro(usuarios, temAdministrador,ListaRegistro);
            setVisible(false);
        } else if (e.getSource() == limpar) {
            limparTexto(true, true);
        } else if (e.getSource() == logar) {
            String nome = nomeTxt.getText();
            String senha = new String(senhaTxt.getPassword());
            if (LoginController.validarCampos(nome, senha)){
                LoginController.logarUser(nome, senha);
            }
        }
    }

    public void limparTexto(boolean nome, boolean senha) {
        if (nome) {
            nomeTxt.setText("");
        }
        if (senha) {
            senhaTxt.setText("");
        }

    }

    public void mensagem(String msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public void bloquearUser() {
        nomeTxt.setEnabled(false);
        senhaTxt.setEnabled(false);
    }

}
