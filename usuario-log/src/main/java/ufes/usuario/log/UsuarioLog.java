package ufes.usuario.log;

import ufes.models.Log;
import ufes.presenter.ConfiguracaoPresenter;
import ufes.services.log.GerenciadorLog;

public class UsuarioLog {

    public static void main(String[] args) {
        
        ConfiguracaoPresenter presneter = ConfiguracaoPresenter.getIntancia();
        presneter.setVisible(true);
        
        Log log = new Log("Daniel", "Matheus", "REMOÇÃO");
        GerenciadorLog.salvarLog(presneter.getTipoLog(), log);
        
        Log log2 = new Log("Daniel" ,"Matheus","ADIÇÃO", "index of");
        GerenciadorLog.salvarLog(presneter.getTipoLog(), log2);
    }
}
