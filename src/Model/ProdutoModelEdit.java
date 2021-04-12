/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Usuario
 */
public class ProdutoModelEdit {
    
    private static String codigo, descricao;
    private static double precoCompra, precoVenda;
    private static int estoque;

    public ProdutoModelEdit() {
    }

    public static String getCodigo() {
        return codigo;
    }

    public static void setCodigo(String codigo) {
        ProdutoModelEdit.codigo = codigo;
    }

    public static String getDescricao() {
        return descricao;
    }

    public static void setDescricao(String descricao) {
        ProdutoModelEdit.descricao = descricao;
    }

    public static double getPrecoCompra() {
        return precoCompra;
    }

    public static void setPrecoCompra(double precoCompra) {
        ProdutoModelEdit.precoCompra = precoCompra;
    }

    public static double getPrecoVenda() {
        return precoVenda;
    }

    public static void setPrecoVenda(double precoVenda) {
        ProdutoModelEdit.precoVenda = precoVenda;
    }

    public static int getEstoque() {
        return estoque;
    }

    public static void setEstoque(int estoque) {
        ProdutoModelEdit.estoque = estoque;
    }
    
    
    
}
