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

    public static List<Colaborador> getColaboradores(int codFilial) {
        PreparedStatement preparedStatement = null;
        List<Colaborador> colaboradores = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_colaborador where status = 1 and codFilial = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, codFilial);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codColaborador = resultSet.getInt("codColaborador");
                String nome = resultSet.getString("nomeCompleto");
                String cpf = resultSet.getString("cpf");
                String endereco = resultSet.getString("endereco");
                int numero = resultSet.getInt("numero");
                int cep = resultSet.getInt("cep");
                String cidade = resultSet.getString("cidade");
                String cargo = resultSet.getString("cargo");
                int codigoFilial = resultSet.getInt("codFilial");
                String usuario = resultSet.getString("usuario");
                String perfil = resultSet.getString("perfil");
                colaboradores.add(new Colaborador(nome, cpf, endereco, numero, cep, cidade, cargo, codigoFilial, usuario, perfil, codColaborador));
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

    
    public static Colaborador getColaboradores(String login) {
        PreparedStatement ps = null;
        Colaborador colaborador = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_colaborador where usuario = ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, login);
                        
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int codColaborador = resultSet.getInt("codColaborador");
                String nome = resultSet.getString("nomeCompleto");
                String cargo = resultSet.getString("cargo");
                String usuario = resultSet.getString("usuario");
                String perfil = resultSet.getString("perfil");
                String senha = resultSet.getString("senha");
                int codFilial = resultSet.getInt("codFilial");
                String cpf = resultSet.getString("cpf");


                colaborador = new Colaborador();
                colaborador.setNome(nome);
                colaborador.setCargo(cargo);
                colaborador.setPerfil(perfil);
                colaborador.setUsuario(usuario);
                colaborador.setSenha(senha);
                colaborador.setCpf(cpf);
                colaborador.setCodColaborador(codColaborador);
                colaborador.setCodFilial(codFilial);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return colaborador;
    }
   
    
    public static void addColadorador(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try {
            Connection con = ConexaoDB.getConexao();
            String query = "insert into tb_colaborador (nomeCompleto, cpf, usuario, senha, cargo, codFilial, endereco, numero, cep, cidade, status,perfil ) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getCpf());
            ps.setString(3, colaborador.getUsuario());
            ps.setString(4, colaborador.getSenha());
            ps.setString(5, colaborador.getCargo());
            ps.setInt(6, colaborador.getCodFilial());
            ps.setString(7, colaborador.getEndereco());
            ps.setInt(8, colaborador.getNumero());
            ps.setInt(9, colaborador.getCep());
            ps.setString(10, colaborador.getCidade());
            ps.setInt(11, 1);
            ps.setString(12, colaborador.getPerfil());
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
                String usuario = resultSet.getString("usuario");
                String senha = resultSet.getString("senha");
                String perfil = resultSet.getString("perfil");
                colaborador = new Colaborador(nome, cpf, endereco, numero, cep, cidade, cargo, codigoFilial, usuario, senha, perfil);
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
            String query = "update tb_colaborador set nomeCompleto=?, usuario=?, senha=?, cargo=?, codFilial=?, endereco=?, numero=?, cep=?, cidade=? where cpf=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, colaborador.getNome());
            ps.setString(2, colaborador.getUsuario());
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
