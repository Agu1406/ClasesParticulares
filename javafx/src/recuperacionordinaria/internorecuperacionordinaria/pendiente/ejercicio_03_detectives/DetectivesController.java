package recuperacionordinaria.internorecuperacionordinaria.pendiente.ejercicio_03_detectives;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * TODO Apartado A: enlazar campos del FXML.
 * TODO Apartado B: onArchivarClick — serializar CasoDetective en archivo_secreto.dat.
 * TODO Apartado C: onCargarUltimoClick — deserializar ultimo caso y actualizar UI.
 */
public class DetectivesController {

	@FXML
	private TextField campoCodigo;

	@FXML
	private TextField campoSospechoso;

	@FXML
	private ComboBox<String> comboEstado;

	@FXML
	private Label lblEstado;

	@FXML
	private void initialize() {
		// TODO: comboEstado -> "Caso Cerrado", "Caso Resuelto"
	}

	@FXML
	private void onArchivarClick() {
		// TODO
	}

	@FXML
	private void onCargarUltimoClick() {
		// TODO
	}
}
