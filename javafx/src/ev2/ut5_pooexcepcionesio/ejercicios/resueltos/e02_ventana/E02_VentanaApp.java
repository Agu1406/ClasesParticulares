package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e02_ventana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class E02_VentanaApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("e02_main-view.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("E02 - Ventana secundaria");
		stage.sizeToScene();
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
