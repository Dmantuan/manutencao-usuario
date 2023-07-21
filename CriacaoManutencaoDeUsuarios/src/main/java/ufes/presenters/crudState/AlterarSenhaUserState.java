/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.presenters.crudState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ufes.business.business.UsuarioBusiness;
import ufes.models.Usuario;
import ufes.presenters.CrudPresenter;

/**
 *
 * @author annin
 */
public class AlterarSenhaUserState extends CrudState {

    private Usuario user;
    private UsuarioBusiness usuarioBusiness;

    public AlterarSenhaUserState(CrudPresenter presenter, Usuario user) {
        super(presenter);
        this.user = user;
        usuarioBusiness = new UsuarioBusiness();
        editarUsuario();
        crudPresenter.getCardLayout().show(crudPresenter.getCrudPanel(), "editarUser");
        
        // ######### Pagina de Editar user
        crudPresenter.getCrudView().getBtn_cancelar_editarPanel1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crudPresenter.getCrudView().setVisible(false);
            }
        });

        crudPresenter.getCrudView().getBtn_salvar_editarPanel1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    usuarioBusiness.update(user.getId(), crudPresenter.getCrudView().getTxField_nome_editarPanel1().getText(), crudPresenter.getCrudView().getTxField_login_editarPanel1().getText(), crudPresenter.getCrudView().getTxField_senhaNova_editarPanel1().getText());
                    JOptionPane.showMessageDialog(crudPresenter.getCrudView(), "Usuario salvo com sucesso!");
                    crudPresenter.getCrudView().setVisible(false);
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(crudPresenter.getCrudView(), e.getMessage());
                }
            }
        });
    }

    private void editarUsuario() {
        crudPresenter.getCrudView().getTxField_nome_editarPanel1().setText(user.getNome());
        crudPresenter.getCrudView().getTxField_login_editarPanel1().setText(user.getLogin());
        crudPresenter.getCrudView().getTxField_senhaAntiga_editarPanel1().setText(user.getSenha());
        crudPresenter.getCrudView().getTxField_senhaNova_editarPanel1().setText("");
    }
}
