package ufes.presenters.crudCommand;

import ufes.presenters.CrudPresenter;

public class EditarCommand implements ICrudCommand {
    private final CrudPresenter crudPresenter;
    
    public EditarCommand(CrudPresenter crudPresenter){
        this.crudPresenter = crudPresenter;
    }
    
    @Override
    public void execute(){
        this.crudPresenter.editar();
    }
}
