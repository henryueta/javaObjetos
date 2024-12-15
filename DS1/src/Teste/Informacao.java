package Teste;

import java.util.Scanner;

public class Informacao extends Dado{
Scanner entrada = new Scanner(System.in);
	
public Informacao() {
	
}
		
	public void escrever() {
		int numUser=0;
		
		System.out.println("Escreva um número: ");
		numUser = entrada.nextInt();
		super.setNum(numUser);
		super.informar();
	}
	
	public void mostrarDado() {
		
	}
	
	
}
