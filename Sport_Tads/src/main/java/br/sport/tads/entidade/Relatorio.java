
package br.sport.tads.entidade;

import java.util.Date;

/**
 *
 * @author savio
 */
public class Relatorio {
    private int codVenda;
    private String dataVenda;
    private String cpfCliente;
    private String nomeCliente;
    private int codProduto;
    private String nomeProduto;
    private int quantidade;
    private double valorProduto;
    private double subTotal;
    private double valorTotal;

    public Relatorio(int codVenda, String dataVenda, String cpfCliente, String nomeCliente, int codProduto, String nomeProduto, int quantidade, double valorProduto, double subTotal, double valorTotal) {
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorProduto = valorProduto;
        this.subTotal = subTotal;
        this.valorTotal = valorTotal;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
