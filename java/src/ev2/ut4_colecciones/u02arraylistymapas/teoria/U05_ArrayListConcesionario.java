package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;

/**
 * Ejercicio de teoria real: gestionar un concesionario con {@link ArrayList}.
 * Buscar, filtrar, vender y contar coches en el stock.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_ArrayListConcesionario {

	static class Coche {

		private final String marca;
		private final String modelo;
		private final double precio;

		public Coche(String marca, String modelo, double precio) {
			this.marca = marca;
			this.modelo = modelo;
			this.precio = precio;
		}

		public String getMarca() {
			return marca;
		}

		public String getModelo() {
			return modelo;
		}

		public double getPrecio() {
			return precio;
		}

		@Override
		public String toString() {
			return marca + " " + modelo + " (" + precio + " EUR)";
		}
	}

	public static void main(String[] args) {

		ArrayList<Coche> stock = new ArrayList<>();
		stock.add(new Coche("Seat", "Ibiza", 14500));
		stock.add(new Coche("Toyota", "Corolla", 24900));
		stock.add(new Coche("Renault", "Clio", 13200));
		stock.add(new Coche("Seat", "Leon", 22800));
		stock.add(new Coche("Dacia", "Sandero", 11800));

		/*
		 * Ejercicio 1: encontrar el coche mas caro del stock.
		 */
		Coche masCaro = stock.get(0);
		for (int i = 1; i < stock.size(); i++) {
			if (stock.get(i).getPrecio() > masCaro.getPrecio()) {
				masCaro = stock.get(i);
			}
		}
		System.out.println("Coche mas caro: " + masCaro);

		/*
		 * Ejercicio 2: listar coches con precio inferior a 20 000 EUR.
		 * Creamos una segunda lista con el resultado filtrado.
		 */
		ArrayList<Coche> economicos = new ArrayList<>();
		for (Coche coche : stock) {
			if (coche.getPrecio() < 20000) {
				economicos.add(coche);
			}
		}
		System.out.println("\nCoches por debajo de 20 000 EUR:");
		for (Coche coche : economicos) {
			System.out.println(" - " + coche);
		}

		/*
		 * Ejercicio 3: contar cuantos Seat hay en el stock.
		 */
		int contadorSeat = 0;
		for (Coche coche : stock) {
			if (coche.getMarca().equals("Seat")) {
				contadorSeat++;
			}
		}
		System.out.println("\nNumero de Seat en stock: " + contadorSeat);

		/*
		 * Ejercicio 4: vender un coche (eliminarlo del stock).
		 * Buscamos el indice del Renault Clio y lo quitamos con remove(indice).
		 *
		 * Antes     => 5 coches
		 * Despues   => 4 coches (sin el Clio)
		 */
		int indiceVendido = -1;
		for (int i = 0; i < stock.size(); i++) {
			Coche coche = stock.get(i);
			if (coche.getMarca().equals("Renault") && coche.getModelo().equals("Clio")) {
				indiceVendido = i;
				break;
			}
		}
		if (indiceVendido != -1) {
			System.out.println("\nVendido: " + stock.get(indiceVendido));
			stock.remove(indiceVendido);
		}
		System.out.println("Coches restantes: " + stock.size());

		/*
		 * Ejercicio 5: mostrar el inventario final.
		 */
		System.out.println("\n--- Stock final ---");
		for (Coche coche : stock) {
			System.out.println(coche);
		}
	}
}
