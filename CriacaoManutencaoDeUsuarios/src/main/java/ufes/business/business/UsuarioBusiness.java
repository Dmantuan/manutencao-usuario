package ufes.business.business;

import com.pss.senha.validacao.ValidadorSenha;
import java.util.ArrayList;
import java.util.List;
import ufes.business.dao.UsuarioDAO;
import ufes.models.MultipleExceptions;
import ufes.models.Usuario;

public class UsuarioBusiness {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    ValidadorSenha validadorSenha = new ValidadorSenha();
    
    public void insert(Usuario usuario) throws Exception{
        validate(usuario);
        this.usuarioDAO.insert(usuario);
    }
    
    public void update(Usuario usuario) throws Exception {
        validateExists(usuario.getId());
        validate(usuario);
        this.usuarioDAO.update(usuario);
    }
    
    public void delete(Integer id) throws Exception {
        validateExists(id);
        this.usuarioDAO.deleteById(id);
    }
    
    public Usuario getUserById(Integer id) throws Exception {
        return validateExists(id);
    }
        
    public List<Usuario> getAllUsers() throws Exception {
        return this.usuarioDAO.getAll();
    }
    
    public Usuario getByLogin(String login) throws Exception{
        return this.usuarioDAO.getByLogin(login);
    }
    
    private void validate(Usuario usuario) throws Exception {
        List<Exception> exceptionList = new ArrayList<>();
        if(usuario.getNome() == null){
            exceptionList.add(new Exception("O Nome de usuario esta vazio"));
        }
        if(usuario.getLogin() == null){
            exceptionList.add(new Exception("O Login de usuario esta vazio"));
        }
        exceptionList.addAll(validatePassWord(usuario.getSenha()));
        
        throw new MultipleExceptions(exceptionList);
    }
    
        
    private List validatePassWord(String senha){
        List<String> listaErros = this.validadorSenha.validar(senha);
        
        return listaErros;
    }
    
    private Usuario validateExists(Integer id) throws Exception {
        Usuario usuario = this.usuarioDAO.getById(id);
        if(usuario == null){
            throw new Exception("O usuario nao consta na nossa base de dados");
        }
        
        return usuario;
    }

}
