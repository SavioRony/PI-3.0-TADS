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

/**
 *
 * @author savio
 */
public class FilialDAO {
    
    public static List<Filial> getFilial(int codFilial) {
        PreparedStatement ps = null;
        List<Filial> listaFilial = new ArrayList();

        try {
            Connection con = ConexaoDB.getConexao();
            String query = "select * from tb_filial where codFilial=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, codFilial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nomeFilial");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                String status = rs.getString("status");
                listaFilial.add(new Filial(codFilial, nome, estado, cidade, status));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return listaFilial;
    }
}
