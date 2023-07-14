package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufes.services.log.ILog;
import ufes.services.log.LogJSON;
import ufes.services.log.LogCSV;
import ufes.view.ConfiguracaoView;

public class ConfiguracaoPresenter {
    private ConfiguracaoView view;
    private static ILog tipoLog;
    
    public ConfiguracaoPresenter(){
        this.view = new ConfiguracaoView();
        this.view.setVisible(false);
        
        this.view.getCmbBox().removeAllItems();
        this.view.getCmbBox().addItem("CSV");
        this.view.getCmbBox().addItem("JSON");
        
        this.view.getCmbBox().setSelectedIndex(0);
        
        setConfiguracao();
        
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setConfiguracao();
                view.setVisible(false);
            }
        });
        
    }
    
    private void setConfiguracao(){
        if( this.view.getCmbBox().getItemAt(this.view.getCmbBox().getSelectedIndex()).equalsIgnoreCase("V")){
            ConfiguracaoPresenter.tipoLog = new LogCSV();
        }
        else{
            ConfiguracaoPresenter.tipoLog = new LogJSON();
        }
    }
    
    public static ILog getTipoLog(){
        return ConfiguracaoPresenter.tipoLog;
    }
    
    public void setVisible(){
        this.view.setVisible(true);
    }
    
}
