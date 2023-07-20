package ufes.presenters.crudCommand;

import ufes.presenters.CrudPresenter;

public class BuscarCommand implements ICrudCommand{
    private final CrudPresenter crudPresenter;
    
    public BuscarCommand(CrudPresenter crudPresenter){
        this.crudPresenter = crudPresenter;
    }
    
    
    @Override
    public void execute(){
        this.crudPresenter.buscar();
    }
}
