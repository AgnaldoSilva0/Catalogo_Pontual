/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    
    public static void update(String codigo, String descricao,double precoCompra, double precoVenda, int estoque) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = Conexoes.conectar();
            
            
            String sql = "UPDATE banco_produtos"
                    + " SET "
                    + " precoVenda = ?,"
                    + " descricao = ?,"
                    + " precoCompra = ?,"
                    + " estoque = ?"
                    + " WHERE codigo = ?";
                    
            ps = conn.prepareStatement(sql);
            ps.setString(5, codigo);
            ps.setDouble(1, precoVenda);
            ps.setString(2, descricao);
            ps.setDouble(3, precoCompra);
            ps.setInt(4, estoque);
            
            int linhasAfetadas = ps.executeUpdate();
            System.out.println(linhasAfetadas);
           
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            Conexoes.closeStatement(ps);
            Conexoes.closeConection();
        }
    }
    
}
