package ev2.ut5.u01poobasica.ejercicios.resueltos;

/**
 * Ejercicio POO Basico - Constructores (Resuelto)
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/05/2026
 */
public class Ejercicio1_ConstructoresBasicos_RESUELTO {
    public static void main(String[] args) {
        LibroResuelto libro = new LibroResuelto("Clean Code", "Robert C. Martin");
        System.out.println("Titulo: " + libro.titulo);
        System.out.println("Autor: " + libro.autor);
    }
}

class LibroResuelto {
    String titulo;
    String autor;

    LibroResuelto(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
}
