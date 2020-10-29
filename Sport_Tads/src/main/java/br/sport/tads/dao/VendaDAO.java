package br.sport.tads.dao;

import br.sport.tads.bd.ConexaoDB;
import br.sport.tads.entidade.Cliente;
import br.sport.tads.entidade.Venda;
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

public class VendaDAO {

    public static Venda GerarPedidoVenda(Venda venda) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            ps = con.prepareStatement("insert into tb_venda (cpfCliente,codFilial,dt"
                    + "Venda) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, venda.getCpfCliente());
            ps.setInt(2, venda.getCodFilial());
            ps.setDate(3, new java.sql.Date(venda.getDataDaVenda().getTime()));

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                venda.setCodVenda(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Falha ao obter o Codigo da venda");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return venda;
    }

    public static int buscarNumeroPedido() throws SQLException, ClassNotFoundException {
        int codVenda = 0;

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_produto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                codVenda = rs.getInt("codVenda");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return codVenda;
    }

    public static List<Cliente> listaCpf() {
        List<Cliente> listaCpf = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select cpf from tb_produto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                listaCpf.add(new Cliente(cpf));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCpf;
    }

    public static void finalizarVenda(double valorTotal, int codVenda) {
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update tb_venda set total = ? where codVenda=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, valorTotal);
            ps.setInt(2, codVenda);
            ps.execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
