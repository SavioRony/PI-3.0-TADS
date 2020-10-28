package br.sport.tads.dao;

import br.sport.tads.bd.ConexaoDB;

import br.sport.tads.entidade.Relatorio;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author savio
 */
public class RelatorioDAO {

    public static List<Relatorio> getRelatorioCliente(String cpf) {
        PreparedStatement ps = null;
        List<Relatorio> listaRelatorioCliente = new ArrayList();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select tb_venda.codVenda, tb_venda.dt_hr_Venda, tb_cliente.cpf, tb_cliente.nome, tb_produto.codProduto, tb_produto.nomeProduto, \n"
                    + "tb_itemvenda.quantidade, tb_produto.valorProduto, tb_itemvenda.subTotal, tb_venda.total from tb_venda\n"
                    + "inner join tb_itemvenda on tb_itemvenda.codVenda = tb_venda.codVenda\n"
                    + "inner join tb_cliente on tb_cliente.cpf = tb_venda.cpfCliente\n"
                    + "inner join tb_produto on tb_produto.codProduto = tb_itemvenda.codProduto\n"
                    + "where cpf = ?\n"
                    + "order by codVenda;";
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codVenda = rs.getInt("codVenda");
                Date data = rs.getDate("dt_hr_Venda");
                String dataForma = formatador.format(data);
                cpf = rs.getString("cpf");
                String nomeCliente = rs.getString("nome");
                int codProduto = rs.getInt("codProduto");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidade = rs.getInt("quantidade");
                double valorProduto = rs.getDouble("valorProduto");
                double subTotal = rs.getDouble("subTotal");
                double valorTotal = rs.getDouble("total");
                listaRelatorioCliente.add(new Relatorio(codVenda, dataForma, cpf, nomeCliente, codProduto, nomeProduto, quantidade, valorProduto, subTotal, valorTotal));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return listaRelatorioCliente;
    }

    public static List<Relatorio> relatorioDezMaisVendidos() {
       
        
        List<Relatorio> relatorioDez = new ArrayList();
        
       
        try {
            Connection con = ConexaoDB.getConexao();
            String query = " select \n"
                    + "	tb_produto.codProduto,\n"
                    + "	tb_produto.nomeProduto,\n"
                    + "	tb_produto.marcaProduto,\n"
                    + "	tb_produto.valorProduto, \n"
                    + "	SUM(tb_itemvenda.quantidade) as quantidade,\n"
                    + "    (tb_produto.valorProduto * (SUM(tb_itemvenda.quantidade))) as valorTotal\n"
                    + "from \n"
                    + "	tb_itemvenda \n"
                    + "inner join \n"
                    + "	tb_produto \n"
                    + "on \n"
                    + "	tb_itemvenda.codProduto = tb_produto.codProduto \n"
                    + "group by codProduto \n"
                    + "order by quantidade DESC \n"
                    + "limit 10";
           PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                int codProduto = rs.getInt("codProduto");
                String nomeProduto = rs.getString("nomeProduto");
                String  marcaProd = rs.getString("marcaProduto");
                Double valorUn = rs.getDouble("valorProduto");
                int quantidade = rs.getInt("quantidade");
                Double valorTotal = rs.getDouble("valorTotal");
                                
                relatorioDez.add(new Relatorio(codProduto,nomeProduto, marcaProd,valorUn,quantidade,valorTotal));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return relatorioDez;
    }

     
     
     
     
     
}
