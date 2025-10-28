package org.agu1406.clasesjavafxgradle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;

public class SecundaryController implements Initializable {
    
    @FXML
    private ComboBox<String> comboBoxOpciones;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Agregar las 3 opciones al ComboBox
        comboBoxOpciones.getItems().addAll("Option A", "Option B", "Option C");
    }
}

