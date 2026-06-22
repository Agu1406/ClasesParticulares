package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e01_saludo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class E01_SaludoApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("e01_saludo-view.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("E01 - Saludo personalizado");
		stage.sizeToScene();
		stage.setMinWidth(stage.getWidth());
		stage.setMinHeight(stage.getHeight());
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
