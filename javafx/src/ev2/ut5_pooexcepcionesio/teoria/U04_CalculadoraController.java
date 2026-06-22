package ev2.ut5_pooexcepcionesio.teoria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Calculadora junior: suma, resta, multiplicacion y division con dos operandos.
 */
public class U04_CalculadoraController {

	@FXML
	private TextField display;

	private double primerNumero;
	private String operador;

	@FXML
	private void onDigito(ActionEvent event) {
		String tecla = ((Button) event.getSource()).getText();
		display.setText(display.getText() + tecla);
	}

	@FXML
	private void onOperador(ActionEvent event) {
		try {
			primerNumero = Double.parseDouble(display.getText());
			operador = ((Button) event.getSource()).getText();
			display.clear();
		} catch (NumberFormatException e) {
			display.setText("Error");
		}
	}

	@FXML
	private void onIgual() {
		try {
			double segundoNumero = Double.parseDouble(display.getText());
			double resultado = calcular(primerNumero, segundoNumero, operador);
			display.setText(String.valueOf(resultado));
		} catch (NumberFormatException e) {
			display.setText("Error");
		}
	}

	@FXML
	private void onLimpiar() {
		display.clear();
		primerNumero = 0;
		operador = "+";
	}

	private static double calcular(double a, double b, String op) {
		return switch (op) {
			case "+" -> a + b;
			case "-" -> a - b;
			case "*" -> a * b;
			case "/" -> b == 0 ? 0 : a / b;
			default -> b;
		};
	}
}
