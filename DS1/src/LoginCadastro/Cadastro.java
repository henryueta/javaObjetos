package LoginCadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Cadastro extends JFrame implements ActionListener {

	JLabel nome_user, senha;
	JTextField user_txt;
	JPasswordField senha_txt;
	JButton cadastrar, limpar, logar;
	JButton mostrarUser;
	Font destaque;
	private Usuario usuarios[];
	int contador;
	boolean ind = true;
	private String dados;

	public Cadastro(Usuario usuarios[], String dados, int contador) {
		this.dados = dados;
		this.usuarios = usuarios;
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
		cadastrar.setFont(destaque);
		limpar.addActionListener(this);
		logar.addActionListener(this);
		
		mostrarUser.addActionListener(this);
		
		
		setVisible(true);
		setSize(1000, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CADASTRAR USUÁRIO");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cadastrar) {
			CadastroUser();
		}

		if (e.getSource() == limpar) {
			user_txt.setText("");
			senha_txt.setText("");
		}

		if (e.getSource() == logar) {
			Login telaLogin = new Login(usuarios, dados, contador);
		}

		if (e.getSource() == mostrarUser) {
			JOptionPane.showMessageDialog(null, dados, "Usuários do Sistema", JOptionPane.WARNING_MESSAGE);
		}

	}

	private void CadastroUser() {
		String valorPass = new String(senha_txt.getPassword());
		if (user_txt.getText().trim().isEmpty() || valorPass.trim().isEmpty() ) {
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos!", "Aviso",
					JOptionPane.WARNING_MESSAGE);
			user_txt.setText("");
			senha_txt.setText("");
		} else {

			for (int i = 0; i < this.usuarios.length; i++) {
				if (this.usuarios[i] != null) {
					if (user_txt.getText().equalsIgnoreCase(this.usuarios[i].getNome_user())
							&& valorPass.equals(this.usuarios[i].getSenha_user())) {
						ind=false;
					}
				}

			}

			if (ind) {
				contador++;
				usuarios[contador] = new Usuario(user_txt.getText(), valorPass, "cadastrado");

				dados = dados  + usuarios[contador].getNome_user()+ "\n";
			} else {
				JOptionPane.showMessageDialog(null, "Este usuário já existe no sistema!", "Aviso",
						JOptionPane.WARNING_MESSAGE);
				ind = true;
			}

		}
		user_txt.setText("");
		senha_txt.setText("");
	}

}
