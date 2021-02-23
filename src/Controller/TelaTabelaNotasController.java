package Controller;

import Comando.Regras;
import Enums.Cor;
import Enums.Modelos;
import Model.AlteracoesNota;
import Model.GerenciadorDeListas;
import Model.GerenciadorDeTelas;
import Model.Listas;
import Model.Nota;
import catalogopontual.TabelaNotas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaTabelaNotasController implements Initializable {

    @FXML private Button btMenuInicial, btPesquisarProprietario, btCadastrarNota, btFecharNota, btAddPasta, btVoltarInicio;
    @FXML private TextField tfProprietarioCadastro;
    @FXML private TextField tfPlacaCadastro;
    @FXML private TextField tfNotaCadastro;
    @FXML private ComboBox<Modelos> cbModelo;
    @FXML private ComboBox<Cor> cbCor;
    @FXML private TextField tfProprietarioPesquisar;
    @FXML private ImageView imgLogoCadastro, imgVoltar;
    @FXML private TableView<Nota> tbListaNotas;
    @FXML private TableColumn<Nota, String> clmProprietario;
    @FXML private TableColumn<Nota, String> clmPlaca;
    @FXML private TableColumn<Nota, Integer> clmNota;
    @FXML private TableColumn<Nota, String> clmModelo;
    @FXML private TableColumn<Nota, String> clmCor;
    @FXML private TableColumn<Nota, String> clmStatus;

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgVoltar.setImage(new Image("/Icons/voltar.png"));
        carregarRegras();
        cbModelo.getItems().addAll(Modelos.values());
        cbCor.getItems().addAll(Cor.values());
        btMenuInicial.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.voltarAoMenuInicial();
        TabelaNotas.getStage().close();
    }); 
        
    }    
    
    private void iniciarInitNotas() {
        clmProprietario.setCellValueFactory(new PropertyValueFactory("proprietario"));
        clmPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        clmNota.setCellValueFactory(new PropertyValueFactory("numNota"));
        clmModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        clmCor.setCellValueFactory(new PropertyValueFactory("cor"));
        clmStatus.setCellValueFactory(new PropertyValueFactory("status"));
    }
    
    private ObservableList<Nota> Busca() {
        ObservableList<Nota> obsPesquisa = FXCollections.observableArrayList();
        String i = tfProprietarioPesquisar.getText();
        for (Nota t : Listas.listNotas) {
            if (t.getProprietario().toUpperCase().contains(i.toUpperCase()) ||
                t.getPlaca().toUpperCase().contains(i.toUpperCase()) || 
                t.getModelo().toUpperCase().contains(i.toUpperCase()) || 
                t.getCor().toUpperCase().contains(i.toUpperCase()) ||
                t.getNumNota() == Integer.parseInt(i)) {
                obsPesquisa.add(new Nota(t.getProprietario(), t.getCor(), t.getModelo(), t.getPlaca(), t.getStatus(), t.getNumNota()));
            }
        }
        return obsPesquisa;
    }
    
    @FXML private void onBtPesquisarProprietario() {
        try {
            String i = tfProprietarioPesquisar.getText();
            for (Nota t : Listas.listNotas) {
                if (t.getProprietario().toUpperCase().contains(i.toUpperCase()) ||
                t.getPlaca().toUpperCase().contains(i.toUpperCase()) || 
                t.getModelo().toUpperCase().contains(i.toUpperCase()) || 
                t.getCor().toUpperCase().contains(i.toUpperCase()) ||
                t.getNumNota() == Integer.parseInt(i) ) {
                    iniciarInitNotas();
                    tbListaNotas.setItems(Busca());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }
    
    @FXML private void onBtCadastrarNota() {
        String proprietario = tfProprietarioCadastro.getText();
        String cor = String.valueOf(cbCor.getSelectionModel().getSelectedItem());
        String modelo = String.valueOf(cbModelo.getSelectionModel().getSelectedItem());
        String placa = tfPlacaCadastro.getText();
        int numNota = Integer.parseInt(tfNotaCadastro.getText());
        Listas.listNotas.add(new Nota(proprietario, cor, modelo, placa, "Aberto", numNota));
        GerenciadorDeListas.addNota();
    }
    
    @FXML private void onBtFinalizarNota() {
            int notaSelecionada = tbListaNotas.getSelectionModel().getSelectedItem().getNumNota();
            AlteracoesNota.finalizarNota(notaSelecionada);
            onBtPesquisarProprietario();
    }
    
    @FXML private void onBtAdicionarPastaNota() {
            int notaSelecionada = tbListaNotas.getSelectionModel().getSelectedItem().getNumNota();
            AlteracoesNota.addNotaPasta(notaSelecionada);
            onBtPesquisarProprietario();
    }
    
    @FXML private void onBtVoltarInicio() {
        GerenciadorDeTelas.voltarAoMenuInicial();
        TabelaNotas.getStage().close();
    }
    
    private void carregarRegras() {
        Regras.setTextFieldInteger(tfNotaCadastro);
    }
    
}
