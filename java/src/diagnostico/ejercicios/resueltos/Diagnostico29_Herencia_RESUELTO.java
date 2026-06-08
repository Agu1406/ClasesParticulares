package diagnostico.ejercicios.resueltos;

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
public class Diagnostico29_Herencia_RESUELTO {

    static class Animal {
        protected String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public void hacerSonido() {
            System.out.println(nombre + " hace un sonido");
        }
    }

    static class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + ": Guau");
        }
    }

    static class Gato extends Animal {
        public Gato(String nombre) {
            super(nombre);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + ": Miau");
        }
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
        for (Animal mascota : animales) {
            mascota.hacerSonido();
        }
        teclado.close();
    }
}
