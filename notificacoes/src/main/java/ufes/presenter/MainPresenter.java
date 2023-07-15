package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import ufes.view.MainView;

public class MainPresenter {
    
    private MainView view;
    private int qtdNovasNotificacoes;
    private String user;
    
    public MainPresenter(){
        
        this.view = new MainView();
        this.view.setVisible(true);
        
        novasNotificacoes();
        
        this.view.getNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                visualizarNotificacoes();
            }
        });
        
            
    }
    
    private void visualizarNotificacoes(){
        
        ListarMensagensPresenter listarMensagensPresenter = new ListarMensagensPresenter();
        JInternalFrame internalFrame = listarMensagensPresenter.getView();
        internalFrame.setSize(view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(view.getDesktopPane().getSize());
        
        int x = (view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2;
        internalFrame.setLocation(x, y);
        
        view.getDesktopPane().add(internalFrame);
    }
    
    private void novasNotificacoes(){
        try {
            this.qtdNovasNotificacoes = 4; // aqui vai ser feita a consulta
            this.user = "Admin: Matheus";
            
            this.view.getNotificacao().setText(String.valueOf(this.qtdNovasNotificacoes));
            this.view.getTipoUser().setText(this.user);
        } catch (Exception e) {
            
        }
    }
    
    public void setVisible(){
        this.view.setVisible(true);
    }
    
    public void exibirEmTelaCheia() {
        this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
