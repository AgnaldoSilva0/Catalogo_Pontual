/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BancoDados;

import Model.Listas;
import Model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pesquisar {
    
    public static void pesquisarProduto() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Listas.listProduto.clear();
            conn = Conexoes.conectar();
            String sql = "SELECT * FROM banco_produtos";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Listas.listProduto.add(new Produtos(rs.getString("codigo"), rs.getString("descricao"), rs.getDouble("precoCompra")
                , rs.getDouble("precoVenda"), rs.getInt("estoque")));
            }
            
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                rs.close();
                System.out.println("rs fechado");
            } catch (SQLException ex) {
                ex.getMessage();
            }
            Conexoes.closeStatement(ps);
            Conexoes.closeConection();
        }
    }
    
}
