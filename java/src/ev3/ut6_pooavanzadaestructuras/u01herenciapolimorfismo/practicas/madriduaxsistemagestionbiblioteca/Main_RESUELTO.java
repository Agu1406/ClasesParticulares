package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.Date;

public class Main_RESUELTO {
    public static void main(String[] args) {
        // Crear biblioteca
        Biblioteca_RESUELTO biblioteca = new Biblioteca_RESUELTO("sistema_gestion_biblioteca.Biblioteca_RESUELTO Central", 10, 5);

        // Crear libros fisicos
        LibroFisico_RESUELTO libroFisico1 = new LibroFisico_RESUELTO("Don Quijote", "Miguel de Cervantes", "Bueno");
        LibroFisico_RESUELTO libroFisico2 = new LibroFisico_RESUELTO("Cien anos de soledad", "Gabriel Garcia Marquez", "Excelente");
        LibroFisico_RESUELTO libroFisico3 = new LibroFisico_RESUELTO("La Casa de los Espiritus", "Isabel Allende", "Regular");

        // Crear libros digitales
        LibroDigital_RESUELTO libroDigital1 = new LibroDigital_RESUELTO("El Principito", "Antoine de Saint-Exupery", "PDF");
        LibroDigital_RESUELTO libroDigital2 = new LibroDigital_RESUELTO("1984", "George Orwell", "EPUB");
        LibroDigital_RESUELTO libroDigital3 = new LibroDigital_RESUELTO("Fahrenheit 451", "Ray Bradbury", "MOBI");

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libroFisico1);
        biblioteca.agregarLibro(libroFisico2);
        biblioteca.agregarLibro(libroFisico3);
        biblioteca.agregarLibro(libroDigital1);
        biblioteca.agregarLibro(libroDigital2);
        biblioteca.agregarLibro(libroDigital3);

        // Crear usuarios
        Usuario_RESUELTO usuario1 = new Usuario_RESUELTO("Juan Perez");
        Usuario_RESUELTO usuario2 = new Usuario_RESUELTO("Maria Garcia");
        Usuario_RESUELTO usuario3 = new Usuario_RESUELTO("Carlos Lopez");

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
