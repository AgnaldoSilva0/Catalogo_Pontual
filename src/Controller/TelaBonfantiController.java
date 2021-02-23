package Controller;

import Model.GerenciadorDeTelas;
import Model.Listas;
import Model.Produtos;
import catalogopontual.CatalogoBonfanti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaBonfantiController implements Initializable {

    @FXML
    private Button btMenuInicial;
    @FXML
    private ImageView imgLogoBonfanti;
    @FXML
    private Button btPesquisarCodigo;
    @FXML
    private TextField tfCodigo;
    @FXML
    private TextField tfDescricao;
    @FXML
    private Button tfDescricaoPesquisar;
    @FXML
    private TableView<Produtos> tbTabelaPesquisa;
    @FXML
    private TableColumn<Produtos, String> clmCodigo;
    @FXML
    private TableColumn<Produtos, String> clmDescricao;
    @FXML
    private TableColumn<Produtos, Double> clmPrecoCompra;
    @FXML
    private TableColumn<Produtos, Double> clmPrecoVenda;
    @FXML
    private TableColumn<Produtos, Integer> clmIpi;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgLogoBonfanti.setImage(new Image("Icons/bonfanti.png"));
        btMenuInicial.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeTelas.voltarAoMenuInicial();
            CatalogoBonfanti.getStage().close();
        });

        btPesquisarCodigo.setOnMouseClicked((MouseEvent e) -> {
            onBtPesquisarCodigo();
        });
    }

    private void iniciarInitBonfanti() {
        clmCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmIpi.setCellValueFactory(new PropertyValueFactory("ipi"));
        clmPrecoCompra.setCellValueFactory(new PropertyValueFactory("preco"));
        clmPrecoVenda.setCellValueFactory(new PropertyValueFactory("precovenda"));
    }

    @FXML
    private void onBtPesquisarCodigo() {
        try {
            String i = tfCodigo.getText();
            for (Produtos t : Listas.listBonfanti) {
                if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                    iniciarInitBonfanti();
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
        for (Produtos t : Listas.listBonfanti) {
            if (t.getCodigo().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Produtos(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getPrecovenda(), t.getIpi()));
            }
        }
        return obsPesquisa;
    }

}
