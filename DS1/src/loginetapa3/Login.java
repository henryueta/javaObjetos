package loginetapa3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Login extends JFrame implements ActionListener {

	JLabel lblNome;
	JLabel lblSenha;
	JTextField nomeTxt;
	JPasswordField senhaTxt;
	JButton cadastrar;
	JButton limpar;
	JButton logar;
	JPanel info;
	JPanel botoes;
	JOptionPane popup;
	private ArrayList<Usuario> usuarios;
	boolean userCadastrado;
	int tentativas;

	public Login(ArrayList<Usuario> usuarios, boolean userCadastrado) {

		Container c = getContentPane();
		this.usuarios = usuarios;
		this.userCadastrado = userCadastrado;
		popup = new JOptionPane();
		info = new JPanel();
		botoes = new JPanel();
		lblNome = new JLabel("Usuário:");
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
		logar.setEnabled(userCadastrado);

		if (!userCadastrado) {
			mensagem("É necessário ter um Administrador!", "Aviso");
		}

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
			Cadastro telaCadastro = new Cadastro(usuarios, userCadastrado);
			setVisible(false);
		} else if (e.getSource() == limpar) {
			limparTexto(true, true);
		} else if (e.getSource() == logar) {
			logarUser();
		}

	}

	public void logarUser() {
		int diferente = 0;
		boolean senhaValida = false;
		boolean nomeValido = false;
		boolean userValido = false;
		String pegarNome = nomeTxt.getText();
		int pegarInd = 1;
		if (tentativas > 0) {
			for (int i = 0; i < usuarios.size(); i++) {
				String nome = usuarios.get(i).getNome_user();
				String senha = usuarios.get(i).getSenha_user();
				if (pegarNome.equals(nome)) {
					pegarInd = i;
					nomeValido = true;
					if (usuarios.get(i).getSituacao_user().equalsIgnoreCase("bloqueado")) {
						userValido = false;
					} else {
						userValido = true;
					}
				}
				if (pegarSenha().equals(senha)) {
					senhaValida = true;
				}
				if (nomeValido && senhaValida) {

				} 
			}
			
			if(!userValido) {
				mensagem("Sua conta foi bloqueada!", "Aviso");
				bloquearUser(false);
			}
			
			 
			
			
			if (pegarNome.trim().isEmpty() || pegarSenha().trim().isEmpty()) {
				mensagem("Nenhum campo pode estar vazio!", "Aviso");
			}

			if (userValido) {
				
				if (nomeValido && !senhaValida) {
					tentativas--;
					mensagem("Senha incorreta!" + pegarNome + ", você tem " + tentativas + " tentativas!", "Aviso");
				} else {
					diferente++;
				}
				
				
				if (diferente < usuarios.size() && senhaValida) {

					mensagem("Login Validado!", "Aviso");
					tentativas = 3;

				} else if (diferente == usuarios.size()) {
					mensagem("Usuário inexistente!", "Aviso");
				}
			} 

			limparTexto(true, true);
		}

		if (tentativas == 0) {
			mensagem("Excesso de tentativas!", "Aviso");
			usuarios.get(pegarInd).setSituacao_user("bloqueado");
			bloquearUser(false);
		}

	}

	public String pegarSenha() {
		String pass = new String(senhaTxt.getPassword());
		return pass;
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
		popup.showMessageDialog(null, msg, titulo, JOptionPane.WARNING_MESSAGE);
	}

	public void bloquearUser(boolean userValido) {
		if (!userValido) {
			nomeTxt.setEnabled(false);
			senhaTxt.setEnabled(false);
		}
	}

}
