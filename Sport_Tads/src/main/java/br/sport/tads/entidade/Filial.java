
package br.sport.tads.entidade;


public class Filial {
    
    private int codFilial;
    private String nomeFilial;
    private String estado;
    private String cidade;
    private int status;

    public Filial(String nomeFilial, String estado, String cidade, int status) {
        this.nomeFilial = nomeFilial;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status; 
    }

    public Filial(int codFilial, String nomeFilial, String estado, String cidade, int status) {
        this.codFilial = codFilial;
        this.nomeFilial = nomeFilial;
        this.estado = estado;
        this.cidade = cidade;
        this.status = status; 
    }

    
    public void Filial(int codFilial, String nomeFilial, String estado, String cidade, int status){
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
        return String.format("codFilial %s <br/> Filial %s <br/> Estado %s <br/> Cidade %s <br/> Status %d",
                this.getCodFilial(), this.getNomeFilial(), this.getEstado(), this.getCidade(), this.getStatus());
    }
    
    
    
    
}
