/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ImprimirJasper.DadosSaida;
import ImprimirJasper.ImpressaoOrcamento;
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
public class TelaFinalizarController implements Initializable {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfModelo;

    @FXML
    private TextField tfPlaca;

    @FXML
    private TextField tfValorPago;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEndereco;

    @FXML
    private TextField tfCidade;
    
    @FXML
    private TextField tfPagamento;

    @FXML
    private Button btImprimir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void finalizarCompra() {
        DadosSaida.setCliente(tfNome.getText());
        DadosSaida.setEndereco(tfEndereco.getText());
        DadosSaida.setCpf(tfCpf.getText());
        DadosSaida.setCidade(tfCidade.getText());
        DadosSaida.setTelefone(tfTelefone.getText());
        DadosSaida.setModelo(tfModelo.getText());
        DadosSaida.setPlaca(tfPlaca.getText());
        DadosSaida.setComDesconto(Double.parseDouble(tfValorPago.getText()));
        DadosSaida.setPagamento(tfPagamento.getText());
        ImpressaoOrcamento.addAtributoLista();
        ImpressaoOrcamento.imprimir();
    }
    
}
