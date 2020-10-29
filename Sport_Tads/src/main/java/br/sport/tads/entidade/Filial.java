package br.sport.tads.entidade;

public class Filial {

    private int codFilial;
    private String nomeFilial;
    private String estado;
    private String cidade;
    private int status;

    public Filial(String nomeFilial, String estado, String cidade) {
        this.nomeFilial = nomeFilial;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Filial(int codFilial, String nomeFilial, String estado, String cidade, int status) {
        this.codFilial = codFilial;
        this.nomeFilial = nomeFilial;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("codFilial %d <br> nomeFilial %s <br> estado %s <br/> cidade %s <br>"
                + " status %d ",
                this.getCodFilial(), this.getNomeFilial(), this.getEstado(), this.getCidade(), this.getStatus());
    }
}
