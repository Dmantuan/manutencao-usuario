package ufes.presenters;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.models.Usuario;
import ufes.views.LoginView;
import javax.swing.JOptionPane;
import ufes.business.business.UsuarioBusiness;

public class LoginPresenter {

    private final LoginView view;
    private final UsuarioBusiness usuarioBusiness;
    private final CardLayout cardLayout;
    private Usuario usuarioLogado;

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
                logar();
            }
        });

        this.view.getBtn_cadastrar_cadastroPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cadastrar();
            }
        });

        this.view.getBtn_logar_cadastroPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchLogar();
            }
        });

        this.view.setVisible(true);
    }

    public void switchCadastrar() {
        cardLayout.show(view.getLoginPanel(), "cadastro");
    }

    public void switchLogar() {
        cardLayout.show(view.getLoginPanel(), "login");
    }

    public void logar() {
        
        try {
            Usuario usuario = usuarioBusiness.getByLogin(view.getTxField_login_loginPanel().getText());

            if (usuario == null) {
                throw new Exception("O login do usuario nao consta no banco de dados");
            }

            if (!usuario.getSenha().equals(view.getTxField_senha_loginPanel().getText())) {
                throw new Exception("A senha do usuario esta errada");
            }
            
            modificarLogin(usuario);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public void cadastrar() {
        try {
            Usuario usuario = new Usuario(
                    view.getTxField_nome_cadastroPanel().getText(),
                    view.getTxField_senha_cadastroPanel().getText(),
                    view.getTxField_login_cadastroPanel().getText()
            );
            usuarioBusiness.insert(usuario);
            
            JOptionPane.showMessageDialog(view, "Usuario cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    public LoginView getView() {
        return view;
    }

    public void setVisible(boolean visible) {
        view.setVisible(visible);
    }

    public Usuario getUsuario() {
        return this.usuarioLogado;
    }
    
    public synchronized void modificarLogin(Usuario usuario){
        usuarioLogado = usuario;
        notify();
    }
    
    public synchronized void loginHandler(){
        while(usuarioLogado == null){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
