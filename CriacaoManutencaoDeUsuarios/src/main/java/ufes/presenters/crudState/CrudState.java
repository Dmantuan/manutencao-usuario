package ufes.presenters.crudState;

import ufes.presenters.CrudPresenter;

public abstract class CrudState {

    protected CrudPresenter crudPresenter;

    public CrudState(CrudPresenter presenter) {
        this.crudPresenter = presenter;
    }

    public void visualizar() {
        throw new RuntimeException("Não é possível abrir uma porta ");

    }

    public void editar() {
        throw new RuntimeException("Não é possível abrir uma porta ");

    }

    public void autorizar() {
        throw new RuntimeException("Não é possível abrir uma porta ");

    }

    public void buscar() {
        throw new RuntimeException("Não é possível abrir uma porta ");

    }
}
