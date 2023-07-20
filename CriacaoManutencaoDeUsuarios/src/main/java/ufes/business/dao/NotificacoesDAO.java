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

    public int getQtdNovasNotificacoes(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT COUNT(n.id) as quantidade ");
        query.append(" FROM usuario as u ");
        query.append(" INNER JOIN usuario_notificacao un ");
        query.append(" ON un.id_remetente = u.id ");
        query.append(" LEFT JOIN notificacao n ");
        query.append(" ON n.id = un.id_notificacao ");
        query.append(" WHERE n.bool_visualizado = FALSE and u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            Integer quantidade = rs.getInt("quantidade");

            return quantidade;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public int getQtdNotificacoesLidas(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT COUNT(n.id) as quantidade ");
        query.append(" FROM usuario as u ");
        query.append(" INNER JOIN usuario_notificacao un ");
        query.append(" ON un.id_remetente = u.id ");
        query.append(" LEFT JOIN notificacao n ");
        query.append(" ON n.id = un.id_notificacao ");
        query.append(" WHERE n.bool_visualizado = TRUE and u.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            Integer quantidade = rs.getInt("quantidade");

            return quantidade;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void alterarStatusMensagem(Notificacao notificacao, boolean lida) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" UPDATE notificacao as n ");
        query.append(" SET bool_visualizado = ? ");
        query.append(" WHERE n.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setBoolean(1, lida);
            stm.setInt(2, notificacao.getId());

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Notificacao getById(Integer idNotificacao) throws Exception {

        StringBuilder query = new StringBuilder();

        query.append(" SELECT n.id as id, "
                + " un.id_remetente as id_remetente, "
                + " un.id_destinatario as id_destinatario, "
                + " n.tx_conteudo as tx_conteudo, "
                + " n.tx_titulo as tx_titulo, "
                + " n.bool_visualizado as bool_visualizado, "
                + " u.nm_usuario as nm_usuario "
        );
        query.append(" FROM usuario as u ");
        query.append(" INNER JOIN usuario_notificacao un ");
        query.append(" ON un.id_destinatario = u.id ");
        query.append(" LEFT JOIN notificacao n ");
        query.append(" ON n.id = un.id_notificacao ");
        query.append(" WHERE n.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, idNotificacao);

            ResultSet rs = stm.executeQuery();

            if (!rs.next()) {
                return null;
            }
            Notificacao notificacao = new Notificacao(
                    idNotificacao,
                    rs.getInt("id_remetente"),
                    rs.getInt("id_destinatario"),
                    rs.getString("tx_conteudo"),
                    rs.getString("tx_titulo"),
                    rs.getBoolean("bool_visualizado"),
                    rs.getString("nm_usuario")
            );

            return notificacao;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Notificacao> getAllByUserDestinyId(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" SELECT n.id as id, un.id_remetente as id_remetente, "
                + " un.id_destinatario as id_destinatario, "
                + " n.tx_conteudo as tx_conteudo, "
                + " n.tx_titulo as tx_titulo, "
                + " n.bool_visualizado as bool_visualizado, "
                + " u.nm_usuario as nm_usuario ");
        
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
                Notificacao notificacao = new Notificacao(
                        rs.getInt("id"),
                        rs.getInt("id_remetente"),
                        rs.getInt("id_destinatario"),
                        rs.getString("tx_conteudo"),
                        rs.getString("tx_titulo"),
                        rs.getBoolean("bool_visualizado"),
                        rs.getString("nm_usuario")
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

        query.append(" SELECT n.id as id, "
                + " un.id_remetente as id_remetente, "
                + " un.id_destinatario as id_destinatario, "
                + " n.tx_conteudo as tx_conteudo, "
                + " n.tx_titulo as tx_titulo, "
                + " n.bool_visualizado as bool_visualizado, "
                + " u.nm_usuario as nm_usuario ");
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
                        rs.getString("tx_titulo"),
                        rs.getBoolean("bool_visualizado"),
                        rs.getString("nm_usuario")
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

        query.append(" SELECT DISTINCT n.id as id, un.id_remetente as id_remetente, un.id_destinatario as id_destinatario, n.tx_conteudo as tx_conteudo, n.tx_titulo as tx_titulo, n.bool_visualizado as bool_visualizado ");
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
                        rs.getString("tx_titulo"),
                        rs.getBoolean("bool_visualizado"),
                        rs.getString("nm_usuario")
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
            stm.setBoolean(3, notificacao.getBool_vizualizado());

            stm.execute();

            insertUsuarioNotificacao(notificacao.getId_remetente(), notificacao.getId_destinatario());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertUsuarioNotificacao(Integer id_remetente, Integer id_destinatario) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" INSERT INTO usuario_notificacao (id_remetente, id_destinatario, id_notificacao) ");
        query.append(" VALUES (?, ?, ?) ");

        try {
            PreparedStatement stma = db.getConnection().prepareStatement(query.toString());
            stma.setInt(1, id_remetente);
            stma.setInt(2, id_destinatario);
            stma.setInt(3, getMaxId());

            stma.execute();
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
