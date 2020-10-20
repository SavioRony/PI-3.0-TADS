
package br.sport.tads.bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {
    
    // Bloco executado uma única vez quando o servidor é inicializado
    static {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");  // org.apache.derby.jdbc.EmbeddedDriver

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoDB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       
    }
    
    public static Connection getConexao()throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/teste?useTimezone=true&serverTimezone=UTC&useSSL=false";  // jdbc:derby://localhost:1527/teste
        String user = "root";
        String password = "root";

        return DriverManager.getConnection(url, user, password);
    }
    
    
    
}
