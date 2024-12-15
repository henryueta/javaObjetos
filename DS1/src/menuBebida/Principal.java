package menuBebida;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
    
	int codInt=0;
	String codString="";
	
	//Geral
	String nome="";
	double preco=0;
	//----------
	
	//Vinho
	int qntV=0;
	int safra=0;
	String tipo="";
	//----------
	
	//Suco
	String sabor="";
	int qntS=0;
	//----------
	
	//Refrigerante
	String cond="nao";
	boolean retornavel=false;
	int qntR=0;
	//----------
	
    Vinho v1 = new Vinho();
    Refrigerante r1 = new Refrigerante();
    Suco s1 = new Suco();
    
    
    do {
    	
    System.out.println("\nMENU\n1-CADASTRO\n2-VERIFICAR PREÇO\n3-MOSTRAR DADOS");
    
    
    
 
	codInt = entrada.nextInt();
    
	switch(codInt) {
	
	case(1):
	System.out.println("\nCADASTRO\n(escolha o tipo de bebida)\nA-VINHO("+qntV+")\nB-SUCO("+qntS+")\nC-REFRIGERANTE("+qntR+")");
	codString = entrada.next();
	
	System.out.println("\nDigite o nome: ");
	nome = entrada.next();
	System.out.println("Digite o preço: ");
	preco = entrada.nextDouble();
	
	if(codString.equalsIgnoreCase("A")) {
		qntV++;
		v1.setName(nome);
		v1.setPreco(preco);
		
		System.out.println("Digite a safra: ");
		safra = entrada.nextInt();
		v1.setSafra(safra);
		
		System.out.println("Digite o tipo");
		tipo = entrada.next();
		v1.setTipo(tipo);
		
		}
		else if(codString.equalsIgnoreCase("B")) {
		qntS++;
		s1.setName(nome);
		s1.setPreco(preco);
		
		System.out.println("Digite o valor do sabor: ");
		sabor = entrada.next();
		s1.setSabor(sabor);		
		
		}
		else if(codString.equalsIgnoreCase("C")) {
		qntR++;
		r1.setName(nome);
		r1.setPreco(preco);
		
		System.out.println("O produto é retornável?\nSim\nNao");	
		cond = entrada.next();
		
		if(cond.equalsIgnoreCase("sim")) {
		retornavel = true;
		}else if(cond.equalsIgnoreCase("nao")) {
		retornavel = false;
		}
		r1.setRetornavel(retornavel);
	   }
		else {
		System.out.println("-----\nOpção inexistente!\n-----");
		}
	  
	break;
	
	case(2):
	System.out.println("\nVERIFICAR PREÇO\n(escolha o tipo de bebida)\nA-VINHO("+qntV+")\nB-SUCO("+qntS+")\nC-REFRIGERANTE("+qntR+")");
	codString = entrada.next();
	
	boolean receptor=false;
	
	if(codString.equalsIgnoreCase("A")) {
	receptor=v1.verificarPreco(preco);	
	}
	
	else if(codString.equalsIgnoreCase("B")) {
	receptor=s1.verificarPreco(preco);
	}
	
	else if(codString.equalsIgnoreCase("C")) {
	receptor=r1.verificarPreco(preco);	
	}
	
	else {
	System.out.println("-----\nOpção inexistente!\n-----");
	}
	
	if(receptor == true) {
	System.out.println("\n-----\nSITUAÇÂO\nProduto em oferta!\n-----");	
	}else {
	System.out.println("\n-----\nSITUAÇÂO\nProduto com preço normal\n-----");
	}
	
	break;
	
	case(3):
	System.out.println("\nMOSTRAR DADOS\n(escolha o tipo de bebida)\nA-VINHO("+qntV+")\nB-SUCO("+qntS+")\nC-REFRIGERANTE("+qntR+")");
	codString = entrada.next();
    
	if(codString.equalsIgnoreCase("A")) {
	System.out.println("\n-----\n"+v1.mostraBebida()+"\n-----");
	}
	
	else if(codString.equalsIgnoreCase("B")) {
	System.out.println("\n-----\n"+s1.mostraBebida()+"\n-----");
	}
	
	else if(codString.equalsIgnoreCase("C")) {
	System.out.println("\n-----\n"+r1.mostraBebida()+"\n-----");
	}
	
	else {
	System.out.println("-----\nOpção inexistente!\n-----");
	}

	break;
	
	}

   }while(codInt != 4);
 }

}
