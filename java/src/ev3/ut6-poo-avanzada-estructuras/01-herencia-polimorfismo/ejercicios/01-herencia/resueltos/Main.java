package ev3.ut7.herencia;

import java.util.ArrayList;

public class Main {
    static void main() {
        /**
         * Creamos una lista del tipo "Animal" para guardar animales,
         * creamos nuevos animales y los metemos ("add") dentro de la
         * lista.
         */
        ArrayList <Animal> listaAnimales = new ArrayList<>();
        Animal nuevoAnimal = new Animal("Agustín", "Macho", "Blanco");
        listaAnimales.add(nuevoAnimal);

        /**
         * Cuando creamso objetos podemos escribir en el código de
         * sus clases lo que queremos que hagan esos objetos, aquí
         * por ejemplo todos los animales hacen ruido.
         */
        nuevoAnimal.hacerSonido();

        /**
         * El "toString()" permite guardar en un String toda la
         * información que queramos de un objeto en el formato
         * que hayamos diseñado.
         */
        String informacionAnimal = nuevoAnimal.toString();
        System.out.println(informacionAnimal);

        /**
         * Obtenemos todos los datos de un objeto usando los Getters
         * de la clase y los guardamos para sus posterior uso, en
         * este caso, imprimirlos (acceso a datos).
         */
        String nombreAnimal = nuevoAnimal.getNombre();
        String generoAnimal = nuevoAnimal.getGenero();
        String colorAnimal = nuevoAnimal.getColor();

        System.out.println("Nombre del animal: " + nombreAnimal);
        System.out.println("Genero del animal: " + generoAnimal);
        System.out.println("Color del animal: " + colorAnimal);


    }
}
