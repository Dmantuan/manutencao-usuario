package ufes.presenters;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import ufes.business.business.NotificacoesBusiness;
import ufes.business.business.UsuarioBusiness;
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
    private List<Usuario> usuarios;
    private List<Usuario> usuariosAutorizar;
    private Usuario user;

    private DefaultTableModel buscar_model = new DefaultTableModel();

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

        //Criando tabela de usuarios com scrool pane
//        DefaultTableModel buscar_model = new DefaultTableModel();
        buscar_model.addColumn("Nome");
        buscar_model.addColumn("Login");
        buscar_model.addColumn("Notificacoes Lidas");
        buscar_model.addColumn("Notificacoes enviadas");

        // Criando tabela de usuarios com scrool pane
        DefaultTableModel autorizar_model = new DefaultTableModel();
        autorizar_model.addColumn("Nome");
        autorizar_model.addColumn("Login");
        autorizar_model.addColumn("Notificacoes Lidas");
        autorizar_model.addColumn("Notificacoes enviadas");

        // ####### Pagina de buscar usuario
//        loadData(buscar_model);
        view.getBtn_visuzalizar_buscarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int select = view.getTb_usuarios_buscarPanel().getSelectedRow();

                    view.getTxField_nome_visualizarPanel().setText(usuarios.get(select).getNome());
                    view.getTxField_nome_visualizarPanel().setEnabled(false);

                    String pattern = "dd/MM/yyyy HH:mm:ss";
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                    view.getTxField_dataCricao_visualizarPanel().setText(usuarios.get(select).getData().format(formatter));
                    view.getTxField_dataCricao_visualizarPanel().setEnabled(false);

                    view.getTxField_msgRecebidas_visualizarPanel().setText(String.valueOf(notificacaoBusines.getQtdNovasNotificacoes(usuarios.get(select).getId())));
                    view.getTxField_msgRecebidas_visualizarPanel().setEnabled(false);
                    view.getTxField_msgLida_visualizarPanel().setText(String.valueOf(notificacaoBusines.getQtdNotificacoesLidas(usuarios.get(select).getId())));
                    view.getTxField_msgLida_visualizarPanel().setEnabled(false);

                    control.setCommand(visualizarCommand);
                    control.pressionarBotao();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, "Nao foi possivel visualizar o usuario pois: " + ex.getMessage());
                }
            }
        });

        view.getBtn_autorizar_buscarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                control.setCommand(autorizarCommand);
                control.pressionarBotao();
                carregarTabelaAutorizarModel(autorizar_model);
                loadUsersAutorizar();
            }
        });

        view.getBtn_fechar_buscarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
            }
        });

        // ######### Pagina de Visualizar
        view.getBtn_editar_visualizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int select = view.getTb_usuarios_buscarPanel().getSelectedRow();
                control.setCommand(editarCommand);
                control.pressionarBotao();

                view.getTxField_nome_editarPanel().setText(usuarios.get(select).getNome());
                view.getTxField_login_editarPanel().setText(usuarios.get(select).getLogin());
                view.getTxField_senhaAntiga_editarPanel().setText(usuarios.get(select).getSenha());
                view.getTxField_senhaNova_editarPanel().setText("");
            }
        });

        view.getBtn_excluir_visualizarPanel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO: chamar o log
                try {
                    if (JOptionPane.showConfirmDialog(view, "Deseja realmente excluir?") == JOptionPane.YES_OPTION) {
                        int select = view.getTb_usuarios_buscarPanel().getSelectedRow();
                        usuarioBusiness.delete(usuarios.get(select).getId()); //passar o id para ca
                        JOptionPane.showMessageDialog(view, "Usuario excluido");
                        control.setCommand(buscarCommand);
                        control.pressionarBotao();
                        loadData();
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
                int select = view.getTb_usuarios_buscarPanel().getSelectedRow();
                try {
                    usuarioBusiness.update(usuarios.get(select).getId(), view.getTxField_nome_editarPanel().getText(), view.getTxField_login_editarPanel().getText(), view.getTxField_senhaNova_editarPanel().getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, e.getMessage());
                }
                control.setCommand(visualizarCommand);
                control.pressionarBotao();
                loadData();
            }
        });

        // ######### Pagina de autorizar
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
                int select = view.getTb_usuarios_autorizarPanel().getSelectedRow();
                try {
                    usuarioBusiness.updateAutorizado(usuariosAutorizar.get(select).getId(), Boolean.TRUE);

                    JOptionPane.showMessageDialog(view, "Usuario foi autorizado com sucesso");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, e.getMessage());
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

    public CrudView getCrudView() {
        return this.view;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setVisible(boolean visible) {
        EventQueue.invokeLater(() -> {
            view.setVisible(visible);
            view.toFront(); // Abrir a tela na frente de outras
        });
    }

    public void loadData() {

        try {
            this.usuarios = usuarioBusiness.getAllUsers(this.user.getId());
        } catch (Exception ex) {
            Logger.getLogger(CrudPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        buscar_model.setNumRows(0);
        try {
            for (Usuario usuario : usuarios) {
                buscar_model.addRow(new Object[]{usuario.getNome(), usuario.getLogin(), notificacaoBusines.getQtdNotificacoesLidas(usuario.getId()), notificacaoBusines.getQtdNovasNotificacoes(usuario.getId())});
            }
        } catch (Exception ex) {
            Logger.getLogger(CrudPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

        view.getTb_usuarios_buscarPanel().setModel(buscar_model);
    }

    public void loadUsersAutorizar() {
        try {
            this.usuariosAutorizar = usuarioBusiness.getAllUsersNaoAutorizados();
        } catch (Exception ex) {
            Logger.getLogger(CrudPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarTabelaAutorizarModel(DefaultTableModel autorizar_model) {

        autorizar_model.setNumRows(0);
        loadUsersAutorizar();
        try {
            for (Usuario usuario : usuariosAutorizar) {
                autorizar_model.addRow(new Object[]{usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getSenha()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Nao foi possivel carregar os dados da tabela");
        }

        view.getTb_usuarios_autorizarPanel().setModel(autorizar_model);
    }
}
