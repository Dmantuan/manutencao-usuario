package ufes.business.business;

import java.util.List;
import ufes.business.dao.NotificacoesDAO;
import ufes.business.dao.UsuarioDAO;
import ufes.models.Log;
import ufes.models.Notificacao;
import ufes.models.Usuario;
import ufes.presenter.ConfiguracaoPresenter;
import ufes.services.log.GerenciadorLog;

public class NotificacoesBusiness {
    
    private ConfiguracaoPresenter logPresenter = ConfiguracaoPresenter.getIntancia();
    
    private final NotificacoesDAO notificacoesDAO;

    private final UsuarioDAO usuarioDAO;

    public NotificacoesBusiness() {

        this.notificacoesDAO = new NotificacoesDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public int getQtdNovasNotificacoes(Integer id) throws Exception {
        return this.notificacoesDAO.getQtdNovasNotificacoes(id);
    }

    public int getQtdNotificacoesLidas(Integer id) throws Exception {
        return this.notificacoesDAO.getQtdNotificacoesLidas(id);
    }

    public Notificacao getById(Integer id) throws Exception {
        return this.notificacoesDAO.getById(id);
    }

    public List<Notificacao> getAllByUserId(Integer id) throws Exception {
        return notificacoesDAO.getAllByUserDestinyId(id);
    }

    public List<Notificacao> getAll() throws Exception {
        return notificacoesDAO.getAll();
    }
    public List<Notificacao> getAllByUserSendId(Integer id) throws Exception {
        return notificacoesDAO.getAllByUserSendId(id);
    }

    public void insert(Notificacao notificacao) throws Exception {
        validate(notificacao);
        this.notificacoesDAO.insert(notificacao);
    }

    public void delete(Integer id) throws Exception {
        validateExists(id);
        Notificacao notificacao =  notificacoesDAO.getById(id);
        Usuario user = usuarioDAO.getById(notificacao.getId_destinatario());
        
        try {
            this.notificacoesDAO.deleteById(id);
            
            Log log = new Log(notificacao.getTx_nomeRemetente(),String.valueOf(user.getId()), "Mensagem com id: (" + notificacao.getId()+ ") enviada para: " + user.getNome());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        } catch (Exception e) {
            Log log = new Log(notificacao.getTx_nomeRemetente(),String.valueOf(user.getId()), "Mensagem com id: (" + notificacao.getId()+ ") enviada para: " + user.getNome(), e.getMessage());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        }    
    }

    public void alterarStatusMensagem(Integer id, boolean lida) throws Exception {
        Notificacao notificacao =  notificacoesDAO.getById(id);
        Usuario user = usuarioDAO.getById(notificacao.getId_destinatario());
        
        try {
            this.notificacoesDAO.alterarStatusMensagem(notificacao, lida);
            user = usuarioDAO.getById(notificacao.getId_destinatario());
            
            Log log = new Log(notificacao.getTx_nomeRemetente(), String.valueOf(user.getId()), "Mensagem com id: (" + notificacao.getId()+ ") maracada como lida?: " + notificacao.getBool_vizualizado());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        } catch (Exception e) {
            Log log = new Log(notificacao.getTx_nomeRemetente(), String.valueOf(user.getId()), "Mensagem com id: (" + notificacao.getId()+ ") maracada como lida?: " + notificacao.getBool_vizualizado(), e.getMessage());
            GerenciadorLog.salvarLog(logPresenter.getTipoLog(), log);
        }    
    }

    private void validate(Notificacao notificacao) throws Exception {
        if (notificacao.getId_destinatario() == null) {
            throw new Exception("A mensagem não tem nenhum destinatario declarado");
        }
        if (this.usuarioDAO.getById(notificacao.getId_destinatario()) == null) {
            throw new Exception("O id do usuario de destino não consta na nossa base de dados");
        }
        if (notificacao.getId_remetente() == null) {
            throw new Exception("O remetente não esta declarado");
        }
        if (this.usuarioDAO.getById(notificacao.getId_remetente()) == null) {
            throw new Exception("O id do usuario remetente não consta na nossa base de dados");
        }
        if ( notificacao.getTx_titulo().isEmpty()) {
            notificacao.setTx_titulo("SEM ASSUNTO");
        }
        if (notificacao.getTx_conteudo().isEmpty()) {
            throw new Exception("O conteudo da mensagem está vazio");
        }
    }

    private Notificacao validateExists(Integer id) throws Exception {
        Notificacao notificacao = this.notificacoesDAO.getById(id);
        if (notificacao == null) {
            throw new Exception("A notificacao não consta no nosso banco de dados");
        }

        return notificacao;
    }
}
