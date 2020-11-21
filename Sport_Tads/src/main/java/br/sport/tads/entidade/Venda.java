package br.sport.tads.entidade;

import java.util.Date;

public class Venda {

    int codVenda;
    String cpfCliente;
    int codFilial;
    int codVendedor;
    Date dataDaVenda;
    Double total;

    public Venda() {
    }

    public Venda(String cpfCliente, int codFilial, Date dataDaVenda) {
        this.cpfCliente = cpfCliente;
        this.codFilial = codFilial;
        this.dataDaVenda = dataDaVenda;
    }

    public Venda(String cpfCliente, int codFilial, int codVendedor, Date data_Venda, int codVenda, double total) {
        this.cpfCliente = cpfCliente;
        this.codFilial = codFilial;
        this.codVendedor = codVendedor;
        this.dataDaVenda = data_Venda;
        this.codVenda = codVenda;
        this.total = total;
    }

    public Venda(String cpfCliente, int codFilial, int codVendedor, Date dataDaVenda, double total) {
        this.cpfCliente = cpfCliente;
        this.codFilial = codFilial;
        this.codVendedor = codVendedor;
        this.dataDaVenda = dataDaVenda;
        this.total = total;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("codVenda%d <br> cpfCliente %s <br> codFilial %d <br/> codVendedor %s <br>"
                + " dataDaVenda %d <br> total %f <br/> ",
                this.getCodVenda(), this.getCpfCliente(), this.getCodFilial(), this.getCodVendedor(),
                this.getDataDaVenda(), this.getTotal());
    }
}
