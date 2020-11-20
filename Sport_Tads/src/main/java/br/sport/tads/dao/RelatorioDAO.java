package br.sport.tads.dao;

import br.sport.tads.bd.ConexaoDB;

import br.sport.tads.entidade.Relatorio;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatorioDAO {

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
                String marcaProd = rs.getString("marcaProduto");
                Double valorUn = rs.getDouble("valorProduto");
                int quantidade = rs.getInt("quantidade");
                Double valorTotal = rs.getDouble("valorTotal");
                relatorioDez.add(new Relatorio(codProduto, nomeProduto, marcaProd, valorUn, quantidade, valorTotal));
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

    public static List<Relatorio> relatorioFiliais() {
        List<Relatorio> relatorioFiliais = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select f.codFilial, f.nomeFilial, sum(i.quantidade) as quantidadeVendida, sum(v.total) as totalFaturado\n"
                    + "from tb_filial f\n"
                    + "inner join tb_venda v\n"
                    + "on v.codFilial = f.CodFilial\n"
                    + "inner join tb_itemVenda i\n"
                    + "on i.codVenda = v.codVenda\n"
                    + "group by f.codFilial\n"
                    + "order by totalFaturado desc;";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codFilial = rs.getInt("codFilial");
                String nomeFilial = rs.getString("nomeFilial");
                int quantidadeVendida = rs.getInt("quantidadeVendida");
                double totalFaturado = rs.getDouble("totalFaturado");
                relatorioFiliais.add(new Relatorio(codFilial, nomeFilial, quantidadeVendida, totalFaturado));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return relatorioFiliais;
    }

    public static List<Relatorio> novoRelatorioVendasPorFilial(int codFilial, String dataInicio, String dataFinal) {
        PreparedStatement ps = null;
        List<Relatorio> listaRelatorioVendasPorFilial = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "SELECT v.codVenda, c.nome, v.cpfCliente, v.codVendedor, DATE_FORMAT(v.dtVenda, '%d/%m/%Y') AS dtVenda, v.total\n"
                    + "FROM tb_venda v\n"
                    + "INNER JOIN tb_cliente c\n"
                    + "ON c.cpf = v.cpfCliente\n"
                    + "WHERE v.codFilial = ?\n"
                    + "AND v.dtVenda BETWEEN '?' AND '?'";
            ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ps.setString(2, dataInicio);
            ps.setString(3, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codVenda = rs.getInt("codVenda");
                String nomeCliente = rs.getString("nome");
                String cpf = rs.getString("cpfCliente");
                int codVendedor = rs.getInt("codVendor");
                String dtVenda = rs.getString("dtVenda");
                double total = rs.getDouble("total");
                listaRelatorioVendasPorFilial.add(new Relatorio(codVenda, dtVenda, cpf, nomeCliente, total, codVendedor));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaRelatorioVendasPorFilial;
    }

    public static List<Relatorio> novoRelatorioConsolidadoVendasPorFilial(String dataInicio, String dataFinal) {
        PreparedStatement ps = null;
        List<Relatorio> listaConsolidadoRelatorioVendasPorFilial = new ArrayList();
        System.out.println("Data inicio " + dataInicio + "data fim " + dataFinal);
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "SELECT v.codFilial, f.nomeFilial, DATE_FORMAT(v.dtVenda, '%d/%m/%Y') AS dtVenda, COUNT(v.codFilial) AS quantidade, SUM(v.total) AS total, \n"
                    + "(SELECT SUM(total) FROM tb_venda WHERE v.dtVenda BETWEEN ? AND ?) AS totalConsolidado, \n"
                    + "FORMAT((SUM(v.total) * 100 ) / (SELECT SUM(total) FROM tb_venda WHERE v.dtVenda BETWEEN ? AND ?),0) as percentual\n"
                    + "FROM tb_venda v\n"
                    + "INNER JOIN tb_filial f\n"
                    + "ON f.codFilial = v.codFilial\n"
                    + "WHERE v.dtVenda BETWEEN ? AND ?\n"
                    + "GROUP BY v.codFilial";
            ps = con.prepareStatement(query);
            ps.setString(1, dataInicio);
            ps.setString(2, dataFinal);
            ps.setString(3, dataInicio);
            ps.setString(4, dataFinal);
            ps.setString(5, dataInicio);
            ps.setString(6, dataFinal);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codFilial = rs.getInt("codFilial");
                String nomeFilial = rs.getString("nomeFilial");
                String dtVenda = rs.getString("dtVenda");
                int quantidade = rs.getInt("quantidade");
                double total = rs.getDouble("total");
                double totalConsolidado = rs.getDouble("totalConsolidado");
                int percentual = rs.getInt("percentual");
                listaConsolidadoRelatorioVendasPorFilial.add(new Relatorio(dtVenda, quantidade, total, totalConsolidado, codFilial, nomeFilial, percentual));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaConsolidadoRelatorioVendasPorFilial;
    }

    public static List<Relatorio> novoRelatorioCategoriaProduto(String dataInicio, String dataFinal, String categoria, int codFilial) {
        PreparedStatement ps = null;
        List<Relatorio> listaRelatorioCategoriaProduto = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "SELECT p.codProduto, p.nomeProduto, p.marcaProduto, p.categoriaProduto, p.valorProduto, sum(i.quantidade) AS quantidade, DATE_FORMAT(v.dtVenda, '%d/%m/%Y') AS dtVenda,\n"
                    + "(p.valorProduto * (SUM(i.quantidade))) AS valorTotal\n"
                    + "FROM tb_itemvenda i\n"
                    + "INNER JOIN tb_produto p\n"
                    + "ON i.codProduto = p.codProduto\n"
                    + "INNER JOIN tb_venda v\n"
                    + "ON v.codVenda = i.codVenda\n"
                    + "WHERE v.dtVenda BETWEEN ? AND ?\n"
                    + "AND p.categoriaProduto = ?\n"
                    + "AND v.codFilial = ?\n"
                    + "GROUP BY p.categoriaProduto, p.codProduto\n"
                    + "ORDER BY i.quantidade DESC";
            ps = con.prepareStatement(query);
            ps.setString(1, dataInicio);
            ps.setString(2, dataFinal);
            ps.setString(3, categoria);
            ps.setInt(4, codFilial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codProduto = rs.getInt("codProduto");
                String nomeProduto = rs.getString("nomeProduto");
                String marcaProduto = rs.getString("marcaProduto");
                String categoriaProduto = rs.getString("categoriaProduto");
                double valorProduto = rs.getDouble("valorProduto");
                int quantidade = rs.getInt("quantidade");
                String dtVenda = rs.getString("dtVenda");
                double total = rs.getDouble("valorTotal");
                listaRelatorioCategoriaProduto.add(new Relatorio(dtVenda, codProduto, nomeProduto, quantidade, valorProduto, total, marcaProduto, categoriaProduto));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaRelatorioCategoriaProduto;
    }

    public static List<Relatorio> novoRelatorioVendasPorCliente(String cpf, String dataInicio, String dataFinal, int codFilial) {
        PreparedStatement ps = null;
        List<Relatorio> listaRelatorioVendasPorCliente = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "SELECT v.codVenda, c.cpf, c.nome, DATE_FORMAT(v.dtVenda, '%d/%m/%Y') as dtVenda, v.total \n"
                    + "FROM tb_venda v\n"
                    + "INNER JOIN tb_cliente c ON c.cpf = v.cpfCliente\n"
                    + "WHERE cpf = ?\n"
                    + "AND v.dtVenda BETWEEN ? AND ?\n"
                    + "AND v.codFilial = ?\n"
                    + "ORDER BY v.codVenda";
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.setString(2, dataInicio);
            ps.setString(3, dataFinal);
            ps.setInt(4, codFilial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codVenda = rs.getInt("codVenda");
                String cpfCliente = rs.getString("cpf");
                String nome = rs.getString("nome");
                String dtVenda = rs.getString("dtVenda");
                double total = rs.getDouble("total");
                listaRelatorioVendasPorCliente.add(new Relatorio(codVenda, dtVenda, cpfCliente, nome, total));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaRelatorioVendasPorCliente;
    }

    public static List<Relatorio> novoRelatorioVendasFilial(int codFilial, String dataInicio, String dataFinal) {
        PreparedStatement ps = null;
        List<Relatorio> listaRelatorioVendasPorRegional = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "SELECT v.codVenda, DATE_FORMAT(v.dtVenda, '%d/%m/%Y') as dtVenda, v.cpfCliente, v.codVendedor, c.nomeCompleto, i.codProduto, i.quantidade, i.subTotal\n"
                    + "FROM tb_venda v\n"
                    + "INNER JOIN tb_colaborador c ON v.codVendedor = c.codColaborador\n"
                    + "INNER JOIN tb_itemVenda i ON v.codVenda = i.codVenda\n"
                    + "WHERE v.codFilial = ?\n"
                    + "AND V.dtVenda BETWEEN ? AND ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ps.setString(2, dataInicio);
            ps.setString(3, dataFinal);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codVenda = rs.getInt("codVenda");
                String dtVenda = rs.getString("dtVenda");
                String cpfCliente = rs.getString("cpfCliente");
                int codVendedor = rs.getInt("codVendedor");
                String nomeCompleto = rs.getString("nomeCompleto");
                int codProduto = rs.getInt("codProduto");
                int quantidade = rs.getInt("quantidade");
                double total = rs.getDouble("subTotal");
                listaRelatorioVendasPorRegional.add(new Relatorio(codVenda, dtVenda, cpfCliente, nomeCompleto, codProduto, quantidade, total, codVendedor));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaRelatorioVendasPorRegional;
    }

}
