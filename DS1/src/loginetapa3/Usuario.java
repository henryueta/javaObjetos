package loginetapa3;

public class Usuario {

	private final String nome_user;
	private final String senha_user;
	private String situacao_user;
	private final String tipo_user;
	
	public Usuario(String nome,String senha,String situacao,String tipo) {
		this.nome_user = nome;
		this.senha_user = senha;
		this.situacao_user = situacao;
		this.tipo_user = tipo;
	}
	
	
	public String getNome_user() {
		return nome_user;
	}

	public String getSenha_user() {
		return senha_user;
	}

	public String getSituacao_user() {
		return situacao_user;
	}

	public String getTipo_user() {
		return tipo_user;
	}
	
	public void setSituacao_user(String situacao) {
		this.situacao_user = situacao;
	}
	
}
