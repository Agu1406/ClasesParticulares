package ev2.ut5_pooexcepcionesio.teoria;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller de un formulario con {@link Initializable} para preparar datos al cargar el FXML.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U03_FormularioController implements Initializable {

	@FXML
	private ComboBox<String> comboBoxOpciones;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		comboBoxOpciones.getItems().addAll("Opcion A", "Opcion B", "Opcion C");
	}
}
