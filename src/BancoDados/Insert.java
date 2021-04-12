/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    
    public static void inserirProduto(String codigo, String descricao, double precoCompra, double precoVenda, int estoque) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexoes.conectar();
            
            String sql = "INSERT INTO banco_produtos"
                    + "(codigo, descricao, precoCompra, precoVenda, estoque)"
                    + "VALUES "
                    + "(?,?,?,?,?)";
                   
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, descricao);
            ps.setDouble(3, precoCompra);
            ps.setDouble(4, precoVenda);
            ps.setInt(5, estoque);
            
            int linhasAfetadas = ps.executeUpdate();
                    
        } catch(SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConection();
        }
    }
    
}
