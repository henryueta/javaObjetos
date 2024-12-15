package telaLogin;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {

	private String usuarioDigito;
	private String senhaDigito;

	JLabel usuario;
	JLabel senha;
	JTextField user;
	JTextField pass;
	JButton ok;
	JButton cancel;
	Font fonteBtn;
	Font fonteTxt;

	public Login() {

		usuario = new JLabel("Usuário:");
		senha = new JLabel("Senha:");

		user = new JTextField();
		pass = new JTextField();

		ok = new JButton("OK".toUpperCase());
		ok.addActionListener(this);

		cancel = new JButton("Cancelar".toUpperCase());
		cancel.addActionListener(this);
		
		fonteBtn = new Font("SansSerif", Font.BOLD, 30);
		ok.setFont(fonteBtn);
		cancel.setFont(fonteBtn);

		fonteTxt = new Font("SansSerif", 0, 20);
		usuario.setFont(fonteTxt);
		senha.setFont(fonteTxt);

		Container c = getContentPane();

		c.setLayout(new GridLayout(3, 2, 0, 0));
		c.add(usuario);
		c.add(user);
		c.add(senha);
		c.add(pass);
		c.add(ok);
		c.add(cancel);

		setTitle("LOGIN");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ok) {
			int contador = 0;
			if (this.usuarioDigito.equals(user.getText())) {
				contador++;
			}
			if (this.senhaDigito.equals(pass.getText())) {
				contador++;
			}
			if (contador == 2) {
				JOptionPane.showMessageDialog(null, "Login Validado!", "AVISO", JOptionPane.PLAIN_MESSAGE);
			} else if (contador < 2) {
				JOptionPane.showMessageDialog(null, "Login Inválido!", "AVISO", JOptionPane.PLAIN_MESSAGE);
			}
			user.setText("");
			pass.setText("");
			contador = 0;

		} else if (e.getSource() == cancel) {
			user.setText("");
			pass.setText("");		
		}

	}

	public String getUsuarioDigito() {
		return usuarioDigito;
	}

	public void setUsuarioDigito(String usuarioDigito) {
		this.usuarioDigito = usuarioDigito;
	}

	public String getSenhaDigito() {
		return senhaDigito;
	}

	public void setSenhaDigito(String senhaDigito) {
		this.senhaDigito = senhaDigito;
	}

}
