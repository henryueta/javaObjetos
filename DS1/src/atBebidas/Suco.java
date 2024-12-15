package atBebidas;

public class Suco  extends Bebida{
	
	private String sabor;



	@Override
	public String mostrarBebida() {
		super.getNome();
		super.getPreco();
		this.sabor = sabor;
		
		String suco = ("Nome do suco: "+getNome() +"\n"+"sabor: "+getSabor()+ "\n "+"Preço:" + getPreco());
	
		
		
		return suco;
	}

	@Override
	public boolean verificarPreco(double preco) {
		boolean preco1;
		
		if(preco<2.5) {
			preco1 = true;
			System.out.println("Está em promoção");
			
		}else {
			preco1 = false;
			System.out.println("preço normal");
		}
		
		return false;
	}
	
	
	
	
	
	
	
	public String getSabor() {
		return sabor;
	}

	public String setSabor(String sabor) {
		return this.sabor = sabor;
	}

}
