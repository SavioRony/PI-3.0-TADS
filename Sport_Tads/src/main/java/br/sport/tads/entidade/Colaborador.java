package br.sport.tads.entidade;

import at.favre.lib.crypto.bcrypt.BCrypt;

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
    private String usuario;
    private String senha;
    private String perfil;

    public Colaborador() {
    }

    public Colaborador(String nome, String cpf, String endereco, int numero,
            int cep, String cidade, String cargo, int codFilial, String usuario, String perfil, int codColaborador) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.cargo = cargo;
        this.codFilial = codFilial;
        this.status = 1;
        this.usuario = usuario;
        this.perfil = perfil;
        this.codColaborador = codColaborador;
    }

    public Colaborador(String nome, String cpf, String endereco, int numero,
            int cep, String cidade, String cargo, int codFilial, String usuario, String senha, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.cargo = cargo;
        this.codFilial = codFilial;
        this.status = 1;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getCodigoColaborador() {
        return codColaborador;
    }

    public void setCodColaborador(int codColaborador) {
        this.codColaborador = codColaborador;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String email) {
        this.usuario = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isGlobal() {
        return this.perfil.equalsIgnoreCase("Global");
    }

    public boolean isRegional() {
        return this.perfil.equalsIgnoreCase("Regional");
    }

    public boolean isVendas() {
        return this.perfil.equalsIgnoreCase("Vendas");
    }

    public boolean isBackoffice() {
        return this.perfil.equalsIgnoreCase("Backoffice");
    }

    public boolean isTi() {
        return this.perfil.equalsIgnoreCase("Ti");
    }

    public String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }

    public boolean validarSenha(String senha) {
        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), this.senha);
        return response.verified;
    }

}
