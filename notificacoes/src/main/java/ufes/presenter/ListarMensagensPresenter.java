package ufes.presenter;

import ufes.view.ListarMensagensView;
import ufes.business.business.NotificacoesBusiness;

public class ListarMensagensPresenter {
    private ListarMensagensView view;
    
    public ListarMensagensPresenter(){
        this.view = new ListarMensagensView();
        
        // Habilitar a barra de fechar no JInternalFrame
        this.view.setClosable(true);

        this.view.setVisible(true);
    }
    
    private void loadData(){
        
    }

    public ListarMensagensView getView() {
        return this.view;
    }
}

