package model;

import java.time.LocalDate;

public class Solicitacao {

    private int id;
    private int idUsuario;
    private int idLivro;
    private LocalDate dataSolicitacao;
    private String status;

    public Solicitacao() {
    }

    public Solicitacao(int idUsuario, int idLivro, LocalDate dataSolicitacao, String status) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
