package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexoes {
    
    private static Connection conn;
    
    public static Connection conectar() {
        try {
            String url = "jdbc:sqlite:BancoDados/banco_produtos.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Banco Conectado");
        } catch (SQLException e) {
            e.getMessage();
        }
        return conn;
    }
    
    public static void closeConection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Desconectado");
            } catch(SQLException e) {
                e.getMessage();
            }
        }
    }
    
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
                System.out.println("Statement Fechado");
            } catch(SQLException e) {
                e.getMessage();
            }
            
        } 
    }
    
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("ResultSet Fechado");
            } catch(SQLException e) {
                e.getMessage();
            }
        }
    }
    
    public static void criarTabelaProduto() {
        Connection conn = null;
        Statement st = null;
        
        try {
            conn = conectar();
            String sql = "CREATE TABLE IF NOT EXISTS banco_produtos"
                    + "(id INTEGER PRIMARY KEY,"
                    + "codigo text,"
                    + "descricao text,"
                    + "precoCompra double,"
                    + "precoVenda double,"
                    + "estoque integer)";
            
            st = conn.createStatement();
            st.execute(sql);
            System.out.println("Tabela Criada");
            
            
        } catch(SQLException e) {
            e.getMessage();
        } finally {
            closeConection();
            closeStatement(st);
        }
    }
    
}
