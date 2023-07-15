package ufes.presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import ufes.business.business.UsuarioBusiness;
import ufes.models.Notificacao;
import ufes.models.Usuario;
import ufes.view.EnviarMensagemView;

public class EnviarMensagemPresenter {

    private EnviarMensagemView view;
    private ArrayList<Usuario> usuarios;
    private UsuarioBusiness dbUsuarios;
    private Notificacao mensagem;

    public EnviarMensagemPresenter() {
        this.view = new EnviarMensagemView();
        // this.dbUsuarios = new UsuarioBusiness(); // ver erro aki

        // Habilitar a barra de fechar no JInternalFrame
        this.view.setClosable(true);
//        this.view.setVisible(true);

        // configurando o JcomboBox
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 20"};
        JList<String> checkBoxList = new JList<>(items);
        checkBoxList.setCellRenderer(new CheckBoxListRenderer());
        checkBoxList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        this.view.getEnviar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                enviarMensagem();

                Object[] selectedItems = checkBoxList.getSelectedValues();
                for (Object item : selectedItems) {
                    System.out.println(item);
                }
            }
        });
        
       // Adicionar o JList ao JScrollPane e ao JInternalFrame
        JScrollPane scrollPane = new JScrollPane(checkBoxList);
        this.view.getContentPane().add(scrollPane, BorderLayout.CENTER);

        this.view.pack();
        this.view.setVisible(true);
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

    private void enviarMensagem() {

//        Integer id_remetente = Integer.valueOf(this.view.getTitulo().getText());
//        ArrayList<Integer> id_destinatario = Integer.valueOf(this.view.getDestinatarios().getItemAt)
//        String tx_titulo;
//        Boolean bool_vizualizada;
//        String tx_conteudo;
//        
//        this.mensagem = new Notificacao();
    }
}

class CheckBoxListRenderer extends JCheckBox implements ListCellRenderer<Object> {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        setComponentOrientation(list.getComponentOrientation());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setSelected(isSelected);
        setText(value.toString());
        return this;
    }
}
