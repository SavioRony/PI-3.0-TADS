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
        //Somente os Ti e atravez dele e possivel cadastrar novos
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
                    + "('Matriz SP', 'SP', 'Sao Paulo', 1),\n"
                    + "('Campina Grande', 'PB', 'Paraiba', 1),\n"
                    + "('Joinville', 'SC', 'Santa catarina', 1)";
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
                    + "(1, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 30),\n"
                    + "(1, 'Caneleira', 'Penalty', 'Futebol', 39.99, 30),\n"
                    + "(1, 'Luvas de Goleiro', 'Penalty', 'Futebol', 57.49, 30),\n"
                    
                    + "(1, 'Tenis cano alto', 'Adidas', 'Basquete', 99.99, 30),\n"
                    + "(1, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 30),\n"
                    + "(1, 'Meia cano alto', 'Penalty', 'Basquete', 97.49, 30),\n"
                    
                    + "(1, 'Halteres', 'Oxer', 'Fitness', 37.99, 30),\n"
                    + "(1, 'Caneleira de peso 2kg', 'Domyos', 'Fitness', 44.99, 30),\n"
                    + "(1, 'Tapete baixa densidade', 'Domyos', 'Fitness', 24.49, 30),\n"
                    
                    + "(1, 'Kimonos', 'Torah', 'Marciais', 109.99, 30),\n"
                    + "(1, 'Luva de Boxes', 'Outshock', 'Marciais', 159.99, 20),\n"
                    + "(1, 'Corda de Pular', 'Outshock', 'Marciais', 45.49, 10),\n"
                    
                    + "(1, 'Bola de Volei', 'Allsix', 'Volei', 99.99, 10),\n"
                    + "(1, 'Rede', 'Penalty', 'Volei', 49.99, 10),\n"
                    + "(1, 'Bola Volei de quadra', 'Allsix', 'Volei', 77.49, 10)"
                    
                    + "(2, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 30),\n"
                    + "(2, 'Caneleira', 'Penalty', 'Futebol', 39.99, 30),\n"
                    + "(2, 'Luvas de Goleiro', 'Penalty', 'Futebol', 57.49, 30),\n"
                    
                    + "(2, 'Tenis cano alto', 'Adidas', 'Basquete', 99.99, 30),\n"
                    + "(2, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 30),\n"
                    + "(2, 'Meia cano alto', 'Penalty', 'Basquete', 97.49, 30),\n"
                    
                    + "(2, 'Halteres', 'Oxer', 'Fitness', 37.99, 30),\n"
                    + "(2, 'Caneleira de peso 2kg', 'Domyos', 'Fitness', 44.99, 30),\n"
                    + "(2, 'Tapete baixa densidade', 'Domyos', 'Fitness', 24.49, 30),\n"
                    
                    + "(2, 'Kimonos', 'Torah', 'Marciais', 109.99, 30),\n"
                    + "(2, 'Luva de Boxes', 'Outshock', 'Marciais', 159.99, 20),\n"
                    + "(2, 'Corda de Pular', 'Outshock', 'Marciais', 45.49, 10),\n"
                    
                    + "(2, 'Bola de Volei', 'Allsix', 'Volei', 99.99, 10),\n"
                    + "(2, 'Rede', 'Penalty', 'Volei', 49.99, 10),\n"
                    + "(2, 'Bola Volei de quadra', 'Allsix', 'Volei', 77.49, 10)\n"
                                        
                    + "(3, 'Bola de Futebol de Campo', 'Adidas', 'Futebol', 99.99, 30),\n"
                    + "(3, 'Caneleira', 'Penalty', 'Futebol', 39.99, 30),\n"
                    + "(3, 'Luvas de Goleiro', 'Penalty', 'Futebol', 57.49, 30),\n"
                    
                    + "(3, 'Tenis cano alto', 'Adidas', 'Basquete', 99.99, 30),\n"
                    + "(3, 'Bola de Basquete', 'Penalty', 'Basquete', 49.99, 30),\n"
                    + "(3, 'Meia cano alto', 'Penalty', 'Basquete', 97.49, 30),\n"
                    
                    + "(3, 'Halteres', 'Oxer', 'Fitness', 37.99, 30),\n"
                    + "(3, 'Caneleira de peso 2kg', 'Domyos', 'Fitness', 44.99, 30),\n"
                    + "(3, 'Tapete baixa densidade', 'Domyos', 'Fitness', 24.49, 30),\n"
                    
                    + "(3, 'Kimonos', 'Torah', 'Marciais', 109.99, 30),\n"
                    + "(3, 'Luva de Boxes', 'Outshock', 'Marciais', 159.99, 20),\n"
                    + "(3, 'Corda de Pular', 'Outshock', 'Marciais', 45.49, 10),\n"
                    
                    + "(3, 'Bola de Volei', 'Allsix', 'Volei', 99.99, 10),\n"
                    + "(3, 'Rede', 'Penalty', 'Volei', 49.99, 10),\n"
                    + "(3, 'Bola Volei de quadra', 'Allsix', 'Volei', 77.49, 10)";
            
                    
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
                13870319, "Sao Paulo", "Analista de Sistemas", 1, "Ti_01", "123", "TI");
        colaborador1.setSenha(colaborador1.codificarSenha(colaborador1.getSenha()));

        Colaborador colaborador2 = new Colaborador("Maria Aurora da Mata", "90508119308", "Rua São Marcos", 298,
                69915428, "Campina Grande", "Analista de Sistemas", 2, "Ti_02", "123\n" +
                "", "TI");
        colaborador2.setSenha(colaborador2.codificarSenha(colaborador2.getSenha()));

        Colaborador colaborador3 = new Colaborador("Mateus Kaique Caua Drumond", "85701237796", "Rua Otacilio Mangueira Ramalho", 458,
                58036836, "Join ville", "Analista de Sistemas", 3, "Ti_02", "123", "TI");
        colaborador3.setSenha(colaborador3.codificarSenha(colaborador3.getSenha()));

        try {
            ColaboradorDAO.addColadorador(colaborador1);
            ColaboradorDAO.addColadorador(colaborador2);
            ColaboradorDAO.addColadorador(colaborador3);
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
