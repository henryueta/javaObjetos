package Biblioteca;

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
import java.awt.Color;


public class Interface extends JFrame{

	JLabel opcoes;
	JLabel opcoes2;
	JTextField teste;
	
public Interface() {
	
	teste = new JTextField("AQUI");
	opcoes = new JLabel("OLA MUNDO");
	opcoes2 = new JLabel("OLA MUNDO");
	Container c = getContentPane();
	c.setBackground(Color.WHITE);
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setSize(900,500);
	
	setTitle("Gerenciador de pedidos");
	
	setVisible(true);
	
	c.setLayout(null);
	opcoes.setHorizontalAlignment(JLabel.CENTER);
	opcoes.setOpaque(true);
	
	opcoes.setBounds(500,100,150,150);
	c.add(opcoes);
	opcoes.setOpaque(true);
	opcoes.setBackground(Color.BLACK);

	
	
}
	
	
}
