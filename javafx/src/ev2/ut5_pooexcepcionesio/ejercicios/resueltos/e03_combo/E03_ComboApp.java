package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e03_combo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class E03_ComboApp extends Application {

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("e03_combo-view.fxml"));
		Parent root = loader.load();
		stage.setScene(new Scene(root));
		stage.setTitle("E03 - ComboBox paises");
		stage.sizeToScene();
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
