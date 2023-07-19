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
    ListarMensagemPresenter listarMensagensPresenter;
    EnviarMensagemPresenter enviarMensagensPresenter;

    public MainPresenter() {

        this.view = new MainView();
        this.view.setVisible(true);
        
        this.enviarMensagensPresenter = EnviarMensagemPresenter.getIntance();
        this.listarMensagensPresenter = ListarMensagemPresenter.getIntance();

        exibirEmTelaCheia();
        novasNotificacoes();

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
        
        inicializarListarMensagens();
        inicializarEnviarMensagens();
    }

    private void inicializarListarMensagens() {

        JInternalFrame internalFrame = this.listarMensagensPresenter.getView();
        internalFrame.setSize(view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(view.getDesktopPane().getSize());
        int x = (view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2;
        internalFrame.setLocation(x, y);

        internalFrame.setVisible(false);
        view.getDesktopPane().add(internalFrame);
    }

    private void inicializarEnviarMensagens() {

        JInternalFrame internalFrame = this.enviarMensagensPresenter.getView();
        internalFrame.setSize(view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(view.getDesktopPane().getSize());
        int x = (view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2;
        internalFrame.setLocation(x, y);

        internalFrame.setVisible(false);
        view.getDesktopPane().add(internalFrame);
    }
    
    private void visualizarNotificacoes(){
        this.listarMensagensPresenter.setVisible(true);
        this.enviarMensagensPresenter.setVisible(false);
    }
    
    private void enviarNotificacoes(){
        this.enviarMensagensPresenter.setVisible(true);
        this.listarMensagensPresenter.setVisible(false);
    }

    private void novasNotificacoes() {
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
}
