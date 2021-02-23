package catalogopontual;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Orcamento extends Application {
    
    private static Stage stage;
    
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaOrcamento.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Orçamento");
        stage.getIcons().add(new Image("/Icons/espa.jpg"));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Orcamento.stage = stage;
    }
}