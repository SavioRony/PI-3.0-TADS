package br.sport.tads.entidade;
//
public class Colaborador {

    private int codColaborador;
    private String nome;
    private String cpf;
    private String endereco;
    private int numero;
    private int cep;
    private String cidade;
    private String cargo;
    private int codFilial;
    private int status;
    private String email;
    private String senha;

    public Colaborador(String nome, String cpf, String endereco, int numero,
            int cep, String cidade, String cargo, int codFilial, String email, String senha) {
        this.codColaborador = 0;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.cargo = cargo;
        this.codFilial = codFilial;
        this.status = 1;
        this.email = email;
        this.senha = senha;
    }

    public Integer getCodigoColaborador() {
        return codColaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(Integer codigoFilial) {
        this.codFilial = codigoFilial;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
