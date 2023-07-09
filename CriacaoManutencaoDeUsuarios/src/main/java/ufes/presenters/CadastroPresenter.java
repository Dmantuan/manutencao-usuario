package ufes.presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.views.ViewCadastro;
import ufes.views.ViewLogin;

public class CadastroPresenter {

    private ViewCadastro viewCad;
    private static CadastroPresenter instancia;
    private LoginPresenter logPresenter;

    public CadastroPresenter(boolean isVisible) {

        this.viewCad = new ViewCadastro();
        this.viewCad.setVisible(isVisible);

        this.viewCad.getCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VerificarLogin();
            }
        });

        this.viewCad.getLogar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                navigateLogin();
            }
        });
    }

    private void VerificarLogin(){
        String loginUser = viewCad.getLogin().getText();
        String senhaUser = viewCad.getSenha().getText();

        System.out.println(loginUser);
        System.out.println(senhaUser);
    }

    private void navigateLogin(){

        this.logPresenter = new LoginPresenter(true);
        this.viewCad.setVisible(false);
    }
}