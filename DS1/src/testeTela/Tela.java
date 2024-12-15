package testeTela;

import javax.swing.JFrame;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Tela extends JFrame implements ActionListener{
	
	
	JButton[] lista;
	JButton btn;
	JTextField txt;
	GridLayout g;
	public Tela() {
	
		
	Container c = getContentPane();
	btn = new JButton("clique");
	lista = new JButton[25];
	txt = new JTextField();
	g = new GridLayout(5,5,2,2);
	
	btn.setBounds(0, 0, 150, 50);
	setTitle("Teste");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,600);
	setVisible(true);
	c.setLayout(g);
	c.setBackground(Color.GRAY);
	
	
	for(int i = 0;i<25;i++) {
		lista[i] = new JButton();
		if(i % 2 == 0) {
			lista[i].setBackground(Color.WHITE);
			
		} else {
			lista[i].setBackground(Color.BLACK);
		}
		lista[i].addActionListener(this);
		c.add(lista[i]);
	}


	}
	public void actionPerformed(ActionEvent e) {
		for(int i = 0;i<25;i++) {
			
		if(e.getSource() == lista[i]) {
			if(lista[i].getBackground() == Color.WHITE) {
				lista[i].setBackground(Color.BLACK);
			} else {
				lista[i].setBackground(Color.WHITE);
			}
			
		} 
		
	}
	}

}
