package loginetapa03;

import java.util.ArrayList;

public class LoginController {
	private boolean temAdministrador;
	private ArrayList<Usuario> usuarios;
	private int tentativas = 3;
	private Login LoginView;

	public LoginController(Login LoginView, ArrayList<Usuario> usuarios, boolean temAdministrador) {
		this.usuarios = usuarios;
		this.LoginView = LoginView;
		this.temAdministrador = temAdministrador;
	}

	public boolean validarCampos(String nome, String senha) {
		if (nome.trim().isEmpty() || senha.trim().isEmpty()) {
			LoginView.mensagem("Nenhum campo pode estar vazio!", "Aviso");
			return false;
		}
		return true;
	}

	public void logarUser(String nome, String senha) {
		int diferente = 0;
		boolean senhaValida = false;
		boolean nomeValido = false;
		boolean userValido = true;
		int pegarInd = -1;
		int i = 0;
		
			for (Usuario usuario : usuarios) {
				if (usuario.getTipo_user().equalsIgnoreCase("administrador")) {
					temAdministrador = true;
				}
				if (tentativas > 0 && temAdministrador) {
				if (usuario.getNome_user().equals(nome)) {
					pegarInd = i;
					nomeValido = true;
					if (usuario.getSituacao_user().equalsIgnoreCase("bloqueado")) {
						userValido = false;
					}
				} else {
					diferente++;
				}

				if (usuario.getSenha_user().equals(senha)) {
					senhaValida = true;
				}

			}
			}

			if (!userValido) {
				LoginView.mensagem("Sua conta foi bloqueada!", "Aviso");
				LoginView.bloquearUser();
			} else {

				if (nomeValido && senhaValida) {
					LoginView.mensagem("Login validado!", "Sucesso.");
					tentativas = 3;

				} else {
					tentativas--;
					if (nomeValido && !senhaValida) {
						LoginView.mensagem("Senha incorreta! Tentativas Restantes: " + tentativas, "Erro");
					} else if (diferente == usuarios.size()) {
						LoginView.mensagem("Usuário inexistente!", "Erro");
					}
				}
			}
			limparCampos(true, true);
		 if (!temAdministrador) {
			LoginView.mensagem("É necessário um Administrador!", "aviso");
		}

		if (tentativas == 0) {
			usuarios.get(pegarInd).setSituacao_user("bloqueado");
			LoginView.mensagem("Excesso de tentativas!!", "Erro");
			LoginView.bloquearUser();
		}
	}

	public void limparCampos(boolean nome, boolean senha) {
		LoginView.limparTexto(nome, senha);
	}
}
