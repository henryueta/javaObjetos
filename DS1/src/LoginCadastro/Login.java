package LoginCadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener {

	JLabel nome_user, senha;
	JTextField user_txt;
	JPasswordField senha_txt;
	JButton cadastrar, limpar, logar;
	JButton mostrarUser;
	Font destaque;
	int vez = 3;
	int block = -1;
	boolean validar = false;
	int contador;
	int exist = 0;
	private Usuario lista[];
	private String dados = "";

	public Login(Usuario lista[], String dados, int contador) {

		this.dados = dados;
		this.lista = lista;
		this.contador = contador;
		Container c = getContentPane();
		nome_user = new JLabel("Nome de Usuário: ");
		senha = new JLabel("Senha: ");
		user_txt = new JTextField();
		senha_txt = new JPasswordField();
		cadastrar = new JButton("Cadastrar");
		limpar = new JButton("Limpar");
		logar = new JButton("Logar");
		mostrarUser = new JButton("Usuários");
		destaque = new Font("SansSerif", Font.BOLD, 30);
		c.setLayout(new GridLayout(2, 3));
		c.add(nome_user);
		c.add(user_txt); // campo de txt
		c.add(senha);
		c.add(senha_txt); // campo de txt
		c.add(cadastrar);
		c.add(limpar);
		c.add(logar);
		c.add(mostrarUser);

		nome_user.setHorizontalAlignment(JLabel.CENTER);
		senha.setHorizontalAlignment(JLabel.CENTER);

		cadastrar.addActionListener(this);
		limpar.addActionListener(this);
		logar.addActionListener(this);
		logar.setFont(destaque);
		mostrarUser.addActionListener(this);

		setVisible(true);
		setSize(1000, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("LOGAR USUÁRIO");

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cadastrar) {
			Cadastro telaCadastro = new Cadastro(this.lista, this.dados, this.contador);
		}
		if (e.getSource() == logar) {
			Logar();
		}
		if (e.getSource() == mostrarUser) {
			JOptionPane.showMessageDialog(null, dados, "Usuários do Sistema", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void Logar() {

		String nomeBlock = "";
		String valorPass = new String(senha_txt.getPassword());
		if (user_txt.getText().trim().isEmpty() || valorPass.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
			user_txt.setText("");
			senha_txt.setText("");
		}
		if (vez > 0) {
			for (int i = 0; i < this.lista.length; i++) {
				if (lista[i] != null) {
					if (user_txt.getText().equals(lista[i].getNome_user())
							&& lista[i].getSituacao_user().equalsIgnoreCase("bloqueado")) {
						Bloquear("SUA CONTA FOI BLOQUEADA!");
					}
					if (user_txt.getText().equals(this.lista[i].getNome_user())
							&& valorPass.equals(this.lista[i].getSenha_user())) {
						validar = true;
					} else if (!user_txt.getText().equals(this.lista[i].getNome_user())) {
						exist++;
						System.out.println(exist);
						System.out.println(contador+1);
					} else if (user_txt.getText().equals(this.lista[i].getNome_user())
							&& !valorPass.equals(this.lista[i].getSenha_user())) {
						vez--;
						JOptionPane.showMessageDialog(null, "SENHA INCORRETA!\nVocê tem " + vez + " Tentativas",
								"Aviso", JOptionPane.WARNING_MESSAGE);
						if (vez == 0) {
							lista[i].setSituacao_user("bloqueado");
							Bloquear("EXCESSO DE TENTATIVAS! ACESSO NEGADO");
						}
					}
 
					
				}

			}
			user_txt.setText("");
			senha_txt.setText("");
		}

		if (validar) {
			JOptionPane.showMessageDialog(null, "ACESSO PERMITIDO!", "Parabéns!", JOptionPane.WARNING_MESSAGE);
			vez = 3;
			validar = false;
			exist = 0;
		} 
		if(exist == contador+1) {							
			JOptionPane.showMessageDialog(null, "USUÁRIO INEXISTENTE!TENTE NOVAMENTE!",
					"Aviso", JOptionPane.WARNING_MESSAGE);
			exist = 0;
		}

	}

	private void Bloquear(String frase) {
		JOptionPane.showMessageDialog(null, frase, "Aviso", JOptionPane.WARNING_MESSAGE);
		user_txt.setText("");
		senha_txt.setText("");
		user_txt.setEnabled(false);
		senha_txt.setEnabled(false);
	}

}
