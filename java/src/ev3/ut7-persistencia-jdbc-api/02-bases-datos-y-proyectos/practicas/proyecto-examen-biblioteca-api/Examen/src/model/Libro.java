package model;

public class Libro {
    public String isbn;
    public int autorId;
    public int bibliotecaId;
    public int numeroPaginas;
    public String tipo;
    public int anioPublicacion;

    public Libro(String isbn, int autorId, int bibliotecaId, int numeroPaginas, String tipo, int anioPublicacion) {
        this.isbn = isbn;
        this.autorId = autorId;
        this.bibliotecaId = bibliotecaId;
        this.numeroPaginas = numeroPaginas;
        this.tipo = tipo;
        this.anioPublicacion = anioPublicacion;
    }
}
