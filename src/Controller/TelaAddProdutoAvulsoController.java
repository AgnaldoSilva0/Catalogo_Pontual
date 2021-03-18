/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Comando.Regras;
import Model.Listas;
import Model.Produtos;
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
public class TelaAddProdutoAvulsoController extends TelaBalcaoController implements Initializable {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfPreco;

    @FXML
    private Button btAdicionar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Regras.setTextFieldInteger(tfQuantidade);
        Regras.setTextFieldDouble(tfPreco);
    }    
    
    @FXML
    private void onBtActionAdicionarProduto() {
        String codigo = tfCodigo.getText();
        String descricao = tfDescricao.getText();
        int quantidade = Integer.parseInt(tfQuantidade.getText());
        double preco = Double.parseDouble(tfPreco.getText());
        double total = preco * quantidade;
        Listas.listOrcamentoBalcao.add(new Produtos(codigo, descricao, preco, quantidade, total));
        limparCampos();
    }
    
    private void limparCampos() {
        tfCodigo.clear();
        tfDescricao.clear();
        tfPreco.clear();
        tfQuantidade.clear();
    }
    
}
