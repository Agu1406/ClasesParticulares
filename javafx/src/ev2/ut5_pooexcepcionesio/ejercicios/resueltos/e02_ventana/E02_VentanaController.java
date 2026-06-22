package ev2.ut5_pooexcepcionesio.ejercicios.resueltos.e02_ventana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class E02_VentanaController {

	@FXML
	private void onAbrirAvisoClick() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("e02_aviso-view.fxml"));
			Scene scene = new Scene(loader.load());
			Stage aviso = new Stage();
			aviso.setTitle("Aviso");
			aviso.setScene(scene);
			aviso.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
