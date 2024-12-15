package thred;

public class Saudacao extends Thread{
	String palavra;
	long tempo;
	
	public Saudacao(String palavra, long tempo){
		this.palavra = palavra;
		this.tempo = tempo;
	}
	
	public void run(){
		try {	
			for (int i = 0; i < 10; i++){
				System.out.println(palavra);
				Thread.sleep(tempo);
			}
		}catch (InterruptedException e) {
			return;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Saudacao("Oi", 2000).start();
		new Saudacao("Tchaw", 4000).start();
		System.out.println("Ver Thread");
	}

}
