package castillaleon.valladolid.iesgregoriofernandez.aplicacion_bancaria.modelos;

public class Cuenta {
	private String ISBN;
	private String titular;
	private Double saldo;
	public Cuenta(String iSBN, String titular, Double saldo) {
		this.ISBN = iSBN;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	
}
