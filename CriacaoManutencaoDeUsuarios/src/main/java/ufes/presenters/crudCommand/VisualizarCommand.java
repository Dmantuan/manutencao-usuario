package ufes.presenters.crudCommand;

import ufes.presenters.CrudPresenter;
import ufes.presenters.crudState.VisualizadaState;

public class VisualizarCommand implements ICrudCommand{
    private final CrudPresenter crudPresenter;
    
    public VisualizarCommand(CrudPresenter crudPresenter){
        this.crudPresenter = crudPresenter;
    }
    
    @Override
    public void execute() {
        this.crudPresenter.visualizar();
    }
}
