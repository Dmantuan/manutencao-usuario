package ufes.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ufes.models.Usuario;
import ufes.db.ConexaoDB;

public class UsuarioDAO {

    private final ConexaoDB db = ConexaoDB.getInstancia();

    public UsuarioDAO() {

    }

    public Usuario getById(Integer id) throws Exception {

        StringBuilder query = new StringBuilder();

        query.append(" SELECT * ");
        query.append(" FROM usuario as u ");
        query.append(" WHERE u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                return null;
            }
            Usuario usuario = new Usuario(id,
                    rs.getString("nm_usuario"),
                    rs.getString("tx_senha"),
                    rs.getString("tx_login"),
                    rs.getTimestamp("dt_criacao").toLocalDateTime(),
                    rs.getBoolean("bool_admin"),
                    rs.getBoolean("bool_autorizado")
            );

            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Usuario getByLogin(String login) throws Exception {

        StringBuilder query = new StringBuilder();

        query.append(" SELECT * ");
        query.append(" FROM usuario as u ");
        query.append(" WHERE u.tx_login = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setString(1, login);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                return null;
            }

            Usuario usuario = new Usuario(rs.getInt("id"),
                    rs.getString("nm_usuario"),
                    rs.getString("tx_senha"),
                    rs.getString("tx_login"),
                    rs.getTimestamp("dt_criacao").toLocalDateTime(),
                    rs.getBoolean("bool_admin"),
                    rs.getBoolean("bool_autorizado")
            );

            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Usuario> getAll() throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT * ");
        query.append(" FROM usuario ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());

            ResultSet rs = stm.executeQuery();

            List<Usuario> lista = new ArrayList<>();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"),
                        rs.getString("nm_usuario"),
                        rs.getString("tx_senha"),
                        rs.getString("tx_login"),
                        rs.getTimestamp("dt_criacao").toLocalDateTime(),
                        rs.getBoolean("bool_admin"),
                        rs.getBoolean("bool_autorizado")
                );
                lista.add(usuario);
            }

            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void updateAdmin(Integer id, Boolean autorizado, Boolean admin) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" UPDATE usuario as u ");
        query.append(" SET bool_admin = ?, bool_autorizado = ? ");
        query.append(" WHERE u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setBoolean(1, admin);
            stm.setBoolean(2, autorizado);
            stm.setInt(3, id);

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void update(Integer id, String nome, String login, String senha) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" UPDATE usuario as u ");
        query.append(" SET nm_usuario = ?, tx_senha = ?, tx_login = ? ");
        query.append(" WHERE u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setString(1, nome);
            stm.setString(2, senha);
            stm.setString(3, login);
            stm.setInt(4, id);

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteById(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" DELETE FROM usuario as u ");
        query.append(" WHERE u.id = ?  ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insert(Usuario usuario) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" INSERT INTO usuario (nm_usuario, tx_senha, tx_login) ");
        query.append(" VALUES (?, ?, ?) ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getSenha());
            stm.setString(3, usuario.getLogin());

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
