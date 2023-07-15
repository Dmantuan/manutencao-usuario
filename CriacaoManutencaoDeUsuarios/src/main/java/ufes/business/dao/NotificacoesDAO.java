package ufes.business.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ufes.db.conexaoDB;
import ufes.models.Notificacao;
import ufes.models.Usuario;

public class NotificacoesDAO {

    private final conexaoDB db = conexaoDB.getInstancia();

    public NotificacoesDAO() {
        
    }
    
    public Notificacao getById(Integer id) throws Exception {

        StringBuilder query = new StringBuilder();

        query.append(" SELECT * ");
        query.append(" FROM notificacoes as n ");
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

        query.append(" SELECT n.id as id, un.id_remetente as id_remetente, un.id_destinatario as id_destinatario, n.tx_conteudo as tx_conteudo ");
        query.append(" FROM usuario as u ");
        query.append(" LEFT JOIN usuario_notificacao as un ");
        query.append(" ON un.id_destinatario = ? ");
        query.append(" LEFT JOIN notificacao as n ");
        query.append(" ON n.id = un.id_notificacao ");

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

        query.append(" SELECT n.id as id, un.id_remetente as id_remetente, un.id_destinatario as id_destinatario, n.tx_conteudo as tx_conteudo ");
        query.append(" FROM usuario as u ");
        query.append(" LEFT JOIN usuario_notificacao as un ");
        query.append(" ON un.id_remetente = ? ");
        query.append(" LEFT JOIN notificacao as n ");
        query.append(" ON n.id = un.id_notificacao ");

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

    public void update(Notificacao notificacao) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" UPDATE notificacoes as n ");
        query.append(" SET id_remetente = ?, id_destinatario = ?, tx_conteudo = ? ");
        query.append(" WHERE n.id = ? ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, notificacao.getId_remetente());
            stm.setInt(2, notificacao.getId_destinatario());
            stm.setString(3, notificacao.getTx_conteudo());
            stm.setInt(4, notificacao.getId());

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteById(Integer id) throws Exception {
        StringBuilder query = new StringBuilder();

        query.append(" DELETE FROM notificacoes as n ");
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

        query.append(" INSERT INTO notificacoes (id_remetente, id_destinatario, tx_conteudo) ");
        query.append(" VALUES (?, ?, ?) ");

        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query.toString());
            stm.setInt(1, notificacao.getId_remetente());
            stm.setInt(2, notificacao.getId_destinatario());
            stm.setString(3, notificacao.getTx_conteudo());

            stm.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
