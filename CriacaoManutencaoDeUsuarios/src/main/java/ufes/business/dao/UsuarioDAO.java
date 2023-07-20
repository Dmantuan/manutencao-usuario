package ufes.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

            Timestamp timestamp = rs.getTimestamp("dt_criacao");
            LocalDateTime dt_criacao = timestamp != null ? timestamp.toLocalDateTime() : null;

            Usuario usuario = new Usuario(rs.getInt("id"),
                    rs.getString("nm_usuario"),
                    rs.getString("tx_senha"),
                    rs.getString("tx_login"),
                    dt_criacao,
                    rs.getBoolean("bool_admin")
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

            Timestamp timestamp = rs.getTimestamp("dt_criacao");
            LocalDateTime dt_criacao = timestamp != null ? timestamp.toLocalDateTime() : null;

            Usuario usuario = new Usuario(rs.getInt("id"),
                    rs.getString("nm_usuario"),
                    rs.getString("tx_senha"),
                    rs.getString("tx_login"),
                    dt_criacao,
                    rs.getBoolean("bool_admin")
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
                Timestamp timestamp = rs.getTimestamp("dt_criacao");
                LocalDateTime dt_criacao = timestamp != null ? timestamp.toLocalDateTime() : null;

                Usuario usuario = new Usuario(rs.getInt("id"),
                        rs.getString("nm_usuario"),
                        rs.getString("tx_senha"),
                        rs.getString("tx_login"),
                        dt_criacao,
                        rs.getBoolean("bool_admin")
                );
                lista.add(usuario);
            }

            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void update(Usuario usuario) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" UPDATE usuario as u ");
        query.append(" SET nm_usuario = ?, tx_senha = ?, tx_login = ? ");
        query.append(" WHERE u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getSenha());
            stm.setString(3, usuario.getLogin());
            stm.setInt(4, usuario.getId());

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
