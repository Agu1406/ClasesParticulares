package recuperacionordinaria.internorecuperacionordinaria.pendiente.ejercicio_03_detectives;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** TODO: cargar detectives-view.fxml */
public class DetectivesApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("detectives-view.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("Agencia de Detectives — Archivo digital");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
