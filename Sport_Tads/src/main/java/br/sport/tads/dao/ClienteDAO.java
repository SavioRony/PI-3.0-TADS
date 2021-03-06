package br.sport.tads.dao;

import br.sport.tads.bd.ConexaoDB;
import br.sport.tads.entidade.Cliente;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public static List<Cliente> getClientes() {
        PreparedStatement ps = null;
        List<Cliente> listaClientes = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_cliente";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                long celular = rs.getLong("celular");
                listaClientes.add(new Cliente(nome, cpf, email, celular));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }

    public static List<Cliente> getClientes(String cpf) {
        PreparedStatement ps = null;
        List<Cliente> listaClientes = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_cliente where cpf=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                long celular = rs.getLong("celular");
                listaClientes.add(new Cliente(nome, cpf, email, celular));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }

    public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            ps = con.prepareStatement("insert into tb_cliente (nome,cpf,email,celular) values (?,?,?,?)");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setLong(4, cliente.getCelular());
            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void updateCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update tb_cliente set nome=?,email=?,celular=? where cpf=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setLong(3, cliente.getCelular());
            ps.setString(4, cliente.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteCliente(String cpf) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        try {
            ps = null;
            Connection con = ConexaoDB.getConexao();
            String query = "delete from tb_cliente where cpf=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static Cliente getCliente(String cpf) {
        PreparedStatement ps = null;
        Cliente cliente = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_cliente where cpf=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                long celular = rs.getLong("celular");
                cliente = new Cliente(nome, cpf, email, celular);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
