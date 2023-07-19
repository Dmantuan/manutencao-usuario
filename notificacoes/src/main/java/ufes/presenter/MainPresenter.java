package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import ufes.view.MainView;

public class MainPresenter implements IAtualizarTelas {

    private MainView view;
    private int qtdNovasNotificacoes;
    private String user;
    ListarMensagemPresenter listarMensagensPresenter;
    EnviarMensagemPresenter enviarMensagensPresenter;
    private static MainPresenter instancia = null;

    public MainPresenter() {
        this.view = new MainView();
        exibirEmTelaCheia();
        novasNotificacoes();
        this.view.setVisible(true);
        
        this.enviarMensagensPresenter = new EnviarMensagemPresenter();
        this.listarMensagensPresenter = new ListarMensagemPresenter();

        inicializarEnviarMensagens();
        inicializarListarMensagens();
        
        this.view.getNotificacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                visualizarNotificacoes();
            }
        });

        this.view.getMensagem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                enviarNotificacoes();
            }
        });
    }
    
//    public static MainPresenter getIntance(){
//        
//        if(instancia == null){
//            instancia = new MainPresenter();
//        }
//        return instancia;
//    }

    private void inicializarListarMensagens() {

        JInternalFrame internalFrame = this.listarMensagensPresenter.getView();
        internalFrame.setSize(this.view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2;
        internalFrame.setLocation(x, y);

        internalFrame.setVisible(false);
        this.view.getDesktopPane().add(internalFrame);
    }

    private void inicializarEnviarMensagens() {

        JInternalFrame internalFrame = this.enviarMensagensPresenter.getView();
        internalFrame.setSize(this.view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2;
        internalFrame.setLocation(x, y);

        internalFrame.setVisible(false);
        this.view.getDesktopPane().add(internalFrame);
    }
    
    private void visualizarNotificacoes(){
        this.listarMensagensPresenter.setVisible(true);
        this.enviarMensagensPresenter.setVisible(false);
    }
    
    private void enviarNotificacoes(){
        this.enviarMensagensPresenter.setVisible(true);
        this.listarMensagensPresenter.setVisible(false);
    }

    private void novasNotificacoes(){
        try {
            this.qtdNovasNotificacoes = 4; // aqui vai ser feita a consulta
            this.user = "Admin: Matheus";

            this.view.getNotificacao().setText("Mensagens não lidas: " + String.valueOf(this.qtdNovasNotificacoes));
            this.view.getTipoUser().setText(this.user);
        } catch (Exception e) {

        }
    }

    public void setVisible() {
        this.view.setVisible(true);
    }

    private void exibirEmTelaCheia() {
        this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    @Override
    public void atualizarTela() {
        try {
            novasNotificacoes();
            System.out.println("ufes.presenter.MainPresenter.atualizarTela() tela atualizada");
        } catch (Exception ex) {
            Logger.getLogger(ListarMensagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
