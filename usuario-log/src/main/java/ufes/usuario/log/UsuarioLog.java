package ufes.usuario.log;

import ufes.models.Log;
import ufes.presenter.ConfiguracaoPresenter;
import ufes.services.log.GerenciadorLog;



public class UsuarioLog {

    public static void main(String[] args) {
        
        ConfiguracaoPresenter presneter = new ConfiguracaoPresenter();
        presneter.setVisible();
        
        Log log = new Log("Matheus", "REMOÇÃO");
        GerenciadorLog.salvarLog(ConfiguracaoPresenter.getTipoLog(), log);
        
        Log log2 = new Log("Matheus","ADIÇÃO");
        GerenciadorLog.salvarLog(ConfiguracaoPresenter.getTipoLog(), log2);
    }
}
