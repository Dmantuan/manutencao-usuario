package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
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

    public EnviarMensagemPresenter() {
        this.view = new EnviarMensagemView();
        this.dbUsuarios = new UsuarioBusiness();
        this.dbNotificacoes = new NotificacoesBusiness();
        this.view.setClosable(true);

        // Criação dos objetos de exemplo
        try {
            loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // setando modelo da lista de destinatarios
        DefaultListModel<Usuario> listModelDestinatarios = new DefaultListModel<>();
        for (Usuario item : usuarios) {
            listModelDestinatarios.addElement(item);
        }
        this.view.getDestinatarios().setModel(listModelDestinatarios);

        // setando modelo da lista de destinatarios selecionados
        DefaultListModel<Usuario> listModelDestinatariosSelecionados = new DefaultListModel<>();
        this.view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);

        this.view.setVisible(true);

        this.view.getAdicionarDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarDestinatario(listModelDestinatarios, listModelDestinatariosSelecionados);
                view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);
                view.getDestinatarios().setModel(listModelDestinatarios);
            }
        });

        this.view.getRemoverDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removerDestinatarios(listModelDestinatarios, listModelDestinatariosSelecionados);
                view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);
                view.getDestinatarios().setModel(listModelDestinatarios);
            }
        });

        this.view.getEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    enviarMensagem();
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
                System.out.println(lsModel);
                view.getDestinatarios().setModel(lsModel);
            }
        });

        this.view.getBuscarDestinatariosSelect().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                DefaultListModel<Usuario> lsModel;
                String user = view.getTextoBuscaDestinatariosSelect().getText();
                lsModel = buscaPorDestinatarios(listModelDestinatariosSelecionados, user );
                System.out.println(lsModel);
                view.getDestinatariosSelect().setModel(lsModel);
            }
        });
    }

    public EnviarMensagemView getView() {
        return this.view;
    }

    private void loadData() throws Exception {

        this.usuarios = new ArrayList<>();
        this.usuarios = (ArrayList<Usuario>) dbUsuarios.getAllUsers();
    }
    
    private DefaultListModel<Usuario> buscaPorDestinatarios(DefaultListModel<Usuario> listModelData, String user) {

        if(user == null){
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

    private void adicionarDestinatario(DefaultListModel<Usuario> listModelDestinatarios, DefaultListModel<Usuario> listModelDestinatariosSelecionados) {

        Usuario selectedItem = this.view.getDestinatarios().getSelectedValue();
        if (null != selectedItem) {
            listModelDestinatariosSelecionados.addElement(selectedItem);
            listModelDestinatarios.removeElement(selectedItem);
        }
    }

    private void removerDestinatarios(DefaultListModel<Usuario> listModelDestinatarios,DefaultListModel<Usuario> listModelDestinatariosSelecionados) {

        Usuario selectedItem = this.view.getDestinatariosSelect().getSelectedValue();
        if (null != selectedItem) {
            listModelDestinatariosSelecionados.removeElement(selectedItem);
            listModelDestinatarios.addElement(selectedItem);
        }
    }

    private void enviarMensagem() throws Exception {

        DefaultListModel<Usuario> listModelDestinatariosSelecionados = (DefaultListModel<Usuario>) this.view.getDestinatariosSelect().getModel();
        List<Usuario> destinatariosSelecionados = new ArrayList<>();
        for (int i = 0; i < listModelDestinatariosSelecionados.size(); i++) {
            destinatariosSelecionados.add(listModelDestinatariosSelecionados.get(i));
        }

        // Criar a mensagem e enviar
        Integer id_remetente = 1; // ver dps pra puxar o usuario logado
        String tx_titulo = this.view.getMensagem().getText();
        String tx_conteudo = this.view.getTitulo().getText();

        // atribundo as notificações para cada id de destinatario
        ArrayList<Notificacao> notificacoes = new ArrayList<>();
        for (Usuario ds : destinatariosSelecionados) {

            dbNotificacoes.insert(new Notificacao(id_remetente, ds.getId(), tx_conteudo ,tx_titulo));
            System.out.println(notificacoes.toString());
        }

    }
}
