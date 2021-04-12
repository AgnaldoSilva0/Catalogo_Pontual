/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BancoDados.Pesquisar;
import BancoDados.Update;
import Model.ProdutoModelEdit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class TelaEditarProdutoController implements Initializable {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfPrecoCompra;

    @FXML
    private TextField tfPrecoVenda;

    @FXML
    private TextField tfEstoque;

    @FXML
    private Button btAplicar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarDados();
    }    
    
    @FXML
    public void onBtActionEditar() {
        String codigo = tfCodigo.getText();
        String descricao = tfDescricao.getText();
        double precoCompra = Double.parseDouble(tfPrecoCompra.getText());
        double precoVenda = Double.parseDouble(tfPrecoVenda.getText());
        int estoque = Integer.parseInt(tfEstoque.getText());
        Update.update(codigo, descricao, precoCompra, precoVenda, estoque);
        Pesquisar.pesquisarProduto();
    }
    
    public void carregarDados() {
        ProdutoModelEdit produto = new ProdutoModelEdit();
        tfCodigo.setText(produto.getCodigo());
        tfDescricao.setText(produto.getDescricao());
        tfPrecoCompra.setText(String.valueOf(produto.getPrecoCompra()));
        tfPrecoVenda.setText(String.valueOf(produto.getPrecoVenda()));
        tfEstoque.setText(String.valueOf(produto.getEstoque()));
    }
    
}
