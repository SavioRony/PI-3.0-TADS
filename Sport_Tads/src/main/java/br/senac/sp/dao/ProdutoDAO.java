package br.senac.sp.dao;

import br.senac.sp.bd.ConexaoDB;
import br.sport.tads.entidade.Produto;
import br.senac.sp.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando
 */
public class ProdutoDAO {
    
    public static void incluirProduto( Produto produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "insert into TB_PRODUTO (codfilial,nomeproduto,marcaproduto,categoriaproduto,"
                    + " valorproduto,quantidadeemestoque) values (?,?,?,?,?,?)";
            
            ps = con.prepareStatement(query);
            
            ps.setInt(1, produto.getCodFilial());
            ps.setString(2, produto.getNomeProduto());
            ps.setString(3, produto.getMarcaProduto() );
            ps.setString(4, produto.getCategoriaProduto());
            ps.setDouble(5, produto.getValorProduto());
            ps.setInt(6, produto.getQuantidadeEmEstoque());
                                    
            ps.executeUpdate();
            
                  
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
   public static void alterarProduto( Produto produto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update TB_produto set codfilial=?,nomeproduto=?,marcaproduto=?,categoriaproduto=?, valorproduto=?,quantidadeemestoque=? where codproduto=?";
            
            ps = con.prepareStatement(query);
            ps.setInt(1, produto.getCodFilial());
            ps.setString(2, produto.getNomeProduto());
            ps.setString(3, produto.getMarcaProduto() );
            ps.setString(4, produto.getCategoriaProduto());
            ps.setDouble(5, produto.getValorProduto());
            ps.setInt(6, produto.getQuantidadeEmEstoque());
            ps.setInt(7, produto.getCodProduto());
                                    
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
     public static void excluirProduto( int codproduto) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            ps = null;
            Connection con = ConexaoDB.getConexao();
            String query = "delete from TB_produto where codproduto=?";
            
            ps = con.prepareStatement(query);
            ps.setInt(1, codproduto);
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
       
     public static List<Produto> getListaProdutos() {
       
        List<Produto> listaProdutos = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_produto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
                        
                int codProduto = rs.getInt("codProduto");
                int filial = rs.getInt("codFilial");
                String nomeProduto = rs.getString("nomeProduto");
                String marca = rs.getString("marcaProduto");
                String categoria = rs.getString("categoriaProduto");
                int qtdEstoque = rs.getInt("quantidadeEmEstoque");
                Double valor = rs.getDouble("valorProduto");
           
           listaProdutos.add(new Produto(codProduto,filial,nomeProduto,marca,categoria, qtdEstoque,valor));
         
           
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
            String query = "select * from tb_produto where codProduto=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,codProduto);
            ResultSet rs = ps.executeQuery();
            
           if (rs.next()) {
            
           int codProd = rs.getInt("codproduto");
           int filial = rs.getInt("codfilial");
           String nomeProduto = rs.getString("nomeProduto");
           String marca = rs.getString("marcaProduto");
           String categoria = rs.getString("categoriaProduto");
           Double valor = rs.getDouble("valorProduto");
           int qtdEstoque = rs.getInt("quantidadeEmEstoque");
           
           produto = new Produto (codProd,filial,nomeProduto,marca,categoria,valor,qtdEstoque);
           
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }
     
     
}
