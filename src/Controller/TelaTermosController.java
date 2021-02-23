package Controller;

import Model.GerenciadorDeTelas;
import catalogopontual.TabelaNotas;
import catalogopontual.Termos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaTermosController implements Initializable {
    
    @FXML private Button btVoltar;
    @FXML private ImageView imgVoltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
        GerenciadorDeTelas.voltarAoMenuInicial();
        Termos.getStage().close();
    }); 
        
    }    
    
}
