package loginetapa03;

import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Cadastro extends JFrame{

    private JLabel lblNome;
    private JLabel lblSenha;
    private JLabel lblPerfil;
    private JTextField nomeTxt;
    private JPasswordField senhaTxt;
    private JComboBox<String> caixa;
    private JButton cadastrar;
    private JButton limpar;
    private JButton logar;
    private String opcoes[] = {"Administrador", "Técnico", "Comum"};
    private JPanel botoes;
    private JPanel txt;
    private UserText ListaRegistro;
    
    public Cadastro(ArrayList<Usuario> usuarios, boolean temAdministrador,UserText ListaRegistro) {
        Container c = getContentPane();
        this.ListaRegistro = ListaRegistro;
        
        txt = new JPanel();
        botoes = new JPanel();
        lblNome = new JLabel("Usuário:");
        lblSenha = new JLabel("Senha:");
        lblPerfil = new JLabel("Perfil:");
        nomeTxt = new JTextField();
        senhaTxt = new JPasswordField();
        caixa = new JComboBox<>(opcoes);
        cadastrar = new JButton("Cadastrar");
        logar = new JButton("Logar");
        limpar = new JButton("Limpar");

        txt.setLayout(new GridLayout(3, 2));
        botoes.setLayout(new FlowLayout());


        txt.add(lblNome);
        txt.add(nomeTxt);
        txt.add(lblSenha);
        txt.add(senhaTxt);
        txt.add(lblPerfil);
        txt.add(caixa);

        botoes.add(cadastrar);
        botoes.add(limpar);
        botoes.add(logar);

        c.setLayout(new GridLayout(2, 1));
        c.add(txt);
        c.add(botoes);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Cadastro Usuario");
        setSize(900, 500);
        desativarBtn(false, "senha");

        CadastroController Controller = new CadastroController(this, usuarios, temAdministrador,ListaRegistro);
    }
    public String getNome(){
        return nomeTxt.getText();
    }

    public String getSenha(){
        return new String(senhaTxt.getPassword());
    }

    public String getPerfil(){
        return (String) caixa.getSelectedItem();
    }

    public void mensagem(String msg, String titulo) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.WARNING_MESSAGE);
    }

    public void desativarBtn(boolean cond, String item) {
        if (item.equalsIgnoreCase("senha")) {
            senhaTxt.setEnabled(cond);
        } else if (item.equalsIgnoreCase("nome")) {
            nomeTxt.setEnabled(cond);
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

    public void addCadastrarListener(ActionListener listener){
        cadastrar.addActionListener(listener);
    }

    public void addLimparListener(ActionListener listener){
        limpar.addActionListener(listener);
    }

    public void addLogarListener(ActionListener listener){
        logar.addActionListener(listener);
    }
}
