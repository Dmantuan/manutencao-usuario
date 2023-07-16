package ufes.presenter;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ufes.view.ListarMensagensView;
import ufes.models.Notificacao;
import ufes.business.business.NotificacoesBusiness;

public class ListarMensagensPresenter {

    private DefaultTableModel tbMensagens;
    private ListarMensagensView view;
    private ArrayList<Notificacao> mensagens;
    private NotificacoesBusiness dbMensagens;

    public ListarMensagensPresenter() {
        this.view = new ListarMensagensView();
        this.dbMensagens = new NotificacoesBusiness();
        
        try{
            System.out.println(dbMensagens.getAll());
        }
        catch(Exception e){
            e.printStackTrace();
        }

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

    

    public ListarMensagensView getView() {
        return this.view;
    }

    public void loadData() throws Exception {
       
        this.mensagens = (ArrayList<Notificacao>) dbMensagens.getAllByUserSendId(1); 
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
