package ev2.ut5_pooexcepcionesio.practicas.internoexamenjavafxgui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Examen JavaFX — plantilla pendiente.
 *
 * <p>Enunciado: {@code interno-examen-javafx-gui-enunciado.md}.</p>
 * <p>Completa {@link #start(Stage)} siguiendo el patron de {@link ExamenGuiApp_RESUELTO}.</p>
 */
public class ExamenGuiApp_SIN_RESOLVER extends Application {

	/**
	 * JavaFX llama a este metodo cuando la aplicacion arranca.
	 * Debes cargar {@code ExamenGuiView.fxml} con {@link javafx.fxml.FXMLLoader}
	 * y asignarlo a un {@link javafx.scene.Scene} en el {@link Stage}.
	 *
	 * @param stage ventana principal que nos entrega JavaFX
	 */
	@Override
	public void start(Stage stage) {
		// TODO: FXMLLoader loader = new FXMLLoader(getClass().getResource("ExamenGuiView.fxml"));
		// TODO: stage.setScene(new Scene(loader.load()));
		// TODO: stage.setTitle("Examen JavaFX");
		// TODO: stage.show();
	}

	/**
	 * Metodo main habitual. {@link #launch(String...)} inicia el ciclo de vida JavaFX
	 * y acaba llamando a {@link #start(Stage)}.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
