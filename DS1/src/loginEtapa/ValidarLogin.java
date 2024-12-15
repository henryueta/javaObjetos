package loginEtapa;

import javax.swing.JOptionPane;

public class ValidarLogin {

	public void validarLogin() {
		String pass1, pass2, user1, user2;
		Boolean rep = false;
		do {
			user1 = JOptionPane.showInputDialog(null, "Digite seu username:", "Validar Login", JOptionPane.QUESTION_MESSAGE);
			pass1 = JOptionPane.showInputDialog(null, "Digite a sua senha:", "Validar Login", JOptionPane.QUESTION_MESSAGE);
			
			user2 = JOptionPane.showInputDialog(null, "Confirme o seu username:", "Validar Login", JOptionPane.QUESTION_MESSAGE);
			pass2 = JOptionPane.showInputDialog(null, "Confirme a sua senha:", "Validar Login", JOptionPane.QUESTION_MESSAGE);
			
			if(!user1.equals(user2) || !pass1.equals(pass2)) {
				JOptionPane.showMessageDialog(null, "Username ou senha diferentes!!", "Alerta", JOptionPane.WARNING_MESSAGE); 
			} else {
				rep = true;
				Login lo = new Login(pass2, user2);
				
			}
		}while(rep != true);
	}
	
	
}
