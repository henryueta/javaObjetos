package genius;

import java.awt.Color;
import java.util.Random;


public class GeniusAction extends Thread{
	
	GeniusInterface tela;
	Random generator;
	int colorsList[] = new int[15]; 
	private int color;
	private int newColor;
	
	public GeniusAction() {
		tela = new GeniusInterface();
		generator = new Random();
		
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public int getColor() {
		return color;
	}
	
	public void NumberGenerator(int limit) {
		setColor(generator.nextInt(limit));
	}
	
	public void reset() {
		
	}
	
	
	public void setTimer(int number) {
		try {
			Thread.sleep(number);
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		}
	
	public void array() {
		for(int i = 0; i <= colorsList.length;i++) {
			
			colorsList[i] = generator.nextInt(4);
			
		
		}
	}
	
	
	public void run() {
	
		System.out.println(colorsList);
		
		try {
			for(int i = 0; i <= colorsList.length;i++) {
				NumberGenerator(4);
				
				if(color == 0) {
					tela.blueBtn.setBackground(Color.BLUE);
					setTimer(800);
					tela.blueBtn.setBackground(Color.GRAY);
				}
				if(color== 1) {
					tela.greenBtn.setBackground(Color.GREEN);
					setTimer(800);
					tela.greenBtn.setBackground(Color.GRAY);
				}
				if(color == 2) {
					tela.redBtn.setBackground(Color.RED);
					setTimer(800);
					tela.redBtn.setBackground(Color.GRAY);
				}
				if(color == 3) {
					tela.yellowBtn.setBackground(Color.YELLOW);
					setTimer(800);
					tela.yellowBtn.setBackground(Color.GRAY);
				}
								
				int time = 3000;
				if(tela.getColorValue() == color) {
					time = 1000;
					System.out.println("AAAA");
				} else {
				
				}
				Thread.sleep(time);
			}
		}
			catch(InterruptedException e) {
				System.out.println(e);
			}
		
		
	}
	
}
