package ufes.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ufes.db.ConexaoDB;
import ufes.models.Notificacao;

public class NotificacoesDAO {

    private final ConexaoDB db = ConexaoDB.getInstancia();

    public NotificacoesDAO() {

    }

    public Notificacao getById(Integer id) throws Exception {

        StringBuilder query = new StringBuilder();

        query.append(" SELECT * ");
        query.append(" FROM notificacao as n ");
        query.append(" WHERE n.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                return null;
            }
            Notificacao notificacao = new Notificacao(id,
                    rs.getInt("id_remetente"),
                    rs.getInt("id_destinatario"),
                    rs.getString("tx_conteudo"),
                    rs.getString("tx_titulo")
            );

            return notificacao;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Notificacao> getAllByUserDestinyId(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT n.id as id, un.id_remetente as id_remetente, un.id_destinatario as id_destinatario, n.tx_conteudo as tx_conteudo, n.tx_titulo as tx_titulo ");
        query.append(" FROM usuario as u ");
        query.append(" INNER JOIN usuario_notificacao un ");
        query.append(" ON un.id_destinatario = u.id ");
        query.append(" LEFT JOIN notificacao n ");
        query.append(" ON n.id = un.id_notificacao ");
        query.append(" WHERE u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            List<Notificacao> lista = new ArrayList<>();

            while (rs.next()) {
                Notificacao notificacao = new Notificacao(rs.getInt("id"),
                        rs.getInt("id_remetente"),
                        rs.getInt("id_destinatario"),
                        rs.getString("tx_conteudo"),
                        rs.getString("tx_titulo")
                );
                lista.add(notificacao);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Notificacao> getAllByUserSendId(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT n.id as id, un.id_remetente as id_remetente, un.id_destinatario as id_destinatario, n.tx_conteudo as tx_conteudo, n.tx_titulo as tx_titulo ");
        query.append(" FROM usuario as u ");
        query.append(" INNER JOIN usuario_notificacao un ");
        query.append(" ON un.id_remetente = u.id ");
        query.append(" LEFT JOIN notificacao n ");
        query.append(" ON n.id = un.id_notificacao ");
        query.append(" WHERE u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            List<Notificacao> lista = new ArrayList<>();

            while (rs.next()) {
                Notificacao notificacao = new Notificacao(rs.getInt("id"),
                        rs.getInt("id_remetente"),
                        rs.getInt("id_destinatario"),
                        rs.getString("tx_conteudo"),
                        rs.getString("tx_titulo")
                );
                lista.add(notificacao);
            }

            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Notificacao> getAll() throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT n.id as id, un.id_remetente as id_remetente, un.id_destinatario as id_destinatario, n.tx_conteudo as tx_conteudo, n.tx_titulo as tx_titulo ");
        query.append(" FROM usuario as u ");
        query.append(" INNER JOIN usuario_notificacao un ");
        query.append(" ON un.id_remetente = u.id ");
        query.append(" LEFT JOIN notificacao n ");
        query.append(" ON n.id = un.id_notificacao ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());

            ResultSet rs = stm.executeQuery();

            List<Notificacao> lista = new ArrayList<>();

            while (rs.next()) {
                Notificacao notificacao = new Notificacao(rs.getInt("id"),
                        rs.getInt("id_remetente"),
                        rs.getInt("id_destinatario"),
                        rs.getString("tx_conteudo"),
                        rs.getString("tx_titulo")
                );
                lista.add(notificacao);
            }

            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteById(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" DELETE FROM notificacao as n ");
        query.append(" WHERE n.id = ?  ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insert(Notificacao notificacao) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" INSERT INTO notificacao (tx_conteudo, tx_titulo, bool_visualizado) ");
        query.append(" VALUES (?, ?, ?) ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setString(1, notificacao.getTx_conteudo());
            stm.setString(2, notificacao.getTx_titulo());
            stm.setBoolean(3, notificacao.getBool_vizualizada());

            stm.execute();
            
            insertUsuarioNotificacao(notificacao.getId_remetente(), notificacao.getId_destinatario());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void insertUsuarioNotificacao(Integer id_remetente, Integer id_destinatario) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" INSERT INTO usuario_notificao (id_remetente, id_destinatario, id_notificacao) ");
        query.append(" VALUES (?, ?, ?) ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id_remetente);
            stm.setInt(2, id_destinatario);
            stm.setInt(3, getMaxId());

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Integer getMaxId() throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT MAX(id) as id ");
        query.append(" FROM notificacao ");
        
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());

            ResultSet rs = stm.executeQuery();
            
            return rs.getInt("id");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
