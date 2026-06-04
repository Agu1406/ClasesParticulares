package ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.util;

import ev3.ut7.u02basesdatos.practicas.proyectoexamenbibliotecaapi.examenjdbc.model.Libro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class CsvExporter {

    private CsvExporter() {
    }

    public static Path exportarLibrosAutor(List<Libro> libros, String nombreArchivo) throws IOException {
        Path archivo = Path.of(nombreArchivo);
        StringBuilder sb = new StringBuilder("isbn;paginas;tipo;anio;autor_id;biblioteca_id\n");
        for (Libro libro : libros) {
            sb.append(libro.isbn()).append(';')
                    .append(libro.numeroPaginas()).append(';')
                    .append(libro.tipo()).append(';')
                    .append(libro.anioPublicacion()).append(';')
                    .append(libro.autorId()).append(';')
                    .append(libro.bibliotecaId()).append('\n');
        }
        Files.writeString(archivo, sb.toString());
        return archivo.toAbsolutePath();
    }
}
