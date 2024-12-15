package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.BorderLayout;

public class Modelo extends JFrame implements ActionListener {

	JButton btnSaudacao;
	JButton btnDespedida;
	JLabel labelUser;
	JTextField textoNome;

	public Modelo() {

		Container c1 = getContentPane();
		labelUser = new JLabel("Nome:");
		textoNome = new JTextField();

		btnSaudacao = new JButton("Saudacao");
		btnSaudacao.addActionListener(this);

		btnDespedida = new JButton("Despedida");
		btnDespedida.addActionListener(this);

		setTitle("TESTE");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);

		c1.setLayout(new GridLayout(2, 2));
		c1.add(labelUser);
		c1.add(textoNome);
		c1.add(btnSaudacao);
		c1.add(btnDespedida);

	}
	
	public static void main(String[] args) {
		Modelo janela = new Modelo();
		}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSaudacao) {
		JOptionPane.showMessageDialog(null, "Oi " + textoNome.getText(), "Saudação", JOptionPane.PLAIN_MESSAGE);
		} else if(e.getSource() == btnDespedida) {
			JOptionPane.showMessageDialog(null, "Tchau " + textoNome.getText(), "Despedida", JOptionPane.PLAIN_MESSAGE);
		}
		
		
	}

}
