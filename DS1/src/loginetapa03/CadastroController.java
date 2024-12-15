package loginetapa03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroController{
    private Cadastro CadastroView;
    private UserText ListaCadastro;
    private ArrayList<Usuario> usuarios;
    private int confirma;
    private String nivel = "nome";
    private String nomeVeri;
    private String senhaVeri;
    private String etapa;
    private String userRegister;
    private boolean temAdministrador;
    
    public CadastroController(Cadastro CadastroView, ArrayList<Usuario> usuarios,boolean temAdministrador,UserText ListaCadastro){
        this.CadastroView = CadastroView;
        this.ListaCadastro = ListaCadastro;
        this.usuarios = usuarios;
        this.temAdministrador = temAdministrador;

        this.CadastroView.addCadastrarListener(e -> cadastroUser());
        this.CadastroView.addLimparListener(e -> CadastroView.limparTexto(true, true));
        this.CadastroView.addLogarListener(e -> {
            Login LoginView = new Login(usuarios,temAdministrador,ListaCadastro);
            new LoginController(LoginView, usuarios,temAdministrador);
            CadastroView.setVisible(false);
        });
    }



    public void cadastroUser(){
        boolean existe = false;
        
        for(Usuario usuario : usuarios){
            if (!usuario.getNome_user().equals(CadastroView.getNome())){
                existe = false;
            } else if (usuario.getNome_user().equals(CadastroView.getNome())) {
                existe = true;
                break;
            }
            if(usuario.getTipo_user().equalsIgnoreCase("administrador")) {
            	temAdministrador = true;
            }
                       
        }

        if (existe){
            CadastroView.mensagem("Este usuário já existe no sistema!", "Aviso");
        } 
  
        	analisarDados(existe);
    }

    public void analisarDados(boolean permissao){
        if (!permissao){
            String recept = "";
            String tipo = "";

            if (nivel.equalsIgnoreCase("nome")) {
                recept = CadastroView.getNome();
                tipo = "nome";
            } else if (nivel.equalsIgnoreCase("senha")) {
                recept = CadastroView.getSenha();
                tipo = "senha";
                
            }

            if (!recept.trim().isEmpty()) {
                confirma++;
                if (confirma == 1) {
                    CadastroView.mensagem("Confirme seus dados!", "Aviso");
                }

                confirmaDados(recept, tipo);
                CadastroView.limparTexto(true, true);
            } else {
                CadastroView.mensagem("O campo " + tipo + " não pode estar vazio!", "Aviso");
            }
        } else{
            CadastroView.limparTexto(true, true);
        }
    }

    public void confirmaDados(String info, String tipo){
        if (confirma == 1) {
            etapa = info;
        } else if (confirma == 2) {
            String recept = "";
            if (tipo.equalsIgnoreCase("nome")) {
                recept = CadastroView.getNome();
                nomeVeri = info;
            } else if (tipo.equalsIgnoreCase("senha")) {
                recept = CadastroView.getSenha();
                senhaVeri = info;
            }
            if (recept.equals(etapa)) {
                CadastroView.mensagem(tipo.toUpperCase() + " validado!", "Aviso");
                if (tipo.equalsIgnoreCase("nome")) {
                    nivel = "senha";
                    CadastroView.desativarBtn(true, "senha");
                    CadastroView.desativarBtn(false, "nome");
                } else if (tipo.equalsIgnoreCase("senha")) {
                    nivel = "nome";
                    if (CadastroView.getPerfil().equalsIgnoreCase("administrador")) {
                        temAdministrador = true;
                    }
                    if(temAdministrador) {
                        usuarios.add(new Usuario(nomeVeri, senhaVeri, CadastroView.getPerfil(),"normal" ));
                        String userLine;
                        for(Usuario usuario : usuarios) {
                        	userLine ="\n\nNome: "+ usuario.getNome_user()+"\nSenha: "+ usuario.getSenha_user()+"\n";
                        	userRegister = userRegister + userLine;
                        }
//                        ListaCadastro.UserWriteList(userRegister);
                    } else {
                        CadastroView.mensagem("Primeiro usuario será cadastrado como Admnistrador!\nCadastro não realizado!", "Aviso");
                    }
                    CadastroView.desativarBtn(true, "nome");
                    CadastroView.desativarBtn(false, "senha");
                    
                }
                confirma = 0;
            } else {
                CadastroView.mensagem("Campos não correspondem!", "Aviso");
                confirma = 1;
            }

        }
    }
}
