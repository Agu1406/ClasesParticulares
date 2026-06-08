package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madriduaxsistemagestionbiblioteca;

import java.util.Date;

public class Reserva_SIN_RESOLVER {
    private Usuario_SIN_RESOLVER usuario;
    private Libro_SIN_RESOLVER libro;
    private Date fechaInicio;
    private Date fechaFin;

    public Reserva_SIN_RESOLVER(Usuario_SIN_RESOLVER usuario, Libro_SIN_RESOLVER libro, Date fechaInicio, Date fechaFin) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters
    public Usuario_SIN_RESOLVER getUsuario() { return usuario; }
    public void setUsuario(Usuario_SIN_RESOLVER usuario) { this.usuario = usuario; }

    public Libro_SIN_RESOLVER getLibro() { return libro; }
    public void setLibro(Libro_SIN_RESOLVER libro) { this.libro = libro; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

}
