package atBebidas;

public class Refrigerante extends Bebida{
	
	private boolean retornavel;
	
	
	public String mostrarBebida() {
		super.getNome();
		super.getPreco();
		this.retornavel = retornavel;
		
		
		String refrigerante= ("Nome: "+getNome()+"\n"+ "Preço: "+getPreco() + "\n" + "Retornavel: "+getRetornavel());
		

		return refrigerante;
	}

	
	public boolean verificarPreco(double preco) {
		
		boolean preco1;
		if(preco < 5) {
			preco1 = true;
			System.out.println("Está em promoção");
		}else {
			
			preco1 = false;
			System.out.println("Preço normal");
		}
		
		return preco1;
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean getRetornavel() {
		return retornavel;
	}

	public void setRetornavel(boolean retornavel) {
		this.retornavel = retornavel;
	}	
	
}
