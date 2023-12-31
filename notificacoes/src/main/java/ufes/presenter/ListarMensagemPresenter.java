package ufes.presenter;

import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import ufes.view.ListarMensagemView;
import ufes.models.Notificacao;
import ufes.business.business.NotificacoesBusiness;
import ufes.service.ButtonEditor;
import ufes.service.ButtonRenderer;

public class ListarMensagemPresenter {

    private DefaultTableModel tbMensagens;
    private final ListarMensagemView view;
    private ArrayList<Notificacao> mensagens;
    private final NotificacoesBusiness dbMensagens;
    private Integer idUsuario;
    
    public ListarMensagemPresenter() {
        this.view = new ListarMensagemView();
        this.dbMensagens = new NotificacoesBusiness();

        this.mensagens = new ArrayList<>();

    }

    public ListarMensagemView getView() {
        return this.view;
    }

    public void setVisible(boolean visible) {
        EventQueue.invokeLater(() -> {
            view.setVisible(visible);
            view.toFront(); // Abrir a tela na frente de outras
        });
    }
    
    public final void loadData() throws Exception {

        this.tbMensagens = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Enviado por", "Titulo", "Mensagem", "Status" , "Lida"}
        );
        this.tbMensagens.setNumRows(0);
        this.view.getTable().setModel(tbMensagens);
        this.view.getTable().setEnabled(true);
        
        this.mensagens = new ArrayList<>();
        this.mensagens = (ArrayList<Notificacao>) dbMensagens.getAllByUserId(this.idUsuario);
        atualizarTabela();
        
        // Montar tabelas
        this.view.getTable().getColumnModel().getColumn(4).setMaxWidth(300);
        this.view.getTable().getColumnModel().getColumn(4).setMinWidth(120);
        this.view.getTable().getColumnModel().getColumn(0).setMaxWidth(100);
        this.view.getTable().getColumnModel().getColumn(3).setMaxWidth(200);
        
        TableColumn column0 = this.view.getTable().getColumnModel().getColumn(0);
        TableColumn column3 = this.view.getTable().getColumnModel().getColumn(3);

        // Cria um DefaultTableCellRenderer com alinhamento central
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderer para a coluna
        column0.setCellRenderer(renderer);
        column3.setCellRenderer(renderer);

        TableColumn lidaColumn = this.view.getTable().getColumnModel().getColumn(4);
        lidaColumn.setCellRenderer(new ButtonRenderer());
        lidaColumn.setCellEditor(new ButtonEditor(this.dbMensagens, this.mensagens, this.view.getTable(), this));      
    }
    
    public void setIduser(Integer id){
        this.idUsuario = id;
    }

    private void atualizarTabela() {
        
        this.tbMensagens.setNumRows(0);

        if (this.mensagens != null) {
            for (Notificacao mensagem : this.mensagens) {
                String statusLida = mensagem.getBool_vizualizado() != null && mensagem.getBool_vizualizado() ? "Antiga" : "Nova";
                String textButton = mensagem.getBool_vizualizado() != null && mensagem.getBool_vizualizado() ? "Não Lida" : "Lida";
                this.tbMensagens.addRow(new Object[]{
                    String.valueOf(mensagem.getTx_nomeRemetente()),
                    String.valueOf(mensagem.getTx_titulo()),
                    String.valueOf(mensagem.getTx_conteudo()),
                    statusLida,
                    textButton
                });
            }
        }

        this.view.getTable().setModel(this.tbMensagens);
    }
}
