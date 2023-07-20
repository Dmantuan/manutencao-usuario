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

    private MainView view;
    private int qtdNovasNotificacoes;
    private String user;
    private ListarMensagemPresenter listarMensagensPresenter;
    private EnviarMensagemPresenter enviarMensagensPresenter;
    private CrudPresenter crudPresenter;
    private LoginPresenter loginPresenter;
    private ConfiguracaoPresenter log = ConfiguracaoPresenter.getIntancia();
    private Usuario usuario;

    private NotificacoesBusiness dbMensagens;

    public MainPresenter() {
        this.dbMensagens = new NotificacoesBusiness();

        this.view = new MainView();
        exibirEmTelaCheia();
        novasNotificacoes();

        this.dbMensagens = new NotificacoesBusiness();

        this.loginPresenter = new LoginPresenter(this);
        inicializarLogin();
        
        this.view.setVisible(true);

        this.enviarMensagensPresenter = new EnviarMensagemPresenter();
        this.listarMensagensPresenter = new ListarMensagemPresenter();
        this.crudPresenter = new CrudPresenter();

        inicializarEnviarMensagens();
        inicializarListarMensagens();
        inicializarLog();
        inicializarManterUusarios();

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
    }

    private void inicializarListarMensagens() {

        JInternalFrame internalFrame = this.listarMensagensPresenter.getView();
        internalFrame.setSize(this.view.getDesktopPane().getSize());
        internalFrame.setPreferredSize(this.view.getDesktopPane().getSize());
        int x = (this.view.getDesktopPane().getWidth() - internalFrame.getWidth()) / 2;
        int y = (this.view.getDesktopPane().getHeight() - internalFrame.getHeight()) / 2 - 40;
        internalFrame.setLocation(x, y);

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
    
    private void inicializarManterUusarios(){
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
    
    public void logar(Usuario usuario){
        
        this.usuario = usuario;
        this.user = this.usuario.getNome();
        if(usuario.getAdmin()){
            this.view.getNotificacao().setVisible(true);
            this.view.getMensagem().setVisible(true);
            this.view.getManterUsuarios().setVisible(true);
        }else{
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
            this.qtdNovasNotificacoes = this.dbMensagens.getQtdNovasNotificacoes(3); // aqui vai ser feita a consulta
            this.user = "";
            
            this.view.getNotificacao().setText("Mensagens não lidas: " + String.valueOf(this.qtdNovasNotificacoes));
            this.view.getTipoUser().setText(this.user);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
    
    private void abrirManterUsuarios(){
        this.crudPresenter.setVisible(true);
    }

    public void setVisible() {
        this.view.setVisible(true);
    }

    private void exibirEmTelaCheia() {
        this.view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
