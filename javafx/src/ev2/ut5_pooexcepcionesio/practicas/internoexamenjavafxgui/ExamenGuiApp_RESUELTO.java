package ev2.ut5_pooexcepcionesio.practicas.internoexamenjavafxgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Examen JavaFX — solucion de referencia.
 *
 * <p>Enunciado: {@code interno-examen-javafx-gui-enunciado.md}.</p>
 * <p>FXML: {@code ExamenGuiView_RESUELTO.fxml} · Controller: {@link ExamenGuiController_RESUELTO}.</p>
 */
public class ExamenGuiApp_RESUELTO extends Application {

	/**
	 * JavaFX llama a este metodo cuando la aplicacion arranca.
	 * Aqui preparamos la ventana principal ({@link Stage}) y mostramos la interfaz.
	 *
	 * @param stage ventana principal que nos entrega JavaFX
	 */
	@Override
	public void start(Stage stage) throws Exception {
		// FXMLLoader lee el .fxml y crea los controles del examen
		FXMLLoader loader = new FXMLLoader(
				ExamenGuiApp_RESUELTO.class.getResource("ExamenGuiView_RESUELTO.fxml"));
		// Scene = contenido de la ventana; loader.load() devuelve el nodo raiz del FXML
		Scene scene = new Scene(loader.load());
		stage.setTitle("Examen JavaFX");
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
