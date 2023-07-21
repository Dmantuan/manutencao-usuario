package ufes.service;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import ufes.business.business.NotificacoesBusiness;
import ufes.models.Notificacao;
import ufes.presenter.ListarMensagemPresenter;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton button;
    private int clickedRow; // Variável para armazenar o índice da linha clicada
    private JTable table; // Reference to the JTable

    public ButtonEditor(NotificacoesBusiness dbMensagens, ArrayList<Notificacao> mensagens, JTable table, ListarMensagemPresenter presenter) {

        this.table = table;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém o índice da linha clicada
                clickedRow = table.convertRowIndexToModel(table.getEditingRow());

                // Acessa os dados da linha clicada
                Integer idNotificacao = mensagens.get(clickedRow).getId();
                if(mensagens.get(clickedRow).getBool_vizualizado() == true){
                    try {  
                        dbMensagens.alterarStatusMensagem(idNotificacao, false);
                        presenter.loadData();
                    } catch (Exception ex) {
                        Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {  
                        dbMensagens.alterarStatusMensagem(idNotificacao, true);
                        presenter.loadData();
                    } catch (Exception ex) {
                        Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                fireEditingStopped(); // Indica que a edição da célula deve ser encerrada
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setText("Lida");
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }

    @Override
    public void cancelCellEditing() {
        super.cancelCellEditing();
    }
}
