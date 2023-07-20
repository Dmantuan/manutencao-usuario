package ufes.business.business;

import java.util.List;
import ufes.business.dao.NotificacoesDAO;
import ufes.business.dao.UsuarioDAO;

import ufes.models.Notificacao;


/*
    - Posso editar mensagens?
    - Posso excluir mensagens?s
 */
public class NotificacoesBusiness {

    private final NotificacoesDAO notificacoesDAO;

    private final UsuarioDAO usuarioDAO;
    
    public NotificacoesBusiness(){
        
        this.notificacoesDAO = new NotificacoesDAO();
        this.usuarioDAO = new UsuarioDAO();
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
        this.notificacoesDAO.deleteById(id);
    }
    
    public void alterarStatusMensagem(Integer id, boolean lida) throws Exception {
        Notificacao notificacao =  notificacoesDAO.getById(id);
        System.out.println(notificacao);
        this.notificacoesDAO.alterarStatusMensagem(notificacao, lida);
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
        if (notificacao.getTx_titulo() == null) {
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
