/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ufes.views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author daniel
 */
public class LoginView extends javax.swing.JInternalFrame {

    /**
     * Creates new form LoginView
     */
    public LoginView() {
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

        loginPanel = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txField_login_loginPanel = new javax.swing.JTextField();
        txField_senha_loginPanel = new javax.swing.JTextField();
        btn_casdastro_loginPanel = new javax.swing.JButton();
        btn_login_loginPanel = new javax.swing.JButton();
        cadastro = new javax.swing.JPanel();
        btn_cadastrar_cadastroPanel = new javax.swing.JButton();
        btn_logar_cadastroPanel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txField_nome_cadastroPanel = new javax.swing.JTextField();
        txField_login_cadastroPanel = new javax.swing.JTextField();
        txField_senha_cadastroPanel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        loginPanel.setLayout(new java.awt.CardLayout());

        jLabel6.setText("Login:");

        jLabel7.setText("Senha:");

        btn_casdastro_loginPanel.setText("Nao é cadastrado?");

        btn_login_loginPanel.setText("Login");
        btn_login_loginPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_login_loginPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(43, 43, 43)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txField_senha_loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txField_login_loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btn_casdastro_loginPanel))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btn_login_loginPanel)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txField_login_loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txField_senha_loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btn_casdastro_loginPanel)
                .addGap(37, 37, 37)
                .addComponent(btn_login_loginPanel)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        loginPanel.add(login, "login");

        btn_cadastrar_cadastroPanel.setText("Cadastrar");
        btn_cadastrar_cadastroPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_cadastroPanelActionPerformed(evt);
            }
        });

        btn_logar_cadastroPanel.setText("Logar");

        jLabel8.setText("Login:");

        jLabel9.setText("Nome:");

        jLabel10.setText("Senha:");

        javax.swing.GroupLayout cadastroLayout = new javax.swing.GroupLayout(cadastro);
        cadastro.setLayout(cadastroLayout);
        cadastroLayout.setHorizontalGroup(
            cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logar_cadastroPanel)
                .addGap(18, 18, 18)
                .addComponent(btn_cadastrar_cadastroPanel)
                .addGap(75, 75, 75))
            .addGroup(cadastroLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cadastroLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(43, 43, 43)
                        .addComponent(txField_senha_cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastroLayout.createSequentialGroup()
                        .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(43, 43, 43)
                        .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txField_login_cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txField_nome_cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        cadastroLayout.setVerticalGroup(
            cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastroLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txField_nome_cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txField_login_cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txField_senha_cadastroPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadastrar_cadastroPanel)
                    .addComponent(btn_logar_cadastroPanel))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        loginPanel.add(cadastro, "cadastro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_login_loginPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_login_loginPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_login_loginPanelActionPerformed

    private void btn_cadastrar_cadastroPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_cadastroPanelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cadastrar_cadastroPanelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar_cadastroPanel;
    private javax.swing.JButton btn_casdastro_loginPanel;
    private javax.swing.JButton btn_logar_cadastroPanel;
    private javax.swing.JButton btn_login_loginPanel;
    private javax.swing.JPanel cadastro;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel login;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JTextField txField_login_cadastroPanel;
    private javax.swing.JTextField txField_login_loginPanel;
    private javax.swing.JTextField txField_nome_cadastroPanel;
    private javax.swing.JTextField txField_senha_cadastroPanel;
    private javax.swing.JTextField txField_senha_loginPanel;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_cadastrar_cadastroPanel() {
        return btn_cadastrar_cadastroPanel;
    }

    public JButton getBtn_casdastro_loginPanel() {
        return btn_casdastro_loginPanel;
    }

    public JButton getBtn_logar_cadastroPanel() {
        return btn_logar_cadastroPanel;
    }

    public JButton getBtn_login_loginPanel() {
        return btn_login_loginPanel;
    }

    public JPanel getLogin() {
        return login;
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public JTextField getTxField_login_cadastroPanel() {
        return txField_login_cadastroPanel;
    }

    public JTextField getTxField_login_loginPanel() {
        return txField_login_loginPanel;
    }

    public JTextField getTxField_nome_cadastroPanel() {
        return txField_nome_cadastroPanel;
    }

    public JTextField getTxField_senha_cadastroPanel() {
        return txField_senha_cadastroPanel;
    }

    public JTextField getTxField_senha_loginPanel() {
        return txField_senha_loginPanel;
    }

    
}