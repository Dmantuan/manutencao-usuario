package ufes.presenter;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import ufes.view.ListarMensagemView;
import ufes.models.Notificacao;
import ufes.business.business.NotificacoesBusiness;

public class ListarMensagemPresenter {

    private DefaultTableModel tbMensagens;
    private ListarMensagemView view;
    private ArrayList<Notificacao> mensagens;
    private NotificacoesBusiness dbMensagens;
    private static ListarMensagemPresenter instancia = null;

    private ListarMensagemPresenter() {
        this.view = new ListarMensagemView();
        this.dbMensagens = new NotificacoesBusiness();

        this.mensagens = new ArrayList<>();

        // tabelas
        this.tbMensagens = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Enviado por", "Titulo", "Mensagem"}
        );
        this.tbMensagens.setNumRows(0);
        this.view.getTable().setModel(tbMensagens);
        this.view.getTable().setEnabled(true);

        // requisição
        try {
            loadData();
        } catch (Exception ex) {
            Logger.getLogger(ListarMensagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ListarMensagemPresenter getIntance(){
        
        if(instancia == null){
            instancia = new ListarMensagemPresenter();
        }
        return instancia;
    }

    public ListarMensagemView getView() {
        return this.view;
    }
    
    public void setVisible(boolean visible){
        EventQueue.invokeLater(() -> {
            view.setVisible(visible);
            view.toFront(); // Abrir a tela na frente de outras
        });
    }

    private void loadData() throws Exception {

        this.mensagens = (ArrayList<Notificacao>) dbMensagens.getAll();
        atualizar();
    }

    private void atualizar() {

        if (this.mensagens != null) {
            for (Notificacao mensagem : this.mensagens) {
                this.tbMensagens.addRow(new Object[]{
                    String.valueOf(mensagem.getId_remetente()),
                    String.valueOf(mensagem.getTx_titulo()),
                    String.valueOf(mensagem.getTx_conteudo())
                });
                System.out.println(mensagem);
            }
        }

        this.view.getTable().setModel(this.tbMensagens); 
    }
}
