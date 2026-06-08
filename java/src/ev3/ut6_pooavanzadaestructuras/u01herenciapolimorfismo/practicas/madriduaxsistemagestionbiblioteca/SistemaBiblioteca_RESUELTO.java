package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.Date;

public class SistemaBiblioteca_RESUELTO {
    public static void main(String[] args) {
        // Crear biblioteca (usaremos biblioteca1)
        Biblioteca_RESUELTO biblioteca1 = new Biblioteca_RESUELTO("Angulo", 5, 5);
        
        // Crear tres libros fisicos
        LibroFisico_RESUELTO libroFisico1 = new LibroFisico_RESUELTO("Don Quijote", "Miguel de Cervantes", "Bueno");
        LibroFisico_RESUELTO libroFisico2 = new LibroFisico_RESUELTO("Cien anos de soledad", "Gabriel Garcia Marquez", "Excelente");
        LibroFisico_RESUELTO libroFisico3 = new LibroFisico_RESUELTO("La Casa de los Espiritus", "Isabel Allende", "Regular");

        // Crear tres libros digitales
        LibroDigital_RESUELTO libroDigital1 = new LibroDigital_RESUELTO("El Principito", "Antoine de Saint-Exupery", "PDF");
        LibroDigital_RESUELTO libroDigital2 = new LibroDigital_RESUELTO("1984", "George Orwell", "EPUB");
        LibroDigital_RESUELTO libroDigital3 = new LibroDigital_RESUELTO("Fahrenheit 451", "Ray Bradbury", "MOBI");

        // Anadir todos los libros al catalogo
        biblioteca1.agregarLibro(libroFisico1);
        biblioteca1.agregarLibro(libroFisico2);
        biblioteca1.agregarLibro(libroFisico3);
        biblioteca1.agregarLibro(libroDigital1);
        biblioteca1.agregarLibro(libroDigital2);
        biblioteca1.agregarLibro(libroDigital3);

        // Registrar varios usuarios
        Usuario_RESUELTO usuario1 = new Usuario_RESUELTO("Juan Perez");
        Usuario_RESUELTO usuario2 = new Usuario_RESUELTO("Maria Garcia");
        Usuario_RESUELTO usuario3 = new Usuario_RESUELTO("Carlos Lopez");

        biblioteca1.agregarUsuario(usuario1);
        biblioteca1.agregarUsuario(usuario2);
        biblioteca1.agregarUsuario(usuario3);

        try {
            // Fechas para las reservas
            Date fecha1Inicio = java.sql.Date.valueOf("2023-12-21");
            Date fecha1Fin = java.sql.Date.valueOf("2023-12-24");
            Date fecha2Inicio = java.sql.Date.valueOf("2012-11-26");
            Date fecha2Fin = java.sql.Date.valueOf("2012-11-30");
            Date fecha3Inicio = java.sql.Date.valueOf("2013-01-02");
            Date fecha3Fin = java.sql.Date.valueOf("2013-01-04");

            // Reservar libro fisico del 21/12/2023 hasta el 24/12/2023
            biblioteca1.reservarLibro(usuario1, libroFisico1, fecha1Inicio, fecha1Fin);

            // Reservar libro digital del 26/11/2012 al 30/11/2012
            biblioteca1.reservarLibro(usuario2, libroDigital1, fecha2Inicio, fecha2Fin);

            // Intentar reservar el mismo libro digital del 2/1/2013 al 4/1/2013
            biblioteca1.reservarLibro(usuario3, libroDigital1, fecha3Inicio, fecha3Fin);

        } catch (IllegalStateException e) {
            System.out.println("Error al reservar: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
        }

        // Mostrar listado de reservas activas
        System.out.println("\n=== LISTADO DE RESERVAS ACTIVAS ===");
        biblioteca1.mostrarReservasActivas();

        // Mostrar informacion completa de la biblioteca
        System.out.println("\n=== CATALOGO DE LA BIBLIOTECA ===");
        biblioteca1.imprimirCatalogo();
    }
} 
