package readtext;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class CopyCharacters {
	public static void main(String[] args) throws IOException {
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		try {
			inputStream = new FileReader("xanadu.txt");
			outputStream = new FileWriter("xanadu.txt");
			
			int c;
			while((c = inputStream.read()) != -1) {
				outputStream.write("WWWWWWWWWWWWW");
			}
			
		} finally {
			if(inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
