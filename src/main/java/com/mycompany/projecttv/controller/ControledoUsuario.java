package com.mycompany.projecttv.controller;

import com.mycompany.projecttv.dao.UsuarioDAO;
import com.mycompany.projecttv.model.Usuario;
import com.mycompany.projecttv.view.MainScreen;
import com.mycompany.projecttv.view.StartScreen;

public class ControledoUsuario {
    
    private UsuarioDAO usuarioDAO;
    private StartScreen startScreen;
    
    public ControledoUsuario(StartScreen startScreen){
        this.usuarioDAO = new UsuarioDAO();
        this.startScreen = startScreen;
    }

    public boolean cadastrar(String nome, String login, String senha) {
        if (nome.isEmpty() || login.isEmpty() || senha.isEmpty()) return false;
        return usuarioDAO.cadastrar(nome, login, senha);
    }

    public boolean autenticar(String login, String senha) {
        return usuarioDAO.autenticar(login, senha);
    }

    
    public Usuario buscarUsuarioPeloLogin(String login) {
        return usuarioDAO.buscarPorLogin(login);
    }
    
    /**
     * Essa funcao é responsável por verificar se o usuario
     *
     */
    public void entrar(){
        String login = this.startScreen.getTxtLogin().getText(); 
        String senha = this.startScreen.getTxtSenha().getText();

        if (this.autenticar(login, senha)) {
            com.mycompany.projecttv.model.Usuario u = this.buscarUsuarioPeloLogin(login); 

            com.mycompany.projecttv.model.Sessao.setUsuario(u);

            MainScreen telaPrincipal = new MainScreen();
            telaPrincipal.setVisible(true);
            telaPrincipal.setLocationRelativeTo(null);
            startScreen.dispose(); 
        } else {
            javax.swing.JOptionPane.showMessageDialog(startScreen, "Usuário ou senha incorretos!");
        }
    }
    public void cadastrar(){
        String nome = this.startScreen.getTxtNome().getText();
        String login = this.startScreen.getTxtLogin().getText();
        String senha = new String(this.startScreen.getTxtSenha().getPassword());

        com.mycompany.projecttv.controller.ControledoUsuario controller = new com.mycompany.projecttv.controller.ControledoUsuario(startScreen);
    
        boolean sucesso = controller.cadastrar(nome, login, senha);

        if (sucesso) {
            javax.swing.JOptionPane.showMessageDialog(startScreen, "Usuário " + nome + " cadastrado com sucesso!");
            this.startScreen.getTxtNome().setText("");
            this.startScreen.getTxtLogin().setText("");
            this.startScreen.getTxtSenha().setText("");
        } 
        else {
        javax.swing.JOptionPane.showMessageDialog(startScreen, "Erro: Login já existe ou campos vazios!");
        }
    }
}