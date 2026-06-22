package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e04_operaciones;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class E04_OperacionesController {

	@FXML
	private TextField campoA;

	@FXML
	private TextField campoB;

	@FXML
	private Label lblResultado;

	@FXML
	private void onSumarClick() {
		calcular('+');
	}

	@FXML
	private void onRestarClick() {
		calcular('-');
	}

	@FXML
	private void onMultiplicarClick() {
		calcular('*');
	}

	@FXML
	private void onDividirClick() {
		calcular('/');
	}

	private void calcular(char operador) {
		try {
			double a = Double.parseDouble(campoA.getText().trim());
			double b = Double.parseDouble(campoB.getText().trim());
			double resultado = switch (operador) {
				case '+' -> a + b;
				case '-' -> a - b;
				case '*' -> a * b;
				case '/' -> {
					if (b == 0) {
						throw new ArithmeticException("division por cero");
					}
					yield a / b;
				}
				default -> 0;
			};
			lblResultado.setText("Resultado: " + resultado);
		} catch (NumberFormatException e) {
			lblResultado.setText("Resultado: numeros no validos");
		} catch (ArithmeticException e) {
			lblResultado.setText("Resultado: no se puede dividir por cero");
		}
	}
}
