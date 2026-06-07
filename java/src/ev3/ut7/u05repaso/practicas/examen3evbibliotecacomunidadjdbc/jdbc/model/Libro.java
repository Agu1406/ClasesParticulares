package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.jdbc.model;

/**
 * POO: fila de la tabla {@code libros}.
 */
public class Libro {

    private Integer id;
    private String isbn;
    private int numPaginas;
    private String tipo;
    private int anioPublicacion;
    private Autor autor;
    private Biblioteca biblioteca;

    public Libro() {
    }

    public Libro(String isbn, int numPaginas, String tipo, int anioPublicacion,
                 Autor autor, Biblioteca biblioteca) {
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.tipo = tipo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return isbn + " - " + tipo + " (" + anioPublicacion + ")";
    }
}
