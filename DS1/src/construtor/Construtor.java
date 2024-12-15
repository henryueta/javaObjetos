package construtor;

public class Construtor {

	String nome;
	int idade;
	double numeros[] = new double[10];
	
	
	Construtor(String info){
	this.nome = info;
	}
	
	Construtor(int dado){
	this.idade = dado;	
	}
	
	Construtor(double array[]){
	this.numeros = array;	
	}
	
	
	
	
}
