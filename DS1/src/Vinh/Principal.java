package Vinh;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
	Vinho sucoUva = new Vinho();
	String nome="",tipo="";
	double preco=0;
	int safra=0,cod=0;
	
	do {
	System.out.println("\nSISTEMA PARA VINHO\n1-CADASTRAR VINHO\n2-VERIFICAR PREÇO\n3-MOSTRAR VINHO\n4-SAIR");
	cod = entrada.nextInt();
	
	switch(cod) {
	
	case 1:
	System.out.println("Você escolheu cadastrar vinho\n");
	
	System.out.println("Digite o nome do vinho: ");
	nome = entrada.next();
	
	System.out.println("Digite qual tipo de vinho: ");
	tipo = entrada.next();
	
	System.out.println("Digite o preço do vinho: ");
	preco = entrada.nextInt();
	
	System.out.println("Digite a safra do vinho: ");
	safra = entrada.nextInt();
	System.out.println("Processo finalizado");
    
	sucoUva = new Vinho(nome,tipo,preco,safra);
	
	break;
	
	case 2:
	
	if(sucoUva.verificarPreco(preco) == true) {
		System.out.println("Produto em oferta!\n");
	}else{
        System.out.println("\nProduto com preço normal!");
	}
	break;
	
	case 3:
	System.out.println(sucoUva.mostrarVinho());	
	break;
	
	}
	
		}while(cod != 4);
		
	}

}
