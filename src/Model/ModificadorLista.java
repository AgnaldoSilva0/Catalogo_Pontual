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
public class ModificadorLista {

    public static void incrementarProduto(int decisao, String codigo, String descricao, double preco, int quantidade, double total) {
        switch (decisao) {
            case 1:
                for (Produtos produto : Listas.listOrcamento) {
                    if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                        produto.setTotal(total + produto.getPreco());
                        produto.setQuantidade(quantidade + 1);
                        return;
                    }
                }
                Listas.listOrcamento.add(new Produtos(codigo, descricao, preco, 1, preco));
                break;
            case 2:
                for (Produtos produto : Listas.listOrcamentoBalcao) {
                    if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                        produto.setTotal(total + produto.getPreco());
                        produto.setQuantidade(quantidade + 1);
                        return;
                    }
                }
                Listas.listOrcamentoBalcao.add(new Produtos(codigo, descricao, preco, 1, preco));
                break;

        }
    }

    public static void decrementarProduto(int decisao, String codigo, String descricao, double preco, int quantidade, double total) {
        switch (decisao) {
            case 1:
                for (Produtos produto : Listas.listOrcamento) {
                    if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                        produto.setTotal(total - produto.getPreco());
                        produto.setQuantidade(quantidade - 1);
                        return;
                    }
                }
                break;
            case 2:
                for (Produtos produto : Listas.listOrcamentoBalcao) {
                    if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                        produto.setTotal(total - produto.getPreco());
                        produto.setQuantidade(quantidade - 1);
                        return;
                    }
                }
                break;

        }
    }

    public static void removerProduto(int decisao, String codigo, String descricao, double preco, int quantidade, double total) {
        switch (decisao) {
            case 1:
                for (Produtos produto : Listas.listOrcamento) {
                    if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                        Listas.listOrcamento.remove(produto);
                        return;
                    }
                }
                break;
            case 2:
                for (Produtos produto : Listas.listOrcamentoBalcao) {
                    if (produto.getCodigo().toUpperCase().equals(codigo.toUpperCase())) {
                        Listas.listOrcamentoBalcao.remove(produto);
                        return;
                    }
                }
                break;

        }
    }

}
