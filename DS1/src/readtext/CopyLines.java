package readtext;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

public class CopyLines {

	public static void main(String[] args) throws IOException {

		Scanner entrada = new Scanner(System.in);
		String nome;
		String soma = "";
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		PrintWriter outputStream2 = null;
			
//			System.out.println("Digite seu nome: ");
//			nome = entrada.next();
			
			//soma += "\n" + nome;
			
		
			String original = "xanadu.txt";
			String copia = "xanadu2.txt";
			
		try {
			inputStream = new BufferedReader(new FileReader(original));
			outputStream = new PrintWriter(new FileWriter(copia));
			outputStream2 = new PrintWriter(new FileWriter(original));
			String l;
			
			while((l = inputStream.readLine()) != null) {
				outputStream.println("nome,tipo");
				System.out.println(l);	
			}
			
			
			
			
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if(outputStream != null) {
				outputStream.close();
			}
		}
	}

}
