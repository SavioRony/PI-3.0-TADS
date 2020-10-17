
package br.senac.sp.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe utilizada para gerenciar a conexão com o banco de dados, 
 *@since Outubro/2020
 */
public class ConexaoSQL {
    
    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";  
    public static String LOGIN = "root";                          
    public static String SENHA = "";                            
    public static String URL = "jdbc:mysql://localhost:3306/db_sportstads?useSSL=false";
    
    public static Connection CONEXAO;

    public ConexaoSQL() {
    }
    
    public static Connection abrirConexao() throws ClassNotFoundException,SQLException {

        
        if(CONEXAO==null)      
        {    
            try {

                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);

                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                } else {
                    STATUS = "Não foi possivel realizar a conexão";
                }

            } catch (ClassNotFoundException e) {  //Driver não encontrado

                throw new ClassNotFoundException("O driver expecificado nao foi encontrado.");

            } catch (SQLException e) { 

                throw new SQLException("Erro ao estabelecer a conexão (Ex: login ou senha errados).");
            }      
        }
        else
        {
            try {
                if(CONEXAO.isClosed())
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch (SQLException ex) {
                throw new SQLException("Falha ao fechar a conexão.");
            }
        }
        return CONEXAO;
    }
    
    public static String getStatusConexao() {
        return STATUS;
    }
    
    public static boolean fecharConexao() throws SQLException {
 
        boolean retorno = false;   
        try {
            if(CONEXAO!=null){
                if(!CONEXAO.isClosed())
                    CONEXAO.close();
            }    
            STATUS = "Não conectado";
            retorno = true; 
         } catch (SQLException e) {
            retorno = false;
        }
        
        return retorno;
    }
   
}

