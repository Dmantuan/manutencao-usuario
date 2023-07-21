package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import ufes.business.business.NotificacoesBusiness;
import ufes.models.Usuario;
import ufes.presenters.CrudPresenter;
import ufes.presenters.LoginPresenter;
import ufes.view.MainView;

public class MainPresenter {

    private final MainView view;
    private int qtdNovasNotificacoes;
    private final ListarMensagemPresenter listarMensagensPresenter;
    private final EnviarMensagemPresenter enviarMensagensPresenter;
    private final CrudPresenter crudPresenter;
    private final LoginPresenter loginPresenter;
    private ConfiguracaoPresenter log = ConfiguracaoPresenter.getIntancia();
    private Usuario usuario;

    private final NotificacoesBusiness dbMensagens;

    public MainPresenter() {
        this.view = new MainView();
        this.dbMensagens = new NotificacoesBusiness();
        exibirEmTelaCheia();

        this.loginPresenter = new LoginPresenter();
        inicializarLogin();

        this.view.setVisible(true);

        this.enviarMensagensPresenter = new EnviarMensagemPresenter();
        this.listarMensagensPresenter = new ListarMensagemPresenter();
        this.crudPresenter = new CrudPresenter();

        inicializarLog();

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

        this.view.getEscolherLog().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                abrirLog();
            }
        });

        this.view.getManterUsuarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                abrirManterUsuarios();
            }
        });
        logar();
    }

    private void inicializarListarMensagens() {

        JInternalFrame internalFrame = this.listarMensagensPresenter.getView();
        internalFrame.setSize(this.view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2 - 40;
        internalFrame.setLocation(x, y);
        
        try{
            this.listarMensagensPresenter.loadData();
        } catch (Exception e){
            JOptionPane.showMessageDialog(internalFrame, "Nao foi possivel carregar as mensagens: \n" + e.getMessage());
        }

        internalFrame.setVisible(false);
        this.view.getDesktopPane().add(internalFrame);
    }

    private void inicializarEnviarMensagens() {

        JInternalFrame internalFrame = this.enviarMensagensPresenter.getView();
        internalFrame.setSize(this.view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2 - 40;
        internalFrame.setLocation(x, y);

        internalFrame.setVisible(false);
        this.view.getDesktopPane().add(internalFrame);
    }

    private void inicializarManterUusarios() {
        JInternalFrame internalFrame = this.crudPresenter.getCrudView();
        internalFrame.setSize(this.view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2 - 40;
        internalFrame.setLocation(x, y);

        internalFrame.setVisible(false);
        this.view.getDesktopPane().add(internalFrame);
    }

    private void inicializarLogin() {

        this.view.getNotificacao().setVisible(false);
        this.view.getMensagem().setVisible(false);
        this.view.getManterUsuarios().setVisible(false);
        JInternalFrame internalFrame = this.loginPresenter.getView();
        internalFrame.setVisible(true);
        this.view.getDesktopPane().add(internalFrame);
    }

    private void inicializarLog() {

        JInternalFrame internalFrame = this.log.getView();
        this.view.getDesktopPane().add(internalFrame);
    }

    private void abrirLog() {
        this.log.setVisible(true);
    }

    public void logar() {

        this.loginPresenter.loginHandler();

        this.usuario = this.loginPresenter.getUsuario();
       
        novasNotificacoes();

        this.listarMensagensPresenter.setIduser(this.usuario.getId());
        this.crudPresenter.setUser(this.usuario);
        this.enviarMensagensPresenter.setUser(this.usuario);
        this.enviarMensagensPresenter.loadData();
        if(usuario != null){
            this.crudPresenter.loadData();
        }
        
        this.enviarMensagensPresenter.setUser(usuario);
        novasNotificacoes();
        inicializarManterUusarios();
        inicializarEnviarMensagens();
        inicializarListarMensagens();

        if (usuario.getAdmin()) {
            this.view.getNotificacao().setVisible(true);
            this.view.getMensagem().setVisible(true);
            this.view.getManterUsuarios().setVisible(true);
        } else {
            this.view.getNotificacao().setVisible(true);
            this.view.getMensagem().setVisible(false);
            this.view.getManterUsuarios().setVisible(false);
        }
        this.loginPresenter.setVisible(false);
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
            this.qtdNovasNotificacoes = this.dbMensagens.getQtdNovasNotificacoes(this.usuario.getId());

            this.view.getNotificacao().setText("Mensagens não lidas: " + String.valueOf(this.qtdNovasNotificacoes));
            this.view.getTipoUser().setText(this.usuario.getAdmin() ? "Admin: " + this.usuario.getNome() : "User: " + this.usuario.getNome());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void abrirManterUsuarios() {
        this.crudPresenter.setVisible(true);
    }

    public void setVisible() {
        this.view.setVisible(true);
    }

    private void exibirEmTelaCheia() {
        this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
