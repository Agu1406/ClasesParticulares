package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Conjunto de cartas de la baraja espanola (40 cartas).
 */
public class Baraja {

	private static final String[] PALOS = {"Oros", "Copas", "Espadas", "Bastos"};

	private final Set<Carta> cartas = new HashSet<>();
	private final Random random = new Random();

	public Baraja() {
		for (String palo : PALOS) {
			for (int numero = 1; numero <= 10; numero++) {
				cartas.add(new Carta(palo, numero));
			}
		}
	}

	public void eliminar(Carta carta) {
		cartas.remove(carta);
	}

	public Carta elegirCartaAleatoria() {
		if (cartas.isEmpty()) {
			return null;
		}
		List<Carta> lista = new ArrayList<>(cartas);
		return lista.get(random.nextInt(lista.size()));
	}

	public boolean estaVacia() {
		return cartas.isEmpty();
	}
}
