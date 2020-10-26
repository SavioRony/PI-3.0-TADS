
package br.sport.tads.dao;

import br.sport.tads.bd.ConexaoDB;
import br.sport.tads.entidade.Filial;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FilialDAO {
    
    public static List<Filial> listarFiliais() {
        PreparedStatement ps = null;
        List<Filial> listaFiliais = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_filial";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codFilial = rs.getInt("codFilial");
                String nomeFilial = rs.getString("nomeFilial");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                int status = rs.getInt("status");
                listaFiliais.add(new Filial(codFilial, nomeFilial, estado, cidade, status));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return listaFiliais;
    }
    
    public static List<Filial> listarFiliais(int codFilial) {
        PreparedStatement ps = null;
        List<Filial> listaFiliais = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_filial where codFilial = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                codFilial = rs.getInt("codFilial");
                String nomeFilial = rs.getString("nomeFilial");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                int status = rs.getInt("status");
                listaFiliais.add(new Filial(codFilial, nomeFilial, estado, cidade, status));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return listaFiliais;
    }
    
    public static Filial getFilial(int codFilial) {
        PreparedStatement ps = null;
        Filial filial = null;

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_filial where codFilial = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                codFilial = rs.getInt("codFilial");
                String nomeFilial = rs.getString("nomeFilial");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                int status = rs.getInt("status");
                filial = new Filial(codFilial, nomeFilial, estado, cidade, status);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return filial;
    }
    
       public static void cadastrarFilial(Filial filial) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "insert into tb_filial (nomeFilial, estado ,cidade , status) values (?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(2, filial.getNomeFilial());
            ps.setString(3, filial.getEstado());
            ps.setString(4, filial.getCidade());
            ps.setInt(5, filial.getStatus());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
       
       public static void excluirCliente(int codFilial) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        try {
            ps = null;
            Connection con = ConexaoDB.getConexao();
            String query = "delete from tb_filial where codFilial = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
    
       public static void alterarFilial(Filial filial) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update tb_filial set nomeFilial = ? , estado = ?, cidade = ?, status = ? where codFilial = ?";
            ps = con.prepareStatement(query);
            ps.setString(2, filial.getNomeFilial());
            ps.setString(3, filial.getEstado());
            ps.setString(4, filial.getCidade());
            ps.setInt(5, filial.getStatus());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
