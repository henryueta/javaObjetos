package onibusistem;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Onibus extends JFrame implements ActionListener{

	private int lugares[] = new int[44];

	String teste = " - ";
	int num, contar = 0, ind = -1;
	String nome;
	Scanner entrada;
	JPanel tela[];
	JLabel lugar[];

	public Onibus() {
		Container c = getContentPane();
		entrada = new Scanner(System.in);
		tela = new JPanel[4];
		lugar = new JLabel[44];
		setTitle("onibus");
		setSize(900, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		c.setLayout(new GridLayout(4,11));
		
		c.setBackground(Color.WHITE);
		
		for (int i = 0; i < lugar.length; i++) {
			lugar[i] = new JLabel(String.valueOf(i+1));		
				c.add(lugar[i]);
				lugar[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				lugar[i].setHorizontalAlignment(JLabel.CENTER);
		}

	}

	public void mostrar() {

	}

	public void cadastro() {
		while (num != 45) {
			System.out.println("Digite seu nome");
			nome = entrada.next();
			System.out.println("Escolha um lugar: ");
			num = entrada.nextInt();
			
			for (int i = 0; i < lugares.length; i++) {

				if (num == lugares[i]) {
					contar++;
				} else if (num != lugares[i]) {

				}

			}

			if (contar == 0) {
				ind++;
				lugares[ind] = num;
				lugar[num-1].setOpaque(true);
				lugar[num-1].setBackground(Color.RED);
				lugar[num-1].setBorder(BorderFactory.createLineBorder(Color.WHITE));
				lugar[num-1].setText(nome);
			}
			if (contar != 0) {
				JOptionPane.showMessageDialog(null,"Este lugar já foi escolhido!",
						"Aviso",JOptionPane.WARNING_MESSAGE);
				contar = 0;
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
