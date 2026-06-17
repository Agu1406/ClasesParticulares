package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.pendiente.ejercicio_1;

import java.util.Objects;

/**
 * Carta de la baraja espanola: palo y numero del 1 al 10.
 */
public class Carta {

	private final String palo;
	private final int numero;

	public Carta(String palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro) {
			return true;
		}
		if (!(otro instanceof Carta carta)) {
			return false;
		}
		return numero == carta.numero && Objects.equals(palo, carta.palo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(palo, numero);
	}

	@Override
	public String toString() {
		return numero + " de " + palo;
	}
}
