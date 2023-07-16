package ufes.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import ufes.business.business.UsuarioBusiness;
import ufes.models.DestinatarioModel;
import ufes.models.Notificacao;
import ufes.models.Usuario;
import ufes.view.EnviarMensagemView;

public class EnviarMensagemPresenter {

    private EnviarMensagemView view;
    private ArrayList<Usuario> usuarios;
    private UsuarioBusiness dbUsuarios;

    public EnviarMensagemPresenter() {
        this.view = new EnviarMensagemView();
        this.view.setClosable(true);

        // Criação dos objetos de exemplo
        List<DestinatarioModel> destinatarios = new ArrayList<>();
        destinatarios.add(new DestinatarioModel(1, "Matheus kanck da silva"));
        destinatarios.add(new DestinatarioModel(2, "Maria Silva Amanaque"));
        destinatarios.add(new DestinatarioModel(3, "Daniel Mantuan"));
        
        // setando modelo da lista de destinatarios
        DefaultListModel<DestinatarioModel> listModelDestinatarios = new DefaultListModel<>();
        for (DestinatarioModel item : destinatarios) {
            listModelDestinatarios.addElement(item);
        }
        this.view.getDestinatarios().setModel(listModelDestinatarios);
        
        // setando modelo da lista de destinatarios selecionados
        DefaultListModel<DestinatarioModel> listModelDestinatariosSelecionados = new DefaultListModel<>();
        this.view.getDestinatariosSelect().setModel(listModelDestinatariosSelecionados);

        this.view.setVisible(true);

        this.view.getAdicionarDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                adicionarDestinatario();
            }
        });
        
        this.view.getRemoverDestinatarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removerDestinatario();
            }
        });
        
        this.view.getEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                enviarMensagem();
            }
        });   
    }

    public EnviarMensagemView getView() {
        return this.view;
    }

    public void loadData() throws Exception {

        this.usuarios = (ArrayList<Usuario>) dbUsuarios.getAllUsers();
        atualizar();
    }

    private void atualizar() {

    }
    
    private void adicionarDestinatario() {
        
        DestinatarioModel selectedItem = this.view.getDestinatarios().getSelectedValue();
        
        if (null != selectedItem) {
            DefaultListModel<DestinatarioModel> listModelDestinatariosSelecionados
                    = (DefaultListModel<DestinatarioModel>) this.view.getDestinatariosSelect().getModel();
            listModelDestinatariosSelecionados.addElement(selectedItem);
        }
    }
    
    private void removerDestinatario() {
        
        DestinatarioModel selectedItem = this.view.getDestinatariosSelect().getSelectedValue();
        if(selectedItem == null){
            DefaultListModel<DestinatarioModel> listModelDestinatariosSelecionados
                    = (DefaultListModel<DestinatarioModel>) this.view.getDestinatariosSelect().getModel();
            listModelDestinatariosSelecionados.removeElement(selectedItem);
        }        
        else {
            
        }
    }

    private void enviarMensagem() {

        DefaultListModel<DestinatarioModel> listModelDestinatariosSelecionados = (DefaultListModel<DestinatarioModel>) this.view.getDestinatariosSelect().getModel();
        List<DestinatarioModel> destinatariosSelecionados = new ArrayList<>();
        for (int i = 0; i < listModelDestinatariosSelecionados.size(); i++) {
            destinatariosSelecionados.add(listModelDestinatariosSelecionados.get(i));
        }

        // Criar a mensagem e enviar
        Integer id_remetente = 1; // ver dps pra puxar o usuario logado
        String tx_titulo = this.view.getMensagem().getText();
        String tx_conteudo = this.view.getTitulo().getText();
        

        // atribundo as notificações para cada id de destinatario
        ArrayList<Notificacao> notificacoes = new ArrayList<>();
        for (DestinatarioModel ds : destinatariosSelecionados) { // talvez fazer essa logica em notificações
            
//            notificacoes.add(new Notificacao(id_remetente, ds.getId(), tx_conteudo ,tx_titulo));
//            System.out.println(notificacoes.toString());

            System.out.println(id_remetente);
            System.out.println(tx_titulo);
            System.out.println(tx_conteudo);
            System.out.println(ds.getNome());
            System.out.println(ds.getId());
            
            
        }
        
        
    }
}
