package ev2.ut5_pooexcepcionesio.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller de U01: primer evento de boton sobre un Label.
 */
public class U01_StageYSceneController {

	@FXML
	private Label lblTitulo;

	@FXML
	private void onPulsarClick() {
		lblTitulo.setText("Evento de boton recibido");
	}
}
