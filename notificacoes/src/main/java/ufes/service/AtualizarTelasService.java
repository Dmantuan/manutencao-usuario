package ufes.service;

import java.util.ArrayList;
import java.util.List;
import ufes.presenter.EnviarMensagemPresenter;
import ufes.presenter.IAtualizarTelas;
import ufes.presenter.ListarMensagemPresenter;
import ufes.presenter.MainPresenter;

public class AtualizarTelasService {
    
    List<IAtualizarTelas> telas;

    public AtualizarTelasService() {
        this.telas = new ArrayList<>();
        addTelas();
    }

    public void atualizarTodasTelas(){
        
        for(IAtualizarTelas tela : telas){
            tela.atualizarTela();
        }
    }   
    
    ////////////////////////////// error //////////////////////////
    private void addTelas(){
        // this.telas.add(MainPresenter.getIntance());
        // this.telas.add(new EnviarMensagemPresenter());
        // this.telas.add(new ListarMensagemPresenter());
    }
}
