package madrid.uax.tecnicasprogramacion.sistema_gestion_biblioteca;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca biblioteca = new Biblioteca("sistema_gestion_biblioteca.Biblioteca Central", 10, 5);

        // Crear libros fisicos
        LibroFisico libroFisico1 = new LibroFisico("Don Quijote", "Miguel de Cervantes", "Bueno");
        LibroFisico libroFisico2 = new LibroFisico("Cien anos de soledad", "Gabriel Garcia Marquez", "Excelente");
        LibroFisico libroFisico3 = new LibroFisico("La Casa de los Espiritus", "Isabel Allende", "Regular");

        // Crear libros digitales
        LibroDigital libroDigital1 = new LibroDigital("El Principito", "Antoine de Saint-Exupery", "PDF");
        LibroDigital libroDigital2 = new LibroDigital("1984", "George Orwell", "EPUB");
        LibroDigital libroDigital3 = new LibroDigital("Fahrenheit 451", "Ray Bradbury", "MOBI");

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libroFisico1);
        biblioteca.agregarLibro(libroFisico2);
        biblioteca.agregarLibro(libroFisico3);
        biblioteca.agregarLibro(libroDigital1);
        biblioteca.agregarLibro(libroDigital2);
        biblioteca.agregarLibro(libroDigital3);

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Perez");
        Usuario usuario2 = new Usuario("Maria Garcia");
        Usuario usuario3 = new Usuario("Carlos Lopez");

        // Registrar usuarios
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);

        try {
            // Crear fechas para las reservas
            Date fecha1Inicio = new Date(123, 11, 21); // 21/12/2023
            Date fecha1Fin = new Date(123, 11, 24);    // 24/12/2023
            Date fecha2Inicio = new Date(112, 10, 26); // 26/11/2012
            Date fecha2Fin = new Date(112, 10, 30);    // 30/11/2012
            Date fecha3Inicio = new Date(113, 0, 2);   // 02/01/2013
            Date fecha3Fin = new Date(113, 0, 4);      // 04/01/2013

            // Reservar libro fisico
            biblioteca.reservarLibro(usuario1, libroFisico1, fecha1Inicio, fecha1Fin);

            // Reservar libro digital
            biblioteca.reservarLibro(usuario2, libroDigital1, fecha2Inicio, fecha2Fin);

            // Intentar reservar el mismo libro digital (debe generar error)
            biblioteca.reservarLibro(usuario3, libroDigital1, fecha3Inicio, fecha3Fin);

        } catch (IllegalStateException e) {
            System.out.println("Error al reservar: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
        }

        // Mostrar informacion de la biblioteca
        System.out.println("\n=== INFORMACION DE LA BIBLIOTECA ===");
        biblioteca.imprimirCatalogo();
        System.out.println();
        biblioteca.mostrarReservasActivas();
    }
}
