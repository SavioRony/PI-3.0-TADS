package br.sport.tads.dao;

//
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

/**
 *
 * @author Hugo Souza Araujo
 */
public class ColaboradorDAO {

    public static List<Colaborador> getColaboradores() {
        PreparedStatement preparedStatement = null;
        List<Colaborador> colaboradores = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from db_sportstads.tb_colaborador";
            preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigoColaborador = resultSet.getInt("codigoColaborador");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String endereco = resultSet.getString("endereco");
                int numero = resultSet.getInt("numero");
                String cep = resultSet.getString("cep");
                String bairro = resultSet.getString("bairro");
                String cargo = resultSet.getString("cargo");
                int codigoFilial = resultSet.getInt("codigoFilial");
                int status = resultSet.getInt("status");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                colaboradores.add(new Colaborador(nome, cpf, endereco, numero,
                        cep, bairro, cargo, codigoFilial, email, senha));
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
}
