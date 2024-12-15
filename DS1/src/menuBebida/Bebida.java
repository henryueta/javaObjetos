package menuBebida;

public abstract class Bebida {

private String name;
private double preco;

public Bebida() {
	
}

public void setName(String nameUser) {
 this.name=nameUser;
}

public String getName() {
	return name;
}

public void setPreco(double precoUser) {
	this.preco = precoUser;
}

public double getPreco() {
	return preco;
}




abstract String mostraBebida();

abstract boolean verificarPreco(double preco);
	
}
