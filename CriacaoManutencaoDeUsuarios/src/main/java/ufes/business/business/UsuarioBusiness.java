package ufes.business.business;

import com.pss.senha.validacao.ValidadorSenha;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import ufes.business.dao.UsuarioDAO;
import ufes.models.Log;
import ufes.models.MultipleExceptions;
import ufes.models.Usuario;
import ufes.presenter.ConfiguracaoPresenter;
import ufes.services.log.GerenciadorLog;

public class UsuarioBusiness {

    private ConfiguracaoPresenter logPresenter = ConfiguracaoPresenter.getIntancia();

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    ValidadorSenha validadorSenha = new ValidadorSenha();

    public void insert(Usuario usuario) throws Exception {

        try {

            if (usuarioDAO.getAllAll().isEmpty()) {
                usuario.setAdmin(Boolean.TRUE);
                usuario.setAutorizado(Boolean.TRUE);
            } else {
                usuario.setAdmin(Boolean.FALSE);
                usuario.setAutorizado(Boolean.FALSE);
            }

            usuario.setData(LocalDateTime.now());
            validate(usuario);

            this.usuarioDAO.insert(usuario);

            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Isercao de usuario");
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        } catch (Exception e) {
            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Isercao de usuario", e.getMessage());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        }
    }

    public void update(Integer id, String nome, String login, String senha) throws Exception {
        validateExists(id);
        validatePassWord(senha);
        Usuario usuario = this.usuarioDAO.getById(id);

        try {
            this.usuarioDAO.update(id, nome, login, senha);
            usuario = this.usuarioDAO.getById(id);
            
            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Update de usuario");
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        } catch (Exception e) {
            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Update de usuario", e.getMessage());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        }
    }

    public void updateAutorizado(Integer id, Boolean autorizado) throws Exception {
        validateExists(id);
        Usuario usuario = this.usuarioDAO.getById(id);

        try {
            this.usuarioDAO.updateAutorizado(id, autorizado);
            usuario = this.usuarioDAO.getById(id);

            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Update de admin");
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        } catch (Exception e) {
            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Update de admin", e.getMessage());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        }
    }

    public void delete(Integer id) throws Exception {
        validateExists(id);
        Usuario usuario = this.usuarioDAO.getById(id);

        try {
            this.usuarioDAO.deleteById(id);

            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Deletando o usuario");
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        } catch (Exception e) {
            Log log = new Log(usuario.getNome(), String.valueOf(usuario.getId()), "Deletando o usuario", e.getMessage());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        }
    }

    public Usuario getUserById(Integer id) throws Exception {
        return validateExists(id);
    }

    public List<Usuario> getAllUsers(Integer id) throws Exception {
        return this.usuarioDAO.getAll(id);
    }

    public List<Usuario> getAllUsersNaoAutorizados() throws Exception {
        return this.usuarioDAO.getAllNaoAutorizados();
    }

    public Usuario getByLogin(String login) throws Exception {
        Usuario user = this.usuarioDAO.getByLogin(login);
        if (!user.getAutorizado()) {
            throw new Exception("O usuario ainda nao esta autorizado");
        }
        return user;
    }

    private void validate(Usuario usuario) throws Exception {
        List<Exception> exceptionList = new ArrayList<>();
        if (usuario.getNome() == null) {
            exceptionList.add(new Exception("O Nome de usuario esta vazio"));
        }
        if (usuario.getLogin() == null) {
            exceptionList.add(new Exception("O Login de usuario esta vazio"));
        }
        exceptionList.addAll(validatePassWord(usuario.getSenha()));

        if (!exceptionList.isEmpty()) {
            throw new MultipleExceptions(exceptionList);
        }
    }

    private List validatePassWord(String senha) {
        List<String> listaErros = this.validadorSenha.validar(senha);

        return listaErros;
    }

    private Usuario validateExists(Integer id) throws Exception {
        Usuario usuario = this.usuarioDAO.getById(id);
        if (usuario == null) {
            throw new Exception("O usuario nao consta na nossa base de dados");
        }

        return usuario;
    }
}
