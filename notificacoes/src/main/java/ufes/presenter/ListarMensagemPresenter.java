package ufes.presenter;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ufes.view.ListarMensagemView;
import ufes.models.Notificacao;
import ufes.business.business.NotificacoesBusiness;

public class ListarMensagemPresenter {

    private DefaultTableModel tbMensagens;
    private ListarMensagemView view;
    private ArrayList<Notificacao> mensagens;
    private NotificacoesBusiness dbMensagens;

    public ListarMensagemPresenter() {
        this.view = new ListarMensagemView();
        this.dbMensagens = new NotificacoesBusiness(); // ver erro aki

        // Habilitar a barra de fechar no JInternalFrame
        this.view.setClosable(true);
        this.view.setVisible(true);

        // tabelas
        this.tbMensagens = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Enviado por", "Titulo", "Mensagem"}
        );
        this.tbMensagens.setNumRows(0);
        this.view.getTable().setModel(tbMensagens);
        this.view.getTable().setEnabled(true);
    }

    

    public ListarMensagemView getView() {
        return this.view;
    }

    public void loadData() throws Exception {
       
        this.mensagens = (ArrayList<Notificacao>) dbMensagens.getAllByUserSendId(2); 
        atualizar();
    }
    
    private void atualizar() {
        
        for (Notificacao mensagem : this.mensagens) {
            this.tbMensagens.addRow(new Object[]{
                String.valueOf(mensagem.getId_remetente()),
                String.valueOf(mensagem.getTx_titulo()),
                String.valueOf(mensagem.getTx_conteudo())
            });
        }

        this.view.getTable().setModel(this.tbMensagens);
    }
}