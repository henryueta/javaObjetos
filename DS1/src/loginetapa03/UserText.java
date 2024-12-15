package loginetapa03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;


public class UserText{

	private String userList;
	private BufferedReader userRead;
	private PrintWriter userWrite;
	
	public UserText() {
		userRead = null;
		userWrite = null;
	}
	
	public void UserReadList() throws IOException{
		
		userRead = new BufferedReader(new FileReader("user.txt"));
		userList = userRead.readLine();
		System.out.println(userList);
		
	}
	
	public void UserWriteList(String userInfo) throws IOException{
		
		userWrite = new PrintWriter(new FileWriter("user.txt"));
		String word;
		while((word = userRead.readLine()) != null) {
			userWrite.write(word + userInfo);
			System.out.println("AAQA");
		}
		
		
		
	}
	
	
	
}
