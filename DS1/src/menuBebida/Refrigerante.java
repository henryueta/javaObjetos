package menuBebida;

public class Refrigerante extends Bebida{

private boolean retornavel;	
	
public void setRetornavel(boolean retornavelUser) {
	this.retornavel = retornavelUser;
}

public boolean getRetornavel() {
	return retornavel;
}



String mostraBebida() {
	String resRetornavel="";
	if(retornavel == true) {
	resRetornavel = "Refrigerante Retorn�vel";	
	}else {
	resRetornavel = "Refrigerante N�o Retorn�vel";
	}
	
	String info="NOME: "+super.getName()+"\nPRE�O: $"+super.getPreco()+"\n"+resRetornavel;
	return info;
}

boolean verificarPreco(double preco) {
	boolean resposta;
	if(preco < 5) {
	resposta=true;
	}else {
	resposta=false;
	}
	 return resposta;
}


}
