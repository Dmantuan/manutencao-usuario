package ufes.models;

public class Notificacao {

    private Integer id;
    private Integer id_remetente;
    private Integer id_destinatario;
    private String tx_titulo;
    private Boolean bool_vizualizado;
    private String tx_conteudo;

    public Notificacao(Integer id, Integer id_remetente, Integer id_destinatario, String tx_conteudo, String tx_titulo, Boolean bool_visualizado) {
        this.id = id;
        this.id_destinatario = id_destinatario;
        this.id_remetente = id_remetente;
        this.tx_conteudo = tx_conteudo;
        this.tx_titulo = tx_titulo;
        this.bool_vizualizado = bool_visualizado;
    }

    public Notificacao(Integer id_remetente, Integer id_destinatario, String tx_conteudo, String tx_titulo, Boolean bool_visualizado) {
        this.id_destinatario = id_destinatario;
        this.id_remetente = id_remetente;
        this.tx_conteudo = tx_conteudo;
        this.tx_titulo = tx_titulo;
        this.bool_vizualizado = bool_visualizado;
    }

    public String getTx_titulo() {
        return tx_titulo;
    }

    public void setTx_titulo(String tx_titulo) {
        this.tx_titulo = tx_titulo;
    }

    public Boolean getBool_vizualizado() {
        return bool_vizualizado;
    }

    public void setBool_vizualizado(Boolean bool_vizualizada) {
        this.bool_vizualizado = bool_vizualizada;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_remetente() {
        return id_remetente;
    }

    public Integer getId_destinatario() {
        return id_destinatario;
    }

    public String getTx_conteudo() {
        return tx_conteudo;
    }

    public void setId_remetente(Integer id_remetente) {
        this.id_remetente = id_remetente;
    }

    public void setId_destinatario(Integer id_destinatario) {
        this.id_destinatario = id_destinatario;
    }

    public void setTx_conteudo(String tx_conteudo) {
        this.tx_conteudo = tx_conteudo;
    }

    @Override
    public String toString() {
        return "id: " + String.valueOf(this.id) + " id_remetente: " + String.valueOf(this.id_remetente) + " id_destino: " + String.valueOf(this.id_destinatario) + " texto: " + this.tx_conteudo;
    }
}
