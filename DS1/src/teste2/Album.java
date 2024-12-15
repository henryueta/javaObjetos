package teste2;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Album extends JFrame implements ItemListener {

	ImageIcon foto = new ImageIcon(getClass().getResource("imgs/chicara.jpg"));
	JLabel imagem;
	JComboBox caixa;
	JButton enviar;
	JTextField info;

	public Album() {

		Container c = getContentPane();
		imagem = new JLabel(foto);
		String teste[] = { "um", "dois", "três", "quatro", "cinco" };
		caixa = new JComboBox(teste);
		enviar = new JButton();
		info = new JTextField("Selecione uma foto");

		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(900, 700);

		c.add(BorderLayout.NORTH, caixa);
		c.add(BorderLayout.CENTER, imagem);
		c.add(BorderLayout.SOUTH, info);

		caixa.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent e) {
		int contador = 0;
		if (e.getSource() == caixa) {
			String imagens[] = { "imgs/chicara.jpg", "imgs/chicara2.jpg", "imgs/chicara3.jpg", "imgs/chicara4.jpg",
					"imgs/chicara5.jpg" };
			String legenda[] = { "imgs/chicara.jpg", "imgs/chicara2.jpg", "imgs/chicara3.jpg", "imgs/chicara4.jpg",
					"imgs/chicara5.jpg" };
			if (caixa.getSelectedItem() == "um") {
				contador = 0;
			} else if (caixa.getSelectedItem() == "dois") {
				contador = 1;
			} else if (caixa.getSelectedItem() == "três") {
				contador = 2;
			} else if (caixa.getSelectedItem() == "quatro") {
				contador = 3;
			} else if (caixa.getSelectedItem() == "cinco") {
				contador = 4;
			}

			ImageIcon foto = new ImageIcon(getClass().getResource(imagens[contador]));
			imagem.setIcon(foto);
			info.setText(legenda[contador]);

		}
	}
}
