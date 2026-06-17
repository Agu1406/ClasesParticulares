package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-enunciado-v6.pdf} (ejercicio 3).</p>
 *
 * <p><b>OBJETIVO:</b> Crear tres plantas leidas por teclado, almacenarlas en una estructura dinamica
 * y mostrarlas ordenadas por {@code alturaMaxima} ascendente.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> {@link ArrayList} de {@link Planta} con {@link Comparable}; se ordena con
 * {@link Collections#sort(List)} antes de listar.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		List<Planta> plantas = new ArrayList<>();

		for (int i = 1; i <= 3; i++) {
			System.out.println("Planta " + i + ":");
			System.out.print("Nombre cientifico: ");
			String nombre = teclado.nextLine().trim();
			System.out.print("Altura maxima (m): ");
			double altura = Double.parseDouble(teclado.nextLine().trim().replace(',', '.'));
			plantas.add(new Planta(nombre, altura));
		}

		Collections.sort(plantas);
		System.out.println();
		System.out.println("Plantas por altura ascendente:");
		plantas.forEach(System.out::println);
	}
}
