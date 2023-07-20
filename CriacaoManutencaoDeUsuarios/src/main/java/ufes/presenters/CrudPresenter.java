package ufes.presenters;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ufes.business.business.NotificacoesBusiness;
import ufes.business.business.UsuarioBusiness;
import ufes.business.dao.UsuarioDAO;
import ufes.presenters.crudState.CrudState;
import ufes.views.CrudView;
import ufes.models.Usuario;
import ufes.presenters.crudCommand.AutorizarCommand;
import ufes.presenters.crudCommand.BuscarCommand;
import ufes.presenters.crudCommand.ControleRemoto;
import ufes.presenters.crudCommand.EditarCommand;
import ufes.presenters.crudCommand.ICrudCommand;
import ufes.presenters.crudCommand.VisualizarCommand;
import ufes.presenters.crudState.BuscaState;

public class CrudPresenter {

    private CrudState estado;
    private CrudView view;
    private UsuarioBusiness usuarioBusiness;
    private NotificacoesBusiness notificacaoBusines;
    private CardLayout cardLayout;

    public CrudPresenter() {
        this.usuarioBusiness = new UsuarioBusiness();
        this.notificacaoBusines = new NotificacoesBusiness();

        view = new CrudView();

        cardLayout = (CardLayout) view.getCrudPanel().getLayout();

        this.estado = new BuscaState(this);

        //iniciando o command
        ControleRemoto control = new ControleRemoto();
        ICrudCommand autorizarCommand = new AutorizarCommand(this);
        ICrudCommand buscarCommand = new BuscarCommand(this);
        ICrudCommand editarCommand = new EditarCommand(this);
        ICrudCommand visualizarCommand = new VisualizarCommand(this);

        // ####### Pagina de buscar usuario
        //Criando tabela de usuarios com scrool pane
        DefaultTableModel buscar_model = new DefaultTableModel();

        buscar_model.addColumn("Nome");
        buscar_model.addColumn("Data de cadastro");
        buscar_model.addColumn("Notificacoes Lidas");
        buscar_model.addColumn("Notificacoes enviadas");
        try {
            for (Usuario usuario : usuarioBusiness.getAllUsers()) {
                buscar_model.addRow(new Object[]{usuario.getNome(), usuario.getLogin(), notificacaoBusines.getQtdNotificacoesLidas(usuario.getId()), notificacaoBusines.getQtdNovasNotificacoes(usuario.getId())});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Nao foi possivel carregar os dados do banco");
        }

        view.getTb_usuarios_buscarPanel().setModel(buscar_model);

        view.getBtn_visuzalizar_buscarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(visualizarCommand);
                control.pressionarBotao();
            }
        });

        view.getBtn_autorizar_buscarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(autorizarCommand);
                control.pressionarBotao();
            }
        });

        view.getBtn_fechar_buscarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.dispose();
            }
        });

        // ######### Pagina de Visualizar
        view.getBtn_editar_visualizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(editarCommand);
                control.pressionarBotao();
            }
        });

        view.getBtn_excluir_visualizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: chamar o log
                try {
                    if (JOptionPane.showConfirmDialog(view, "Deseja realmente excluir?") == JOptionPane.YES_OPTION) {
                        usuarioBusiness.delete(Integer.SIZE); //passar o id para ca
                        JOptionPane.showMessageDialog(view, "Usuario excluido");
                        control.setCommand(buscarCommand);
                        control.pressionarBotao();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, e.getMessage());
                }
            }
        });

        view.getBtn_fechar_visualizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(buscarCommand);
                control.pressionarBotao();
            }
        });

        // ######### Pagina de Editar
        view.getBtn_cancelar_editarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(visualizarCommand);
                control.pressionarBotao();
            }
        });

        view.getBtn_salvar_editarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: chamar log
                try {
                    usuarioBusiness.update(1, view.getTxField_nome_editarPanel().getText(), view.getTxField_login_editarPanel().getText(), view.getTxField_senhaNova_editarPanel().getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, e.getMessage());
                }
                control.setCommand(visualizarCommand);
                control.pressionarBotao();
            }
        });

        // ######### Pagina de autorizar
        DefaultTableModel autorizar_model = new DefaultTableModel();

        autorizar_model.addColumn("Nome");
        autorizar_model.addColumn("Data de cadastro");
        autorizar_model.addColumn("Notificacoes Lidas");
        autorizar_model.addColumn("Notificacoes enviadas");
        try {
            for (Usuario usuario : usuarioBusiness.getAllUsers()) {
                autorizar_model.addRow(new Object[]{usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getSenha()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.getTb_usuarios_autorizarPanel().setModel(autorizar_model);

        view.getBtn_cancelar_autorizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(buscarCommand);
                control.pressionarBotao();
            }
        });

        view.getBtn_autorizar_autorizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: chamar o log
                try {
                    usuarioBusiness.updateAdmin(1, Boolean.TRUE, Boolean.TRUE);

                    control.setCommand(autorizarCommand);
                    control.pressionarBotao();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Nao foi possivel autorizar o usuario");
                }
                control.setCommand(buscarCommand);
                control.pressionarBotao();
            }
        });

        view.setVisible(true);
    }

    public void visualizar() {
        this.estado.visualizar();
    }

    public void editar() {
        this.estado.editar();
    }

    public void autorizar() {
        this.estado.autorizar();
    }

    public void buscar() {
        this.estado.buscar();
    }

    public CardLayout getCardLayout() {
        return this.cardLayout;
    }

    public JPanel getCrudPanel() {
        return this.view.getCrudPanel();
    }

    public void setEstate(CrudState state) {
        this.estado = state;
    }
    
    public CrudView getCrudView(){
        return this.view;
    }
    
    public void setVisible(boolean visible){
        EventQueue.invokeLater(() -> {
            view.setVisible(visible);
            view.toFront(); // Abrir a tela na frente de outras
        });
    }
}
