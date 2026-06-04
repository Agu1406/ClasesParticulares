package ev3.ut7.u02basesdatos.practicas.valladolidiesgregoriofernandezaplicacionbancaria.Modelos;

public class Cliente {
	private String usuario;
	private String password;
	
	public Cliente(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}
