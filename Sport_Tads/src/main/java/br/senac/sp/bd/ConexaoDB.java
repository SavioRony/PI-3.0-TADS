
package br.senac.sp.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {
    
    // Bloco executado uma única vez quando o servidor é inicializado
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }
    
    public static Connection getConexao()throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db_sportstads?useSSL=false";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }
    
    
    
}
