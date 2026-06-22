package ev2.ut5_pooexcepcionesio.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * U04 — Calculadora basica junior (FXML + Scene Builder).
 *
 * <p>El diseño visual esta en {@code u04_calculadora-view.fxml}.
 * La logica de los botones esta en {@link U04_CalculadoraController}.</p>
 */
public class U04_CalculadoraApp extends Application {

	/**
	 * JavaFX llama a este metodo cuando la aplicacion arranca.
	 * Aqui preparamos la ventana principal ({@link Stage}) y mostramos la interfaz.
	 *
	 * @param stage ventana principal que nos entrega JavaFX
	 */
	@Override
	public void start(Stage stage) throws IOException {
		// FXMLLoader lee el .fxml y crea los controles de la calculadora
		FXMLLoader loader = new FXMLLoader(getClass().getResource("u04_calculadora-view.fxml"));
		// Scene envuelve el contenido; aqui fijamos tambien ancho y alto iniciales
		stage.setScene(new Scene(loader.load(), 280, 360));
		stage.setTitle("U04 - Calculadora basica");
		stage.setResizable(false); // la ventana no se puede redimensionar
		stage.show(); // hace visible la ventana
	}

	/**
	 * Metodo main habitual. {@link #launch(String...)} inicia el ciclo de vida JavaFX
	 * y acaba llamando a {@link #start(Stage)}.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
