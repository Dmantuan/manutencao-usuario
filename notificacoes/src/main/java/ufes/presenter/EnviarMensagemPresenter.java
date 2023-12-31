package ufes.presenter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import ufes.business.business.NotificacoesBusiness;
import ufes.business.business.UsuarioBusiness;
import ufes.models.Notificacao;
import ufes.models.Usuario;
import ufes.view.EnviarMensagemView;

public class EnviarMensagemPresenter {

    private EnviarMensagemView view;

    private ArrayList<Usuario> usuarios;
    private UsuarioBusiness dbUsuarios;
    private NotificacoesBusiness dbNotificacoes;
    private Usuario user;

    DefaultListModel<Usuario> listModelDestinatarios;
    DefaultListModel<Usuario> listModelDestinatariosSelecionados;

    public EnviarMensagemPresenter() {
        this.view = new EnviarMensagemView();
        this.dbUsuarios = new UsuarioBusiness();
        this.dbNotificacoes = new NotificacoesBusiness();

        this.view.getAdicionarDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarDestinatario();
                view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);
                view.getDestinatarios().setModel(listModelDestinatarios);
            }
        });

        this.view.getRemoverDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removerDestinatarios();
                view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);
                view.getDestinatarios().setModel(listModelDestinatarios);
            }
        });

        this.view.getEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    enviarMensagem();
                    // AtualizarTelasService.getInstancia().atualizarTodasTelas();
                    JOptionPane.showMessageDialog(view, "Messangens enviadas com sucesso");
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
        });
        
        this.view.getCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(EnviarMensagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getBuscarDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                DefaultListModel<Usuario> lsModel;
                String user = view.getTextoBuscaDestinatarios().getText();
                lsModel = buscaPorDestinatarios(listModelDestinatarios, user);
                view.getDestinatarios().setModel(lsModel);
            }
        });

        this.view.getBuscarDestinatariosSelect().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                DefaultListModel<Usuario> lsModel;
                String user = view.getTextoBuscaDestinatariosSelect().getText();
                lsModel = buscaPorDestinatarios(listModelDestinatariosSelecionados, user);
                view.getDestinatariosSelect().setModel(lsModel);
            }
        });
    }

    public EnviarMensagemView getView() {
        return this.view;
    }
    
    public void setUser(Usuario user){
        this.user = user;
    }

    public void setVisible(boolean visible) {

        EventQueue.invokeLater(() -> {
            view.setVisible(visible);
            view.toFront(); // Abrir a tela na frente de outras
        });
    }

    public void loadData() {

        this.usuarios = new ArrayList<>();
        this.listModelDestinatarios = new DefaultListModel<>();
        this.listModelDestinatariosSelecionados = new DefaultListModel<>();
        
        try {
            this.usuarios = (ArrayList<Usuario>) dbUsuarios.getAllUsers(this.user.getId());
        } catch (Exception ex) {
            Logger.getLogger(EnviarMensagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // setando modelo da lista de destinatarios
        for (Usuario item : usuarios) {
            listModelDestinatarios.addElement(item);
        }

        this.view.getDestinatarios().setModel(listModelDestinatarios);
        this.view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);
        this.view.setVisible(true);
    }

    private DefaultListModel<Usuario> buscaPorDestinatarios(DefaultListModel<Usuario> listModelData, String user) {

        if (user == null) {
            // caso for nulo os dados totais serão retornados
            return listModelData;
        }

        DefaultListModel<Usuario> listModel = new DefaultListModel<>();
        int size = listModelData.getSize();

        for (int i = 0; i < size; i++) {
            Usuario usuario = listModelData.getElementAt(i);
            if (usuario.getNome().toLowerCase().contains(user.toLowerCase())) {
                listModel.addElement(usuario);
            }
        }

        return listModel;
    }

    private void adicionarDestinatario() {

        Usuario selectedItem = this.view.getDestinatarios().getSelectedValue();
        if (null != selectedItem) {
            listModelDestinatariosSelecionados.addElement(selectedItem);
            listModelDestinatarios.removeElement(selectedItem);
        }
    }

    private void removerDestinatarios() {

        Usuario selectedItem = this.view.getDestinatariosSelect().getSelectedValue();
        if (null != selectedItem) {
            listModelDestinatariosSelecionados.removeElement(selectedItem);
            listModelDestinatarios.addElement(selectedItem);
        }
    }

    private void enviarMensagem() throws Exception {

        List<Usuario> destinatariosSelecionados = new ArrayList<>();
        
        for (int i = 0; i < listModelDestinatariosSelecionados.size(); i++) {
            destinatariosSelecionados.add(listModelDestinatariosSelecionados.get(i));
        }

        // Criar a mensagem e enviar
        Integer id_remetente = this.user.getId();
        String tx_titulo = this.view.getTitulo().getText();
        String tx_conteudo = this.view.getMensagem().getText();

        // atribundo as notificações para cada id de destinatario
        for (Usuario ds : destinatariosSelecionados) {
            Notificacao notificacao = new Notificacao(id_remetente, ds.getId(), tx_conteudo, tx_titulo, false);
            this.dbNotificacoes.insert(notificacao);
        }
        
        loadData();
        this.view.getTitulo().setText("");
        this.view.getMensagem().setText("");
    }
}
