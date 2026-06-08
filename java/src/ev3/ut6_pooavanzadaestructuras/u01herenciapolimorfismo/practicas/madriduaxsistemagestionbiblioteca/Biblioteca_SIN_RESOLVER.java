package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Biblioteca_SIN_RESOLVER {
    private String nombre;
    private List<Libro_SIN_RESOLVER> catalogo;
    private List<Usuario_SIN_RESOLVER> usuarios;
    private List<Reserva_SIN_RESOLVER> reservas;
    private final int maxLibros;
    private final int maxUsuarios;

    public Biblioteca_SIN_RESOLVER(String nombre, int maxLibros, int maxUsuarios) {
        this.nombre = nombre;
        this.maxLibros = maxLibros;
        this.maxUsuarios = maxUsuarios;
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarLibro(Libro_SIN_RESOLVER libro) {
        if (catalogo.size() >= maxLibros) {
            throw new IllegalStateException("Se ha alcanzado el limite maximo de libros");
        }
        catalogo.add(libro);
    }

    public void agregarUsuario(Usuario_SIN_RESOLVER usuario) {
        if (usuarios.size() >= maxUsuarios) {
            throw new IllegalStateException("Se ha alcanzado el limite maximo de usuarios");
        }
        usuarios.add(usuario);
    }

    public boolean existeLibro(Libro_SIN_RESOLVER libro) {
        return catalogo.contains(libro);
    }

    public boolean existeUsuario(Usuario_SIN_RESOLVER usuario) {
        return usuarios.contains(usuario);
    }

    public void reservarLibro(Usuario_SIN_RESOLVER usuario, Libro_SIN_RESOLVER libro, Date fechaInicio, Date fechaFin) {
        if (!existeUsuario(usuario)) {
            throw new IllegalArgumentException("El usuario no esta registrado en la biblioteca");
        }
        if (!existeLibro(libro)) {
            throw new IllegalArgumentException("El libro no esta en el catalogo");
        }

        Reserva_SIN_RESOLVER nuevaReserva = new Reserva_SIN_RESOLVER(usuario, libro, fechaInicio, fechaFin);
        reservas.add(nuevaReserva);
    }

    public void mostrarReservasActivas() {
        System.out.println("=== Reservas Activas ===");
        for (Reserva_SIN_RESOLVER reserva : reservas) {
            System.out.printf("sistema_gestion_biblioteca.Usuario_SIN_RESOLVER: %s, sistema_gestion_biblioteca.Libro_SIN_RESOLVER: %s, Desde: %s, Hasta: %s%n",
                reserva.getUsuario().getNombre(),
                reserva.getLibro().getTitulo(),
                reserva.getFechaInicio(),
                reserva.getFechaFin());
        }
    }

    public void imprimirCatalogo() {
        System.out.println("=== Catalogo de la sistema_gestion_biblioteca.Biblioteca_SIN_RESOLVER ===");
        for (Libro_SIN_RESOLVER libro : catalogo) {
            libro.imprimir();
        }
    }
} 
