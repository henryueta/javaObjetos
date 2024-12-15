package readtext;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

public class Registro {

	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("test.txt");
			String teste = "deu certo";
			out = new FileOutputStream("users.txt");
			int c;
			while((c = in.read()) != -1) {
				out.write(c);
			}
			
		}
		catch(IOException e) {
			System.out.println(e);
		}
		finally {
			if(in != null) {
				in.close();
			}
			if(out != null) {
				out.close();
			}
		}
		
		
	}

}
