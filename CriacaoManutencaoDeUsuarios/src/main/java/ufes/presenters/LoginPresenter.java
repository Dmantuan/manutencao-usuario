package ufes.presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.views.ViewLogin;

public class LoginPresenter {

    private ViewLogin viewLog;
    private static LoginPresenter instancia;
    private CadastroPresenter cadPresenter;

    public LoginPresenter(boolean isVisible){

        this.viewLog = new ViewLogin();
        this.viewLog.setVisible(isVisible);

        this.viewLog.getLogar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VerificarLogin();
            }
        });

        this.viewLog.getCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                navigateCadastro();
            }
        });
    }

    private void VerificarLogin(){
        String loginUser = viewLog.getLogin().getText();
        String senhaUser = viewLog.getSenha().getText();

        System.out.println(loginUser);
        System.out.println(senhaUser);
    }

    private void navigateCadastro(){

        this.cadPresenter = new CadastroPresenter(true);
        this.viewLog.setVisible(false);
    }
}