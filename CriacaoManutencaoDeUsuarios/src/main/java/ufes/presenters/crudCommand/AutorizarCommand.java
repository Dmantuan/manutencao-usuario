package ufes.presenters.crudCommand;

import ufes.presenters.CrudPresenter;

public class AutorizarCommand implements ICrudCommand {
    private final CrudPresenter crudPresenter;
    
    public AutorizarCommand(CrudPresenter crudPresenter){
        this.crudPresenter = crudPresenter;
    }
    
    @Override
    public void execute(){
        this.crudPresenter.autorizar();
    }
}
