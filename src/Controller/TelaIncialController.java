package Controller;

import Model.GerenciadorDeListas;
import Model.GerenciadorDeTelas;
import catalogopontual.CatalogoPontual;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaIncialController implements Initializable {

    @FXML private ImageView imgBackground, logoBonfanti, logoCadastro, logoTabelaNotas, logoListaTelefonica, logoTermos, logoCaminhoes;
    @FXML private Button btCatAmalcaburio, btCatBonfanti, btTabelaNotas, btFecharPrograma, btCadastrarProduto, btTermosUso, btListaTelefonica, btBalcao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarImagens();
        GerenciadorDeListas.carregarTodasAsListas();
        
        btCatAmalcaburio.setOnMouseClicked((MouseEvent e) -> {
        GerenciadorDeTelas.abrirTelaAmalcaburio();
    });
        
        btCatBonfanti.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.abrirTelaBonfanti();
    }); 
        
        btTabelaNotas.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.abrirTelaNotas();
    });  
        
        btCadastrarProduto.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.abrirTelaCadastrarProduto();
    });  
        
        btTermosUso.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.abrirTelaTermos();
    });  
        
        btListaTelefonica.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.abrirTelaContatos();
    });  
        
        btFecharPrograma.setOnMouseClicked((MouseEvent e)->{
        CatalogoPontual.getStage().close();
    });  
        
        btBalcao.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.abrirTelaBalcao();
    });  
        
    }        

    private void carregarImagens() {
        imgBackground.setImage(new Image("/Icons/AMLOGO.png"));
        logoBonfanti.setImage(new Image("/Icons/bonfanti.png"));
        logoCadastro.setImage(new Image("/Icons/logoCadastro.png"));
        logoTabelaNotas.setImage(new Image("/Icons/logoNotasF.png"));
        logoListaTelefonica.setImage(new Image("/Icons/logoLista.png"));
        logoTermos.setImage(new Image("/Icons/termos.png"));
        logoCaminhoes.setImage(new Image("/Icons/logoCaminhoes.png"));
    }
    
}
