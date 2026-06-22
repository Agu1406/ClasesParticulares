package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_03_detectives;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Ejercicio 3 — Recuperación ordinaria: archivo digital de detectives.
 */
public class DetectivesApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("detectives-view.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("Agencia de Detectives — Archivo digital");
		stage.sizeToScene();
		stage.setMinWidth(stage.getWidth());
		stage.setMinHeight(stage.getHeight());
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
