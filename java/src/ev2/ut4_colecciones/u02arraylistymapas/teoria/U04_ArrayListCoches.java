package ev2.ut4_colecciones.u02arraylistymapas.teoria;

import java.util.ArrayList;

/**
 * {@link ArrayList} aplicado a un stock de coches de concesionario.
 * Cada elemento de la lista es un objeto {@link Coche}.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_ArrayListCoches {

	/**
	 * Representa un coche del stock: marca, modelo y precio de venta.
	 */
	static class Coche {

		private final String marca;
		private final String modelo;
		private double precio;

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

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		@Override
		public String toString() {
			return marca + " " + modelo + " - " + precio + " EUR";
		}
	}

	public static void main(String[] args) {

		/*
		 * ArrayList puede guardar objetos, no solo numeros o textos sueltos.
		 * Aqui cada posicion de la lista es un Coche completo del concesionario.
		 *
		 * Indice    => [0][1][2]...
		 * Valores   => Coche, Coche, Coche...
		 */
		ArrayList<Coche> stock = new ArrayList<>();

		/*
		 * Entrada de vehiculos al stock con add(coche).
		 */
		stock.add(new Coche("Seat", "Ibiza", 14500));
		stock.add(new Coche("Toyota", "Corolla", 24900));
		stock.add(new Coche("Renault", "Clio", 13200));
		stock.add(new Coche("Seat", "Leon", 22800));

		System.out.println("Coches en stock: " + stock.size());
		System.out.println("Primer coche (indice 0): " + stock.get(0));

		/*
		 * Recorrer el stock e imprimir la ficha de cada vehiculo.
		 */
		System.out.println("\n--- Inventario del concesionario ---");
		for (Coche coche : stock) {
			System.out.println(coche);
		}

		/*
		 * Acceder a un coche concreto por indice y modificar su precio (rebaja).
		 *
		 * Antes     => Seat Leon - 22800 EUR
		 * Despues   => Seat Leon - 21500 EUR
		 */
		Coche leon = stock.get(3);
		leon.setPrecio(21500);
		System.out.println("\nTras rebaja del Leon: " + leon);
	}
}
