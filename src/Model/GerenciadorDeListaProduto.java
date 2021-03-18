/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class GerenciadorDeListaProduto {
    
    public static void carregarProdutos() {
        String patch = "C:\\Users\\Usuario\\Documents\\CatalogoPontualDoc\\BancoDados\\BDProdutos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(patch))) {
            String linhaProduto = br.readLine();
            while (linhaProduto != null) {
                String[] vectLeitor = linhaProduto.split(";");
                String codigo = (vectLeitor[0]);
                String descricao = (vectLeitor[1]);
                double preco = Double.parseDouble(vectLeitor[2]);
                double precoVenda = preco * 2;
                Listas.listProduto.add(new Produtos(codigo, descricao, preco, precoVenda));
                linhaProduto = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }   
    
}
