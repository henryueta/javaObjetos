package calc;

import java.util.Scanner;

public class TesteCal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int x=0;
		int y=0;
		int z=0;
		Calculadora minhaCalc = new Calculadora(); 

		System.out.println("Digite o valor do 1� n�mero");
		x = entrada.nextInt();
		System.out.println("Digite o valor do 2� n�mero");
		y = entrada.nextInt();
		
		
		System.out.println("Qual opera��o deseja realizar?\n1-Soma\n2-Subtra��o\n3-Divis�o\n4-Multiplica��o");
		z = entrada.nextInt();	
		
		if(z == 1) {
		System.out.println("Soma: "+minhaCalc.somar(x, y));
		}
			else if(z == 2) {
			System.out.println("Subtra��o: "+minhaCalc.subtrair(x, y));
			}
				else if(z == 3) {
					if(y !=0) {
				System.out.println("Divis�o: "+minhaCalc.dividir(x, y));
					}
					else {
						System.out.println("N�o existe divis�o por 0");
					}
				}
					else if(z == 4) {
					System.out.println("Multiplica��o: "+minhaCalc.multiplicar(x, y));
					}
	}

}
