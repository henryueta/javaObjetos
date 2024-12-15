package atBebidas;

public class Vinho  extends Bebida{
	
	private int safra;
	private String tipo;
	
	
	
	public String mostrarBebida() {
		super.getNome();
		super.getPreco();
		this.safra = safra;
		this.tipo = tipo;
		String vinho = ("Nome: "+getNome()+"\n" +"tipo: "+getTipo()+"\n" + "Preço: "+getPreco()+"\n"+"safra: "+getSafra());
		
		
		return vinho;
	}
	public boolean verificarPreco(double preco) {
		boolean preco1;
		
		if(preco< 25) {
			preco1 = true;
			System.out.println("Está em promoção");
		}else {
			preco1 = false;
			System.out.println("Está com o preço normal");
		}
		
		
		
		return preco1;
	}

	
	
	
	
	
	public int getSafra() {
		return safra;
	}
	public int setSafra(int safra) {
		return this.safra = safra;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String setTipo(String tipo) {
		return this.tipo = tipo;
	}

}
