package general.poo_herencia.resueltos;

/**
 * Ejercicio 1: Herencia básica con animales (RESUELTO)
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio1_HerenciaAnimal {

    // Clase base
    static class Animal {
        protected String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public void hacerSonido() {
            System.out.println("El animal hace un sonido.");
        }
    }

    // Subclase Perro
    static class Perro extends Animal {

        public Perro(String nombre) {
            super(nombre);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + " dice: Guau!");
        }
    }

    // Subclase Gato
    static class Gato extends Animal {

        public Gato(String nombre) {
            super(nombre);
        }

        @Override
        public void hacerSonido() {
            System.out.println(nombre + " dice: Miau!");
        }
    }

    public static void main(String[] args) {
        Perro perro = new Perro("Bobby");
        Gato gato = new Gato("Misu");

        perro.hacerSonido();
        gato.hacerSonido();
    }
}

