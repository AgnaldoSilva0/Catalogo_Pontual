package catalogopontual;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Contatos extends Application {
    private static Stage stage;
    
    public static void main(String[] args) {
        
        launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaListaTelefonica.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Lista Telefônica");
        stage.setScene(scene);
        stage.getIcons().add(new Image("/Icons/termos.png"));
        stage.setResizable(false);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Contatos.stage = stage;
    }
}