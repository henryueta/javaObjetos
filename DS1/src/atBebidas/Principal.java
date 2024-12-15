package atBebidas;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {		

		Scanner sc = new Scanner(System.in);
		
		Vinho v1 = new Vinho();
		Refrigerante r1 = new Refrigerante();
		Suco s1 = new Suco();
		
		
		
		String nome = "";
		String tipo = "";
		String sabor ="";
		
		
		int preco = 0;
		int safra = 0;
		String resp;
		
		String op;
		
		
		
		do {
			
			System.out.println("1)cadastrar");
			System.out.println("2)verificar preço");
			System.out.println("3)Mostrar bebiba");
			op = sc.next();
			
			
			switch(op) {
			case "1":
				System.out.println("Cadastrar");
				System.out.println("A)Vinho");
				System.out.println("B)Suco");
				System.out.println("C)Refrigerante");
				op = sc.next();
				
					switch(op) {
					case "a":
	
						System.out.println("Por favor insira o nome do vinho:");
						nome = sc.next();
						nome = v1.setNome(nome);
						
						System.out.println("agora o tipo");
						tipo = sc.next();
						tipo = v1.setTipo(tipo);
						
						System.out.println("Agora o preço");
						preco = sc.nextInt();
						preco = v1.setPreco(preco);
						
						System.out.println("Agora a safra: ");
						safra = sc.nextInt();
						safra = v1.setSafra(safra);
						break;
					case "b":
						System.out.println("Por favor insira o nome do suco: ");
						nome = sc.next();
						nome = s1.setNome(nome);
						
						System.out.println("Agora o sabor: ");
						sabor = sc.next();
						sabor = s1.setSabor(sabor);
						
						System.out.println("Preço do suco");
						preco = sc.nextInt();
						preco = s1.setPreco(preco);
						break;
					case "c":
						System.out.println("Insira o nome do refrigerante: ");
						nome = sc.next();
						nome = r1.setNome(nome);
						
						System.out.println("Agora o preço");
						preco = sc.nextInt();				
						break;
					}
					break;
			case"2":
				System.out.println("Verificar preço");
				System.out.println("A)Vinho");
				System.out.println("B)Suco");
				System.out.println("C)Refrigerante");	
				op = sc.next();
				
				switch(op) {
				case "a":

					System.out.println("Por favor insira o preço do vinho:");
					 preco = sc.nextInt();
			         preco = v1.setPreco(preco);
			         v1.verificarPreco(preco);
					break;
				case "b":
					
					System.out.println("Por favor insira o valor do suco: ");
					preco = sc.nextInt();
					preco = s1.setPreco(preco);
					s1.verificarPreco(preco);
					break;
				case "c":
					System.out.println("Insira o preço do refrigerante: ");
					preco = sc.nextInt();
					preco = r1.setPreco(preco);
					r1.verificarPreco(preco);	
				break;
				}
				break;
			case"3":
				System.out.println("Mostrar dados");
				System.out.println("A)Vinho");
				System.out.println("B)Suco");
				System.out.println("C)Refrigerante");
				op = sc.next();
				
				switch(op){
				case "a":
					System.out.println(v1.mostrarBebida());
					break;
				case "b":
					System.out.println(s1.mostrarBebida());
					break;
				case"c":
					System.out.println(r1.mostrarBebida());
				}
				break;
		
				
				
			}
			
			System.out.println("Deseja continuar?\nSim\nNão");
			resp = sc.next();	
			
		}while(resp.equalsIgnoreCase("sim"));
		
		
		
		
		
		
		
		
		
		

	}

}
