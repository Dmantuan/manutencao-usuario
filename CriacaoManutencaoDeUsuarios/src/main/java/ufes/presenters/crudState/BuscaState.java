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
public class BuscaState extends CrudState {
    public BuscaState(CrudPresenter crudPresenter){
        super(crudPresenter);
        crudPresenter.getCardLayout().show(crudPresenter.getCrudPanel(), "buscar");
    }
    
    @Override
    public void autorizar(){
        crudPresenter.setEstate(new AutorizadaState(crudPresenter));
    }
    
    @Override
    public void visualizar(){
        crudPresenter.setEstate(new VisualizadaState(crudPresenter));
    }
}
