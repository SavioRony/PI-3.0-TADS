package br.sport.tads.entidade;
//
public class Colaborador {

    private int codigoColaborador;
    private String nome;
    private String cpf;
    private String endereco;
    private int numero;
    private String cep;
    private String bairro;
    private String cargo;
    private int codigoFilial;
    private int status;
    private String email;
    private String senha;

    public Colaborador(String nome, String cpf, String endereco, Integer numero,
            String cep, String bairro, String cargo, Integer codigoFilial, String email, String senha) {
        this.codigoColaborador = 0;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.cargo = cargo;
        this.codigoFilial = codigoFilial;
        this.status = 1;
        this.email = email;
        this.senha = senha;
    }

    public Integer getCodigoColaborador() {
        return codigoColaborador;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(Integer codigoFilial) {
        this.codigoFilial = codigoFilial;
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
