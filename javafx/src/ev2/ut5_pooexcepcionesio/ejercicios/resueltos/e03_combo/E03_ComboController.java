package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e03_combo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class E03_ComboController implements Initializable {

	@FXML
	private ComboBox<String> comboPais;

	@FXML
	private Label lblSeleccion;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		comboPais.getItems().addAll("Espana", "Portugal", "Francia", "Italia");
		comboPais.getSelectionModel().selectFirst();
		actualizarEtiqueta();

		comboPais.setOnAction(event -> actualizarEtiqueta());
	}

	private void actualizarEtiqueta() {
		String pais = comboPais.getSelectionModel().getSelectedItem();
		lblSeleccion.setText("Pais seleccionado: " + (pais != null ? pais : "—"));
	}
}
