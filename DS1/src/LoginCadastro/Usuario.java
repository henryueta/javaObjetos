package LoginCadastro;

public class Usuario {

	final private String nome_user;
	final private String senha_user;
	private String situacao_user;
	
	public Usuario(String nome,String senha,String situacao){
		this.nome_user = nome;
		this.senha_user = senha;
		this.situacao_user = situacao;
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

	public void setSituacao_user(String situacao) {
		this.situacao_user = situacao;
	}
	
	
	
	
	
}
