/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Thiago Peres Bezerra
 */
public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3360/desafio_back_java";
    private static final String USER = "root";
    private static final String PASS = "";
    
    //Realizando a Conexão.
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ocorrido na Conexão", ex);
        }
    }
    
    //Fechando Conexão e Statement.
    public static void closeConnection(Connection conexao){
        if(conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.err.println("ERRO: " +ex);
            }               
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement statement){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                System.err.println("ERRO: " +ex);
            }               
        }
        
        closeConnection(conexao);
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement statement, ResultSet resultset){
        if(resultset != null){
            try {
                resultset.close();
            } catch (SQLException ex) {
                System.err.println("ERRO: " +ex);
            }               
        }
        
        closeConnection(conexao, statement);
    }
    
}