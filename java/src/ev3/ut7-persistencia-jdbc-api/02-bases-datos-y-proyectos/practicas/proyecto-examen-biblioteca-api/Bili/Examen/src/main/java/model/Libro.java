package model;

public class Libro {
    public String isbn;
    public int autorID;
    public int bibliotecaID;
    public int numeroPaginas;
    public String tipo;
    public int anioPublicacion;

    public Libro(String isbn, int autorID, int bibliotecaID, int numeroPaginas, String tipo, int anioPublicacion) {
        this.isbn = isbn;
        this.autorID = autorID;
        this.bibliotecaID = bibliotecaID;
        this.numeroPaginas = numeroPaginas;
        this.tipo = tipo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public int getBibliotecaID() {
        return bibliotecaID;
    }

    public void setBibliotecaID(int bibliotecaID) {
        this.bibliotecaID = bibliotecaID;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
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
}
