package ev1.ut1_fundamentosjava.teoria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * EV1 UT1 — Punto de entrada de la aplicacion JavaFX.
 *
 * <p>El diseño visual esta en {@code u01_tipos-view.fxml} (editar con Scene Builder).
 * La logica de botones y campos esta en {@link U01_TiposYConversionController}.</p>
 */
public class U01_TiposYConversionApp extends Application {

	/**
	 * JavaFX llama a este metodo cuando la aplicacion arranca.
	 * Aqui preparamos la ventana principal ({@link Stage}) y mostramos la interfaz.
	 *
	 * @param stage ventana principal que nos entrega JavaFX
	 */
	@Override
	public void start(Stage stage) throws IOException {
		// FXMLLoader lee el .fxml y crea los controles (Button, Label, TextField...)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("u01_tipos-view.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("EV1 UT1 — Tipos y conversion");
		stage.sizeToScene(); // ajusta la ventana al tamano del FXML
		stage.setMinWidth(stage.getWidth());
		stage.setMinHeight(stage.getHeight());
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
