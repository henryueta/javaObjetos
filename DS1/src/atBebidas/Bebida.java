package atBebidas;

public  abstract class Bebida {
	private String nome;
    private double preco;
    



	public abstract String mostrarBebida();
	
	
	
	public abstract boolean verificarPreco(double preco);
	
    
    
	public String getNome() {
		return nome;
	}
	
	
	public String setNome(String nome) {
		return this.nome = nome;
	}
	
	
	public double getPreco() {
		return preco;
	}
	public int setPreco(double preco) {
		this.preco = preco;
		return (int) preco;
	}

}
