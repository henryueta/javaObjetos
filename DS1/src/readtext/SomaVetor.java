package readtext;

import javax.swing.JOptionPane;

public class SomaVetor {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int total = 0;
		String saida = "Elemento do vetor\n";
		
		for(int i = 0; i < a.length; i++) {
			saida += a[i] + " ";
			total += a[i];
			
			JOptionPane.showMessageDialog(null, saida + "\n Soma dos elementos do vetor " +  total, "Soma os elemnetos do vetor", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
		
				
}
