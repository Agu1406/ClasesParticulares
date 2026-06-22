package ev1.ut1_fundamentosjava.teoria;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller de UT1: conversion de tipos primitivos desde la GUI.
 */
public class U01_TiposYConversionController {

	@FXML
	private TextField campoEntero;

	@FXML
	private TextField campoDecimal;

	@FXML
	private Label lblResultado;

	@FXML
	private void onConvertirClick() {
		try {
			int entero = Integer.parseInt(campoEntero.getText().trim());
			double decimal = Double.parseDouble(campoDecimal.getText().trim());
			int parteEntera = (int) decimal;
			double suma = entero + decimal;

			lblResultado.setText(
					"int=" + entero
							+ " | double=" + decimal
							+ " | (int)decimal=" + parteEntera
							+ " | int+double=" + suma);
		} catch (NumberFormatException e) {
			lblResultado.setText("Error: introduce numeros validos");
		}
	}
}
