package Vinh2;

import javax.swing.JOptionPane;

public class Principal {
	
	
	public static void main(String[] args){
			
			String nome, tipo;
			double preco=0.0;
			int safra;
			String[] opcoes = {"Sair", "Cadastrar", "Verificar pre�o", "Mostrar vinho"};
							
			Vinho vinho1 = new Vinho();
			
			int resp;
			do{
				resp = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "MENU", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			 switch (resp) {  
			 case 0:
				 break;
			 
			 case 1:
	        	nome = JOptionPane.showInputDialog(null,"Nome:", "CADASTRO",JOptionPane.QUESTION_MESSAGE);
	        	tipo = JOptionPane.showInputDialog(null,"Tipo:", "CADASTRO",JOptionPane.QUESTION_MESSAGE);
	        	preco = Double.parseDouble(JOptionPane.showInputDialog(null,"Pre�o:", "CADASTRO",JOptionPane.QUESTION_MESSAGE));
	        	safra = Integer.parseInt(JOptionPane.showInputDialog(null,"Safra:", "CADASTRO",JOptionPane.QUESTION_MESSAGE));
	        	vinho1 = new Vinho(nome,tipo,preco,safra);
	        	break;
	             
	         case 2:  
	        	
	        	if (vinho1.verificarPreco(preco)){    
	         		JOptionPane.showMessageDialog(null,"Produto em PROMO��O!","PRE�O DO PRODUTO",JOptionPane.WARNING_MESSAGE);   
	          	}else{    
	          		JOptionPane.showMessageDialog(null,"Produto com pre�o NORMAL!","PRE�O DO PRODUTO",JOptionPane.INFORMATION_MESSAGE); 
	         	}
	        	break;
	         	
	        case 3:
	        	JOptionPane.showMessageDialog(null, vinho1.mostrarVinho(),"DADOS DO VINHO",JOptionPane.INFORMATION_MESSAGE);
	    		break; 
	    		
	        default:  
	            JOptionPane.showMessageDialog(null, "A op��o digitada � invalida.\n Escolha uma op��o v�lida.");//caso utilize outro tipo de entrada 
			 }
			 
			}while(resp!=0);
	
		}

}
