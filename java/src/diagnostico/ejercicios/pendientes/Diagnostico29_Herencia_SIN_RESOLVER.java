package diagnostico.ejercicios.pendientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Herencia y polimorfismo con animales
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con herencia: Animal, Perro y Gato.</li>
 * <li>Cada subclase debe sobreescribir hacerSonido(). Usa polimorfismo con una lista de Animal.</li>
 * <li>En el main, lee cuantos animales y para cada uno el tipo (perro/gato) y nombre con Scanner teclado.</li>
 * <li>Crea los objetos, guardalos en la lista y recorrela llamando a hacerSonido().</li>
 * </ul>
 *
 * <p>Diagnostico 29 — EV3 · ut6_pooavanzadaestructuras · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico29_Herencia_SIN_RESOLVER {

    // TODO: Animal, Perro, Gato con hacerSonido() y polimorfismo

    static class Animal {
        // TODO
    }

    static class Perro extends Animal {
        // TODO
    }

    static class Gato extends Animal {
        // TODO
    }
    public static void main(String[] args) {
        Scanner teclado;
        int cantidad;
        int indice;
        String tipo;
        String nombre;
        List<Animal> animales;
        Animal animal;
        teclado = new Scanner(System.in);
        System.out.print("Cuantos animales: ");
        cantidad = teclado.nextInt();
        animales = new ArrayList<>();
        for (indice = 0; indice < cantidad; indice++) {
            System.out.print("Tipo (perro/gato): ");
            tipo = teclado.nextLine();
            System.out.print("Nombre: ");
            nombre = teclado.nextLine();
            if (tipo.equalsIgnoreCase("perro")) {
                animales.add(new Perro(nombre));
            } else {
                animales.add(new Gato(nombre));
            }
        }
        // TODO: recorrer animales y llamar a hacerSonido()
        for (Animal mascota : animales) {
            mascota.hacerSonido();
        }
        teclado.close();
    }
}
