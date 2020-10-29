package br.sport.tads.entidade;

public class Produto {

    private int codProduto;
    private int codFilial;
    private String nomeProduto;
    private String marcaProduto;
    private String categoriaProduto;
    private Double valorProduto;
    private int quantidadeEmEstoque;

    public Produto() {
    }

    public Produto(int codProduto, int codFilial, String nomeProduto, String marcaProduto, String categoriaProduto, int quantidadeEmEstoque, Double valorProduto) {
        this.codProduto = codProduto;
        this.codFilial = codFilial;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.categoriaProduto = categoriaProduto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.valorProduto = valorProduto;
    }

    public Produto(int codFilial, String nomeProduto, String marcaProduto, String categoriaProduto, Double valorProduto, int quantidadeEmEstoque) {
        this.codFilial = codFilial;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.categoriaProduto = categoriaProduto;
        this.valorProduto = valorProduto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto(int codProduto, int codFilial, String nomeProduto, String marcaProduto, String categoriaProduto, Double valorProduto, int quantidadeEmEstoque) {
        this.codProduto = codProduto;
        this.codFilial = codFilial;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.categoriaProduto = categoriaProduto;
        this.valorProduto = valorProduto;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return String.format("codProduto %d <br> codFilial %d <br> nomeProduto %s <br/> marcaProduto %s <br>"
                + " categoriaProduto %s <br> valorProduto %f <br/> quantidadeEmEstoque %d",
                this.getCodProduto(), this.getCodFilial(), this.getNomeProduto(), this.getMarcaProduto(),
                this.getCategoriaProduto(), this.getValorProduto(), this.getQuantidadeEmEstoque());
    }
}
