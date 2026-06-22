package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e01_saludo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class E01_SaludoController {

	@FXML
	private TextField campoNombre;

	@FXML
	private Label lblSaludo;

	@FXML
	private void onSaludarClick() {
		String nombre = campoNombre.getText().trim();
		if (nombre.isEmpty()) {
			lblSaludo.setText("Escribe un nombre, por favor.");
		} else {
			lblSaludo.setText("Hola, " + nombre + "!");
		}
	}
}
