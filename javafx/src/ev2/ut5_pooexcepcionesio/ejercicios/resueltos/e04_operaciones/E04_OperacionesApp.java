package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e04_operaciones;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class E04_OperacionesApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("e04_operaciones-view.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("E04 - Operaciones basicas");
		stage.sizeToScene();
		stage.setMinWidth(stage.getWidth());
		stage.setMinHeight(stage.getHeight());
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
