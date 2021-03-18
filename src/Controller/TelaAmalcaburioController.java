package Controller;

import Comando.Alerta;
import Model.GerenciadorDeListasOrcamento;
import Model.GerenciadorDeTelas;
import Model.Listas;
import Model.Produtos;
import catalogopontual.CatalogoAmalcaburio;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaAmalcaburioController implements Initializable {

    @FXML
    private MenuItem btOrcamento;
    @FXML
    private Button btMenuInicial;
    @FXML
    private ImageView imgLogoAmalcaburio;
    @FXML
    private Button btPesquisarCodigo;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfDescricao;
    @FXML
    private Button tfDescricaoPesquisar, btIncrementar;
    @FXML
    private TableView<Produtos> tbTabelaPesquisa;
    @FXML
    protected TableColumn<Produtos, String> clmCodigo;
    @FXML
    protected TableColumn<Produtos, String> clmDescricao;
    @FXML
    protected TableColumn<Produtos, Double> clmPrecoCompra;
    @FXML
    protected TableColumn<Produtos, Double> clmPrecoVenda;
    @FXML
    protected TableColumn<Produtos, Integer> clmIpi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgLogoAmalcaburio.setImage(new Image("/Icons/AMLOGO.png"));
        btMenuInicial.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeTelas.voltarAoMenuInicial();
            CatalogoAmalcaburio.getStage().close();
        });
        
        btPesquisarCodigo.setOnMouseClicked((MouseEvent e) -> {
            onBtPesquisarCodigo();
        });
    }
    
    @FXML
    private void onBtActionOrcamento() {
        GerenciadorDeTelas.abrirTelaOrcamento();
    }

    private void iniciarInitAmalcaburio() {
        clmCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmIpi.setCellValueFactory(new PropertyValueFactory("ipi"));
        clmPrecoCompra.setCellValueFactory(new PropertyValueFactory("preco"));
        clmPrecoVenda.setCellValueFactory(new PropertyValueFactory("precovenda"));
    }

    @FXML private void onBtPesquisarCodigo() {
        try {
            String i = tfCodigo.getText();
            for (Produtos t : Listas.listAmalcaburio) {
                if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                    iniciarInitAmalcaburio();
                    tbTabelaPesquisa.setItems(Busca());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    private ObservableList<Produtos> Busca() {
        ObservableList<Produtos> obsPesquisa = FXCollections.observableArrayList();
        String i = tfCodigo.getText();
        for (Produtos t : Listas.listAmalcaburio) {
            if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Produtos(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getPrecovenda(), t.getIpi()));
            }
        }
        return obsPesquisa;
    }
    
    @FXML
    public void onBtActionAdicionarProduto() {
        try {
        String codigo = tbTabelaPesquisa.getSelectionModel().getSelectedItem().getCodigo();
        String descricao = tbTabelaPesquisa.getSelectionModel().getSelectedItem().getDescricao();
        double preco = tbTabelaPesquisa.getSelectionModel().getSelectedItem().getPreco();
        int quantidade = tbTabelaPesquisa.getSelectionModel().getSelectedItem().getQuantidade();
        double total = tbTabelaPesquisa.getSelectionModel().getSelectedItem().getTotal();
        GerenciadorDeListasOrcamento.incrementarProduto(1, codigo, descricao, preco, quantidade, total);
        onBtPesquisarCodigo();
        GerenciadorDeListasOrcamento.addProdutoArqOrcamento();
        } catch (java.lang.RuntimeException e) {
            Alerta.showAlert("Erro", "Nenhum Item Selecionado", "", Alert.AlertType.INFORMATION);
    }
}
}