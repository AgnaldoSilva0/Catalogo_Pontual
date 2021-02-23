package Controller;

import Model.GerenciadorDeTelas;
import Model.Listas;
import Model.Contato;
import Model.GerenciadorDeListas;
import catalogopontual.Contatos;
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
import javafx.scene.input.MouseEvent;

public class TelaListaTelefonicaController implements Initializable {
    
    @FXML private TableView<Contato> tbContatos;
    @FXML private TableColumn<Contato, String> clmNome;
    @FXML private TableColumn<Contato, Integer> clmNumero;
    @FXML private TableColumn<Contato, String> clmReferencia;
    @FXML private TableColumn<Contato, Integer> clmDdd;
    @FXML private Button btPesquisar, btVoltarTelaInicial;
    @FXML private TextField tfPesquisar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btVoltarTelaInicial.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeTelas.voltarAoMenuInicial();
            Contatos.getStage().close();
        });
        
    }    
    
    private void iniciarInitContatos() {
        clmNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clmNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        clmReferencia.setCellValueFactory(new PropertyValueFactory("referencia"));
        clmDdd.setCellValueFactory(new PropertyValueFactory("ddd"));
    }
    
    private ObservableList<Contato> Busca() {
        ObservableList<Contato> obsPesquisa = FXCollections.observableArrayList();
        String i = tfPesquisar.getText();
        for (Contato t : Listas.listContatos) {
            if (t.getNome().toUpperCase().contains(i.toUpperCase()) || 
                t.getReferencia().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Contato(t.getNome(), t.getNumero(), t.getReferencia(), t.getDdd()));
                GerenciadorDeListas.addArqContato();
            }
        }
        return obsPesquisa;
    }
    
    @FXML private void onBtPesquisarContato() {
        try {
            String i = tfPesquisar.getText();
            for (Contato t : Listas.listContatos) {
                if (t.getNome().toUpperCase().contains(i.toUpperCase()) || 
                t.getReferencia().toUpperCase().contains(i.toUpperCase()) ) {
                iniciarInitContatos();
                tbContatos.setItems(Busca());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    
}}
