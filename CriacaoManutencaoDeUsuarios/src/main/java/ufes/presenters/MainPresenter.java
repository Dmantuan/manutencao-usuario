package ufes.presenters;

import ufes.views.ViewCadastro;

public class MainPresenter {

    private CadastroPresenter cadPresenter;
    private LoginPresenter logPresenter;

    public MainPresenter() {

        // verificação se o banco de dados está vazio
        if(1 == 1){
            this.cadPresenter = new CadastroPresenter( true);
            this.logPresenter = new LoginPresenter( false);
        }else{
            this.logPresenter = new LoginPresenter( true);
            this.cadPresenter = new CadastroPresenter( false);
        }

    }
}