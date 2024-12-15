package Teste;

public class Dado {

private int num;

private String frase;

public Dado() {
	
}

public void setNum(int numUser) {
	this.num = numUser;
}

public int getNum() {
	return num;
}

public void setFrase(String fraseUser) {
	this.frase = fraseUser;
}

public String getFrase() {
	return frase;
}

protected void informar() {
	
	mostrarDado();
	
	if(this.num == -1) {
		this.frase = "menos um";
	}
	
	else if(this.num == -2) {
		this.frase = "menos dois";
	}
	System.out.println(this.frase);
}
	
public void mostrarDado() {
}
	
}
