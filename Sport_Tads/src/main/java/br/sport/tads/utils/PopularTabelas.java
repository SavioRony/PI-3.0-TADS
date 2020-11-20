package br.sport.tads.utils;

import br.sport.tads.bd.ConexaoDB;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.sport.tads.dao.ColaboradorDAO;

public class PopularTabelas {

    public static void main(String[] args) {

        inserirClientes();
        inserirFiliais();
        inserirProdutos();
        inserirColaboradores();
        inserirVendas();
        inserirItensVendas();
    }

    public static void inserirClientes() {
        try {
            Connection conexao = ConexaoDB.getConexao();
            String query = "INSERT INTO tb_cliente (cpf, nome, celular, email) \n"
                    + "VALUES \n"
                    + "('76328505035', 'Ana Tereza de A. Vasques', 43978484307, 'avasques@teste.com.br'),\n"
                    + "('08456726060', 'Brisa Silva Bracchi', 59971948909, 'bbracchi@teste.com.br'),\n"
                    + "('86414734080', 'Debora Kaynara Patricio da Silva', 29924196783, 'dsilva@teste.com.br'),\n"
                    + "('58487040071', 'Glaucia Adriana Dantas Pereira', 47961996232, 'gpereira@teste.com.br'),\n"
                    + "('47958992076', 'Isabele Acciolo P. Lima', 54941020194, 'ilima@teste.com.br')";
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.execute(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void inserirFiliais() {
        try {
            Connection conexao = ConexaoDB.getConexao();
            String query = "INSERT INTO tb_filial \n"
                    + "(nomeFilial, estado, cidade, status)\n"
                    + "VALUES\n"
                    + "('Feira de Santana', 'BA', 'Feira de Santana', 1),\n"
                    + "('Rio de Janeiro', 'RJ', 'Rio de Janeiro', 1),\n"
                    + "('Belo Horizonte', 'MG', 'Belo Horizonte', 1),\n"
                    + "('Porto Alegre', 'RS', 'Porto Alegre', 1),\n"
                    + "('Campo Grande', 'MS', 'Campo Grande', 1)";
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.execute(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void inserirProdutos() {
        try {
            Connection conexao = ConexaoDB.getConexao();
            String query = "INSERT INTO tb_produto\n"
                    + "(codFilial, nomeProduto, marcaProduto, categoriaProduto, valorProduto, quantidadeEmEstoque)\n"
                    + "VALUES\n"
                    + "(1, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 10),\n"
                    + "(1, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 10),\n"
                    + "(1, 'Luvas de Goleiro', 'Penalty', 'Futebol', 97.49, 10),\n"
                    + "(2, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 10),\n"
                    + "(2, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 10),\n"
                    + "(2, 'Luvas de Goleiro', 'Penalty', 'Futebol', 97.49, 10),\n"
                    + "(3, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 10),\n"
                    + "(3, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 10),\n"
                    + "(3, 'Luvas de Goleiro', 'Penalty', 'Futebol', 97.49, 10),\n"
                    + "(4, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 10),\n"
                    + "(4, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 10),\n"
                    + "(4, 'Luvas de Goleiro', 'Penalty', 'Futebol', 97.49, 10),\n"
                    + "(5, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 10),\n"
                    + "(5, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 10),\n"
                    + "(5, 'Luvas de Goleiro', 'Penalty', 'Futebol', 97.49, 10)";
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.execute(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void inserirColaboradores() {

        Colaborador colaborador1 = new Colaborador("Benedita Raimunda Bernardes", "24292790965", "Praça Bento Gonçalves", 325,
                13870319, "São João da Boa Vista", "Analista de Sistemas", 2, "brbernardes", "123456789", "TI");
        colaborador1.setSenha(colaborador1.codificarSenha(colaborador1.getSenha()));

        Colaborador colaborador2 = new Colaborador("Maria Aurora da Mata", "90508119308", "Rua São Marcos", 298,
                69915428, "Rio Branco", "Vendedor(a)", 1, "madmata", "123456789", "VENDAS");
        colaborador2.setSenha(colaborador2.codificarSenha(colaborador2.getSenha()));

        Colaborador colaborador3 = new Colaborador("Mateus Kaique Caua Drumond", "85701237796", "Rua Otacilio Mangueira Ramalho", 458,
                58036836, "João Pessoa", "Analista de Estoque", 3, "mkcdrumond", "123456789", "BACKOFFICE");
        colaborador3.setSenha(colaborador3.codificarSenha(colaborador3.getSenha()));

        Colaborador colaborador4 = new Colaborador("Clara Simone Rezende", "98345164790", "Travessa L4 da Fonte Nova", 1474,
                68928208, "Santana", "Gerente Regional", 4, "csrezende", "123456789", "REGIONAL");
        colaborador4.setSenha(colaborador4.codificarSenha(colaborador4.getSenha()));

        Colaborador colaborador5 = new Colaborador("Hadassa Malu Regina da Mata", "77377115700", "Rua Primeiro de Janeiro", 1432,
                68908874, "Macapá", "Gerente Global", 5, "hmrdmata", "123456789", "GLOBAL");
        colaborador5.setSenha(colaborador5.codificarSenha(colaborador5.getSenha()));

        try {
            ColaboradorDAO.addColadorador(colaborador1);
            ColaboradorDAO.addColadorador(colaborador2);
            ColaboradorDAO.addColadorador(colaborador3);
            ColaboradorDAO.addColadorador(colaborador4);
            ColaboradorDAO.addColadorador(colaborador5);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void inserirVendas() {
        try {
            Connection conexao = ConexaoDB.getConexao();
            String query = "INSERT INTO tb_venda\n"
                    + "(cpfCliente, codFilial, codVendedor, dtVenda, total)\n"
                    + "VALUES\n"
                    + "('76328505035', 1, 2, CURDATE(), 299.97),\n"
                    + "('08456726060', 1, 2, CURDATE(), 249.95),\n"
                    + "('86414734080', 1, 2, CURDATE(), 194.98),\n"
                    + "('58487040071', 1, 2, CURDATE(), 294.94),\n"
                    + "('47958992076', 1, 2, CURDATE(), 389.96)";
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.execute(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void inserirItensVendas() {
        try {
            Connection conexao = ConexaoDB.getConexao();
            String query = "INSERT INTO tb_itemVenda\n"
                    + "(codVenda, codProduto, quantidade, subtotal)\n"
                    + "VALUES\n"
                    + "(1, 1, 3, 299.97),\n"
                    + "(2, 5, 4, 249.95),\n"
                    + "(3, 9, 2, 194.98),\n"
                    + "(4, 11, 6, 294.94),\n"
                    + "(5, 15, 4, 389.96)";
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.execute(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
