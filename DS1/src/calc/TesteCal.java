package calc;

import java.util.Scanner;

public class TesteCal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int x=0;
		int y=0;
		int z=0;
		Calculadora minhaCalc = new Calculadora(); 

		System.out.println("Digite o valor do 1º número");
		x = entrada.nextInt();
		System.out.println("Digite o valor do 2º número");
		y = entrada.nextInt();
		
		
		System.out.println("Qual operação deseja realizar?\n1-Soma\n2-Subtração\n3-Divisão\n4-Multiplicação");
		z = entrada.nextInt();	
		
		if(z == 1) {
		System.out.println("Soma: "+minhaCalc.somar(x, y));
		}
			else if(z == 2) {
			System.out.println("Subtração: "+minhaCalc.subtrair(x, y));
			}
				else if(z == 3) {
					if(y !=0) {
				System.out.println("Divisão: "+minhaCalc.dividir(x, y));
					}
					else {
						System.out.println("Não existe divisão por 0");
					}
				}
					else if(z == 4) {
					System.out.println("Multiplicação: "+minhaCalc.multiplicar(x, y));
					}
	}

}
