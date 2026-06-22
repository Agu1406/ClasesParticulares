package ev1.ut3_stringsyenvolventes.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller de UT3: metodos de String y envolventes.
 */
public class U01_StringsYEnvolventesController {

	@FXML
	private TextField campoTexto;

	@FXML
	private Label lblResultado;

	@FXML
	private void onMayusculasClick() {
		lblResultado.setText("Resultado: " + campoTexto.getText().toUpperCase());
	}

	@FXML
	private void onLongitudClick() {
		lblResultado.setText("Resultado: length=" + campoTexto.getText().length());
	}

	@FXML
	private void onTrimClick() {
		String recortado = campoTexto.getText().trim();
		campoTexto.setText(recortado);
		lblResultado.setText("Resultado: trim -> '" + recortado + "'");
	}

	@FXML
	private void onParseIntClick() {
		try {
			int valor = Integer.parseInt(campoTexto.getText().trim());
			lblResultado.setText("Resultado: parseInt=" + valor);
		} catch (NumberFormatException e) {
			lblResultado.setText("Resultado: escribe un entero (ej. 42)");
		}
	}
}
