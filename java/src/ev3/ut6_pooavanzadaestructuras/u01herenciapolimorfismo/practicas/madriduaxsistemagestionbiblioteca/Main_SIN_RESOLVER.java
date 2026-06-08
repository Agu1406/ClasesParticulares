package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.Date;

public class Main_SIN_RESOLVER {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca_SIN_RESOLVER biblioteca = new Biblioteca_SIN_RESOLVER("sistema_gestion_biblioteca.Biblioteca_SIN_RESOLVER Central", 10, 5);

        // Crear libros fisicos
        LibroFisico_SIN_RESOLVER libroFisico1 = new LibroFisico_SIN_RESOLVER("Don Quijote", "Miguel de Cervantes", "Bueno");
        LibroFisico_SIN_RESOLVER libroFisico2 = new LibroFisico_SIN_RESOLVER("Cien anos de soledad", "Gabriel Garcia Marquez", "Excelente");
        LibroFisico_SIN_RESOLVER libroFisico3 = new LibroFisico_SIN_RESOLVER("La Casa de los Espiritus", "Isabel Allende", "Regular");

        // Crear libros digitales
        LibroDigital_SIN_RESOLVER libroDigital1 = new LibroDigital_SIN_RESOLVER("El Principito", "Antoine de Saint-Exupery", "PDF");
        LibroDigital_SIN_RESOLVER libroDigital2 = new LibroDigital_SIN_RESOLVER("1984", "George Orwell", "EPUB");
        LibroDigital_SIN_RESOLVER libroDigital3 = new LibroDigital_SIN_RESOLVER("Fahrenheit 451", "Ray Bradbury", "MOBI");

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libroFisico1);
        biblioteca.agregarLibro(libroFisico2);
        biblioteca.agregarLibro(libroFisico3);
        biblioteca.agregarLibro(libroDigital1);
        biblioteca.agregarLibro(libroDigital2);
        biblioteca.agregarLibro(libroDigital3);

        // Crear usuarios
        Usuario_SIN_RESOLVER usuario1 = new Usuario_SIN_RESOLVER("Juan Perez");
        Usuario_SIN_RESOLVER usuario2 = new Usuario_SIN_RESOLVER("Maria Garcia");
        Usuario_SIN_RESOLVER usuario3 = new Usuario_SIN_RESOLVER("Carlos Lopez");

        // Registrar usuarios
        biblioteca.agregarUsuario(usuario1);
        biblioteca.agregarUsuario(usuario2);
        biblioteca.agregarUsuario(usuario3);

        try {
            // Crear fechas para las reservas
            Date fecha1Inicio = java.sql.Date.valueOf("2023-12-21");
            Date fecha1Fin = java.sql.Date.valueOf("2023-12-24");
            Date fecha2Inicio = java.sql.Date.valueOf("2012-11-26");
            Date fecha2Fin = java.sql.Date.valueOf("2012-11-30");
            Date fecha3Inicio = java.sql.Date.valueOf("2013-01-02");
            Date fecha3Fin = java.sql.Date.valueOf("2013-01-04");

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
