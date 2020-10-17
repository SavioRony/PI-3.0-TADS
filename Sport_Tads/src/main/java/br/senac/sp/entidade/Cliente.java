package br.senac.sp.entidade;

public class Cliente {

    private String nome;
    private String email;
    private String cpf;
    private int celular;
    
    public Cliente(String nome, String cpf, String email, int celular) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.celular = celular;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }


    @Override
    public String toString() {
        return String.format("Nome %s <br/> Email %s <br/> CPF %d",
                this.getNome(), this.getEmail(), this.getCpf());
    }

}
