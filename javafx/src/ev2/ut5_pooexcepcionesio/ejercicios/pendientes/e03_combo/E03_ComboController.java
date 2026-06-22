package ev2.ut5_pooexcepcionesio.ejercicios.pendientes.e03_combo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * E03 — Rellenar ComboBox en initialize() y actualizar lblSeleccion al elegir pais.
 */
public class E03_ComboController implements Initializable {

	@FXML
	private ComboBox<String> comboPais;

	@FXML
	private Label lblSeleccion;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO: addAll "Espana", "Portugal", "Francia", "Italia"
		// TODO: listener on comboPais -> actualizar lblSeleccion
	}
}
