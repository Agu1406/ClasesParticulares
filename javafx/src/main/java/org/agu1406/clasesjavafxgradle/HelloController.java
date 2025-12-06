package org.agu1406.clasesjavafxgradle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {
    
    @FXML
    protected void onHelloButtonClick() {
        try {
            // Cargar el FXML del formulario
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("secundary-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Crear una nueva ventana (Stage)
            Stage secondaryStage = new Stage();
            secondaryStage.setTitle("Formulario");
            secondaryStage.setScene(scene);
            secondaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}