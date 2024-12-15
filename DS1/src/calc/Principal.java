package calc;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    double num1=0,num2=0;
    int op=0;
    Calculadora2 minhaCalc = new Calculadora2();
    
    System.out.println("Digite o valor do 1º");
    num1 = entrada.nextDouble();
    System.out.println("Digite o valor do 2º");
    num2 = entrada.nextDouble();
	
    System.out.println("Qual operação deseja realizar?\n1-Soma\n2-Subtração\n3-Multiplicação\n4-Divisão");
	op = entrada.nextInt();	
	
	System.out.println("Resultado: "+ minhaCalc.calcular(num1, num2, op));
	}
	

}
