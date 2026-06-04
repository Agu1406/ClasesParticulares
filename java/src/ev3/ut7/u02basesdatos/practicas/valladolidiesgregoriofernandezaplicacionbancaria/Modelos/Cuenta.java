package ev3.ut7.u02basesdatos.practicas.valladolidiesgregoriofernandezaplicacionbancaria.Modelos;

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
