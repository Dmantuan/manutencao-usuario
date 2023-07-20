package ufes.service;

import java.util.ArrayList;
import java.util.List;
import ufes.presenter.EnviarMensagemPresenter;
import ufes.presenter.IAtualizarTelas;
import ufes.presenter.ListarMensagemPresenter;
import ufes.presenter.MainPresenter;

public class AtualizarTelasService {
    
    private List<IAtualizarTelas> telas;
    private static AtualizarTelasService ats;

    private AtualizarTelasService() {
        this.telas = new ArrayList<>();
    }
    
    public static AtualizarTelasService getInstancia(){
        if(ats == null){
            ats = new AtualizarTelasService();
        } 
        return ats;
    }

    public void atualizarTodasTelas(){
        
        for(IAtualizarTelas tela : telas){
            tela.atualizarTela();
        }
    }   

    public void addTelas(IAtualizarTelas presenter){
        this.telas.add(new MainPresenter());
    }
}
