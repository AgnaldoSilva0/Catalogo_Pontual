/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogopontual;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class Balcao extends Application {
    
    private static Stage stage;
    
    public static void main(String[] args) {
       launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TelaBalcao.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Pontual Peças");
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
        Balcao.stage = stage;
    }
}