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
public class EditadaState extends CrudState{
    public EditadaState(CrudPresenter crudPresenter){
        super(crudPresenter);
        crudPresenter.getCardLayout().show(crudPresenter.getCrudPanel(), "editar");
    }
    
    @Override
    public void visualizar() {
        crudPresenter.setEstate(new VisualizadaState(crudPresenter));
    }
}
