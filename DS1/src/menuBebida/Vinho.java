package menuBebida;

public class Vinho extends Bebida{
	
	
private int safra;
private String tipo;

public void setSafra(int safraUser) {
	this.safra = safraUser;
}

public int getSafra() {
	return safra;
}

public void setTipo(String tipoUser) {
	this.tipo = tipoUser;
}

public String getTipo() {
	return tipo;
}


String mostraBebida() {
	String info="NOME: "+super.getName()+"\nPREÇO: $"+super.getPreco()+"\nSAFRA: "+safra+"\nTIPO: "+tipo;
	return info;
}

boolean verificarPreco(double preco) {
	boolean resposta;
	if(preco < 25) {
	resposta=true;
	}else {
	resposta=false;
	}
	 return resposta;
}


}
