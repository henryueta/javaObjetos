package genius;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GeniusInterface extends JFrame implements ActionListener{
	
	JButton greenBtn;
	JButton blueBtn;
	JButton redBtn;
	JButton yellowBtn;
	JTextField txt;
	private int colorValue;
	
	public GeniusInterface() {

	Container c = getContentPane();
	greenBtn = new JButton();
	blueBtn = new JButton();
	redBtn = new JButton();
	yellowBtn = new JButton();
	txt = new JTextField();
	
	
	setTitle("Teste");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(500,500);
	setVisible(true);
	c.setLayout(new GridLayout(2,2));
	c.setBackground(Color.GRAY);
	
	c.add(greenBtn);
	greenBtn.setBackground(Color.GRAY);
	greenBtn.addActionListener(this);
	
	c.add(yellowBtn);
	yellowBtn.setBackground(Color.GRAY);
	yellowBtn.addActionListener(this);
	
	c.add(redBtn);
	redBtn.setBackground(Color.GRAY);
	redBtn.addActionListener(this);
	
	c.add(blueBtn);
	blueBtn.setBackground(Color.GRAY);
	blueBtn.addActionListener(this);
	
	}
	
	public void StartGame() {
		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == greenBtn) {
			setColorValue(1);
			
		} else if(e.getSource() == blueBtn) {
			setColorValue(0);
		}
		else if(e.getSource() == redBtn) {
			setColorValue(2);
			
		} else if(e.getSource() == yellowBtn) {
			setColorValue(3);
		}
		
	}

	public int getColorValue() {
		return colorValue;
	}

	public void setColorValue(int colorValue) {
		this.colorValue = colorValue;
	}
	}

