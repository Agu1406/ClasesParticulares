package ev1.ut2_controlflujometodos.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller de UT2: if/else y metodos desde eventos de botones.
 */
public class U01_CondicionalesYMetodosController {

	@FXML
	private TextField campoNumero;

	@FXML
	private Label lblParidad;

	@FXML
	private Label lblContador;

	private int contador = 0;

	@FXML
	private void onComprobarParidadClick() {
		try {
			int numero = Integer.parseInt(campoNumero.getText().trim());
			lblParidad.setText("Paridad: " + clasificarParidad(numero));
		} catch (NumberFormatException e) {
			lblParidad.setText("Paridad: numero no valido");
		}
	}

	@FXML
	private void onIncrementarClick() {
		incrementarContador();
		lblContador.setText("Contador: " + contador);
	}

	private static String clasificarParidad(int numero) {
		if (numero % 2 == 0) {
			return numero + " es par";
		}
		return numero + " es impar";
	}

	private void incrementarContador() {
		contador++;
	}
}
