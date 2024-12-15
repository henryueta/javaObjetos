package thred;

public class ComprasCompartilhadas implements Runnable{

	ContaConjunta conta = new ContaConjunta();
	
	public static void main(String[] args){
		ComprasCompartilhadas comprar = new ComprasCompartilhadas();
		new Thread(comprar, "M�e").start();
		new Thread(comprar, "Filha").start();
		new Thread(comprar, "Pai").start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String cliente = Thread.currentThread().getName();
		for(int i=0; i < 5; i++){
			conta.sacar(30, cliente);
			if(conta.getSaldo() < 0){
				System.out.println("Conta sem saldo!!!");
			}
		}
		
	}

}
