package calc;

public class Calculadora2 {
	String tipo;
	
	public double calcular (double num1, double num2, int op) {
		double operacao=0;
		
		if(op == 1) {
			operacao = num1 + num2;
		} else if(op == 2) {
			operacao = num1 - num2;
			} else if(op == 3) {
				operacao = num1 * num2;
				} else if(op == 4) {
					operacao = num1 / num2;
					}
		
		return (operacao);
	}
}

//1-Soma
//2-Subtra��o
//3-Multiplica��o
//4-Divis�o
