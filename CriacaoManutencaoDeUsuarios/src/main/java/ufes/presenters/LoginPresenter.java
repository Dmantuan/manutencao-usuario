package ufes.presenters;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.models.Usuario;
import ufes.views.LoginView;
import com.pss.senha.validacao.ValidadorSenha;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ufes.business.business.UsuarioBusiness;

public class LoginPresenter {

    private final LoginView view;
    private final UsuarioBusiness usuarioBusiness;
    private final CardLayout cardLayout;

    public LoginPresenter() {
        this.usuarioBusiness = new UsuarioBusiness();

        this.view = new LoginView();

        this.cardLayout = (CardLayout) view.getLoginPanel().getLayout();

        this.view.getBtn_casdastro_loginPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchCadastrar();
            }
        });

        this.view.getBtn_login_loginPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    logar();
                } catch (Exception ex) {
                    Logger.getLogger(LoginPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getBtn_cadastrar_cadastroPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cadastrar();
            }
        });

        this.view.getBtn_casdastro_loginPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchLogar();
            }
        });

        this.view.setVisible(
                true);
    }

    public void switchCadastrar() {
        cardLayout.show(view.getLoginPanel(), "cadastro");
    }

    public void switchLogar() {
        cardLayout.show(view.getLoginPanel(), "login");
    }

    public Usuario logar() throws Exception {
        
        Usuario usuario = usuarioBusiness.getByLogin(view.getTxField_login_loginPanel().getText());

        if (usuario == null) {
            throw new Exception("O login do usuario nao consta no bano de dados");
        }
        
        verificarLoginSenha(usuario);

        return usuario;
    }

    public void cadastrar() {
        try {
            Usuario usuario = new Usuario(
                    view.getTxField_nome_cadastroPanel().toString(),
                    view.getTxField_senha_cadastroPanel().toString(),
                    view.getTxField_login_cadastroPanel().toString()
            );
            usuarioBusiness.insert(usuario);

            ValidadorSenha validadorSenha = new ValidadorSenha();
            List passWordException = new ArrayList<>();

            passWordException.addAll(validadorSenha.validar(usuario.getSenha()));

            if (passWordException == null) {
                throw new Exception("O senha est");
            }
        } catch (Exception e) {
            //TODO: tratamento de erro
        }
    }

    public LoginView getView() {
        return view;
    }
    
    private void verificarLoginSenha(Usuario usuario){
        
        String senha = this.view.getTxField_senha_loginPanel().getText();
        
        if(usuario.getSenha() == null ? senha == null : usuario.getSenha().equals(senha)){
            System.out.println("Uusario/admin logado com sucesso");
        }
        else{
            System.out.println("usuario não está autorizado, senha incorreta");
        }
    }
}
