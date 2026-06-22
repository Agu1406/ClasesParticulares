package ev2.ut5_pooexcepcionesio.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * U01 — Punto de entrada: {@link Stage} (ventana) y {@link Scene} (contenido).
 *
 * <p>El diseño visual esta en {@code u01_stage-view.fxml} (editar con Scene Builder).
 * La logica esta en {@link U01_StageYSceneController}.</p>
 */
public class U01_StageYSceneApp extends Application {

	/**
	 * JavaFX llama a este metodo cuando la aplicacion arranca.
	 * Aqui preparamos la ventana principal ({@link Stage}) y mostramos la interfaz.
	 *
	 * @param stage ventana principal que nos entrega JavaFX
	 */
	@Override
	public void start(Stage stage) throws IOException {
		// FXMLLoader lee el .fxml y crea los controles definidos en Scene Builder
		FXMLLoader loader = new FXMLLoader(getClass().getResource("u01_stage-view.fxml"));
		// Scene envuelve el contenido; aqui fijamos tambien ancho y alto iniciales
		stage.setScene(new Scene(loader.load(), 320, 200));
		stage.setTitle("U01 - Stage y Scene");
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
