/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.presenters.crudState;

import ufes.presenters.CrudPresenter;

/**
 *
 * @author daniel
 */
public class VisualizadaState extends CrudState {

    public VisualizadaState(CrudPresenter crudPresenter) {
        super(crudPresenter);
        crudPresenter.getCardLayout().show(crudPresenter.getCrudPanel(), "visualizar");
    }

    @Override
    public void editar() {
        crudPresenter.setEstate(new EditadaState(crudPresenter));
    }

    @Override
    public void buscar() {
        crudPresenter.setEstate(new BuscaState(crudPresenter));
    }
}
