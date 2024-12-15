package construtor;

public class TesteConstrutor {

	public static void main(String[] args) {
	String teste = new String("Ola");
	String teste2 = new String(" Mundo");
	double array[] = {1,2,3,4,5,6,7,8,9,10};
    Construtor cubo1 = new Construtor("Henry");
    Construtor cubo2 = new Construtor(19);	
    Construtor cubo3 = new Construtor(array);
	
    System.out.println(teste.indexOf("o"));
    System.out.println(teste.indexOf("l"));
    System.out.println(teste.indexOf("a"));
    System.out.println(teste.toUpperCase());
    System.out.println(teste.toLowerCase());
    System.out.println(teste.concat(teste2));
    System.out.println(teste+"\n");
    
    
    System.out.println(cubo1.nome);
    System.out.println(cubo2.idade);
    System.out.println(cubo3.numeros);

    
	}
	
}
