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
public class AutorizadaState extends CrudState {
    public AutorizadaState(CrudPresenter crudPresenter){
        super(crudPresenter);
        crudPresenter.getCardLayout().show(crudPresenter.getCrudPanel(), "autorizar");
    }
    
    @Override
    public void buscar(){
        crudPresenter.setEstate(new BuscaState(crudPresenter));
    }
}
