package ev3.ut7.u05repaso.practicas.examen3evbibliotecacomunidadjdbc.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad JPA: fila de la tabla {@code libros}.
 *
 * <p>Las relaciones {@link #autor} y {@link #biblioteca} se guardan como {@code id_autor} e {@code id_biblioteca}.</p>
 */
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(name = "num_paginas", nullable = false)
    private int numPaginas;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(name = "anio_publicacion", nullable = false)
    private int anioPublicacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_biblioteca", nullable = false)
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
