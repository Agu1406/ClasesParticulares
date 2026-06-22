package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_03_detectives;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller — Ejercicio 3: archivar y cargar expedientes serializados.
 */
public class DetectivesController {

	private static final String ARCHIVO = "archivo_secreto.dat";
	private static final String CERRADO = "Caso Cerrado";
	private static final String RESUELTO = "Caso Resuelto";

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
		comboEstado.setItems(FXCollections.observableArrayList(CERRADO, RESUELTO));
		comboEstado.getSelectionModel().selectFirst();
	}

	@FXML
	private void onArchivarClick() {
		try {
			CasoDetective caso = leerCasoDesdeFormulario();
			List<CasoDetective> expedientes = cargarTodosLosExpedientes();
			expedientes.add(caso);
			guardarExpedientes(expedientes);
			lblEstado.setText("Archivado: " + caso);
		} catch (IllegalArgumentException e) {
			lblEstado.setText("Error: " + e.getMessage());
		} catch (IOException | ClassNotFoundException e) {
			lblEstado.setText("Error al guardar: " + e.getMessage());
		}
	}

	@FXML
	private void onCargarUltimoClick() {
		try {
			List<CasoDetective> expedientes = cargarTodosLosExpedientes();
			if (expedientes.isEmpty()) {
				lblEstado.setText("No hay expedientes archivados.");
				return;
			}
			CasoDetective ultimo = expedientes.get(expedientes.size() - 1);
			mostrarCasoEnFormulario(ultimo);
			lblEstado.setText("Cargado ultimo: " + ultimo);
		} catch (IOException | ClassNotFoundException e) {
			lblEstado.setText("Error al cargar: " + e.getMessage());
		}
	}

	private CasoDetective leerCasoDesdeFormulario() {
		String codigo = campoCodigo.getText().trim();
		String sospechoso = campoSospechoso.getText().trim();
		if (codigo.isEmpty() || sospechoso.isEmpty()) {
			throw new IllegalArgumentException("Completa codigo y sospechoso.");
		}
		boolean resuelto = RESUELTO.equals(comboEstado.getSelectionModel().getSelectedItem());
		return new CasoDetective(codigo, sospechoso, resuelto);
	}

	private void mostrarCasoEnFormulario(CasoDetective caso) {
		campoCodigo.setText(caso.getCodigoCaso());
		campoSospechoso.setText(caso.getNombreSospechoso());
		comboEstado.getSelectionModel().select(caso.isEstaResuelto() ? RESUELTO : CERRADO);
	}

	private List<CasoDetective> cargarTodosLosExpedientes() throws IOException, ClassNotFoundException {
		File fichero = new File(ARCHIVO);
		if (!fichero.exists()) {
			return new ArrayList<>();
		}
		List<CasoDetective> expedientes = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
			while (true) {
				try {
					expedientes.add((CasoDetective) ois.readObject());
				} catch (EOFException e) {
					break;
				}
			}
		}
		return expedientes;
	}

	private void guardarExpedientes(List<CasoDetective> expedientes) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
			for (CasoDetective caso : expedientes) {
				oos.writeObject(caso);
			}
		}
	}
}
