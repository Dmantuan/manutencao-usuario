package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import ufes.services.log.ILog;
import ufes.services.log.LogJSON;
import ufes.services.log.LogCSV;
import ufes.view.ConfiguracaoView;

public class ConfiguracaoPresenter {
    private ConfiguracaoView view;
    private ILog tipoLog;
    private static ConfiguracaoPresenter configuracaoPresenter;
    
    private ConfiguracaoPresenter(){
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
    
    public static ConfiguracaoPresenter getIntancia(){
        if(configuracaoPresenter == null){
            configuracaoPresenter = new ConfiguracaoPresenter();
        }
        return configuracaoPresenter;
    }
    
    private void setConfiguracao(){
        if( this.view.getCmbBox().getItemAt(this.view.getCmbBox().getSelectedIndex()).equalsIgnoreCase("CSV")){
            this.tipoLog = new LogCSV();
        }
        else{
            this.tipoLog = new LogJSON();
        }
    }
    
    public ILog getTipoLog(){
        return this.tipoLog;
    }
    
    public void setVisible(boolean visible){
        this.view.setVisible(visible);
    }

    public ConfiguracaoView getView() {
        return view;
    }
}
