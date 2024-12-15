package loginEtapa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;

public class Login extends JFrame implements ActionListener {

	JLabel username, password;
	JTextField userTxt;
	JPasswordField passTxt;
	JButton login, cancel;
	private String senha;
	private String usuario;
	public int contador = 3;
	public int limite = 0;

	public Login() {
	}

	public Login(String senha, String usuario) {
		this.senha = senha;
		this.usuario = usuario;

		Container c = getContentPane();

		username = new JLabel("Usuário");
		password = new JLabel("Senha");
		userTxt = new JTextField();
		passTxt = new JPasswordField();
		login = new JButton("Login");
		cancel = new JButton("Cancel");

		c.setLayout(new GridLayout(3, 2));
		c.add(username);
		c.add(userTxt);
		c.add(password);
		c.add(passTxt);

		c.add(login);
		login.addActionListener(this);
		c.add(cancel);
		cancel.addActionListener(this);

		setTitle("Tela Login");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {

			if (contador != limite) {
				String valorSenha = new String(passTxt.getPassword());
				if (userTxt.getText().equals("") || valorSenha.equals("")) {
					contador--;
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preechidos!!", "Alerta",
							JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, "Você tem " + contador + " tentativas!!", "Alerta",
							JOptionPane.WARNING_MESSAGE);
					userTxt.setText("");
					passTxt.setText("");

					System.out.println(contador);
				} else if (!userTxt.getText().equals(this.senha) || !valorSenha.equals(this.senha)) {
					contador--;
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto!!", "Alerta",
							JOptionPane.WARNING_MESSAGE);
					JOptionPane.showMessageDialog(null, "Você tem " + contador + " tentativas!!", "Alerta",
							JOptionPane.WARNING_MESSAGE);
					userTxt.setText("");
					passTxt.setText("");

					System.out.println(contador);
				} else if (userTxt.getText().equals(this.senha) && valorSenha.equals(this.senha)) {
					JOptionPane.showMessageDialog(null, "Login Validado!", "AVISO", JOptionPane.PLAIN_MESSAGE);
				}

			} if (contador == limite) {
				JOptionPane.showMessageDialog(null, "Excesso de tentativas!\nLogin bloqueado!", "AVISO",
						JOptionPane.PLAIN_MESSAGE);
				userTxt.setEnabled(false);
				passTxt.setEnabled(false);
				System.out.println("AAA");
			} 
		} else if (e.getSource() == cancel) {
			userTxt.setText("");
			passTxt.setText("");
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
