package thred;

public class ContaConjunta {
	
	private int saldo = 200;
	
	public int getSaldo(){
		return saldo;
	}
	
	public synchronized void sacar(int valor, String cliente){
		 if(saldo>=valor){
			 int saldoAnterior = saldo;
			 System.out.println(cliente + " vai sacar");
			 try {
				System.out.println(cliente + " aguardando");
				Thread.sleep(500);//aguardando processamento
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 saldo -= valor;
			 System.out.println(cliente + " sacou " + valor + " saldo anterior " + saldoAnterior + " novo saldo " + saldo);
		 }else{
			 System.out.println("Saldo insuficiente para saque " + cliente);
		 }
	 }
}
