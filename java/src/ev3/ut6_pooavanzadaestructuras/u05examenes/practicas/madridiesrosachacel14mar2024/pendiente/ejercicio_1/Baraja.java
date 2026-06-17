package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.pendiente.ejercicio_1;

import java.util.HashSet;
import java.util.Set;

/**
 * Conjunto de cartas de la baraja espanola (40 cartas).
 */
public class Baraja {

	private static final String[] PALOS = {"Oros", "Copas", "Espadas", "Bastos"};

	private final Set<Carta> cartas = new HashSet<>();

	public Baraja() {
		for (String palo : PALOS) {
			for (int numero = 1; numero <= 10; numero++) {
				cartas.add(new Carta(palo, numero));
			}
		}
	}

	// TODO: metodos para eliminar cartas, elegir aleatoria y comprobar si esta vacia
}
