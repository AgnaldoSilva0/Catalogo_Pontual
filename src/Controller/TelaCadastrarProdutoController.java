package Controller;

import BancoDados.Insert;
import Comando.Regras;
import Model.Contato;
import Model.GerenciadorDeTelas;
import Model.Listas;
import catalogopontual.CadastrarProdutos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaCadastrarProdutoController implements Initializable {

    @FXML private Button btMenuInicial;
    @FXML public TextField tfCodigo;
    @FXML public TextField tfDescricao;
    @FXML public TextField tfPreco;
    @FXML
    private TextField tfPrecoVenda;
    @FXML
    private TextField tfEstoque;
    @FXML private Button btCadastrar;
    @FXML private TextField tfNome;
    @FXML private TextField tfNumero;
    @FXML private TextField tfDdd;
    @FXML private TextField tfReferencia;
    @FXML private Button btCadastrarContato;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarRegras();
        btMenuInicial.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeTelas.voltarAoMenuInicial();
            CadastrarProdutos.getStage().close();
        });
        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            addProdutoAmalcaburio();
        });
        btCadastrarContato.setOnMouseClicked((MouseEvent e) -> {
            addContato();
        });
        
        
    }

    private void addProdutoAmalcaburio() {
        String descricao = tfDescricao.getText();
        String codigo = tfCodigo.getText();
        double precoCompra = Double.parseDouble(tfPreco.getText());
        double precoVenda = Double.parseDouble(tfPrecoVenda.getText());
        int estoque = Integer.parseInt(tfEstoque.getText());
        Insert.inserirProduto(codigo, descricao, precoCompra, precoVenda, estoque);
        //int ipi = Integer.parseInt(tfIpi.getText());
        //Listas.listAmalcaburio.add(new Produtos(codigo, descricao, preco, ipi));
        //GerenciadorDeListas.addProdutoArqAmalcaburio();
        limparCamposProduto();
    }
    
    private void addContato() {
        String nome = tfNome.getText();
        int numero = Integer.parseInt(tfNumero.getText());
        int ddd = Integer.parseInt(tfDdd.getText());
        String referencia = tfReferencia.getText();
        Listas.listContatos.add(new Contato(nome, numero, referencia, ddd));
        limparCamposContato();
    }
    
    private void carregarRegras() {
        //Regras.setTextFieldInteger(tfIpi);
        Regras.setTextFieldDouble(tfPreco);
        Regras.setTextFieldInteger(tfNumero);
        Regras.setTextFieldDouble(tfDdd);
        Regras.setTextFieldMaxLength(tfDdd, 2);
    }
    
    private void limparCamposContato() {
        tfNome.clear();
        tfNumero.clear();
        tfDdd.clear();
        tfReferencia.clear();
    }
    
    private void limparCamposProduto() {
        tfCodigo.clear();
        tfDescricao.clear();
        tfPreco.clear();
        //tfIpi.clear();
    }

}
