package Vinh2;

public class Vinho {
	private String nome, tipo;
	private double preco;
	private int safra;
	
	public Vinho() {
	}
		
	public Vinho(String v_nome, String v_tipo, double v_preco, int v_safra){
		this.nome = v_nome;
		this.tipo = v_tipo;
		this.preco = v_preco;
		this.safra = v_safra;
	}
	
	public boolean verificarPreco(double preco){
		if (preco<25){
			return true;
		}else{
			return false;
		}
	}
	
	public String mostrarVinho(){
		return ("VINHO: "+this.nome+"\nTIPO: "+this.tipo+"\nPREÇO: R$ "+this.preco+"\nSAFRA: "+this.safra);
	}

}
