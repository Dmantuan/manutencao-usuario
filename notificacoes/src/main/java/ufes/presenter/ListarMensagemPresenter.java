package ufes.presenter;

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

    public ListarMensagemPresenter() {
        this.view = new ListarMensagemView();
        this.dbMensagens = new NotificacoesBusiness();

        this.mensagens = new ArrayList<>();

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

        // requisição
        try {
            loadData();
        } catch (Exception ex) {
            Logger.getLogger(ListarMensagemPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ListarMensagemView getView() {
        return this.view;
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

        // Defina o tamanho da primeira coluna
        this.view.getTable().getColumnModel().getColumn(0).setPreferredWidth(10);
        
    }
}
