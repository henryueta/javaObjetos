package menuBebida;

public class Suco extends Bebida{

private String sabor;	

public void setSabor(String saborUser) {
	this.sabor = saborUser;
}

public String getSabor() {
	return sabor;
}

String mostraBebida() {
	String info="NOME: "+super.getName()+"\nPREÇO: $"+super.getPreco()+"\nSABOR: "+sabor;
	return info;
}

 boolean verificarPreco(double preco) {
	boolean resposta;
	if(preco < 2.5) {
	resposta=true;
	}else {
	resposta=false;
	}
	 return resposta;
}


}
