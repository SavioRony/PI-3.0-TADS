package br.sport.tads.dao;

import br.sport.tads.bd.ConexaoDB;
import br.sport.tads.entidade.Produto;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

    public static void incluirProduto(Produto produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            ps = con.prepareStatement("insert into TB_PRODUTO (codfilial,nomeproduto,marcaproduto,categoriaproduto, valorproduto,quantidadeemestoque) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, produto.getCodFilial());
            ps.setString(2, produto.getNomeProduto());
            ps.setString(3, produto.getMarcaProduto());
            ps.setString(4, produto.getCategoriaProduto());
            ps.setDouble(5, produto.getValorProduto());
            ps.setInt(6, produto.getQuantidadeEmEstoque());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void alterarProduto(Produto produto) throws SQLException, ClassNotFoundException {

        Connection con = ConexaoDB.getConexao();
        String query = "update tb_produto set codfilial=?,nomeProduto=?,marcaProduto=?,categoriaProduto=?, valorProduto=?,quantidadeEmEstoque=? where codProduto=?";
        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, produto.getCodFilial());
        ps.setString(2, produto.getNomeProduto());
        ps.setString(3, produto.getMarcaProduto());
        ps.setString(4, produto.getCategoriaProduto());
        ps.setDouble(5, produto.getValorProduto());
        ps.setInt(6, produto.getQuantidadeEmEstoque());
        ps.setInt(7, produto.getCodProduto());

        ps.execute();

    }

    public static void excluirProduto(int codProd) throws SQLException, ClassNotFoundException {

        Connection con = ConexaoDB.getConexao();
        String query = "delete from tb_produto where codProduto=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, codProd);
        ps.execute();
    }

    public static List<Produto> getListaProdutos(int codFilial) {
        List<Produto> listaProdutos = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_produto where codFilial=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int codProduto = rs.getInt("codProduto");
                int filial = rs.getInt("codFilial");
                String nomeProduto = rs.getString("nomeProduto");
                String marca = rs.getString("marcaProduto");
                String categoria = rs.getString("categoriaProduto");
                int qtdEstoque = rs.getInt("quantidadeEmEstoque");
                Double valor = rs.getDouble("valorProduto");

                listaProdutos.add(new Produto(codProduto, filial, nomeProduto, marca, categoria, qtdEstoque, valor));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }
    
   public static Produto getProduto(int codProduto) {
        Produto produto = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_produto where codProduto=? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codProduto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int codProd = rs.getInt("codproduto");
                int filial = rs.getInt("codfilial");
                String nomeProduto = rs.getString("nomeProduto");
                String marca = rs.getString("marcaProduto");
                String categoria = rs.getString("categoriaProduto");
                Double valor = rs.getDouble("valorProduto");
                int qtdEstoque = rs.getInt("quantidadeEmEstoque");

                produto = new Produto(codProd, filial, nomeProduto, marca, categoria, valor, qtdEstoque);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
   
    public static Produto getProduto(int codProduto, int codFilial) {
        Produto produto = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_produto where codProduto=? and codFilial=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codProduto);
            ps.setInt(2, codFilial);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int codProd = rs.getInt("codproduto");
                int filial = rs.getInt("codfilial");
                String nomeProduto = rs.getString("nomeProduto");
                String marca = rs.getString("marcaProduto");
                String categoria = rs.getString("categoriaProduto");
                Double valor = rs.getDouble("valorProduto");
                int qtdEstoque = rs.getInt("quantidadeEmEstoque");

                produto = new Produto(codProd, filial, nomeProduto, marca, categoria, valor, qtdEstoque);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public static List<Produto> getListaProdutos(int codFilial, int codProduto) {
        List<Produto> listaProdutos = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_produto where codFilial=? and codProduto=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ps.setInt(2, codProduto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codProd = rs.getInt("codProduto");
                int filial = rs.getInt("codFilial");
                String nomeProduto = rs.getString("nomeProduto");
                String marca = rs.getString("marcaProduto");
                String categoria = rs.getString("categoriaProduto");
                int qtdEstoque = rs.getInt("quantidadeEmEstoque");
                Double valor = rs.getDouble("valorProduto");

                listaProdutos.add(new Produto(codProd, filial, nomeProduto, marca, categoria, qtdEstoque, valor));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }
}
