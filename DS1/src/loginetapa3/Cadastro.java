package loginetapa3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.util.ArrayList;

public class Cadastro extends JFrame implements ActionListener {

	JLabel lblNome;
	JLabel lblSenha;
	JLabel lblPerfil;
	JTextField nomeTxt;
	JPasswordField senhaTxt;
	JComboBox caixa;
	JOptionPane popup;
	JButton cadastrar;
	JButton limpar;
	JButton logar;
	String opcoes[] = { "Administrador", "Técnico", "Comum" };
	private String nomeVeri;
	private String senhaVeri;
	JPanel botoes;
	JPanel txt;
	private ArrayList<Usuario> usuarios;
	private String etapa;
	boolean userCadastrado;
	int confirma;
	private String nivel;

	public Cadastro(ArrayList<Usuario> usuarios, boolean userCadastrado) {
		Container c = getContentPane();
		this.usuarios = usuarios;
		this.userCadastrado = userCadastrado;
		popup = new JOptionPane();
		JPanel txt = new JPanel();
		JPanel botoes = new JPanel();
		lblNome = new JLabel("Usuário:");
		lblSenha = new JLabel("Senha:");
		lblPerfil = new JLabel("Perfil:");
		nomeTxt = new JTextField();
		senhaTxt = new JPasswordField();
		caixa = new JComboBox<>(opcoes);
		cadastrar = new JButton("Cadastrar");
		logar = new JButton("Logar");
		limpar = new JButton("Limpar");
		
		
		
		confirma = 0;
		nivel = "nome";

		txt.setLayout(new GridLayout(3, 2));
		botoes.setLayout(new FlowLayout());

		txt.add(lblNome);
		txt.add(nomeTxt);
		txt.add(lblSenha);
		txt.add(senhaTxt);
		txt.add(lblPerfil);
		txt.add(caixa);

		botoes.add(cadastrar);
		cadastrar.addActionListener(this);

		botoes.add(limpar);
		limpar.addActionListener(this);

		botoes.add(logar);
		logar.addActionListener(this);

		c.setLayout(new GridLayout(2, 1));
		c.add(txt);
		c.add(botoes);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Cadastro Usuario");
		setSize(900, 500);
		DesativarBtn(false, "senha");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			cadastroUser();
		} else if (e.getSource() == limpar) {
			limparTexto(true,true);
		} else if (e.getSource() == logar) {
			Login telaLogin = new Login(usuarios, userCadastrado);
			setVisible(false);
		}
	}

	public void cadastroUser() {
		boolean existe = false;
		for (Usuario usuario : usuarios) {
			if (usuario.getNome_user().isEmpty()) {
				userCadastrado = false;
			} else {
				userCadastrado = true;
				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarios.get(i).getNome_user().equals(nomeTxt.getText())) {
						mensagem("Este usuário já existe no sistema!", "Aviso");
						existe = true;
					}
				}
			}
		}
		if (!userCadastrado) {
			if (caixa.getSelectedItem() != opcoes[0]) {
				mensagem("É necessário ter um Administrador!","Aviso");
			} else {
				analisarDados(existe);
			}
		} else {
			analisarDados(existe);
		}

	}

	public void confirmaDados(String info, String tipo) {
		if (confirma == 1) {
			etapa = info;
		} else if (confirma == 2) {
			String recept = "";
			if (tipo.equalsIgnoreCase("nome")) {
				recept = nomeTxt.getText();
				nomeVeri = info;
			} else if (tipo.equalsIgnoreCase("senha")) {
				recept = pegarSenha();
				senhaVeri = info;
			}
			if (recept.equals(etapa)) {
				mensagem(tipo.toUpperCase() + " validado!","Aviso");
				if (tipo.equalsIgnoreCase("nome")) {

					nivel = "senha";
					nomeTxt.setText(info);
					DesativarBtn(true, "senha");
					DesativarBtn(false, "nome");

				} else if (tipo.equalsIgnoreCase("senha")) {
					nivel = "nome";
					senhaTxt.setText(info);
					DesativarBtn(true, "nome");
					DesativarBtn(false, "senha");
					usuarios.add(new Usuario(nomeVeri, senhaVeri, "normal", String.valueOf(caixa.getSelectedItem())));
//					for(Usuario usuario : usuarios) {
//						System.out.println(usuario.getNome_user()+"\n"+usuario.getSenha_user()+"\n"+usuario.getTipo_user());
//					}
				}
				confirma = 0;
			} else {
				mensagem("Campos não correspondem!","Aviso");
				confirma = 1;
			}

		}
	}

	public void DesativarBtn(boolean cond, String item) {
		if (item.equalsIgnoreCase("senha")) {
			senhaTxt.setEnabled(cond);
		} else if (item.equalsIgnoreCase("nome")) {
			nomeTxt.setEnabled(cond);
		}
	}

	public String pegarSenha() {
		String pass = new String(senhaTxt.getPassword());
		return pass;
	}

	public void analisarDados(boolean permissao) {
		if (!permissao) {
			String recept = "";
			String tipo = "";

			if (nivel.equalsIgnoreCase("nome")) {
				recept = nomeTxt.getText();
				tipo = "nome";
			} else if (nivel.equalsIgnoreCase("senha")) {
				recept = pegarSenha();
				tipo = "senha";
				userCadastrado = true;
			}

			if (!recept.trim().isEmpty()) {
				confirma++;
				if (confirma == 1) {
					mensagem("Confirme seus dados!","Aviso");
				}

				confirmaDados(recept, tipo);
				limparTexto(true,true);

			} else {
				mensagem("O campo " + tipo + " não \n pode estar vazio!", "Aviso");
			}

		} else {
			limparTexto(true,true);
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
	
	public void mensagem(String msg,String titulo) {
		popup.showMessageDialog(null, msg,titulo,JOptionPane.WARNING_MESSAGE);
	}

}
