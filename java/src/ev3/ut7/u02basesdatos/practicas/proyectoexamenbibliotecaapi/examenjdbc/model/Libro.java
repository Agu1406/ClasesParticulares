package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model;

public record Libro(
        String isbn,
        int numeroPaginas,
        String tipo,
        int anioPublicacion,
        long autorId,
        long bibliotecaId
) {
}
