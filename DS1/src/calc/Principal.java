package calc;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    double num1=0,num2=0;
    int op=0;
    Calculadora2 minhaCalc = new Calculadora2();
    
    System.out.println("Digite o valor do 1�");
    num1 = entrada.nextDouble();
    System.out.println("Digite o valor do 2�");
    num2 = entrada.nextDouble();
	
    System.out.println("Qual opera��o deseja realizar?\n1-Soma\n2-Subtra��o\n3-Multiplica��o\n4-Divis�o");
	op = entrada.nextInt();	
	
	System.out.println("Resultado: "+ minhaCalc.calcular(num1, num2, op));
	}
	

}
