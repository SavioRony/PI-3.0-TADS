
package br.sport.tads.entidade;

/**
 *
 * @author savio
 */
public class Filial {
   private int codFilial;
   private String nomeFilial;
   private String estado;
   private String cidade;

    public Filial(int codFilial, String nomeFilial, String estado, String cidade, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   private String status;
}
