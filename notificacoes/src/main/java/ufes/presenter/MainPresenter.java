package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import ufes.business.business.NotificacoesBusiness;
import ufes.models.Usuario;
import ufes.presenters.LoginPresenter;
import ufes.service.AtualizarTelasService;
import ufes.view.MainView;

public class MainPresenter implements IAtualizarTelas {

    private MainView view;
    private int qtdNovasNotificacoes;
    private String user;
    private ListarMensagemPresenter listarMensagensPresenter;
    private EnviarMensagemPresenter enviarMensagensPresenter;
    private LoginPresenter loginPresenter;
    private Usuario usuario;
    private AtualizarTelasService atualizarTelasService;
    private NotificacoesBusiness dbMensagens;

    public MainPresenter() {
        this.dbMensagens = new NotificacoesBusiness();

        this.view = new MainView();
        exibirEmTelaCheia();
        novasNotificacoes();

        this.dbMensagens = new NotificacoesBusiness();

        this.loginPresenter = new LoginPresenter();

        this.view.setVisible(true);

        //  atualizarTelasService = AtualizarTelasService.getInstancia();
        this.enviarMensagensPresenter = new EnviarMensagemPresenter();
        this.listarMensagensPresenter = new ListarMensagemPresenter();

//        atualizarTelasService.addTelas(this);
//        atualizarTelasService.addTelas(this.enviarMensagensPresenter);
//        atualizarTelasService.addTelas(this.listarMensagensPresenter);
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

    private void inicializarLogin() {

        this.view.getNotificacao().setVisible(false);
        this.view.getMensagem().setVisible(false);
        JInternalFrame internalFrame = this.loginPresenter.getView();
//        internalFrame.setSize(this.view.getDesktopPane().getSize());
//        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
//        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
//        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2;
//        internalFrame.setLocation(x, y);

        internalFrame.setVisible(true);
        this.view.getDesktopPane().add(internalFrame);
    }

    private void visualizarNotificacoes() {
        this.listarMensagensPresenter.setVisible(true);
        this.enviarMensagensPresenter.setVisible(false);
    }

    private void enviarNotificacoes() {
        this.enviarMensagensPresenter.setVisible(true);
        this.listarMensagensPresenter.setVisible(false);
    }

    private void novasNotificacoes() {
        try {
            this.qtdNovasNotificacoes = this.dbMensagens.getQtdNovasNotificacoes(3); // aqui vai ser feita a consulta
            System.out.println(qtdNovasNotificacoes);
            this.user = "Admin: Matheus";

            this.view.getNotificacao().setText("Mensagens não lidas: " + String.valueOf(this.qtdNovasNotificacoes));
            this.view.getTipoUser().setText(this.user);
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception ex) {
            Logger.getLogger(ListarMensagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
