package readtext;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Lista {

	public static void main(String[] args) {
		
		String teste[] = new String[10];
		ArrayList <String> word = new ArrayList<String>();
		
		for(int i = 0; i <= 10;i++) {
			word.add("--");
		}
		
		for(String letter : word) {
			System.out.println(letter);
		}
		
		
		JOptionPane.showMessageDialog(null, word);
	}
	
}
