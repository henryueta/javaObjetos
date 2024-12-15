package Biblioteca;

public class Pedido {
	
	private int codigo_pedido;
	
	private String qnt_livro;
	
	private String data_pedido;
	
	private String data_devolucao;
	
	private Livro l;
	
	private Cliente c;
	
	public Pedido() {
		
		l = new Livro();
		c = new Cliente();
		
	}

	public int getCodigo_pedido() {
		return codigo_pedido;
	}

	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	public String getQnt_livro() {
		return qnt_livro;
	}

	public void setQnt_livro(String qnt_livro) {
		this.qnt_livro = qnt_livro;
	}

	public String getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}

	public String getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	
	
	
	
}
