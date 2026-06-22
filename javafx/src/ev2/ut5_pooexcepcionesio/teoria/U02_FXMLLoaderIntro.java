package ev2.ut5_pooexcepcionesio.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * U02 — Carga de interfaz con {@link FXMLLoader}: separar diseno (FXML) y logica (controller).
 *
 * <p>El diseño visual esta en {@code u02_hello-view.fxml} (editar con Scene Builder).
 * La logica esta en {@link U03_ControllerVentanas}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U02_FXMLLoaderIntro extends Application {

	/**
	 * JavaFX llama a este metodo cuando la aplicacion arranca.
	 * Aqui preparamos la ventana principal ({@link Stage}) y mostramos la interfaz.
	 *
	 * @param stage ventana principal que nos entrega JavaFX
	 */
	@Override
	public void start(Stage stage) throws IOException {
		// FXMLLoader lee el .fxml y crea los controles (Button, Label...)
		FXMLLoader loader = new FXMLLoader(
				U02_FXMLLoaderIntro.class.getResource("u02_hello-view.fxml"));
		// Scene = contenido de la ventana; loader.load() devuelve el nodo raiz del FXML
		Scene scene = new Scene(loader.load(), 320, 240);
		stage.setTitle("U02 - FXMLLoader");
		stage.setScene(scene);
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
