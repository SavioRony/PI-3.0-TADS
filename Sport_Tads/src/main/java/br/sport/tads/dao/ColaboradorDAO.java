/*    
Document   : ColaboradorDAO
Created on : 21/10/2020
Author     : Savio Rony
*/

package br.sport.tads.dao;


import br.sport.tads.bd.ConexaoDB;
import br.sport.tads.entidade.Colaborador;
import br.sport.tads.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColaboradorDAO {

    public static List<Colaborador> getColaboradores() {
        PreparedStatement preparedStatement = null;
        List<Colaborador> colaboradores = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from db_sportstads.tb_colaborador where status = 1";
            preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String nome = resultSet.getString("nomeCompleto");
                String cpf = resultSet.getString("cpf");
                String endereco = resultSet.getString("endereco");
                int numero = resultSet.getInt("numero");
                int cep = resultSet.getInt("cep");
                String cidade = resultSet.getString("cidade");
                String cargo = resultSet.getString("cargo");
                int codigoFilial = resultSet.getInt("codFilial");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                colaboradores.add(new Colaborador(nome, cpf, endereco, numero, cep, cidade, cargo, codigoFilial, email, senha));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return colaboradores;
    }

    public static void addColadorador(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "insert into tb_colaborador (nomeCompleto, cpf, email, senha, cargo, codFilial, endereco, numero, cep, cidade, status ) values (?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getCpf());
            ps.setString(3, colaborador.getEmail());
            ps.setString(4, colaborador.getSenha());
            ps.setString(5, colaborador.getCargo());
            ps.setInt(6, colaborador.getCodFilial());
            ps.setString(7, colaborador.getEndereco());
            ps.setInt(8, colaborador.getNumero());
            ps.setInt(9, colaborador.getCep());
            ps.setString(10, colaborador.getCidade());
            ps.setInt(11, 1);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteColadorador(String cpf) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update tb_colaborador set status=? where cpf=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, 0);
            ps.setString(2, cpf);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static Colaborador getColaborador(String cpf) {
        PreparedStatement ps = null;
        Colaborador colaborador = null;

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_colaborador where cpf=?";
            ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nomeCompleto");
                String endereco = resultSet.getString("endereco");
                int numero = resultSet.getInt("numero");
                int cep = resultSet.getInt("cep");
                String cidade = resultSet.getString("cidade");
                String cargo = resultSet.getString("cargo");
                int codigoFilial = resultSet.getInt("codFilial");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                colaborador = new Colaborador(nome, cpf, endereco, numero, cep, cidade, cargo, codigoFilial, email, senha);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colaborador;
    }

    public static void updateColaborador(Colaborador colaborador) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "update tb_colaborador set nomeCompleto=?, email=?, senha=?, cargo=?, codFilial=?, endereco=?, numero=?, cep=?, cidade=? where cpf=? " ;
            ps = con.prepareStatement(query);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getEmail());
            ps.setString(3, colaborador.getSenha());
            ps.setString(4, colaborador.getCargo());
            ps.setInt(5, colaborador.getCodFilial());
            ps.setString(6, colaborador.getEndereco());
            ps.setInt(7, colaborador.getNumero());
            ps.setInt(8, colaborador.getCep());
            ps.setString(9, colaborador.getCidade());
            ps.setString(10, colaborador.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
