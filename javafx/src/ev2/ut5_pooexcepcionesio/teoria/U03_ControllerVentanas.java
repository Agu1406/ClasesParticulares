package ev2.ut5_pooexcepcionesio.teoria;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller FXML: metodos enlazados con {@code onAction} y apertura de una segunda ventana.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U03_ControllerVentanas {

	@FXML
	protected void onAbrirFormularioClick() {
		try {
			FXMLLoader loader = new FXMLLoader(
					U02_FXMLLoaderIntro.class.getResource("u03_formulario-view.fxml"));
			Scene scene = new Scene(loader.load());
			Stage ventanaSecundaria = new Stage();
			ventanaSecundaria.setTitle("Formulario");
			ventanaSecundaria.setScene(scene);
			ventanaSecundaria.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
