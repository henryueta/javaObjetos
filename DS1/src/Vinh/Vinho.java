package Vinh;

public class Vinho {
	
	private String nome;
	private String tipo;
	private double preco;
	private int safra;
	
	
	public String mostrarVinho() {
		String info = "" + nome + ".\n" + tipo + ".\nR$" + preco + ".\n" + safra + ".\n";
		return (info);
	}
	
	public Vinho() {
		
	}
	
	public Vinho(String nomeUs,String tipoUs,double precoUs,int safraUs) {
	this.nome = nomeUs;
	this.tipo = tipoUs;
	this.preco = precoUs;
	this.safra = safraUs;
	}

	public boolean verificarPreco (double preco) {
		boolean verificar;
		if(preco < 25) {
			verificar = true;
		} else {
			verificar = false;
		}
		return (verificar);
	}
}
