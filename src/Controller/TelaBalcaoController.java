/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Comando.Alerta;
import ImprimirJasper.DadosSaida;
import ImprimirJasper.ImpressaoOrcamento;
import Model.Cliente;
import Model.GerenciadorDeListasOrcamento;
import Model.GerenciadorDeTelas;
import Model.Listas;
import Model.Produtos;
import catalogopontual.Balcao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class TelaBalcaoController implements Initializable {

    @FXML
    private TableView<Produtos> tbProdutos;

    @FXML
    private TableColumn<Produtos, String> clmCodigoP;

    @FXML
    private TableColumn<Produtos, String> clmDescricaoP;

    @FXML
    private TableColumn<Produtos, Double> clmPrecoCompra;

    @FXML
    private TableColumn<Produtos, Double> clmPrecoVenda;

    @FXML
    private TableView<Produtos> tbOrcamento;

    @FXML
    private TableColumn<Produtos, String> clmCodigoO;

    @FXML
    private TableColumn<Produtos, String> clmDescricaoO;

    @FXML
    private TableColumn<Produtos, Integer> clmQuantidadeO;

    @FXML
    private TableColumn<Produtos, Double> clmPrecoO;

    @FXML
    private TableColumn<Produtos, Double> clmTotalO;

    @FXML
    private TableView<Cliente> tbCliente;

    @FXML
    private TableColumn<Cliente, String> clmCliente;

    @FXML
    private TableColumn<Cliente, String> clmNumero;

    @FXML
    private TableColumn<Cliente, String> clmEndereco;

    @FXML
    private TableColumn<Cliente, String> clmCnpj;

    @FXML
    private TableColumn<Cliente, String> clmCidade;

    @FXML
    private Button btVendaAvulsa;

    @FXML
    private Button btFinalizar;

    @FXML
    private Button btAdicionarOrcamento;

    @FXML
    private Button btPesquisar;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private Button btAdicionarItemAvulso;

    @FXML
    private Button btCadastrarItem;

    @FXML
    private Button btMenu;

    @FXML
    private Button btImcrementar;

    @FXML
    private Button btDecrementar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btEditarValor;

    @FXML
    private Button btSalvarOrcamento;

    @FXML
    private MenuItem miCarregarOrcamento;

    @FXML
    private MenuItem miAtualizarOrcamento;

    @FXML
    private Label lbTotal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btMenu.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeTelas.voltarAoMenuInicial();
            Balcao.getStage().close();
        });
        btImcrementar.setOnMouseClicked((MouseEvent e) -> {
            modificadorLista(1);
        });
        btDecrementar.setOnMouseClicked((MouseEvent e) -> {
            modificadorLista(2);
        });
        btExcluir.setOnMouseClicked((MouseEvent e) -> {
            modificadorLista(3);
        });
        btSalvarOrcamento.setOnMouseClicked((MouseEvent e) -> {
            GerenciadorDeListasOrcamento.salvarOrcamentoBalcao();
        });
        carregarTabelas();
        total();
    }

    @FXML private void onBtPesquisarCodigo() {
        try {
            String i = tfPesquisar.getText();
            for (Produtos t : Listas.listProduto) {
                if (t.getCodigo().toUpperCase().contains(i.toUpperCase()) || t.getDescricao().toUpperCase().contains(i.toUpperCase())) {
                    iniciarInitTabelaProduto();
                    tbProdutos.setItems(Busca());
                }
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }
    
    private ObservableList<Produtos> Busca() {
        ObservableList<Produtos> obsPesquisa = FXCollections.observableArrayList();
        String i = tfPesquisar.getText();
        for (Produtos t : Listas.listProduto) {
            if (t.getCodigo().toUpperCase().contains(i.toUpperCase()) || t.getDescricao().toUpperCase().contains(i.toUpperCase())) {
                obsPesquisa.add(new Produtos(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getPrecovenda(), t.getIpi()));
            }
        }
        return obsPesquisa;
    }
    
    @FXML
    private void btActionCarregarOrcamento() {
        Listas.listOrcamentoBalcao.clear();
        GerenciadorDeListasOrcamento.carregarOrcamentoArquivo();
        tbOrcamento.setItems(ObsMetodoBalcao());
        iniciarInitTabelaOrcamento();
        total();
    }

    private void iniciarInitTabelaOrcamento() {
        clmCodigoO.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricaoO.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmQuantidadeO.setCellValueFactory(new PropertyValueFactory("quantidade"));
        clmPrecoO.setCellValueFactory(new PropertyValueFactory("preco"));
        clmTotalO.setCellValueFactory(new PropertyValueFactory("total"));
    }

    private ObservableList<Produtos> ObsMetodoBalcao() {
        ObservableList<Produtos> obs = FXCollections.observableArrayList();
        for (Produtos t : Listas.listOrcamentoBalcao) {
            obs.add(new Produtos(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getQuantidade(), t.getTotal()));
        }
        return obs;
    }

    private void iniciarInitTabelaCliente() {
        clmCliente.setCellValueFactory(new PropertyValueFactory("nome"));
        clmNumero.setCellValueFactory(new PropertyValueFactory("numero"));
        clmEndereco.setCellValueFactory(new PropertyValueFactory("endereco"));
        clmCnpj.setCellValueFactory(new PropertyValueFactory("cnpj"));
        clmCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
    }

    private ObservableList<Cliente> ObsMetodoCliente() {
        ObservableList<Cliente> obs = FXCollections.observableArrayList();
        for (Cliente t : Listas.listCliente) {
            obs.add(new Cliente(t.getNome(), t.getCnpj(), t.getEndereco(), t.getNumero(), t.getCidade()));
        }
        return obs;
    }

    private void iniciarInitTabelaProduto() {
        clmCodigoP.setCellValueFactory(new PropertyValueFactory("codigo"));
        clmDescricaoP.setCellValueFactory(new PropertyValueFactory("descricao"));
        clmPrecoCompra.setCellValueFactory(new PropertyValueFactory("preco"));
        clmPrecoVenda.setCellValueFactory(new PropertyValueFactory("precovenda"));
    }

    private ObservableList<Produtos> ObsMetodoProduto() {
        ObservableList<Produtos> obs = FXCollections.observableArrayList();
        for (Produtos t : Listas.listProduto) {
            obs.add(new Produtos(t.getCodigo(), t.getDescricao(), t.getPreco(), t.getPrecovenda()));
        }
        return obs;
    }

    @FXML
    private void onBtActionAddProdutoOrcamento() {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        String codigo = tbProdutos.getSelectionModel().getSelectedItem().getCodigo();
        GerenciadorDeListasOrcamento.addProdutoOrcamento(codigo, quantidade);
        tbOrcamento.setItems(ObsMetodoBalcao());
        iniciarInitTabelaOrcamento();
        total();
    }

    private void modificadorLista(int decisao) {
        try {
            String codigo = tbOrcamento.getSelectionModel().getSelectedItem().getCodigo();
            String descricao = tbOrcamento.getSelectionModel().getSelectedItem().getDescricao();
            double preco = tbOrcamento.getSelectionModel().getSelectedItem().getPreco();
            int quantidade = tbOrcamento.getSelectionModel().getSelectedItem().getQuantidade();
            double total = tbOrcamento.getSelectionModel().getSelectedItem().getTotal();
            switch (decisao) {
                case 1:
                    GerenciadorDeListasOrcamento.incrementarProduto(2, codigo, descricao, preco, quantidade, total);
                    tbOrcamento.setItems(ObsMetodoBalcao());
                    total();
                    break;
                case 2:
                    GerenciadorDeListasOrcamento.decrementarProduto(2, codigo, descricao, preco, quantidade, total);
                    tbOrcamento.setItems(ObsMetodoBalcao());
                    total();
                    break;
                case 3:
                    GerenciadorDeListasOrcamento.removerProduto(2, codigo, descricao, preco, quantidade, total);
                    tbOrcamento.setItems(ObsMetodoBalcao());
                    total();
            }
        } catch (Exception e) {
            Alerta.showAlert("Erro", "Selecione Um Item", "", Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    private void onBtActionAddProdutoAvulso() {
        GerenciadorDeTelas.abrirTelaProdutoAvulso();
        total();
    }

    @FXML
    private void onBtActionAtualizarOrcamento() {
        tbOrcamento.setItems(ObsMetodoBalcao());
        iniciarInitTabelaOrcamento();
        total();
    }
    
    @FXML
    private void onBtActionImprimirRelatorio() {
        DadosSaida.setCliente(tbCliente.getSelectionModel().getSelectedItem().getNome());
        DadosSaida.setEndereco(tbCliente.getSelectionModel().getSelectedItem().getEndereco());
        DadosSaida.setCpf(tbCliente.getSelectionModel().getSelectedItem().getCnpj());
        DadosSaida.setCidade(tbCliente.getSelectionModel().getSelectedItem().getCidade());
        DadosSaida.setTelefone(tbCliente.getSelectionModel().getSelectedItem().getNumero());
        DadosSaida.setModelo(JOptionPane.showInputDialog("Modelo"));
        DadosSaida.setPlaca(JOptionPane.showInputDialog("Placa"));
        ImpressaoOrcamento.addAtributoLista();
        ImpressaoOrcamento.imprimir();
    }
    
    @FXML
    private void onBtActionImprimirRelatorioAvulso() {
        DadosSaida.setCliente(JOptionPane.showInputDialog("Nome"));
        DadosSaida.setEndereco("");
        DadosSaida.setCpf("");
        DadosSaida.setCidade("");
        DadosSaida.setTelefone("");
        DadosSaida.setModelo(JOptionPane.showInputDialog("Modelo"));
        DadosSaida.setPlaca(JOptionPane.showInputDialog("Placa"));
        ImpressaoOrcamento.addAtributoLista();
        ImpressaoOrcamento.imprimir();
    }

    private void total() {
        lbTotal.setText(String.valueOf(GerenciadorDeListasOrcamento.calcularTotal(0)));
    }
    
    private void carregarTabelas() {
        tbOrcamento.setItems(ObsMetodoBalcao());
        tbCliente.setItems(ObsMetodoCliente());
        iniciarInitTabelaOrcamento();
        iniciarInitTabelaCliente();
    }

}
