package testeDesign;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;


public class Tela extends JFrame implements ActionListener{

	JLabel teste;
	JLabel teste1;
	JTextField txt;
	JTextField txt2;
	JButton perso;
	JButton teste2;
	JButton[] lista;
	JPanel teste3;
	JPanel teste4;
	JPanel teste5;
	Font fonte;
	public int contador = 0;
	public Tela() {
	fonte = new Font("SansSerif", Font.BOLD, 20);
	
	Container c = getContentPane();
	txt = new JTextField();
	txt2 = new JTextField();
	teste3 = new JPanel();
	teste4 = new JPanel();
	teste5 = new JPanel();
	teste = new JLabel("Digite");
	perso = new JButton();
	teste1 = new JLabel("Digite");
	teste2 = new JButton();
	lista = new JButton[3];
	
	setSize(400,500);
	
	setTitle("Design");
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setVisible(true);
	
	c.setLayout(new GridLayout(0,1));

	
	teste3.setBackground(Color.WHITE);
	
	c.add(teste3);
	teste3.setLayout(new BorderLayout());
	teste3.add(teste1,BorderLayout.NORTH);
	
	teste1.setFont(fonte);
	
	teste3.add(txt2,BorderLayout.CENTER);
	txt2.setFont(fonte);
	txt2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
	teste4.setBackground(Color.WHITE);
	
	c.add(teste4);
	teste4.setLayout(new BorderLayout());
	teste4.add(teste,BorderLayout.NORTH);
	
	teste.setFont(fonte);
	
	teste4.add(txt,BorderLayout.CENTER);
	txt.setFont(fonte);
	txt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	teste5.setBackground(Color.BLACK);
	
	c.add(teste5);
	teste5.setLayout(new GridLayout());
	
	for(int i =0;i<lista.length;i++) {
		lista[i] = new JButton("click");
		teste5.add(lista[i]);
		lista[i].setFont(fonte);
		lista[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lista[i].setBackground(Color.WHITE);
	}
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
	
}
