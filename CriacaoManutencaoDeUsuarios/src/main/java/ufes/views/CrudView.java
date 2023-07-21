/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ufes.views;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author daniel
 */
public class CrudView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrudView1
     */
    public CrudView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crudPanel = new javax.swing.JPanel();
        buscar = new javax.swing.JPanel();
        usuario_label = new javax.swing.JLabel();
        usuarios_scrollPane = new javax.swing.JScrollPane();
        tb_usuarios_buscarPanel = new javax.swing.JTable();
        btn_autorizar_buscarPanel = new javax.swing.JButton();
        btn_visuzalizar_buscarPanel = new javax.swing.JButton();
        btn_fechar_buscarPanel = new javax.swing.JButton();
        editar = new javax.swing.JPanel();
        btn_cancelar_editarPanel = new javax.swing.JButton();
        btn_salvar_editarPanel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txField_nome_editarPanel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txField_login_editarPanel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txField_senhaNova_editarPanel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txField_senhaAntiga_editarPanel = new javax.swing.JTextField();
        autorizar = new javax.swing.JPanel();
        usuarios_scrollPane1 = new javax.swing.JScrollPane();
        tb_usuarios_autorizarPanel = new javax.swing.JTable();
        label_usuario_autorizarPanel = new javax.swing.JLabel();
        btn_cancelar_autorizarPanel = new javax.swing.JButton();
        btn_autorizar_autorizarPanel = new javax.swing.JButton();
        visualizar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txField_nome_visualizarPanel = new javax.swing.JTextField();
        txField_dataCricao_visualizarPanel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txField_msgRecebidas_visualizarPanel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txField_msgLida_visualizarPanel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btn_editar_visualizarPanel = new javax.swing.JButton();
        btn_fechar_visualizarPanel = new javax.swing.JButton();
        btn_excluir_visualizarPanel = new javax.swing.JButton();
        editarUser = new javax.swing.JPanel();
        btn_cancelar_editarPanel1 = new javax.swing.JButton();
        btn_salvar_editarPanel1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txField_nome_editarPanel1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txField_login_editarPanel1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txField_senhaNova_editarPanel1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txField_senhaAntiga_editarPanel1 = new javax.swing.JTextField();

        crudPanel.setLayout(new java.awt.CardLayout());

        usuario_label.setText("Usuarios: ");

        tb_usuarios_buscarPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        usuarios_scrollPane.setViewportView(tb_usuarios_buscarPanel);

        btn_autorizar_buscarPanel.setText("Autorizar");
        btn_autorizar_buscarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_autorizar_buscarPanelActionPerformed(evt);
            }
        });

        btn_visuzalizar_buscarPanel.setText("Visualizar");

        btn_fechar_buscarPanel.setText("Fechar");

        javax.swing.GroupLayout buscarLayout = new javax.swing.GroupLayout(buscar);
        buscar.setLayout(buscarLayout);
        buscarLayout.setHorizontalGroup(
            buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuarios_scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario_label)
                    .addGroup(buscarLayout.createSequentialGroup()
                        .addComponent(btn_autorizar_buscarPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_visuzalizar_buscarPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_fechar_buscarPanel)))
                .addGap(12, 12, 12))
        );
        buscarLayout.setVerticalGroup(
            buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(usuario_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarios_scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_autorizar_buscarPanel)
                    .addComponent(btn_visuzalizar_buscarPanel)
                    .addComponent(btn_fechar_buscarPanel))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        crudPanel.add(buscar, "buscar");

        btn_cancelar_editarPanel.setText("Cancelar");

        btn_salvar_editarPanel.setText("Salvar");

        jLabel2.setText("Nome:");

        jLabel3.setText("Login:");

        jLabel4.setText("Senha nova:");

        jLabel5.setText("Senha antiga:");

        javax.swing.GroupLayout editarLayout = new javax.swing.GroupLayout(editar);
        editar.setLayout(editarLayout);
        editarLayout.setHorizontalGroup(
            editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarLayout.createSequentialGroup()
                .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txField_nome_editarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txField_login_editarPanel)
                            .addComponent(txField_senhaAntiga_editarPanel)
                            .addComponent(txField_senhaNova_editarPanel)))
                    .addGroup(editarLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btn_salvar_editarPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_editarPanel)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        editarLayout.setVerticalGroup(
            editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txField_nome_editarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txField_login_editarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txField_senhaAntiga_editarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txField_senhaNova_editarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(97, 97, 97)
                .addGroup(editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_editarPanel)
                    .addComponent(btn_salvar_editarPanel))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        crudPanel.add(editar, "editar");

        tb_usuarios_autorizarPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        usuarios_scrollPane1.setViewportView(tb_usuarios_autorizarPanel);

        label_usuario_autorizarPanel.setText("Usuarios: ");

        btn_cancelar_autorizarPanel.setText("Cancelar");

        btn_autorizar_autorizarPanel.setText("Autorizar");

        javax.swing.GroupLayout autorizarLayout = new javax.swing.GroupLayout(autorizar);
        autorizar.setLayout(autorizarLayout);
        autorizarLayout.setHorizontalGroup(
            autorizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, autorizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_autorizar_autorizarPanel)
                .addGap(54, 54, 54)
                .addComponent(btn_cancelar_autorizarPanel)
                .addGap(211, 211, 211))
            .addGroup(autorizarLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(autorizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(autorizarLayout.createSequentialGroup()
                        .addComponent(label_usuario_autorizarPanel)
                        .addContainerGap(553, Short.MAX_VALUE))
                    .addGroup(autorizarLayout.createSequentialGroup()
                        .addComponent(usuarios_scrollPane1)
                        .addGap(12, 12, 12))))
        );
        autorizarLayout.setVerticalGroup(
            autorizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, autorizarLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(label_usuario_autorizarPanel)
                .addGap(18, 18, 18)
                .addComponent(usuarios_scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(autorizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_autorizarPanel)
                    .addComponent(btn_autorizar_autorizarPanel))
                .addGap(38, 38, 38))
        );

        crudPanel.add(autorizar, "autorizar");

        jLabel6.setText("Nome:");

        jLabel7.setText("Data Criacao:");

        jLabel8.setText("Quantidade de mensagens recebidas:");

        txField_msgLida_visualizarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txField_msgLida_visualizarPanelActionPerformed(evt);
            }
        });

        jLabel9.setText("Quantidade de mensagens lidas:");

        btn_editar_visualizarPanel.setText("Editar");

        btn_fechar_visualizarPanel.setText("Fechar");

        btn_excluir_visualizarPanel.setText("Excluir");

        javax.swing.GroupLayout visualizarLayout = new javax.swing.GroupLayout(visualizar);
        visualizar.setLayout(visualizarLayout);
        visualizarLayout.setHorizontalGroup(
            visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizarLayout.createSequentialGroup()
                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(visualizarLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(visualizarLayout.createSequentialGroup()
                                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(176, 176, 176)
                                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txField_nome_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txField_dataCricao_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(visualizarLayout.createSequentialGroup()
                                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txField_msgLida_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txField_msgRecebidas_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(visualizarLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(btn_excluir_visualizarPanel)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editar_visualizarPanel)
                        .addGap(18, 18, 18)
                        .addComponent(btn_fechar_visualizarPanel)))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        visualizarLayout.setVerticalGroup(
            visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualizarLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txField_nome_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txField_dataCricao_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txField_msgRecebidas_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txField_msgLida_visualizarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(visualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fechar_visualizarPanel)
                    .addComponent(btn_editar_visualizarPanel)
                    .addComponent(btn_excluir_visualizarPanel))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        crudPanel.add(visualizar, "visualizar");

        btn_cancelar_editarPanel1.setText("Cancelar");

        btn_salvar_editarPanel1.setText("Salvar");

        jLabel10.setText("Nome:");

        jLabel11.setText("Login:");

        jLabel12.setText("Senha nova:");

        jLabel13.setText("Senha antiga:");

        javax.swing.GroupLayout editarUserLayout = new javax.swing.GroupLayout(editarUser);
        editarUser.setLayout(editarUserLayout);
        editarUserLayout.setHorizontalGroup(
            editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editarUserLayout.createSequentialGroup()
                .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editarUserLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txField_nome_editarPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txField_login_editarPanel1)
                            .addComponent(txField_senhaAntiga_editarPanel1)
                            .addComponent(txField_senhaNova_editarPanel1)))
                    .addGroup(editarUserLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btn_salvar_editarPanel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelar_editarPanel1)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        editarUserLayout.setVerticalGroup(
            editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editarUserLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txField_nome_editarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txField_login_editarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txField_senhaAntiga_editarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txField_senhaNova_editarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(97, 97, 97)
                .addGroup(editarUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar_editarPanel1)
                    .addComponent(btn_salvar_editarPanel1))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        crudPanel.add(editarUser, "editarUser");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_autorizar_buscarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_autorizar_buscarPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_autorizar_buscarPanelActionPerformed

    private void txField_msgLida_visualizarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txField_msgLida_visualizarPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txField_msgLida_visualizarPanelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel autorizar;
    private javax.swing.JButton btn_autorizar_autorizarPanel;
    private javax.swing.JButton btn_autorizar_buscarPanel;
    private javax.swing.JButton btn_cancelar_autorizarPanel;
    private javax.swing.JButton btn_cancelar_editarPanel;
    private javax.swing.JButton btn_cancelar_editarPanel1;
    private javax.swing.JButton btn_editar_visualizarPanel;
    private javax.swing.JButton btn_excluir_visualizarPanel;
    private javax.swing.JButton btn_fechar_buscarPanel;
    private javax.swing.JButton btn_fechar_visualizarPanel;
    private javax.swing.JButton btn_salvar_editarPanel;
    private javax.swing.JButton btn_salvar_editarPanel1;
    private javax.swing.JButton btn_visuzalizar_buscarPanel;
    private javax.swing.JPanel buscar;
    private javax.swing.JPanel crudPanel;
    private javax.swing.JPanel editar;
    private javax.swing.JPanel editarUser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel label_usuario_autorizarPanel;
    private javax.swing.JTable tb_usuarios_autorizarPanel;
    private javax.swing.JTable tb_usuarios_buscarPanel;
    private javax.swing.JTextField txField_dataCricao_visualizarPanel;
    private javax.swing.JTextField txField_login_editarPanel;
    private javax.swing.JTextField txField_login_editarPanel1;
    private javax.swing.JTextField txField_msgLida_visualizarPanel;
    private javax.swing.JTextField txField_msgRecebidas_visualizarPanel;
    private javax.swing.JTextField txField_nome_editarPanel;
    private javax.swing.JTextField txField_nome_editarPanel1;
    private javax.swing.JTextField txField_nome_visualizarPanel;
    private javax.swing.JTextField txField_senhaAntiga_editarPanel;
    private javax.swing.JTextField txField_senhaAntiga_editarPanel1;
    private javax.swing.JTextField txField_senhaNova_editarPanel;
    private javax.swing.JTextField txField_senhaNova_editarPanel1;
    private javax.swing.JLabel usuario_label;
    private javax.swing.JScrollPane usuarios_scrollPane;
    private javax.swing.JScrollPane usuarios_scrollPane1;
    private javax.swing.JPanel visualizar;
    // End of variables declaration//GEN-END:variables

    public JPanel getAutorizar() {
        return autorizar;
    }

    public JButton getBtn_autorizar_autorizarPanel() {
        return btn_autorizar_autorizarPanel;
    }

    public JButton getBtn_autorizar_buscarPanel() {
        return btn_autorizar_buscarPanel;
    }

    public JButton getBtn_cancelar_autorizarPanel() {
        return btn_cancelar_autorizarPanel;
    }

    public JButton getBtn_cancelar_editarPanel() {
        return btn_cancelar_editarPanel;
    }

    public JButton getBtn_editar_visualizarPanel() {
        return btn_editar_visualizarPanel;
    }

    public JButton getBtn_excluir_visualizarPanel() {
        return btn_excluir_visualizarPanel;
    }

    public JButton getBtn_fechar_buscarPanel() {
        return btn_fechar_buscarPanel;
    }

    public JButton getBtn_fechar_visualizarPanel() {
        return btn_fechar_visualizarPanel;
    }

    public JButton getBtn_salvar_editarPanel() {
        return btn_salvar_editarPanel;
    }

    public JButton getBtn_visuzalizar_buscarPanel() {
        return btn_visuzalizar_buscarPanel;
    }

    public JPanel getBuscar() {
        return buscar;
    }

    public JPanel getCrudPanel() {
        return crudPanel;
    }

    public JPanel getEditar() {
        return editar;
    }

    public JTable getTb_usuarios_autorizarPanel() {
        return tb_usuarios_autorizarPanel;
    }

    public JTable getTb_usuarios_buscarPanel() {
        return tb_usuarios_buscarPanel;
    }

    public JTextField getTxField_dataCricao_visualizarPanel() {
        return txField_dataCricao_visualizarPanel;
    }

    public JTextField getTxField_login_editarPanel() {
        return txField_login_editarPanel;
    }

    public JTextField getTxField_msgLida_visualizarPanel() {
        return txField_msgLida_visualizarPanel;
    }

    public JTextField getTxField_msgRecebidas_visualizarPanel() {
        return txField_msgRecebidas_visualizarPanel;
    }

    public JTextField getTxField_nome_editarPanel() {
        return txField_nome_editarPanel;
    }

    public JTextField getTxField_nome_visualizarPanel() {
        return txField_nome_visualizarPanel;
    }

    public JTextField getTxField_senhaAntiga_editarPanel() {
        return txField_senhaAntiga_editarPanel;
    }

    public JTextField getTxField_senhaNova_editarPanel() {
        return txField_senhaNova_editarPanel;
    }

    public JPanel getVisualizar() {
        return visualizar;
    }

    public JButton getBtn_cancelar_editarPanel1() {
        return btn_cancelar_editarPanel1;
    }

    public JButton getBtn_salvar_editarPanel1() {
        return btn_salvar_editarPanel1;
    }

    public JTextField getTxField_login_editarPanel1() {
        return txField_login_editarPanel1;
    }

    public JTextField getTxField_nome_editarPanel1() {
        return txField_nome_editarPanel1;
    }

    public JTextField getTxField_senhaAntiga_editarPanel1() {
        return txField_senhaAntiga_editarPanel1;
    }

    public JTextField getTxField_senhaNova_editarPanel1() {
        return txField_senhaNova_editarPanel1;
    }

}
