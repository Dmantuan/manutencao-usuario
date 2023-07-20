package ufes.presenters;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private UsuarioDAO usuarioDAO;
    private CardLayout cardLayout;

    public CrudPresenter() {
        this.usuarioDAO = new UsuarioDAO();

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
        buscar_model.addRow(new Object[]{"meu", "cu", "ta", "Doendo"});
        try {
            for (Usuario usuario : usuarioDAO.getAll()) {
                buscar_model.addRow(new Object[]{usuario.getNome(), usuario.getLogin(), usuario.getSenha(), usuario.getSenha()});
            }
        } catch (Exception e) {
            e.printStackTrace();
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
                //TODO: algoritmo de exclusao
                control.setCommand(buscarCommand);
                control.pressionarBotao();
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
        autorizar_model.addRow(new Object[]{"meu", "cu", "ta", "Doendo"});
        try {
            for (Usuario usuario : usuarioDAO.getAll()) {
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
                //TODO: Algoritmo de atualizacao
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
}
