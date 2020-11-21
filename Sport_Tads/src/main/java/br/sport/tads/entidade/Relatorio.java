package br.sport.tads.entidade;

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
    private String marcaProduto;
    private int codFilial;
    private String nomeFilial;
    private int percentual;
    private double totalFaturado;
    private int codVendedor;
    private String categoriaProduto;

    public Relatorio(int codVenda, String dataVenda, String cpfCliente, String nomeCliente, double valorTotal) {
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
    }

    public Relatorio(int codProduto, String nomeProduto, String marcaProduto,
            double valorProduto, int quantidade, double valorTotal) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.valorProduto = valorProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Relatorio(int codFilial, String nomeFilial, int quantidade, double totalFaturado) {
        this.quantidade = quantidade;
        this.codFilial = codFilial;
        this.nomeFilial = nomeFilial;
        this.totalFaturado = totalFaturado;
    }

    public Relatorio(int codVenda, String dataVenda, String cpfCliente, String nomeCliente, double valorTotal, int codVendedor) {
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.valorTotal = valorTotal;
        this.codVendedor = codVendedor;
    }

    public Relatorio(String dataVenda, int quantidade, double subTotal, double valorTotal, int codFilial, String nomeFilial, int percentual) {
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.subTotal = subTotal;
        this.valorTotal = valorTotal;
        this.codFilial = codFilial;
        this.nomeFilial = nomeFilial;
        this.percentual = percentual;
    }

    public Relatorio(int codVenda, String dataVenda, String cpfCliente, String nomeCliente, int codProduto, int quantidade, double valorTotal, int codVendedor) {
        this.codVenda = codVenda;
        this.dataVenda = dataVenda;
        this.cpfCliente = cpfCliente;
        this.nomeCliente = nomeCliente;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.codVendedor = codVendedor;
    }

    public Relatorio(String dataVenda, int codProduto, String nomeProduto, int quantidade, double valorProduto, double valorTotal, String marcaProduto, String categoriaProduto) {
        this.dataVenda = dataVenda;
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorProduto = valorProduto;
        this.valorTotal = valorTotal;
        this.marcaProduto = marcaProduto;
        this.categoriaProduto = categoriaProduto;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
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

    public int getPercentual() {
        return percentual;
    }

    public void setPercentual(int percentual) {
        this.percentual = percentual;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }

    public void setTotalFaturado(double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marca) {
        this.marcaProduto = marca;
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
