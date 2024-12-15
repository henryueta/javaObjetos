package thred;

public class SaudacaoRunnable implements Runnable{
	String palavra;
	long tempo;
	public SaudacaoRunnable(String palavra, long tempo){
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
		//Thread t = new Thread();
		Runnable um = new SaudacaoRunnable("Olá ", 1000);
		Runnable dois = new SaudacaoRunnable("Até logo ", 2500);
		new Thread(um, "ola").start();
		new Thread(dois, "até logo").start();
		System.out.println("Ver Threads!");
	}
}
