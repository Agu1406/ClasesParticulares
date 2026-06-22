package recuperacionordinaria.internorecuperacionordinaria.resuelto.ejercicio_02_hardware;

/**
 * Ejercicio 2 — Recuperación ordinaria: gestor de presupuestos de hardware.
 */
public class Main {

	public static void main(String[] args) {
		Ordenador pc = new Ordenador();
		pc.agregarComponente(new Procesador("Ryzen 9 7950X", 170, 16, 5.7));
		pc.agregarComponente(new TarjetaGrafica("RTX 4090", 450, 24, 128));
		pc.agregarComponente(new Procesador("Core i7-14700K", 125, 20, 5.6));

		pc.mostrarInforme();
	}
}
