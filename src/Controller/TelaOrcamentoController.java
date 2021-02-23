package Controller;

import Comando.Alerta;
import Model.GerenciadorDeListasOrcamento;
import Model.GerenciadorDeTelas;
import Model.Listas;
import Model.Produtos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TelaOrcamentoController implements Initializable {
    
    @FXML
    private TableView<Produtos> tbTabela;

    @FXML
    private TableColumn<Produtos, Integer> clmQuantidade;

    @FXML
    private TableColumn<Produtos, String> clmCodigo;

    @FXML
    private TableColumn<Produtos, String> clmDescricao;

    @FXML
    private TableColumn<Produtos, Double> clmPreco;

    @FXML
    private TableColumn<Produtos, Double> clmTotal;

    @FXML
    private Button btFechar, btEnviar, btSalvarOrcamento, btAdicionar, btReduzir;

    @FXML
    private Label lbTotal;

    @FXML
    private Button btRemover;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btFechar.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeTelas.fecharTelaOrcamento();
        });
        btSalvarOrcamento.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeListasOrcamento.salvarArquivoOrcamento();
        });
        tbTabela.setItems(ObsMetodo());
        iniciarInitTabela();
        valorTotal();
    }    
    
    private void iniciarInitTabela() {
        clmCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmQuantidade.setCellValueFactory(new PropertyValueFactory("quantidade"));
        clmPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        clmTotal.setCellValueFactory(new PropertyValueFactory("total"));
    }
    
    private ObservableList<Produtos> ObsMetodo() {
        ObservableList<Produtos> obs = FXCollections.observableArrayList();
            for (Produtos t : Listas.listOrcamento) {
                obs.add(new Produtos(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getQuantidade(), t.getTotal()));
		}
		return obs;
	}
    
    @FXML
    public void onBtActionAdicionarProduto() {
        try {
            String codigo = tbTabela.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbTabela.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbTabela.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbTabela.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbTabela.getSelectionModel().getSelectedItem().getTotal();
            GerenciadorDeListasOrcamento.incrementarProduto(codigo, descricao, preco, quantidade, total);
            GerenciadorDeListasOrcamento.addProdutoArqOrcamento();
            tbTabela.setItems(ObsMetodo());
            valorTotal();
        } catch (java.lang.RuntimeException e){
            Alerta.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja excluir", Alert.AlertType.INFORMATION);
        } 
        }
        
    
    @FXML
    public void onBtActionDecrementarProduto() {
        try {
            String codigo = tbTabela.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbTabela.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbTabela.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbTabela.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbTabela.getSelectionModel().getSelectedItem().getTotal();
            GerenciadorDeListasOrcamento.decrementarProduto(codigo, descricao, preco, quantidade, total);
            GerenciadorDeListasOrcamento.addProdutoArqOrcamento();
            tbTabela.setItems(ObsMetodo());
            valorTotal();
        } catch (java.lang.RuntimeException e){
            Alerta.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja diminuir", Alert.AlertType.INFORMATION);
        }
        }
    
    @FXML
    public void onBtActionRemoverProduto() {
        try {
            String codigo = tbTabela.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbTabela.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbTabela.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbTabela.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbTabela.getSelectionModel().getSelectedItem().getTotal();
            GerenciadorDeListasOrcamento.removerProduto(codigo, descricao, preco, quantidade, total);
            GerenciadorDeListasOrcamento.addProdutoArqOrcamento();
            tbTabela.setItems(ObsMetodo());
            valorTotal();
        } catch (java.lang.RuntimeException e){
            Alerta.showAlert("Erro", "Nenhum Item Selecionado", "Selecione o produto que deseja remover", Alert.AlertType.INFORMATION);
        }
        }
    
    public void valorTotal() {
        double total = 0;
        for (Produtos produto : Listas.listOrcamento) {
            total = total + produto.getTotal();
        }
       lbTotal.setText(String.valueOf(total));
    }
        
    }


